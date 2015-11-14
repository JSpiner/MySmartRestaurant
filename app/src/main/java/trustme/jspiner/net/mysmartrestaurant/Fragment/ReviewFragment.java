package trustme.jspiner.net.mysmartrestaurant.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.SlideInEffect;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import trustme.jspiner.net.mysmartrestaurant.Adapter.ReviewAdapter;
import trustme.jspiner.net.mysmartrestaurant.R;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class ReviewFragment extends Fragment {

    //로그에 쓰일 tag
    public static final String TAG = ReviewFragment.class.getSimpleName();

    @Bind(R.id.lv_review) JazzyListView listView;

    int layoutId;
    Context context;

    public ReviewFragment(){
        this.layoutId = R.layout.fragment_review;
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

        ArrayList<String> testData = new ArrayList<>();
        for(int i=0;i<10;i++) {
            testData.add("asdf");
        }
        ReviewAdapter adapter = new ReviewAdapter(context, testData);
        listView.setAdapter(adapter);
        listView.setTransitionEffect(new SlideInEffect());
    }

}
