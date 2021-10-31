package com.hc.toutiao.service;

import com.hc.toutiao.pojo.News;

import java.util.List;

public interface NewsService {
    void save(News news);
    void update(News news);
    void delete(int id);
    News findById(int id);
    List<News> findAll();
    List<News> findByNewsTag(int newsTag, int pageStart, int pageSize);
}
