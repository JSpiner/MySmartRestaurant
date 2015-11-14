package trustme.jspiner.net.mysmartrestaurant.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twotoasters.jazzylistview.JazzyListView;
import com.twotoasters.jazzylistview.effects.SlideInEffect;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import trustme.jspiner.net.mysmartrestaurant.Adapter.ReviewAdapter;
import trustme.jspiner.net.mysmartrestaurant.Adapter.StoreMenuAdapter;
import trustme.jspiner.net.mysmartrestaurant.Model.Menu;
import trustme.jspiner.net.mysmartrestaurant.Model.SubMenu;
import trustme.jspiner.net.mysmartrestaurant.R;
import trustme.jspiner.net.mysmartrestaurant.View.AnimatedExpandableListView;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class StoreMenuFragment extends Fragment {

    //로그에 쓰일 tag
    public static final String TAG = StoreMenuFragment.class.getSimpleName();

    @Bind(R.id.lv_menu) AnimatedExpandableListView listView;

    int layoutId;
    Context context;

    public StoreMenuFragment(){
        this.layoutId = R.layout.fragment_menu;
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

        ArrayList<Menu> mList = new ArrayList<>();

        for(int i=0;i<3;i++){
            Menu tmp = new Menu("식사류");
            tmp.items = new ArrayList<>();
            SubMenu tmp2;
            tmp2 = new SubMenu("치킨"); tmp.items.add(tmp2);
            tmp2 = new SubMenu("피자"); tmp.items.add(tmp2);
            tmp2 = new SubMenu("햄버거"); tmp.items.add(tmp2);
            tmp2 = new SubMenu("스파게티"); tmp.items.add(tmp2);
            mList.add(tmp);
        }

        StoreMenuAdapter adapter = new StoreMenuAdapter(context);
        adapter.setData(mList);
        listView.setAdapter(adapter);

    }

}
