package com.splash_counter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    TextView tv_lable;
    private static int SPLASH_TIME_OUT = 5000;
    private static int TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        tv_lable = findViewById(R.id.tv_lable);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                tv_lable.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.slide_down);
                tv_lable.startAnimation(animation);
            }
        }, TIME_OUT);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashScreenActivity.this, CounterActivity.class);
                startActivity(splashIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
