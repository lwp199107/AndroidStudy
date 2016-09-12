package com.example.fourthday.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fourthday.view.R;
import com.example.fourthday.annotation.MyAnnotation;

/**
 *1.SharePreferences xml文件存储.更多是用来做设置
 *      PreferenceActivity 专门用来做设置界面的Activity
 *
 *
 *
 * 4.数据库存储
 *      4.1 SQLIte3
 *      4.2 ContentProvider(内容提供者.不仅仅可以提供数据库还可以提供文件)
 *
 *
 * 5.网络存储
 *      云盘
 *
 *
 *1.SplashActivity ->欢迎界面
 *2.GuideActivity  ->引导界面
 *
 *
 * 作业:
 *      1.如何封装BaseActivity
 *
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 注解
     */
    @MyAnnotation(getId = 1)
    public void test(){

    }
}
