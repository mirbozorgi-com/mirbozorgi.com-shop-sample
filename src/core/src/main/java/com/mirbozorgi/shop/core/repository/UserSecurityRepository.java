package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.UserSecurity;
import com.mirbozorgi.shop.core.enums.Role;
import java.util.List;

public interface UserSecurityRepository {

  UserSecurity add(UserSecurity userSecurity);

  UserSecurity update(
      String email,
      String password,
      Role role,
      long lastLoginDate,
      Boolean verifyEmail,
      String verificationCode,
      long verificationCodeCreatedDate,
      String forgetPassToken,
      long createdForgetPassTokenDate,
      long verifiedDate);

  UserSecurity getByEmail(String email);

  UserSecurity get(int userId);

  void delete(int userId);

  List<UserSecurity> getAll();

}
