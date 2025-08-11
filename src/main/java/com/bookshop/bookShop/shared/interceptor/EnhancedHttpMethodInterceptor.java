package com.bookshop.bookShop.shared.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class EnhancedHttpMethodInterceptor implements HandlerInterceptor {
    private static final Logger logger  = LoggerFactory.getLogger(EnhancedHttpMethodInterceptor.class);

    private static final String[] TARGET_METHODS = { "GET", "POST", "DELETE" };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();

        if(isTargetMethod(method)){
            long starTime = System.currentTimeMillis();
            request.setAttribute("startTime", starTime);

            Map<String, String> requestDetails = new HashMap<>();
            requestDetails.put("method", method);
            requestDetails.put("uri", request.getRequestURI());
            requestDetails.put("client", request.getRemoteAddr());
            requestDetails.put("headers", getHeadersAsMap(request).toString());

            logger.info("Incoming {} request: {}", method, requestDetails);

            //TODO: Validación específica por método
            switch(method){
                case "GET":
                    validateGetRequest(request);
                    break;
                case "POST":
                    validatePostRequest(request);
                    break;
                case "DELETE":
                    validateDeleteRequest(request);
                    break;
            }
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {
        String method = request.getMethod();

        if(isTargetMethod(method)){
            long startTime = (Long) request.getAttribute("startTime");
            long duration = System.currentTimeMillis() - startTime;

            Map<String, Object> responseDetails = new HashMap<>();
            responseDetails.put("status", response.getStatus());
            responseDetails.put("duration", duration + "ms");

            if(ex != null){
                responseDetails.put("error", ex.getMessage());
            }

            logger.info("Completed {} request: {}", method, responseDetails);
        }
    }

    private boolean isTargetMethod(String method) {
        for(String target : TARGET_METHODS){
            if (target.equals(method)) {
                return true;
            }
        }

        return false;
    }

    private Map<String, String> getHeadersAsMap(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            headersMap.put(headerName, request.getHeader(headerName));
        }

        return headersMap;
    }


    private void validatePostRequest(HttpServletRequest request){
        if(request.getContentType() == null || !request.getContentType().contains("applications/json")){
            logger.warn("POST request without JSON content type");
        }
    }

    private void validateGetRequest(HttpServletRequest request){
        logger.debug("Validating GET request parameters");
    }

    private void validateDeleteRequest(HttpServletRequest request){
        if(request.getHeader("X-Confirm-Delete") == null){
            logger.error("DELETE request without confirmation header");
            throw new RuntimeException("DELETE request require X-Confirm-Delete header");
        }
    }
}
