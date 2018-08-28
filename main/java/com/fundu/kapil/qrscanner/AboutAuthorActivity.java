package com.fundu.kapil.qrscanner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutAuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_author);
    }

    public void btn_gmail(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        String[] to = { "agrawalkapil543@gamil.com"};
        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,"QR-X");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i,"Send Email");
        startActivity(chooser);
    }

    public void btn_dial(View view) {
        Intent j = new Intent(Intent.ACTION_DIAL);
        j.setData(Uri.parse("tel:+917772022364"));
        startActivity(j);
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
