package com.frazycrazy.kappu.qrx;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class FunActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);

        //********* InterstitialAd
        MobileAds.initialize(this,getResources().getString(R.string.app_1_Id));
        AdRequest mAdRequest2 = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(FunActivity.this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.app_1_interstitial_1));
        mInterstitialAd.loadAd(mAdRequest2);
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

            }
        });
        //********* / InterstitialAd

        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter3 viewPagerAdapter = new ViewPagerAdapter3(this);
        viewPager.setAdapter(viewPagerAdapter);

    }

}
