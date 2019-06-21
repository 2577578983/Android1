package com.example.myapplication.Propert.Ui_acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

public class Acivity_ban extends AppCompatActivity {

    private Toolbar mTb;
    private WebView mWv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_ban);
        initView();
    }

    private void initView() {
        mTb = (Toolbar) findViewById(R.id.tb);
        mWv = (WebView) findViewById(R.id.wv);
        Intent intent = getIntent();
        String ban = intent.getStringExtra("ban");
        mWv.loadUrl(ban);
        mWv.setWebViewClient(new WebViewClient());
        mTb.setTitle(ban);
    }
}