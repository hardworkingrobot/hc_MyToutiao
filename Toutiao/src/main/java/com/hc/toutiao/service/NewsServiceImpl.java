package com.hc.toutiao.service;

import com.hc.toutiao.dao.NewsMapper;
import com.hc.toutiao.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsMapper newsMapper;

    @Override
    public void save(News news) {
        newsMapper.save(news);
    }

    @Override
    public void update(News news) {
        newsMapper.update(news);
    }

    @Override
    public void delete(int id) {
        newsMapper.delete(id);
    }

    @Override
    public News findById(int id) {
        return newsMapper.findById(id);
    }

    @Override
    public List<News> findAll() {
        return newsMapper.findAll();
    }

    @Override
    public List<News> findByNewsTag(int newsTag, int pageStart, int pageSize) {
        return newsMapper.findByNewsTag(newsTag,pageStart,pageSize);
    }
}
