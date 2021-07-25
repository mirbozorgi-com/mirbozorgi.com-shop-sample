package com.mirbozorgi.shop.model;

import javax.validation.constraints.Email;

public class UserSecurityModel {

  @Email
  private String email;
  private String password;

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
