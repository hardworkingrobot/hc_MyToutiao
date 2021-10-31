package com.hc.toutiao.service;

import com.alibaba.fastjson.JSON;
import com.hc.toutiao.pojo.News;
import com.hc.toutiao.utils.CrawerUtils;
import com.hc.toutiao.vo.PeopleNews;
import com.hc.toutiao.vo.PeopleNewsWrap;

import java.util.ArrayList;
import java.util.List;

public class PeopleNewsCrawer implements WebCrawerService{

    String newPageUrl = "http://news.people.com.cn/210801/211150/index.js?_=1635487149372";

    @Override
    public List<News> crawer() {
        List<News> newsList = new ArrayList<>();
        String indexPageContent = CrawerUtils.get(newPageUrl);
        //System.out.println(indexPageContent);
        PeopleNewsWrap peopleNewsWrap = JSON.parseObject(indexPageContent, PeopleNewsWrap.class);
        //System.out.println(peopleNewsWrap.getItems());
        System.out.println(peopleNewsWrap.getItems().get(0).getTitle());

        for (int i = 0; i < peopleNewsWrap.getItems().size(); i++) {
            News news = new News();
            PeopleNews peopleNews = peopleNewsWrap.getItems().get(i);
            news.setTitle(peopleNews.getTitle());
            news.setOriginalUrl(peopleNews.getUrl());
        }
        return newsList;
    }

    public static void main(String[] args) {
        PeopleNewsCrawer peopleNewsCrawer = new PeopleNewsCrawer();
        peopleNewsCrawer.crawer();
    }
}
