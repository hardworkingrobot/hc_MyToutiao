package com.hc.toutiao.service;

import com.hc.toutiao.pojo.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    void update(Category category);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
