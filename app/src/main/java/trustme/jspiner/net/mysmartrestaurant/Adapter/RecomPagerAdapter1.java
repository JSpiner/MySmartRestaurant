package trustme.jspiner.net.mysmartrestaurant.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import trustme.jspiner.net.mysmartrestaurant.Activity.MainActivity;
import trustme.jspiner.net.mysmartrestaurant.R;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class RecomPagerAdapter1 extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public RecomPagerAdapter1(Context c){
        this.context = c;
        this.inflater = LayoutInflater.from(c);
    }

    @Override
    public Object instantiateItem(View pager, int position){

        View v = null;

        v = inflater.inflate(R.layout.item_recom_store,null);
        ImageView imv1 = (ImageView)v.findViewById(R.id.iv_recomstore_1);
        ImageView imv2 = (ImageView)v.findViewById(R.id.iv_recomstore_2);
        ImageView imv3 = (ImageView)v.findViewById(R.id.iv_recomstore_3);

        Picasso.with(context)
                .load(R.drawable.sample5)
                .resize(400,400)
                .centerCrop()
                .into(imv1);
        Picasso.with(context)
                .load(R.drawable.sample2)
                .resize(400, 400)
                .centerCrop()
                .into(imv2);
        Picasso.with(context)
                .load(R.drawable.sample3)
                .resize(400, 400)
                .centerCrop()
                .into(imv3);

        imv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).onRecomSelect();
            }
        });

        imv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).onRecomSelect();
            }
        });

        imv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).onRecomSelect();
            }
        });

        ((ViewPager) pager).addView(v, 0);

        return v;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
      public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
