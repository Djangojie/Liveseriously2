package com.example.diet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.diet.bean.DBhelper;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int time = 5;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {       //what是用来保存消息标示的
                time--;              //发送一次就-1
                if (time ==0) {
                    //  跳转页面
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,HomeMenuActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    tv.setText(time+"");
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DBhelper dBhelper = new DBhelper();
        tv = findViewById(R.id.main_tv);
        handler.sendEmptyMessageDelayed(1,1000); //每一秒发送一次
    }
}