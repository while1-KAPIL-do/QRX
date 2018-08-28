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

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater ;
    private Integer [] img = {R.mipmap.s1,R.mipmap.s2,R.mipmap.s3,R.mipmap.s4,R.mipmap.s5,R.mipmap.s6};

    public ViewPagerAdapter(Context context){
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
        View view = layoutInflater.inflate(R.layout.custom_layout,null);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView img_name_tv = (TextView)view.findViewById(R.id.img_name_tv);
        imageView.setImageResource(img[position]);

        switch (position){
            case 0 :  img_name_tv.setText("Aadhar Card"); break;
            case 1 :  img_name_tv.setText("Website QR"); break;
            case 2 :  img_name_tv.setText("Product QR"); break;
            case 3 :  img_name_tv.setText("Location"); break;
            case 4 :  img_name_tv.setText("Shopping with QR"); break;
            case 5 :  img_name_tv.setText("And Many more Things.."); break;
        }

//        TextView l_textView = (TextView)view.findViewById(R.id.left_arrow_tv);
//        TextView r_textView = (TextView)view.findViewById(R.id.right_arrow_tv);
//        l_textView.setText("<");
//        r_textView.setText(">");
//
//        if(position==0) {
//            l_textView.setVisibility(View.INVISIBLE);
//            r_textView.setVisibility(View.VISIBLE);
//        }else if (position==5){
//            l_textView.setVisibility(View.VISIBLE);
//            r_textView.setVisibility(View.INVISIBLE);
//        }else{
//            l_textView.setVisibility(View.VISIBLE);
//            r_textView.setVisibility(View.VISIBLE);
//        }

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
