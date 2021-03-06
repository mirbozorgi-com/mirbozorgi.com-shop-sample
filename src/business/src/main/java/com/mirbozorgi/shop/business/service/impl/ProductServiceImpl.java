package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.domain.ProductInfo;
import com.mirbozorgi.shop.business.exception.NotFoundException;
import com.mirbozorgi.shop.business.mapper.ProductMapper;
import com.mirbozorgi.shop.business.service.CommentService;
import com.mirbozorgi.shop.business.service.ProductService;
import com.mirbozorgi.shop.business.service.RateService;
import com.mirbozorgi.shop.core.entity.Category;
import com.mirbozorgi.shop.core.entity.Product;
import com.mirbozorgi.shop.core.repository.CategoryRepository;
import com.mirbozorgi.shop.core.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository repository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private CommentService commentService;

  @Autowired
  private RateService rateService;

  @Transactional
  @Override
  public ProductInfo add(
      String name,
      long price,
      String currency,
      String productImageUrl,
      String category) {
    Category categoryFounded = categoryRepository.getByName(category);
    if (categoryFounded == null) {
      throw new NotFoundException();
    }
    Product product = new Product(
        name,
        price,
        currency,
        productImageUrl,
        categoryFounded
    );
    product = repository.add(product);

    return ProductMapper.toInfo(product, new ArrayList<>(), new ArrayList<>());
  }

  @Transactional
  @Override
  public void update(
      int productId,
      String name,
      long price,
      String currency,
      String productImageUrl,
      String categoryName) {
    Category categoryFounded = categoryRepository.getByName(categoryName);
    if (categoryFounded == null) {
      throw new NotFoundException();
    }
    Product product = repository.get(productId);
    if (product == null) {
      throw new NotFoundException();
    }

    repository.update(
        productId,
        name,
        price,
        currency,
        productImageUrl,
        categoryFounded
    );


  }

  @Override
  public ProductInfo get(int productId) {
    Product product = repository.get(productId);
    if (product == null) {
      throw new NotFoundException();
    }

    return ProductMapper.toInfo(
        product,
        commentService.getAllByProduct(productId),
        rateService.getAllByProduct(productId));
  }

  @Transactional
  @Override
  public void delete(int productId) {
    repository.delete(productId);
  }

  @Override
  public List<ProductInfo> getAll(
      String name,
      Long minPrice,
      Long maxPrice,
      String category) {
    List<ProductInfo> productInfos = new ArrayList<>();
    List<Product> all = repository.getAll(
        name,
        minPrice,
        maxPrice,
        categoryRepository.getByName(category).getId()
    );
    if (all == null) {
      return new ArrayList<>();
    }
    for (Product product : all) {
      productInfos.add(ProductMapper.toInfo(
          product,
          new ArrayList<>(),
          new ArrayList<>()
      ));
    }

    return productInfos;
  }
}
