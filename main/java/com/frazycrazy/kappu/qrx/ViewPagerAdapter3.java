package com.frazycrazy.kappu.qrx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
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

public class ViewPagerAdapter3 extends PagerAdapter {

    private Context context;
    private Integer [] img = {R.drawable.f1,R.drawable.f3,R.drawable.f5};

    ViewPagerAdapter3(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout3,null);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView img_name_tv = view.findViewById(R.id.img_name_tv);
        TextView ims_abt_tv = view.findViewById(R.id.img_abt_tv);

        imageView.setImageResource(img[position]);


        switch (position){
            case 0 :  img_name_tv.setText("QR Secret");
                      ims_abt_tv.setText("\" Share your secrete with friends by QR code - just drop your secrete on BUILDER and SHARE these QR code with your friends \"");
                      break;

            case 1 :  img_name_tv.setText("QR Messenger (QRM)");
                      ims_abt_tv.setText("\" just drop your message on BUILDER and Share the QR code with your friends !\"");
                    break;

            case 2 :  img_name_tv.setText("Social site profile / post");
                ims_abt_tv.setText("\" Send your Profile by creating your own QR code , just copy the link and paste on BUILDER and SHARE the QR code with friends \"");
                    break;
        }

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return  view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View)object;
        viewPager.removeView(view);
    }
}
