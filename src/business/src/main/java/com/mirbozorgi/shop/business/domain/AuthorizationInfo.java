package com.mirbozorgi.shop.business.domain;

public class AuthorizationInfo {

  private String role;
  private String email;

  public AuthorizationInfo(String role, String email) {
    this.role = role;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getRole() {
    return role;
  }
}
