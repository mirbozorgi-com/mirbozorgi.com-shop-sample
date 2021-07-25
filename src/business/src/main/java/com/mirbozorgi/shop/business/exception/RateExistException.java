package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class RateExistException  extends CustomException {
  public RateExistException() {
    super("you_rate_before!", HttpStatus.NOT_ACCEPTABLE);
    this.setData("you_rate_before!");
  }

}
