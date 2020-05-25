package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lifecycle.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

//    최근에 백버튼을 누른 시간 기록
    long lastBackTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setUpEvents();
        setValues();

        Log.d("생명주기확인", "onCreate실행");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("생명주기확인","onResume실행");
    }

    @Override
    public void setUpEvents() {

        binding.moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, SecondActivity.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("생명주기확인","onPause실행");
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        long now = System.currentTimeMillis();

//        현재시간 - 지난번 백버튼 누른 시간이 1초 이상? (너무 오랜만에 누름)
        if (now - lastBackTime < 1000) {
            Toast.makeText(mContext, "한번 더 백버튼을 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            finish();
        }

//        언제 눌렀는지 기록 갱신
        lastBackTime = now;

    }
}
