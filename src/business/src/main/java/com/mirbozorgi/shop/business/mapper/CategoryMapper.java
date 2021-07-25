package com.mirbozorgi.shop.business.mapper;

import com.mirbozorgi.shop.business.domain.CategoryInfo;
import com.mirbozorgi.shop.core.entity.Category;

public class CategoryMapper {

  public static CategoryInfo toInfo(Category category) {
    return new CategoryInfo(category.getName());
  }

}
