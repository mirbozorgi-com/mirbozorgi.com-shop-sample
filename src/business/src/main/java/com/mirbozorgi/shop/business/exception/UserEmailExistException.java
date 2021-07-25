package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserEmailExistException extends CustomException {

  public UserEmailExistException() {
    super("email_exist", HttpStatus.NOT_ACCEPTABLE);
    this.setData("email_exist");
  }
}
