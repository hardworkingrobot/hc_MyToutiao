package com.hc.toutiao.test;

import org.junit.Test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class TestHttpURLConnection {

    @Test
    public void testHttpURLConnection(){
        String urlStr = "https://news.sina.com.cn/o/2021-10-26/doc-iktzscyy1912298.shtml";
        System.out.println(get(urlStr));

    }

    public static String get(String urlStr){
        String message="";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5*1000);
            //设置浏览器信息
            connection.setRequestProperty("User-agent","Mozilla/4.0");

            connection.connect();
            InputStream inputStream=connection.getInputStream();
            byte[] data=new byte[1024];
            StringBuffer sb=new StringBuffer();
            int length=0;
            while ((length=inputStream.read(data))!=-1){
                //String s=new String(data, Charset.forName("utf-8"));
                String s=new String(data,0,length, Charset.forName("utf-8"));
                sb.append(s);
            }
            message=sb.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
