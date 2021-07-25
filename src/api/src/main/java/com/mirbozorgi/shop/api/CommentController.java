package com.mirbozorgi.shop.api;

import com.mirbozorgi.shop.business.context.aop.anotions.Auth;
import com.mirbozorgi.shop.business.service.CommentService;
import com.mirbozorgi.shop.model.CategoryUpdateModel;
import com.mirbozorgi.shop.model.CommentAddModel;
import com.mirbozorgi.shop.model.CommentUpdateModel;
import com.mirbozorgi.shop.model.DeleteModel;
import com.mirbozorgi.shop.util.helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/comment")
public class CommentController {

  @Autowired
  private CommentService commentService;


  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity add(@RequestBody CommentAddModel model) {
    return ResponseHelper.response(
        commentService.add(
            model.getContent(),
            model.getUserEmail(),
            model.getProductId()

        )
    );
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity update(@RequestBody CommentUpdateModel model) {
    commentService.update(
        model.getId(),
        model.getContent()
    );
    return ResponseHelper.response(true);

  }

  @RequestMapping(value = "/get-all", method = RequestMethod.GET)
  public ResponseEntity getAll(int userId) {
    return ResponseHelper
        .response(commentService.getAll(userId));
  }


  @RequestMapping(value = "/product/get-all", method = RequestMethod.GET)
  public ResponseEntity getAllProduct(int productId) {
    return ResponseHelper
        .response(commentService.getAllByProduct(productId));
  }


  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public ResponseEntity get(@RequestParam Integer id) {
    return ResponseHelper
        .response(commentService.get(id));
  }

  @Auth
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public ResponseEntity delete(@RequestBody DeleteModel model) {
    commentService.delete(model.getId());
    return ResponseHelper.response(true);
  }
}
