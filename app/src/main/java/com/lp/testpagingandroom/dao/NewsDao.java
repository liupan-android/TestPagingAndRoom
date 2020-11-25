package com.lp.testpagingandroom.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.lp.testpagingandroom.DbConst;
import com.lp.testpagingandroom.bean.News;

import java.util.List;

/**
 * @Author: liupan
 * @Date: 2020/11/20
 */

@Dao
public interface NewsDao {

    @Query(DbConst.SQL_SELECT_ALL)
    List<News> getAllNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNews(List<News> list);
}
