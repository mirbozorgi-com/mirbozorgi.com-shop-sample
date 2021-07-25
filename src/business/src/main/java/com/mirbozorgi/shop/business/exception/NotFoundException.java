package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException {

  public NotFoundException() {
    super("not_found", HttpStatus.NOT_FOUND);
    this.setData("not_found");
  }
}
