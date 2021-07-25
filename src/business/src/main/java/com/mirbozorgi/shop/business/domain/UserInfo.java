package com.mirbozorgi.shop.business.domain;

import com.mirbozorgi.shop.core.enums.Role;

public class UserInfo {

  private String email;
  private Role role;
  private long lastLoginDate;
  private long createdDate;

  public UserInfo(
      String email,
      Role role,
      long lastLoginDate,
      long createdDate) {
    this.email = email;
    this.role = role;
    this.lastLoginDate = lastLoginDate;
    this.createdDate = createdDate;
  }

  public String getEmail() {
    return email;
  }

  public Role getRole() {
    return role;
  }

  public long getLastLoginDate() {
    return lastLoginDate;
  }

  public long getCreatedDate() {
    return createdDate;
  }
}
