package com.example.fourthday.view;

/**
 * Created by Aslan on 2016/9/10.
 */
public interface FinalData {
    String DATABASE_NAME = "ht1626";
    String TABLE_NAME = "student";
    String COLUMN_ID = "_id";//--如果需要使用CursorAdapter 一定要提供_Id.
    String COLUMN_NAME = "name";
    int DATABASE_VERSION = 1;
}
