package com.frazycrazy.kappu.qrx;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Feature_Activity extends AppCompatActivity {
    AdView mAdView_b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_);

        //********* BannerAd
        MobileAds.initialize(this,getResources().getString(R.string.app_1_Id));
        mAdView_b1 = findViewById(R.id.adview_b1);
        AdRequest mAdRequest = new AdRequest.Builder().build();
        mAdView_b1.loadAd(mAdRequest);
        //********* BannerAd


        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
