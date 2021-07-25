package com.mirbozorgi.shop.business.mapper;

import com.mirbozorgi.shop.business.domain.CommentInfo;
import com.mirbozorgi.shop.business.domain.ProductInfo;
import com.mirbozorgi.shop.business.domain.RateInfo;
import com.mirbozorgi.shop.core.entity.Product;
import java.util.List;

public class ProductMapper {

  public static ProductInfo toInfo(
      Product product,
      List<CommentInfo> commentInfos,
      List<RateInfo> rateInfos) {
    return new ProductInfo(
        product.getName(),
        product.getPrice(),
        product.getCurrency(),
        product.getProductImageUrl(),
        product.getName(),
        commentInfos,
        rateInfos
    );
  }

}
