package com.mirbozorgi.shop.core.repository.impl;

import com.mirbozorgi.shop.core.entity.Comment;
import com.mirbozorgi.shop.core.repository.CommentRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl extends CustomRepository implements CommentRepository {

  @Override
  public Comment add(Comment comment) {
    return save(Comment.class, comment);
  }

  @Override
  public void update(
      int id,
      String content) {
    int i = entityManager.createQuery("update Comment set"
        + " content = :content "
        + " Where id = :id ")
        .setParameter("id", id)
        .setParameter("content", content)
        .executeUpdate();
  }

  @Override
  public Comment get(int commentId) {
    return findById(Comment.class, commentId);
  }

  @Override
  public void delete(int commentId) {
    Comment comment = get(commentId);
    if (comment != null) {
      delete(Comment.class, comment);
    }
  }

  @Override
  public List<Comment> getAll(Integer userId) {
    return listQueryWrapper(
        entityManager
            .createQuery(
                "select s from Comment s where :userId is null or s.userSecurity.id = :userId",
                Comment.class)
            .setParameter("userId", userId)
    );
  }

  @Override
  public List<Comment> getAllByProduct(Integer productId) {
    return listQueryWrapper(
        entityManager
            .createQuery(
                "select s from Comment s where :productId is null or s.product.id = :productId",
                Comment.class)
            .setParameter("productId", productId)
    );  }
}
