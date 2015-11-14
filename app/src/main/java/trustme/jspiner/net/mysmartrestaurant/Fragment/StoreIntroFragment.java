package trustme.jspiner.net.mysmartrestaurant.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import trustme.jspiner.net.mysmartrestaurant.R;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class StoreIntroFragment extends Fragment {

    //로그에 쓰일 tag
    public static final String TAG = StoreIntroFragment.class.getSimpleName();


    int layoutId;
    Context context;

    public StoreIntroFragment(){
        this.layoutId = R.layout.fragment_store_intro;
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
