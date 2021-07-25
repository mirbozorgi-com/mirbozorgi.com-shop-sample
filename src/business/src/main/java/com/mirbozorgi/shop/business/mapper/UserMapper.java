package com.mirbozorgi.shop.business.mapper;

import com.mirbozorgi.shop.business.domain.UserInfo;
import com.mirbozorgi.shop.core.entity.UserSecurity;

public class UserMapper {

  public static UserInfo toInfo(UserSecurity userSecurity) {

    return new UserInfo(
        userSecurity.getEmail(),
        userSecurity.getRole(),
        userSecurity.getLastLoginDate(),
        userSecurity.getCreatedDate()
    );
  }
}
