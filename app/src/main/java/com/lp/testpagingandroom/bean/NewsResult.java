package com.lp.testpagingandroom.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: liupan
 * @Date: 2020/11/20
 */
public class NewsResult {
    @SerializedName("list")
    public List<News> list;
}
