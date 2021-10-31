package com.hc.toutiao.test;

import com.hc.toutiao.pojo.News;
import com.hc.toutiao.service.SinaWebCrawerImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestSinaNewCrawer {

    @Autowired
    SinaWebCrawerImpl sinaWebCrawer;

    @Test
    public void testCrawer(){
        List<News> news = sinaWebCrawer.crawer();
        //System.out.println(news.get(3));
    }

    @Test
    public void testFindDate() throws IOException {

        String url = "https://news.sina.com.cn/w/2021-10-27/doc-iktzscyy2137793.shtml";

        //获取新闻内容
        Document document = Jsoup.connect(url).get();
        //获取来源和发布时间
        Element elSource = document.selectFirst("div.date-source > a.source");
        if (elSource!=null){
            System.out.println(elSource.text());
        }

        System.out.println("=============");
        //获取发布时间
        Element elDate = document.selectFirst("div.date-source > span.date");
        if (elDate!=null){
            System.out.println(elDate.text());
        }
        System.out.println("=============");
        //获取新闻内容
        Element elContent = document.selectFirst("div.article");
        if (elContent!=null){
            System.out.println(elContent.html());
        }
        System.out.println("=============");
        //获取新闻图片
        Element elImg = document.selectFirst("div.article > div.img_wrapper>img");
        if (elImg!=null){
            System.out.println(elImg.attr("src"));
        }
    }
}
