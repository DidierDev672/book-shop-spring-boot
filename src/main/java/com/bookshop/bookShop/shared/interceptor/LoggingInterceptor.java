package com.bookshop.bookShop.shared.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        logger.info("Request URL: {}", request.getRequestURI());
        logger.info("Method: {}", request.getMethod());
        logger.info("Client IP: {}", request.getRemoteAddr());

        logger.debug("Request Headers: {}", getHeadersAsString(request));
        logger.debug("Request Parameters: {}", request.getParameterMap());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Puedes registrar información después de que se procesa el controlador
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();

        logger.info("Request completed in {} ms", (endTime - startTime));
        logger.info("Response Status: {}", response.getStatus());
    }

    private String getHeadersAsString(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder();
        Collections.list(request.getHeaderNames())
                .forEach(headerName ->
                        headers.append(headerName)
                                .append(": ")
                                .append(request.getHeader(headerName))
                                .append("; "));
        return headers.toString();
    }
}
