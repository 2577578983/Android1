package com.example.myapplication.Propert.Ui_acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

public class Acivity_xiangmuWebView extends AppCompatActivity {

    private WebView mWv;
    private Toolbar mTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_xiangmu_web_view);
        initView();
    }

    private void initView() {
        mWv = (WebView) findViewById(R.id.wv);
        mTb = (Toolbar) findViewById(R.id.tb);
        Intent intent = getIntent();
        String da = intent.getStringExtra("da");
        mWv.loadUrl(da);
        mWv.setWebViewClient(new WebViewClient());
        mTb.setTitle(da);
    }
}
