package com.mirbozorgi.shop.business.service;


import com.mirbozorgi.shop.business.domain.AuthorizationInfo;
import com.mirbozorgi.shop.core.enums.Role;
import java.util.List;

public interface JwtService {

  String createToken(String email, Role role);

  List<Object> parseToken(String token, String secretPass);

  boolean validateToken(String token, String secret);

  AuthorizationInfo authorize(String token);



}

