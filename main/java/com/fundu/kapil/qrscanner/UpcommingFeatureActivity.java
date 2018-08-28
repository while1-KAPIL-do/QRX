package com.fundu.kapil.qrscanner;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UpcommingFeatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomming_feature);


        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter2 viewPagerAdapter = new ViewPagerAdapter2(this);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
