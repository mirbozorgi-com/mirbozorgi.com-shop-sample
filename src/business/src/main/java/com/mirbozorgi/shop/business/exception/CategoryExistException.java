package com.mirbozorgi.shop.business.exception;

import com.mirbozorgi.shop.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class CategoryExistException extends CustomException {

  public CategoryExistException() {
    super("category_exists_with_this_name", HttpStatus.NOT_ACCEPTABLE);
    this.setData("category_exists_with_this_name");
  }
}
