package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserCredentialException extends CustomException {

  public UserCredentialException() {
    super("user_credential_wrong", HttpStatus.FORBIDDEN);
    this.setData("user_credential_wrong");
  }

}
