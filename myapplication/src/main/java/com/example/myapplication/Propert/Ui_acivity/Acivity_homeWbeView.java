package com.example.myapplication.Propert.Ui_acivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

public class Acivity_homeWbeView extends AppCompatActivity {

    private WebView mWv;
    private Toolbar mTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_home_wbe_view);
        initView();
    }

    private void initView() {
        mWv = (WebView) findViewById(R.id.wv);

        mTb = (Toolbar) findViewById(R.id.tb);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        String ban = intent.getStringExtra("ban");
        mWv.loadUrl(ban);
        mWv.loadUrl(data);
        mWv.setWebViewClient(new WebViewClient());
        mTb.setTitle(data);
    }
}
