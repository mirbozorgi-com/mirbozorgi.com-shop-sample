package com.mirbozorgi.shop.business.domain;

import com.mirbozorgi.shop.core.enums.Role;

public class UserInfo {

  private String email;
  private Role role;
  private long lastLoginDate;
  private long createdDate;
  private boolean block;

  public UserInfo(
      String email,
      Role role,
      long lastLoginDate,
      long createdDate,
      boolean block) {
    this.email = email;
    this.role = role;
    this.lastLoginDate = lastLoginDate;
    this.createdDate = createdDate;
    this.block = block;
  }

  public boolean isBlock() {
    return block;
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
