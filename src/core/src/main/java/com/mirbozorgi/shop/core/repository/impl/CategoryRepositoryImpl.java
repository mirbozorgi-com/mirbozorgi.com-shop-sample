package com.mirbozorgi.shop.core.repository.impl;

import com.mirbozorgi.shop.core.entity.Category;
import com.mirbozorgi.shop.core.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends CustomRepository implements CategoryRepository {

  @Override
  public Category add(Category category) {
    return save(Category.class, category);
  }

  @Override
  public Category update(int id, String name) {
    int i = entityManager.createQuery("update Category set"
        + " name = :name "
        + " Where id = :id ")
        .setParameter("id", id)
        .setParameter("name", name)
        .executeUpdate();
    return get(id);
  }

  @Override
  public Category get(int categoryId) {
    return findById(Category.class, categoryId);
  }

  @Override
  public Category getByName(String name) {
    return findQueryWrapper(entityManager
        .createQuery("select u from Category u where u.name= :name ",
            Category.class)
        .setParameter("name", name));
  }

  @Override
  public void delete(int categoryId) {
    Category category = get(categoryId);
    if (category != null) {
      delete(Category.class, category);
    }
  }

  @Override
  public List<Category> getAll() {
    return listQueryWrapper(entityManager.createQuery(
        "select g from Category g order by g.id desc ",
        Category.class));
  }
}
