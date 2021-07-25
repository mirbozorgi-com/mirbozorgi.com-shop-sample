package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class BlockException extends CustomException {
  public BlockException() {
    super("you_are_blocked!!", HttpStatus.FORBIDDEN);
    this.setData("you_are_blocked!!");
  }

}
