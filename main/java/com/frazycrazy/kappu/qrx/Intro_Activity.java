package com.frazycrazy.kappu.qrx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Intro_Activity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_);

        sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime",true);
        if(firstTime){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime",firstTime);
                    editor.apply();
                }
            },50000);
        }
        else{
            Intent homeIntent = new Intent(Intro_Activity.this,Intro2_Activity.class);
            startActivity(homeIntent);
            finish();
        }
    }
    public void btn_intro(View view) {
        Intent homeIntent = new Intent(Intro_Activity.this,Intro2_Activity.class);
        startActivity(homeIntent);
        finish();
    }
}
