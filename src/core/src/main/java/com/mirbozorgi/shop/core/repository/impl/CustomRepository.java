package com.mirbozorgi.shop.core.repository.impl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class CustomRepository {

  @PersistenceContext
  protected EntityManager entityManager;

  public <T> T findQueryWrapper(TypedQuery<T> typedQuery) {
    List<T> resultList = typedQuery.getResultList();
    if (!resultList.isEmpty()) {
      return resultList.get(0);
    } else {
      return null;
    }
  }

  public <T> List<T> listQueryWrapper(TypedQuery<T> typedQuery) {
    List<T> resultList = typedQuery.getResultList();
    if (resultList.isEmpty()) {
      return null;
    }
    return resultList;
  }


  public <T> void delete(Class<T> type, T entity) {
    entityManager.remove(entity);
  }

  public <T> T save(Class<T> type, T entity) {
    entityManager.persist(entity);
    return entity;
  }

  public <T> T findById(Class<T> type, Object id) {
    try {
      return entityManager.find(type, id);
    } catch (Exception e) {
      return null;
    }
  }
}

