package com.fundu.kapil.qrscanner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.method.ScrollingMovementMethod;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    TextView textView_result,txt_share,txt_brows;
    Button btn_search, btn_shr, btn_info;

    AdView mAdView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //************** Admob*************
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView)findViewById(R.id.adview);
        AdRequest mAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);
        //*********************************

        Toast.makeText(this, "Make sure Your Internet Connection is ON ", Toast.LENGTH_SHORT).show();

        txt_share = (TextView)findViewById(R.id.txt_share);
        txt_brows = (TextView)findViewById(R.id.txt_brows);

        // INFO BUTTON----> Popup MENU

        btn_info = (Button) findViewById(R.id.btn_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btn_info);
                popupMenu.getMenuInflater().inflate(R.menu.my_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1:
                                Intent i = new Intent(MainActivity.this,FunActivity.class);
                                startActivity(i);
                                return true;
                            case R.id.item2:
                                Intent j = new Intent(MainActivity.this,Feature_Activity.class);
                                startActivity(j);
                                return true;
                            case R.id.item3:
                                Intent k = new Intent(MainActivity.this,UpcommingFeatureActivity.class);
                                startActivity(k);
                                return true;
                            case R.id.item4:
                                Intent l = new Intent(MainActivity.this,AboutAuthorActivity.class);
                                startActivity(l);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
        //*********************

        textView_result = (TextView) findViewById(R.id.textView_result);
        btn_shr = (Button) findViewById(R.id.btn_share);
        btn_search = (Button) findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(Intent.ACTION_VIEW);
                k.setData(Uri.parse(textView_result.getText().toString()));
                startActivity(k);
            }
        });
    }

    public void btn_scan(View view) {
        final Activity activity = this;
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "You cancelled the scanning...!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,intentResult.getContents(), Toast.LENGTH_LONG).show();

                btn_shr.setVisibility(View.VISIBLE);
                textView_result.setVisibility(View.VISIBLE);
                txt_share.setVisibility(View.VISIBLE);
                textView_result.setMovementMethod(new ScrollingMovementMethod());

                if ((intentResult.getContents().substring(0, 3)).contentEquals("htt")) {
                    textView_result.setText(intentResult.getContents());

                    btn_search.setVisibility(View.VISIBLE);
                    txt_brows.setVisibility(View.VISIBLE);

                }
                else {
                    btn_search.setVisibility(View.INVISIBLE);
                    txt_brows.setVisibility(View.INVISIBLE);

                    if (intentResult.getContents().length() >= 0 && intentResult.getContents().length() <= 68) {
                        textView_result.setText(intentResult.getContents());
                    }
                    else
                    {
                        if ((((intentResult.getContents()).substring(0, 68)).compareTo("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <PrintLetterBarcodeData uid=\"")) == -22) {
                            textView_result.setText(convertToAadhar(intentResult.getContents()));
                        } else {
                            textView_result.setText(intentResult.getContents());
                        }
                    }
                }
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public static String convertToAadhar(String url) {

        return "ADHAR CARD\n"
                + "\nUserId  : " + kapilfun(url, "uid")
                + "\nName    : " + kapilfun(url, "name")
                + "\nSon Of  : " + kapilfun(url, "co")
                + "\nGender  : " + kapilfun(url, "gender")
                + "\nDOB     : " + kapilfun(url, "dob")
                + "\nHouse   : " + kapilfun(url, "house")
                + "\nStreet  : " + kapilfun(url, "street")
                + "\nLocal   : " + kapilfun(url, "loc")
                + "\nVillage : " + kapilfun(url, "vtc")
                + "\npost    : " + kapilfun(url, "po")
                + "\nDist    : " + kapilfun(url, "dist")
                + "\nSubdist : " + kapilfun(url, "subdist")
                + "\nState   : " + kapilfun(url, "state")
                + "\nPIN     : " + kapilfun(url, "pc");
    }
    private static String kapilfun(String myurl, String mykey) {

        int i, j, k = 0, count;
        char uid[] = new char[10];
        char value[] = new char[100];
        char url[] = myurl.toCharArray();
        char key[] = mykey.toCharArray();

        for (i = 0; i < url.length; i++) {
            if (url[i] == '\"') {
                // making the key by using "
                for (j = 0; (url[i + j - key.length - 1] != '\"'); j++) {
                    uid[j] = url[i + j - key.length - 1];
                }
                // check condition for our (key is valid )
                for (k = 0, count = 0; k < key.length; k++)
                    if (uid[k] == key[k])
                        count++;
                if (count == key.length && uid[count] == '=') {
                    System.out.print(new String(key) + " : ");
                    for (i = i + 1, k = 0; url[i] != '\"'; k++, i++)
                        value[k] = url[i];
                    return new String(value);
                } else {
                    continue;
                }
            }
        }
        return "not Avilable";
    }

    public void btn_share(View view) {
        Intent share_intent = new Intent(Intent.ACTION_SEND);
        share_intent.setType("text/plain");
        String shareBody = textView_result.getText().toString();
        String shareSub = "URL..";
        share_intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        share_intent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(share_intent, "Share using..."));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void btn_createQR(View view) {
        Intent l = new Intent(Intent.ACTION_VIEW);
        l.setData(Uri.parse("https://www.qr-code-generator.com/v5/?utm_expid=.klQ-n8qqQDWf3BLdT8i5Tw.1&utm_referrer=https%3A%2F%2Fwww.google.co.in%2F"));
        startActivity(l);
    }


}