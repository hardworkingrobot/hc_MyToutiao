package com.hc.toutiao.vo;

import lombok.Data;

@Data
public class PeopleNews {
    private int id;
    private String title;
    private String url;
    private String date;
    private int nodeId;
    private int imgCount;
}
