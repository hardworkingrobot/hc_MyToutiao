package com.hc.toutiao.service;

import com.hc.toutiao.dao.CategoryMapper;
import com.hc.toutiao.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void save(Category category) {
        categoryMapper.save(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category findById(int id) {
        return categoryMapper.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }
}
