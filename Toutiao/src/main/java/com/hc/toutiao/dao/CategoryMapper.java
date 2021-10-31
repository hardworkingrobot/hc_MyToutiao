package com.hc.toutiao.dao;

import com.hc.toutiao.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    void save(Category category);
    void update(Category category);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
