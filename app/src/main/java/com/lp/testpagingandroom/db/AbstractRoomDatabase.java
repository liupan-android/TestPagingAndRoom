package com.lp.testpagingandroom.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.lp.testpagingandroom.bean.News;
import com.lp.testpagingandroom.dao.NewsDao;

/**
 * @Author: liupan
 * @Date: 2020/11/20
 */
@Database(entities = {News.class}, version = 1)
public abstract class AbstractRoomDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}
