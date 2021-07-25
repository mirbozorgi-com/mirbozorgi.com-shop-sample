package com.mirbozorgi.shop.model;

import javax.validation.constraints.Email;

public class CommentAddModel {

  private String content;
  @Email
  private String userEmail;
  private int productId;


  public String getContent() {
    return content;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public int getProductId() {
    return productId;
  }
}
