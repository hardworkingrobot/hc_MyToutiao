package com.hc.toutiao.service;

import com.hc.toutiao.pojo.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SinaWebCrawerImpl implements WebCrawerService{

    String newPageUrl = "https://news.sina.com.cn/";
    int count=0;

    @Override
    public List<News> crawer() {
        //新浪网站的爬虫
        //1、抓取新闻首页的链接
        try {
            List<News> newsList = crawerIndexPageLink(newPageUrl);
        //2、获取每个链接的内容
            for (int i = 0; i < newsList.size(); i++) {
                //getNewsContent(newsList.get(i));
                News news = newsList.get(i);
                //获取新闻内容
                Document document = Jsoup.connect(news.getOriginalUrl()).get();
                //获取来源和发布时间
                Element elSource = document.selectFirst("div.date-source > a.source");
                if (elSource!=null){
                    news.setNewsSources(elSource.text());
                }
                //获取发布时间
                Element elDate = document.selectFirst("div.date-source > span.date");
                if (elDate!=null){
                    //System.out.println(elDate.text());
                }

                //获取新闻内容
                Element elContent = document.selectFirst("div.article");
                if (elContent!=null){
                    news.setContent(elContent.html());
                    //System.out.println(elContent.html());
                }

                //获取新闻图片
                Element elImg = document.selectFirst("div.article > div.img_wrapper>img");
                if (elImg!=null){
                    //System.out.println(elImg.attr("src"));
                    news.setImage1(elImg.attr("src"));
                    count++;
                }
            }
            System.out.println("图片有"+count);
            return newsList;
        //3、保存数据到数据库

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

    List<News> crawerIndexPageLink(String url) throws IOException {

        List<News> newsList = new ArrayList<>();

        Document document = Jsoup.connect(url).get();
//        String title = document.title();
//        System.out.println(title);
        //Elements links = document.select("a[href^=https://][href$=.shtml]");
        Elements links = document.select("a[href^=https://][href$=.shtml][href*=doc-],a[href^=https://][href$=.shtml][href*=detail-]");
        for (int i = 0; i < links.size(); i++) {
            News news = new News();
            Element el = links.get(i);
            System.out.println(el.attr("href")+"    "+el.text());

            news.setTitle(el.text());
            news.setOriginalUrl(el.attr("href"));

            newsList.add(news);
        }
        System.out.println("=====总条数===:"+links.size());
        return newsList;
    }

    void getNewsContent(News news) throws IOException {
        //获取新闻内容
        Document document = Jsoup.connect(news.getOriginalUrl()).get();
        //获取来源和发布时间
        Element elSource = document.selectFirst("div.date-source > a.source");
        if (elSource!=null){
            news.setNewsSources(elSource.text());
        }
        //获取发布时间
        Element elDate = document.selectFirst("div.date-source > span.date");
        if (elDate!=null){
            System.out.println(elDate.text());
        }

        //获取新闻内容
        Element elContent = document.selectFirst("div.article");
        if (elContent!=null){
            news.setContent(elContent.html());
            System.out.println(elContent.html());
        }

        //获取新闻图片
        Element elImg = document.selectFirst("div.article > div.img_wrapper>img");
        if (elImg!=null){
            System.out.println(elImg.attr("src"));
            news.setImage1(elImg.attr("src"));
        }
    }


}

