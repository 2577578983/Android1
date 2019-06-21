package com.example.myapplication.Guide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Acivity_guide extends AppCompatActivity {

    private ImageView img;
    private ImageView ImgMark;
    ViewPropertyAnimation.Animator animator=new ViewPropertyAnimation.Animator(){

        @Override
        public void animate(View view) {
            view.setAlpha(0f);
            ObjectAnimator objAnimator=ObjectAnimator.ofFloat(view,"alpha",0f,1f);
            objAnimator.setDuration(1000);
            objAnimator.start();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        initStatus();
        setContentView(R.layout.activity_acivity_guide);
        img= (ImageView) findViewById(R.id.img_id);
        ImgMark= (ImageView) findViewById(R.id.icon_mark);
        ImgMark.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(Acivity_guide.this).load(R.drawable.benbenla)
                        .animate(animator).into(img);
                startAnimat();
            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }

    private void initStatus(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decoderView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decoderView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            //or ?
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    private void startAnimat(){

        int imgHeight=ImgMark.getHeight()/5;
        int height=getWindowManager().getDefaultDisplay().getHeight();
        int curY=height/2 + imgHeight/2;
        int dy=(height-imgHeight)/2;
        AnimatorSet set=new AnimatorSet();
        ObjectAnimator animatorTranslate=ObjectAnimator.ofFloat(ImgMark,"translationY",0,dy);
        ObjectAnimator animatorScaleX=ObjectAnimator.ofFloat(ImgMark,"ScaleX",1f,0.2f);
        ObjectAnimator animatorScaleY=ObjectAnimator.ofFloat(ImgMark,"ScaleY",1f,0.2f);
        ObjectAnimator animatorAlpha=ObjectAnimator.ofFloat(ImgMark,"alpha",1f,0.5f);
        set.play(animatorTranslate)
                .with(animatorScaleX).with(animatorScaleY).with(animatorAlpha);
        set.setDuration(1200);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                ImgMark.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Acivity_guide.this,MainActivity.class));
                        Acivity_guide.this.finish();
                    }
                },3000);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
