package com.mirbozorgi.shop.business.context.aop;


import com.mirbozorgi.shop.business.domain.AuthorizationInfo;
import com.mirbozorgi.shop.business.domain.UserInfo;
import com.mirbozorgi.shop.business.exception.AccessDeniedException;
import com.mirbozorgi.shop.business.exception.BlockException;
import com.mirbozorgi.shop.business.service.UserSecurityService;
import com.mirbozorgi.shop.core.enums.Role;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class AuthAspect {


  @Autowired
  UserSecurityService securityService;


  @Before("@annotation(com.mirbozorgi.shop.business.context.aop.anotions.Auth)")
  public void auth() {

    HttpServletRequest request =
        ((ServletRequestAttributes) RequestContextHolder
            .currentRequestAttributes())
            .getRequest();

    String token = request.getHeader("Authorization");

    if (token == null) {
      throw new AccessDeniedException();
    }

    AuthorizationInfo jwtAuthorizationDataInfo = securityService.authorize(token);
    String email = jwtAuthorizationDataInfo.getEmail();
    UserInfo byEmail = securityService.findByEmail(email);
    if (byEmail.isBlock()) {
      throw new BlockException();
    }

    if (!jwtAuthorizationDataInfo.getRole().equals(Role.ADMIN.toString())) {
      throw new AccessDeniedException();
    }

  }
}
