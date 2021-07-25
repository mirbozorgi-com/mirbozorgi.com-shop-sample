package com.mirbozorgi.shop.business.service.impl;


import com.mirbozorgi.shop.business.service.TimeService;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

  @Override
  public long getNowUnixFromInstantClass() {
    Instant instant = Instant.now();
    return instant.getEpochSecond();
  }

}
