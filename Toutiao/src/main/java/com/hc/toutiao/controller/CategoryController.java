package com.hc.toutiao.controller;

import com.hc.toutiao.pojo.Category;
import com.hc.toutiao.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Category> findAll(){
        List<Category> categories = categoryService.findAll();
        return categories;
    }
}
