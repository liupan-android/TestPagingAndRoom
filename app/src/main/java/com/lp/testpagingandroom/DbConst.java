package com.lp.testpagingandroom;

/**
 * @Author: liupan
 * @Date: 2020/11/20
 */
public class DbConst {

    //新闻实体News的数据库表名
    public static final String NEWS_TABLE_NAME = "table_news";
    //SQL--查询所有数据
    public static final String SQL_SELECT_ALL = "SELECT * FROM " + NEWS_TABLE_NAME;

    public static final String SQL_CREATE_TABLE_TEMP  = "CREATE TABLE temp AS SELECT news_title, news_time, news_src, news_img, news_content FROM " + NEWS_TABLE_NAME;

    public static final String SQL_DROP_TABLE_NEWS = "DROP TABLE " + NEWS_TABLE_NAME;

    public static final String SQL_ALERT_TABLE_NAME = "ALERT TABLE temp RENAME TO " + NEWS_TABLE_NAME;
}
