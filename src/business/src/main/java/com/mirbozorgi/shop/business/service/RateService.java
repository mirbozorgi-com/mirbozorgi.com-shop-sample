package com.mirbozorgi.shop.business.service;

import com.mirbozorgi.shop.business.domain.RateInfo;
import java.util.List;

public interface RateService {

  RateInfo add(int rateValue,
      String email,
      int productId);

  RateInfo update(
      int rateValue,
      int rateId);

  RateInfo get(int rateId);

  void delete(int rateId);

  List<RateInfo> getAll(int userId);

  List<RateInfo> getAllByProduct(int productId);
}
