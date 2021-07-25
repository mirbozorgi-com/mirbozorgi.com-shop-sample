package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.domain.RateInfo;
import com.mirbozorgi.shop.business.exception.NotFoundException;
import com.mirbozorgi.shop.business.mapper.RateMapper;
import com.mirbozorgi.shop.business.service.RateService;
import com.mirbozorgi.shop.business.service.TimeService;
import com.mirbozorgi.shop.core.entity.Product;
import com.mirbozorgi.shop.core.entity.Rate;
import com.mirbozorgi.shop.core.entity.UserSecurity;
import com.mirbozorgi.shop.core.repository.ProductRepository;
import com.mirbozorgi.shop.core.repository.RateRepository;
import com.mirbozorgi.shop.core.repository.UserSecurityRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

  @Autowired
  private RateRepository repository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserSecurityRepository userSecurityRepository;


  @Autowired
  private TimeService timeService;


  @Override
  public RateInfo add(int rateValue, String email, int productId) {
    UserSecurity userFounded = userSecurityRepository.getByEmail(email);
    if (userFounded == null) {
      throw new NotFoundException();
    }
    Product productFounded = productRepository.get(productId);
    if (productFounded == null) {
      throw new NotFoundException();
    }

    Rate rate = new Rate(
        rateValue,
        userFounded,
        productFounded
    );

    productRepository.changeSumOfRate(
        productId,
        rateValue
    );

    return RateMapper.toInfo(rate);
  }

  @Override
  public void update(int rateValue, int rateId) {
    get(rateId);
    repository.update(
        rateValue,
        rateId
    );
  }

  @Override
  public RateInfo get(int rateId) {
    Rate rate = repository.get(rateId);
    if (rate == null) {
      throw new NotFoundException();
    }
    return RateMapper.toInfo(rate);

  }

  @Override
  public void delete(int rateId) {
    repository.delete(rateId);
  }

  @Override
  public List<RateInfo> getAll(int userId) {
    List<RateInfo> rateInfos = new ArrayList<>();

    List<Rate> all = repository.getAll(userId);

    if (all == null) {
      return new ArrayList<>();
    }
    for (Rate rate : all) {
      rateInfos.add(RateMapper.toInfo(rate));
    }

    return rateInfos;
  }

  @Override
  public List<RateInfo> getAllByProduct(int productId) {
    List<RateInfo> rateInfos = new ArrayList<>();
    List<Rate> all = repository.getAllByProduct(productId);
    if (all == null) {
      return new ArrayList<>();
    }
    for (Rate rate : all) {
      rateInfos.add(RateMapper.toInfo(rate));
    }

    return rateInfos;
  }
}
