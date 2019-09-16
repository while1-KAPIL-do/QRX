package com.frazycrazy.kappu.qrx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Intro2_Activity extends AppCompatActivity {

    SharedPreferences sharedPreferences2;
    Boolean firstTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2_);

        sharedPreferences2 = getSharedPreferences("MyPref",MODE_PRIVATE);
        firstTime2 = sharedPreferences2.getBoolean("firstTime",true);
        if(firstTime2){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {

                    SharedPreferences.Editor editor = sharedPreferences2.edit();
                    firstTime2 = false;
                    editor.putBoolean("firstTime",firstTime2);
                    editor.apply();
                }
            },50000);
        }
        else{
            Intent homeIntent2 = new Intent(Intro2_Activity.this,MainActivity.class);
            startActivity(homeIntent2);
            finish();
        }
    }
    public void btn_intro(View view) {
        Intent homeIntent2 = new Intent(Intro2_Activity.this,MainActivity.class);
        startActivity(homeIntent2);
        finish();
    }
}
