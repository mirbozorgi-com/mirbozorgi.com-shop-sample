package com.mirbozorgi.shop.api;

import com.mirbozorgi.shop.business.service.CategoryService;
import com.mirbozorgi.shop.model.CategoryAddModel;
import com.mirbozorgi.shop.model.CategoryUpdateModel;
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
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity add(@RequestBody CategoryAddModel model) {
    return ResponseHelper.response(
        categoryService.add(model.getName())
    );
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity update(@RequestBody CategoryUpdateModel model) {
    categoryService.update(model.getId(), model.getName());
    return ResponseHelper.response(true);

  }

  @RequestMapping(value = "/get-all", method = RequestMethod.GET)
  public ResponseEntity getAll() {
    return ResponseHelper
        .response(categoryService.getAll());
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public ResponseEntity get(@RequestParam Integer id) {
    return ResponseHelper
        .response(categoryService.get(id));
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public ResponseEntity delete(@RequestBody DeleteModel model) {
    categoryService.delete(model.getId());
    return ResponseHelper.response(true);
  }


}
