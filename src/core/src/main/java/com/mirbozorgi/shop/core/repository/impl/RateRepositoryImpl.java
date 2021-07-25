package com.mirbozorgi.shop.core.repository.impl;

import com.mirbozorgi.shop.core.entity.Rate;
import com.mirbozorgi.shop.core.repository.RateRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RateRepositoryImpl extends CustomRepository implements RateRepository {

  @Override
  public Rate add(Rate rate) {
    return save(Rate.class, rate);
  }

  @Override
  public void update(
      int rateValue,
      int rateId) {
    int i = entityManager.createQuery("update Rate set"
        + " rateValue = :rateValue "
        + " Where rateId = :rateId ")
        .setParameter("rateId", rateId)
        .setParameter("rateValue", rateValue)
        .executeUpdate();
  }

  @Override
  public Rate get(int rateId) {
    return findById(Rate.class, rateId);
  }

  @Override
  public void delete(int rateId) {
    Rate rate = get(rateId);
    if (rate!=null) {
      delete(Rate.class, rate);
    }
  }

  @Override
  public List<Rate> getAll(Integer userId) {
    return listQueryWrapper(
        entityManager
            .createQuery(
                "select s from Rate s where :userId is null or s.userSecurity.id = :userId",
                Rate.class)
            .setParameter("userId", userId)
    );
  }

  @Override
  public List<Rate> getAllByProduct(Integer productId) {
    return listQueryWrapper(
        entityManager
            .createQuery(
                "select s from Rate s where :productId is null or s.product.id = :productId",
                Rate.class)
            .setParameter("productId", productId)
    );  }
}
