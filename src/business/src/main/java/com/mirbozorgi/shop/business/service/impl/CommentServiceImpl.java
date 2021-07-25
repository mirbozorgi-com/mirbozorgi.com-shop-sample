package com.mirbozorgi.shop.business.service.impl;

import com.mirbozorgi.shop.business.domain.CommentInfo;
import com.mirbozorgi.shop.business.exception.NotFoundException;
import com.mirbozorgi.shop.business.mapper.CommentMapper;
import com.mirbozorgi.shop.business.service.CommentService;
import com.mirbozorgi.shop.business.service.TimeService;
import com.mirbozorgi.shop.core.entity.Comment;
import com.mirbozorgi.shop.core.entity.Product;
import com.mirbozorgi.shop.core.entity.UserSecurity;
import com.mirbozorgi.shop.core.repository.CommentRepository;
import com.mirbozorgi.shop.core.repository.ProductRepository;
import com.mirbozorgi.shop.core.repository.UserSecurityRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentRepository repository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserSecurityRepository userSecurityRepository;


  @Autowired
  private TimeService timeService;

  @Transactional
  @Override
  public CommentInfo add(
      String content,
      String userEmail,
      int productId) {
    UserSecurity userFounded = userSecurityRepository.getByEmail(userEmail);
    if (userFounded == null) {
      throw new NotFoundException();
    }
    Product productFounded = productRepository.get(productId);
    if (productFounded == null) {
      throw new NotFoundException();
    }

    Comment comment = new Comment(
        content,
        timeService.getNowUnixFromInstantClass(),
        userFounded,
        productFounded
    );
    return CommentMapper.toInfo(repository.add(comment));
  }

  @Transactional
  @Override
  public void update(int id, String content) {
    get(id);
    repository.update(
        id,
        content
    );
  }

  @Override
  public CommentInfo get(int commentId) {
    Comment comment = repository.get(commentId);
    if (comment == null) {
      throw new NotFoundException();
    }
    return CommentMapper.toInfo(comment);
  }

  @Transactional
  @Override
  public void delete(int commentId) {
    repository.delete(commentId);
  }

  @Override
  public List<CommentInfo> getAll(Integer userId) {
    List<Comment> all = repository.getAll(userId);
    if (all == null) {
      return new ArrayList<>();
    }

    List<CommentInfo> commentInfos = new ArrayList<>();
    for (Comment comment : all) {
      commentInfos.add(CommentMapper.toInfo(comment));
    }

    return commentInfos;
  }

  @Override
  public List<CommentInfo> getAllByProduct(Integer productId) {
    List<Comment> all = repository.getAllByProduct(productId);
    if (all == null) {
      return new ArrayList<>();
    }
    List<CommentInfo> commentInfos = new ArrayList<>();
    for (Comment comment : all) {
      commentInfos.add(CommentMapper.toInfo(comment));
    }

    return commentInfos;
  }
}
