package com.mirbozorgi.shop.business.service;


public interface StringService {


  String toMd5(String value);


  String generateRandomString(boolean letter, boolean number, int length);


}
