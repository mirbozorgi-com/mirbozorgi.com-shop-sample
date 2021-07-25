package com.mirbozorgi.shop.business.service;

import com.mirbozorgi.shop.business.domain.AuthorizationInfo;
import com.mirbozorgi.shop.business.domain.UserInfo;

public interface UserSecurityService {

  UserInfo userSignUp(
      String email,
      String password);

  UserInfo adminSignUp(
      String email,
      String password);


  UserInfo findByEmail(
      String email);

  String signIn(
      String email,
      String password);


  AuthorizationInfo authorize(String token);


  void verify(
      String email,
      String verificationCode);


  void reGenerateVerificationCode(
      String email);

  void changePassword(
      String email,
      String password,
      String newPassword);

  void forgetPassword(
      String email,
      String password,
      String forgetPasswordToken);

  void sendForgetPassToken(
      String email);


}
