package com.hc.toutiao.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

public class TestJsoup {
    @Test
    public void test1() throws IOException {
        String url = "https://news.sina.com.cn/";
        Document document = Jsoup.connect(url).get();
        String title = document.title();
        System.out.println(title);
        Elements links = document.select("a[href^=https://][href$=.shtml]");
        for (int i = 0; i < links.size(); i++) {
            Element el = links.get(i);
            System.out.println(el.attr("href")+"    "+el.text());
        }

    }
}
