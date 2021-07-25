package com.mirbozorgi.shop.core.repository;

import com.mirbozorgi.shop.core.entity.Comment;
import java.util.List;

public interface CommentRepository {

  Comment add(Comment comment);

  Comment update(Comment comment);

  Comment get(int commentId);

  Comment delete(int rateId);

  List<Comment> getAll(int userId);
}
