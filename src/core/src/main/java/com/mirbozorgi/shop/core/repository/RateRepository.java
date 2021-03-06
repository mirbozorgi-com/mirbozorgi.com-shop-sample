package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Rate;
import java.util.List;

public interface RateRepository {


  Rate add(Rate rate);

  void update(int rateValue, int rateId);


  Rate getBy(String email, int productId);

  Rate get(int rateId);

  void delete(int rateId);

  List<Rate> getAll(Integer userId);

  List<Rate> getAllByProduct(Integer productId);

}
