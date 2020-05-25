package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpEvents();
        setValues();

        Log.d("생명주기확인", "onCreate실행");
    }

    @Override
    public void setUpEvents() {

    }

    @Override
    public void setValues() {

    }
}
