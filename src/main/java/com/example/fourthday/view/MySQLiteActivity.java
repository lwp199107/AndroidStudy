package com.example.fourthday.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Aslan on 2016/9/10.
 */
public class MySQLiteActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
    }

    private void setView() {
        setContentView(R.layout.activity_my_sqlite);
    }

    public void studentClick(View view){
        StudentDaoImpl studentDao=new StudentDaoImpl(this);
        studentDao.addStudent(new Student("张三"));
        for (Student student : studentDao.queryAllStudent()) {
            Toast.makeText(this,student.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
