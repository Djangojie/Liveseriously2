package com.example.diet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diet.food_list.InfoListActivity;

public class HomeMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.home_btn1:
                intent.setClass(HomeMenuActivity.this, InfoListActivity.class);
                break;
            case R.id.home_btn3:
                intent.setClass(HomeMenuActivity.this, AboutActivity.class);
                break;
//            case R.id.home_btn2:
//                intent.setClass(HomeMenuActivity.this,)
        }
        startActivity(intent);

    }
}
