package trustme.jspiner.net.mysmartrestaurant.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import trustme.jspiner.net.mysmartrestaurant.Fragment.MainFragment;
import trustme.jspiner.net.mysmartrestaurant.Fragment.SearchFragment;
import trustme.jspiner.net.mysmartrestaurant.Fragment.StoreFragment;
import trustme.jspiner.net.mysmartrestaurant.R;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class StoreActivity extends AppCompatActivity {


    //로그에 쓰일 tag
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tv_toolbar_title) TextView tvTitle;
    @Bind(R.id.searchView) SearchView searchView;

    private FragmentManager fragmentManager;
    private int fragmentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init(){

        ButterKnife.bind(this);

        initToolbar();
        initFragment();
    }

    void initToolbar(){


        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tvTitle.setText("갓덴스시");

        searchView.setVisibility(View.GONE);

    }

    void initFragment(){

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.layout_main, new StoreFragment()).commit();
        fragmentIndex=0;
    }

    //0 main    //1 search
    void changeFragment(int i){


        switch (i){
            case 0:
                fragmentManager.beginTransaction().replace(R.id.layout_main, new StoreFragment()).commit();
                fragmentIndex = i;
                break;
        }

    }

    @Override
    protected void onResume() {
        this.overridePendingTransition(0, 0);
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        switch (fragmentIndex){
            case 0:
                break;
            case 1:
                break;

        }

        this.overridePendingTransition(0, 0);
        super.onBackPressed();
    }

}
