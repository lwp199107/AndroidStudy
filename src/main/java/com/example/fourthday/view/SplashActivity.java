package com.example.fourthday.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.fourthday.view.R;

/**
 * 欢迎界面
 *
 * 在android2.3 api10之后不允许在UI线程执行任何耗时操作
 * 避免ANR(应用无法响应),FC.所有的耗时操作需要放在子线程中
 *
 * Created by Aslan on 2016/9/10.
 */
public class SplashActivity extends AppCompatActivity{
    public static final int SKIP_TIME = 1;
    TextView mTextView;
    int count=3;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int result=msg.getData().getInt("time");
            switch (msg.what){
                case SKIP_TIME:
                    mTextView.setText(result+"");
                    if (result==0){
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        SplashActivity.this.finish();
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
    }

    private void initView() {
        mTextView= (TextView) findViewById(R.id.tv_showtime);
    }

    /**
     * 当用户可以看到界面时已经走完了onCreate,onStart
     */
    @Override
    protected void onResume() {
        super.onResume();
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (count!=0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    Bundle bundle=new Bundle();
                    bundle.putInt("time",count);
                    Message msg=new Message();
                    msg.setData(bundle);
                    msg.what=SKIP_TIME;
                    mHandler.sendMessage(msg);
                }
            }
        }.start();
    }
    private void setView() {
        setContentView(R.layout.splash_acticity);
    }
    public void onClick(View view){

    }

}
