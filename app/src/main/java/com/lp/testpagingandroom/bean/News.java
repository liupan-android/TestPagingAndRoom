package com.lp.testpagingandroom.bean;

/**
 * @Author: liupan
 * @Date: 2020/11/18
 */
public class News {


    //新闻标题
    private String title;
    //时间
    private String time;
    //来源
    private String src;
    //图片
    private String pic;
    //新闻内容
    private String content;

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
