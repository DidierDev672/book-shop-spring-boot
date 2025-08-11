package com.bookshop.bookShop;

import com.bookshop.bookShop.shared.interceptor.CustomInterceptor;
import com.bookshop.bookShop.shared.interceptor.EnhancedHttpMethodInterceptor;
import com.bookshop.bookShop.shared.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private CustomInterceptor customInterceptor;

    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Autowired
    private EnhancedHttpMethodInterceptor enhancedHttpMethodInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**");

        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**");

        registry.addInterceptor(enhancedHttpMethodInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**");
    }
}
