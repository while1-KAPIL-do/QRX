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

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private Integer [] img = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6};

    ViewPagerAdapter(Context context){
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

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.custom_layout,null);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView img_name_tv = view.findViewById(R.id.img_name_tv);
        imageView.setImageResource(img[position]);

        switch (position){
            case 0 :  img_name_tv.setText("Aadhar Card"); break;
            case 1 :  img_name_tv.setText("Website QR"); break;
            case 2 :  img_name_tv.setText("Product QR"); break;
            case 3 :  img_name_tv.setText("Location"); break;
            case 4 :  img_name_tv.setText("Shopping with QR"); break;
            case 5 :  img_name_tv.setText("And Many more Things.."); break;
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
