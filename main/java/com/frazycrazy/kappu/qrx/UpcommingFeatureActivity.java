package com.frazycrazy.kappu.qrx;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class UpcommingFeatureActivity extends AppCompatActivity {
    AdView mAdView_b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomming_feature);

        //********* BannerAd
        MobileAds.initialize(this,getResources().getString(R.string.app_1_Id));
        mAdView_b2 = findViewById(R.id.adview_b2);
        AdRequest mAdRequest = new AdRequest.Builder().build();
        mAdView_b2.loadAd(mAdRequest);
        //********* BannerAd

        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter2 viewPagerAdapter = new ViewPagerAdapter2(this);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
