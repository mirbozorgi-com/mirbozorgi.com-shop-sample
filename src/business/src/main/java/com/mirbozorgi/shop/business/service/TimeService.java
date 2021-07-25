package com.mirbozorgi.shop.business.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * default time zone is UTC
 */
public interface TimeService {

  long getNowUnixFromInstantClass();

}
