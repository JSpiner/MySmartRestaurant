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
public class SearchFragment extends Fragment {

    //로그에 쓰일 tag
    public static final String TAG = SearchFragment.class.getSimpleName();


    int layoutId;
    Context context;

    public SearchFragment(){
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

    }

}
