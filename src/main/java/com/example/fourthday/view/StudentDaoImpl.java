package com.example.fourthday.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aslan on 2016/9/10.
 */
public class StudentDaoImpl {

    private static final String TAG = "StudentDaoImpl";
    DBHelper mDBHelper;
    Context mContext;
    SQLiteDatabase mDB;
    List<Student> mStudentList;

    public StudentDaoImpl(Context mContext) {
        this.mContext = mContext;
        mDBHelper = new DBHelper(mContext, FinalData.DATABASE_NAME, null, FinalData.DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();//--在这里创建或打开数据库 read和write区别在于本地磁盘是否可写.
        //--read和write底层调用的都是同一个方法.getDatabaseLock(boolean)
    }

    //--1.增加一名学生
    public boolean addStudent(Student student) {

        if (student == null)
            return false;

//        mDB.execSQL(); //--传统的sql语句
        //String table,   表名
        //String nullColumnHack, 字段
        //ContentValues values  值
        ContentValues values = new ContentValues();//--是对map的封装
        // values.put(FinalData.COLUMN_ID,student.get_id());//--key 是表中的字段.values. 是字段的值
        values.put(FinalData.COLUMN_NAME, student.getName());


        return mDB.insert(FinalData.TABLE_NAME, null, values) > 0;
    }


    /**
     * 获取所有学生
     *
     * @return
     */
    public List<Student> queryAllStudent() {
//        mDB.rawQuery(sql,[]) //--sql 语句

        mStudentList= new ArrayList<>();

        //String table,   表名
        //String[] columns, 要查询的字段数组
        //String selection,  条件 比如 where id = ?
        //String[] selectionArgs,  条件的值 . 就是上面的?
        //String groupBy,  分组
        //String having,   筛选
        //String orderBy,  排序
        //String limit     限制
        Cursor cursor = mDB.query(FinalData.TABLE_NAME, null, null, null, null, null, null, null);
        //--Cursor 游标 等同于ResultSet 就是结果集
        //Log.i(TAG, (cursor.getCount()) + "cursor.getCount");
        while (cursor.moveToNext()) {
            Student stu = new Student();
            stu.set_id(cursor.getInt(cursor.getColumnIndex(FinalData.COLUMN_ID)));
            //Log.i(TAG, stu.get_id() + "id");
            stu.setName(cursor.getString(cursor.getColumnIndex(FinalData.COLUMN_NAME)));
           // Log.i(TAG, stu.getName() + "name");
            mStudentList.add(stu);
        }
        return mStudentList;
    }

    public boolean  updateStudent(int id,String name){
        ContentValues values=new ContentValues();
        values.put(FinalData.COLUMN_NAME,name);
        String where=FinalData.COLUMN_ID+"="+id;
        int resultCode=mDB.update(FinalData.TABLE_NAME,values,where,null);
        return resultCode>0;
    }

    public boolean deleteStudent(int id){
        String where= FinalData.COLUMN_ID+"="+id;
       return mDB.delete(FinalData.TABLE_NAME,where,null)>0;
    }
}
