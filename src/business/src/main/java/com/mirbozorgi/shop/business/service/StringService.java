package com.mirbozorgi.shop.business.service;


public interface StringService {


  String encodeBase64(String input);

  String decodeBase64(String input);

  String encodeBase64WithSalt(String input);

  String decodeBase64WithSalt(String encrypted);

  String generateRandomString(boolean letter, boolean number, int length);


}
