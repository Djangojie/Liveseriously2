package com.example.diet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    TextView shareTv;
    LinearLayout pointLayout;
    List<View>viewList;   //ViewPager的数据源
    int[]picIds = {R.mipmap.ab1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        shareTv = findViewById(R.id.about_tv_share);
        shareTv.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
//        调用系统自带的分享功能
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg= "健康饮食和运动健康非常的重要，了解饮食各种营养素和热量，摄入正确的食物，设置合适的锻炼时间，让你变得更健康，快来下载本app吧~~";
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        startActivity(Intent.createChooser(intent,"自律健康"));
    }
}
