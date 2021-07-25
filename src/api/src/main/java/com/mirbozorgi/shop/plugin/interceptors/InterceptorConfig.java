package com.mirbozorgi.shop.plugin.interceptors;

import com.mirbozorgi.shop.plugin.interceptors.interceptors.ApiUsageInterceptor;
import com.mirbozorgi.shop.plugin.interceptors.interceptors.LogBackInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


  @Autowired
  ApiUsageInterceptor apiUsageInterceptor;

  @Autowired
  LogBackInterceptor LockBackInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    register(registry, apiUsageInterceptor, 1);
    register(registry, LockBackInterceptor, 5);
  }

  private void register(InterceptorRegistry registry, HandlerInterceptor interceptor, int order) {
    registry.addInterceptor(interceptor)
        .order(order)
        .addPathPatterns("/**")
        .excludePathPatterns("/health")
        .excludePathPatterns("/docs")
        .excludePathPatterns("/favicon.ico")
        .excludePathPatterns("/error")
        .excludePathPatterns("/log");
  }

}