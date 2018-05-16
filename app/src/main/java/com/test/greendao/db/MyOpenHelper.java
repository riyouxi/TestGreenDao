package com.test.greendao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by shanshan on 2018/5/15.
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {


    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("TAG",oldVersion+"版本："+newVersion);
        MigrationHelper.migrate(db, UserDao.class);//数据版本变更才会执行
    }
}

