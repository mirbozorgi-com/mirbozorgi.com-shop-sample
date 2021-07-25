package com.mirbozorgi.shop.core.repository.impl;

import com.mirbozorgi.shop.core.entity.Category;
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
  public void update(
      int productId,
      String name,
      String price,
      String currency,
      String productImageUrl,
      Category category) {

    int i = entityManager.createQuery("update Product set"
        + " name = :name ,"
        + " price = :price ,"
        + " currency = :currency ,"
        + " productImageUrl = :productImageUrl "
        + " Where id = :id "

    )
        .setParameter("name", name)
        .setParameter("price", price)
        .setParameter("currency", currency)
        .setParameter("productImageUrl", productImageUrl)
        .setParameter("id", productId)
        .executeUpdate();
  }

  @Override
  public Product get(int productId) {
    return findById(Product.class, productId);
  }

  @Override
  public void delete(int productId) {
    Product product = get(productId);
    if (product!=null) {
      delete(Product.class, product);
    }
  }

  @Override
  public List<Product> getAll(
      String name,
      Integer minPrice,
      Integer maxPrice,
      Integer minRate,
      Integer maxRate,
      Integer categoryId) {

    return listQueryWrapper(
        entityManager
            .createQuery("select s from Product s where :name is null or s.name = :name",
                Product.class)
            .setParameter("name", name)
    );

  }

  @Override
  public void changeSumOfRate(
      int id,
      int changeRate) {

    updateQueryWrapper(entityManager
        .createQuery(
            "UPDATE Product o SET o.changeRate = o.changeRate + :changeRate WHERE o.id = :id ")
        .setParameter("changeRate", changeRate)
        .setParameter("id", id));

  }
}
