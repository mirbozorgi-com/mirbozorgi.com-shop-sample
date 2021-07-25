package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class AccessDeniedException extends CustomException {

  public AccessDeniedException() {
    super("access_denied", HttpStatus.FORBIDDEN);
    this.setData("access_denied");
  }
}
