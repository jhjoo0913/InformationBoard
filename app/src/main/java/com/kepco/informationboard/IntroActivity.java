/*
 * Created by keplor@naver.com on 2020-07-24
 * Github : http//github.com/EulerCauchyEquation
 */
package com.kepco.informationboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

/**
 * intro class
 */
public class IntroActivity extends AppCompatActivity {
    private static final int DELAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), StaffMenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_TIME);
    }
}