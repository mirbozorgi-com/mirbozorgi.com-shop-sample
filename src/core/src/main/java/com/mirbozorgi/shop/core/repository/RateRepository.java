package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Rate;
import java.util.List;

public interface RateRepository {


  Rate add(Rate rate);

  Rate update(Rate rate);

  Rate getByEmail(String email);

  Rate delete(int rateId);

  List<Rate> getAll(int userId);

}
