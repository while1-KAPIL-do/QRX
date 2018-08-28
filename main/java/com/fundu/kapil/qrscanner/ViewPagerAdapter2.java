package com.fundu.kapil.qrscanner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kapil on 7/23/2018.
 */

public class ViewPagerAdapter2 extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater ;
    private Integer [] img = {R.mipmap.f2,R.mipmap.f4};

    public ViewPagerAdapter2(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout2,null);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView img_name_tv = (TextView)view.findViewById(R.id.img_name_tv);
        TextView ims_abt_tv = (TextView)view.findViewById(R.id.img_abt_tv);

        imageView.setImageResource(img[position]);


        switch (position){

            case 0 :  img_name_tv.setText("QR Invitation (QRI)");
                ims_abt_tv.setText("\" You can Create your Own beautiful invitation Card and just share QR Code to invite people , so soon...\"");
                    break;

            case 1 :  img_name_tv.setText("QR Card (QRC)");
                ims_abt_tv.setText("\" Create your own ID-Card here , and Share the QR which contain all your info. , so soon... \"");
                    break;

        }

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return  view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View)object;
        viewPager.removeView(view);
    }
}
