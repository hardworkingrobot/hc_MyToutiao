package com.hc.toutiao.dao;

import com.hc.toutiao.pojo.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class NewsMapperTest {
    @Autowired
    NewsMapper newsMapper;

    @Test
    public void testSelectAll(){
        List<News> news = newsMapper.findAll();
        System.out.println(news);
    }

    //根据新闻的标志：热点新闻，轮播图新闻，普通新闻
    @Test
    public void testSelectByNewsTag(){
        List<News> news = newsMapper.findByNewsTag(1,0,10);
        System.out.println(news);
    }

}
