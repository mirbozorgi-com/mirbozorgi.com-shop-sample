package com.mirbozorgi.shop.core.entity;

import com.mirbozorgi.shop.core.enums.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_security")
public class UserSecurity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private Role role;

  @Column(name = "last_login_date")
  private long lastLoginDate;

  @Column(name = "created_date")
  private long createdDate;

  @Column(name = "verify_email")
  private Boolean verifyEmail;

  @Column(name = "verification_code")
  private String verificationCode;

  @Column(name = "verification_code_created_date")
  private long verificationCodeCreatedDate;

  @Column(name = "forget_pass_token")
  private String forgetPassToken;

  @Column(name = "created_forget_pass_token_date")
  private long createdForgetPassTokenDate;

  @Column(name = "verified_date")
  private long verifiedDate;


  @Column(name = "block")
  private boolean block;


  public UserSecurity() {
  }

  public UserSecurity(String email, Role role) {
    this.email = email;
    this.role = role;
  }

  public UserSecurity(String email,
      String password,
      Role role,
      long lastLoginDate,
      long createdDate,
      Boolean verifyEmail,
      String verificationCode,
      long verificationCodeCreatedDate,
      String forgetPassToken,
      long createdForgetPassTokenDate,
      long verifiedDate) {
    this.email = email;
    this.password = password;
    this.role = role;
    this.lastLoginDate = lastLoginDate;
    this.createdDate = createdDate;
    this.verifyEmail = verifyEmail;
    this.verificationCode = verificationCode;
    this.verificationCodeCreatedDate = verificationCodeCreatedDate;
    this.forgetPassToken = forgetPassToken;
    this.createdForgetPassTokenDate = createdForgetPassTokenDate;
    this.verifiedDate = verifiedDate;
    this.block = false;
  }

  public boolean isBlock() {
    return block;
  }

  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
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

  public Boolean getVerifyEmail() {
    return verifyEmail;
  }

  public String getVerificationCode() {
    return verificationCode;
  }

  public long getVerificationCodeCreatedDate() {
    return verificationCodeCreatedDate;
  }

  public String getForgetPassToken() {
    return forgetPassToken;
  }

  public long getCreatedForgetPassTokenDate() {
    return createdForgetPassTokenDate;
  }

  public long getVerifiedDate() {
    return verifiedDate;
  }
}
