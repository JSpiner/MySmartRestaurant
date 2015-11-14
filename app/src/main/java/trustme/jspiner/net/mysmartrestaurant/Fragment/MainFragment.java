package trustme.jspiner.net.mysmartrestaurant.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import trustme.jspiner.net.mysmartrestaurant.Adapter.RecomPagerAdapter1;
import trustme.jspiner.net.mysmartrestaurant.R;
import trustme.jspiner.net.mysmartrestaurant.Util;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class MainFragment extends Fragment {

    //로그에 쓰일 tag
    public static final String TAG = MainFragment.class.getSimpleName();

    @Bind(R.id.layout_recommand) LinearLayout layoutRecommand;

    int layoutId;
    Context context;

    public MainFragment(){
        this.layoutId = R.layout.fragment_main;
    }

    @Override
    public void onAttach(Activity activity) {
        this.context = activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;

        v = inflater.inflate(layoutId, container, false);


        init(v);

        return v;
    }

    void init(View v){

        ButterKnife.bind(this, v);

        layoutRecommand.addView(makeRecommandView("홍대 BEST 10 >"));
        layoutRecommand.addView(makeRecommandView("강남 BEST 10 >"));
        layoutRecommand.addView(makeRecommandView("건대 BEST 10 >"));
        layoutRecommand.addView(makeRecommandView("이대 BEST 10 >"));
    }

    View makeRecommandView(String title){

        LayoutInflater inflater = LayoutInflater.from(context);

        final View view = inflater.inflate(R.layout.item_recom_region1, null);

        ((TextView)view.findViewById(R.id.tv_recomregion1_title)).setText(title);

        ViewPager pager = (ViewPager)view.findViewById(R.id.pager_recom1);
        RecomPagerAdapter1 adapter = new RecomPagerAdapter1(context);
        pager.setAdapter(adapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 5; i++) {
                    ((ImageView) view.findViewById(R.id.iv_recomregion1_indic1+i))
                            .setImageResource(R.drawable.radius_white);

                }

                ((ImageView) view.findViewById(R.id.iv_recomregion1_indic1+position))
                        .setImageResource(R.drawable.radius_black);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
}
