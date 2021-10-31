package com.hc.toutiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private int id;
    private Category cateId;
    private String title;
    private String content;
    private String image1;
    private String image2;
    private String image3;
    private String movie;
    private Date releaseTime;
    private String editor;
    private int readCount;
    private int contentCount;
    private int newsStatus;
    private String newsSources;
    private int newsTag;
    private String originalUrl;
}
