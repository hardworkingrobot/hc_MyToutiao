package com.hc.toutiao.controller;

import com.hc.toutiao.pojo.News;
import com.hc.toutiao.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<News> findAll(){
        List<News> news = newsService.findAll();
        return news;
    }

    //轮播图可以通过这个来查询
    @RequestMapping("/findByNewsTag")
    @ResponseBody
    public List<News> findByNewsTag(int newsTag){
        List<News> news = newsService.findByNewsTag(newsTag,0,1);
        return news;
    }

    //获取最新的6条新闻：根据时间排序，查询普通新闻
    @RequestMapping("/latesNews")
    @ResponseBody
    public List<News> latesNews(){
        List<News> news = newsService.findByNewsTag(0,0,6);
        return news;
    }

}
