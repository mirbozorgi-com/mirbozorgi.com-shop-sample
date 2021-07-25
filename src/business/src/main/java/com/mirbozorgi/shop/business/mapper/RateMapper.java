package com.mirbozorgi.shop.business.mapper;

import com.mirbozorgi.shop.business.domain.RateInfo;
import com.mirbozorgi.shop.core.entity.Rate;

public class RateMapper {

  public static RateInfo toInfo(Rate rate) {
    return new RateInfo(
        rate.getRateValue(),
        rate.getUser().getEmail(),
        rate.getProduct().getName(),
        rate.getProduct().getId()
    );
  }

}
