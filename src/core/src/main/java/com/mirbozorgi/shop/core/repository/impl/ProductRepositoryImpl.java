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
      long price,
      String currency,
      String productImageUrl,
      Category category) {

    int i = entityManager.createQuery("update Product set"
        + " name = :name ,"
        + " price = :price ,"
        + " currency = :currency ,"
        + " category = :category ,"
        + " productImageUrl = :productImageUrl "
        + " Where id = :id "

    )
        .setParameter("name", name)
        .setParameter("price", price)
        .setParameter("currency", currency)
        .setParameter("productImageUrl", productImageUrl)
        .setParameter("category", category)
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
    if (product != null) {
      delete(Product.class, product);
    }
  }

  @Override
  public List<Product> getAll(
      String name,
      Long minPrice,
      Long maxPrice,
      Integer categoryId) {

    return listQueryWrapper(
        entityManager
            .createQuery("select s from Product s where s.name = :name or :name = null"
                    + " and s.category.id = :categoryId or :categoryId = null "
                    + "and s.prices < :maxPrice"
                    + " and s.prices > :minPrice",
                Product.class)
            .setParameter("name", name)
            .setParameter("minPrice", minPrice)
            .setParameter("maxPrice", maxPrice)
            .setParameter("categoryId", categoryId)
    );

  }

  @Override
  public void changeSumOfRate(
      int id,
      int sumOfRates) {

    Long longSumOfRate = 0L;
    String str = String.valueOf(sumOfRates);
    longSumOfRate = Long.parseLong(str);

    updateQueryWrapper(entityManager
        .createQuery(
            "UPDATE Product o SET o.sumOfRates = o.sumOfRates + :sumOfRates WHERE o.id = :id ")
        .setParameter("sumOfRates", longSumOfRate)
        .setParameter("id", id));
  }
}
