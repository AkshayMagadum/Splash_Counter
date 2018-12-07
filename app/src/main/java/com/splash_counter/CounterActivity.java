package com.splash_counter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener {
    //Widgets
    LinearLayout ll_start, ll_counter;
    TextView tv_start, tv_counter;
    ImageView iv_start;

    //Variables
    private static int TIME_OUT = 1000;
    private static final String TAG = "CounterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        find_view_by_id();
        onclick_listener();
    }

    private void find_view_by_id() {
        ll_start = findViewById(R.id.ll_start);
        iv_start = findViewById(R.id.iv_start);
        tv_start = findViewById(R.id.tv_start);

        ll_counter = findViewById(R.id.ll_counter);
        tv_counter = findViewById(R.id.tv_counter);
    }

    private void onclick_listener() {
        iv_start.setOnClickListener(this);
        tv_start.setOnClickListener(this);

        tv_counter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_start:
                startCounter();
                break;
            case R.id.tv_start:
                // startCounter();
                break;

        }
    }

    private void startCounter() {
        ll_start.setVisibility(View.GONE);
        ll_counter.setVisibility(View.VISIBLE);


        for (int i = 5; i >= 0; i--) {
            final int finalI = i;
            Log.e(TAG, "run: "+ finalI );
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (finalI) {
                        case 5:
                            tv_counter.setText("0");
                            Intent homeIntent = new Intent(CounterActivity.this, MainActivity.class);
                            startActivity(homeIntent);
                            break;
                        case 4:
                            tv_counter.setText("1");
                            break;
                        case 3:
                            tv_counter.setText("2");
                            break;
                        case 2:
                            tv_counter.setText("3");
                            break;
                        case 1:
                            tv_counter.setText("4");
                            break;
                        case 0:
                            tv_counter.setText("5");
                            break;

                    }
                }

            }, TIME_OUT * finalI);
        }
    }
}
