package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Rate;
import java.util.List;

public interface RateRepository {


  Rate add(Rate rate);

  Rate update(int rateValue,
      int rateId);

  Rate get(int rateId);

  void delete(int rateId);

  List<Rate> getAll(int userId);

}
