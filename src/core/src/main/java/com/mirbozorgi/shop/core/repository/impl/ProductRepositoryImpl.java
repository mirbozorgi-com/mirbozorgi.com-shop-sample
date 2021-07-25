package com.mirbozorgi.shop.core.repository.impl;

import com.mirbozorgi.shop.core.entity.Product;
import com.mirbozorgi.shop.core.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends CustomRepository implements ProductRepository {

  @Override
  public Product add(Product product) {
    return save(Product.class, product);
  }

  @Override
  public Product update(Product product) {
    return null;
  }

  @Override
  public Product get(int productId) {
    return findById(Product.class, productId);
  }

  @Override
  public void delete(int productId) {
    Product product = get(productId);
     delete(Product.class, product);
  }

  @Override
  public List<Product> getAll(
      String name,
      Integer minPrice,
      Integer maxPrice,
      Integer minRate,
      Integer maxRate) {

    return listQueryWrapper(
        entityManager
            .createQuery("select s from Product s where :name is null or s.name = :name",
                Product.class)
            .setParameter("name", name)
    );

  }
}
