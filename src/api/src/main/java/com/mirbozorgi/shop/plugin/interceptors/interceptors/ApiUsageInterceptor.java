package com.mirbozorgi.shop.plugin.interceptors.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("apiUsageInterceptor")
public class ApiUsageInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(ApiUsageInterceptor.class);


  @Override
  public boolean preHandle(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final Object handler) throws Exception {



    String url = request.getServletPath();
    if (!url.equals("/error")) {
      MDC.put("end_point", url);
    }

    logger.info(request.getServletPath());

    return true;
  }
}