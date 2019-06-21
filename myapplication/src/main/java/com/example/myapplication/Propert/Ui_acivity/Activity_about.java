package com.example.myapplication.Propert.Ui_acivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.myapplication.R;

public class Activity_about extends AppCompatActivity {

    private TextView mAboutVersion;
    private TextView mAboutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {

    }
}
