package com.frazycrazy.kappu.qrx;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AboutAuthorActivity extends AppCompatActivity {
    AdView mAdView_b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_author);


        //********* BannerAd
        MobileAds.initialize(this,getResources().getString(R.string.app_1_Id));
        mAdView_b3 = findViewById(R.id.adview_b3);
        AdRequest mAdRequest = new AdRequest.Builder().build();
        mAdView_b3.loadAd(mAdRequest);
        //********* BannerAd

    }

    @SuppressLint("IntentReset")
    public void btn_gmail(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        String[] to = { "appbykapil@gamil.com"};
        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,"QR-X");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Send Email");
        startActivity(chooser);
    }


    public void btn_blog(View view) {
        Intent k = new Intent(Intent.ACTION_VIEW);
        k.setData(Uri.parse("http://www.007codbykappu.blogspot.com"));
        startActivity(k);
    }

    public void btn_linkedin(View view) {
        Intent k = new Intent(Intent.ACTION_VIEW);
        k.setData(Uri.parse("https://www.linkedin.com/in/kapil-agrawal-17295a147"));
        startActivity(k);
    }

    public void btn_yt(View view) {
        Intent k = new Intent(Intent.ACTION_VIEW);
        k.setData(Uri.parse("https://www.youtube.com/channel/UCHqnXtxSk6e7sGLoNCq8nZw"));
        startActivity(k);
    }

    public void btn_fbc(View view) {
        Intent k = new Intent(Intent.ACTION_VIEW);
        k.setData(Uri.parse("https://m.facebook.com/groups/1886458611606146/?ref=bookmarks"));
        startActivity(k);
    }
}
