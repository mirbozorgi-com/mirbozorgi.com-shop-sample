package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.core.entity.UserSecurity;
import java.util.HashMap;
import java.util.Map;

public class JwtWrapper {

  private Map<String, Object> map = new HashMap<>();

  public JwtWrapper(UserSecurity user) {
    map.put("role", user.getRole());
    map.put("email", user.getEmail());

  }

  public Map<String, Object> getMap() {
    return map;
  }
}



