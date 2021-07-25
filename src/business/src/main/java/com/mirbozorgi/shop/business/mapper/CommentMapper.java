package com.mirbozorgi.shop.business.mapper;

import com.mirbozorgi.shop.business.domain.CommentInfo;
import com.mirbozorgi.shop.core.entity.Comment;

public class CommentMapper {

  public static CommentInfo toInfo(Comment comment) {
    return new CommentInfo(
        comment.getContent(),
        comment.getCreationDate(),
        comment.getUser().getEmail(),
        comment.getProduct().getName(),
        comment.getProduct().getProductImageUrl()

    );
  }

}
