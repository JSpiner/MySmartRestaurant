package trustme.jspiner.net.mysmartrestaurant.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import trustme.jspiner.net.mysmartrestaurant.Adapter.StoreMenuAdapter;
import trustme.jspiner.net.mysmartrestaurant.Fragment.StoreFragment;
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
public class CheckMenuActivity extends AppCompatActivity {


    //로그에 쓰일 tag
    public static final String TAG = CheckMenuActivity.class.getSimpleName();

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_toolbar_title)
    TextView tvTitle;
    @Bind(R.id.searchView)
    SearchView searchView;
    @Bind(R.id.lv_menu)
    AnimatedExpandableListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkmenu);

        init();
    }

    void init(){

        ButterKnife.bind(this);

        initToolbar();

        ArrayList<Menu> mList = new ArrayList<>();
        Menu m = new Menu("식사류");
        m.items.add(new SubMenu("치킨"));
        m.items.add(new SubMenu("피자"));
        mList.add(m);
        m = new Menu("요리류");
        m.items.add(new SubMenu("스파게티"));
        m.items.add(new SubMenu("탕수육"));
        mList.add(m);

        StoreMenuAdapter adapter = new StoreMenuAdapter(getBaseContext());
        adapter.setData(mList);

        listView.setAdapter(adapter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                if (listView.isGroupExpanded(i)) {
                listView.collapseGroupWithAnimation(i);
            } else {
                listView.expandGroupWithAnimation(i);
            }
                return true;
            }
        });
    }

    void initToolbar(){


        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tvTitle.setText("메뉴선택(갓덴스시)");

        getFragmentManager().addOnBackStackChangedListener(new android.app.FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                onBackPressed();
            }
        });

        searchView.setVisibility(View.GONE);

    }


    @Override
    protected void onResume() {
        this.overridePendingTransition(0, 0);
        super.onResume();
    }

    @Override
    public void onBackPressed() {

        this.overridePendingTransition(0, 0);
        super.onBackPressed();
    }

}