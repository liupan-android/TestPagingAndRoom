package com.lp.testpagingandroom.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.lp.testpagingandroom.DbConst;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
@Entity(tableName = DbConst.NEWS_TABLE_NAME)
public class News {

//    @PrimaryKey(autoGenerate = true)
//    public int id;

    //新闻标题
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "news_title")
    public String title;

    //时间
    @ColumnInfo(name = "news_time")
    public String time;

    //来源
    @ColumnInfo(name = "news_src")
    public String src;

    //图片
    @ColumnInfo(name = "news_img")
    public String pic;

    //新闻内容
    @ColumnInfo(name = "news_content")
    public String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
