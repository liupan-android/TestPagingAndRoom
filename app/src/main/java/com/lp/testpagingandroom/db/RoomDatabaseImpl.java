package com.lp.testpagingandroom.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.lp.testpagingandroom.CustomApplication;
import com.lp.testpagingandroom.DbConst;

/**
 * @Author: liupan
 * @Date: 2020/11/20
 */
public class RoomDatabaseImpl{
    private static AbstractRoomDatabase instance = null;

    private RoomDatabaseImpl(){

    }

    public static AbstractRoomDatabase getInstance(){
        if(instance == null){
            synchronized (RoomDatabaseImpl.class){
                if (instance == null) {
                    instance = Room.databaseBuilder(CustomApplication.getContext(), AbstractRoomDatabase.class, "jisunews")
//                            .addMigrations(new Migration(1, 2) {
//                                @Override
//                                public void migrate(@NonNull SupportSQLiteDatabase database) {
//                                    database.execSQL(DbConst.SQL_CREATE_TABLE_TEMP);
//                                    database.execSQL(DbConst.SQL_DROP_TABLE_NEWS);
//                                    database.execSQL(DbConst.SQL_ALERT_TABLE_NAME);
//                                }
//                            })
                            .build();
                }
            }
        }
        return instance;
    }

//    enum DbEnum{
//        DATABASE;
//        private AbstractRoomDatabase instance;
//
//        private DbEnum(){
//            instance = Room.databaseBuilder()
//        }
//
//        public AbstractRoomDatabase getInstance() {
//            return instance;
//        }
//    }
}
