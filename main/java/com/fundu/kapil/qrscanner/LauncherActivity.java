package com.fundu.kapil.qrscanner;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

    private  static  int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeIntent = new Intent(LauncherActivity.this,Intro_Activity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
