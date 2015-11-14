package trustme.jspiner.net.mysmartrestaurant.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
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
public class MainActivity extends AppCompatActivity {

    //로그에 쓰일 tag
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.searchView) SearchView searchView;
    @Bind(R.id.tv_toolbar_title) TextView tvTitle;
    @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;

    private FragmentManager fragmentManager;
    private int fragmentIndex;
    private ActionBarDrawerToggle toggle;

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

        toggle =
                new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(toggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toggle.syncState();

        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    tvTitle.setVisibility(View.INVISIBLE);
                    changeFragment(1);
                } else {
                    tvTitle.setVisibility(View.VISIBLE);
                    changeFragment(0);
                }
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    void initFragment(){

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.layout_main, new MainFragment()).commit();
        fragmentIndex=0;
    }

    //0 main    //1 search
    void changeFragment(int i){


        fragmentIndex = i;
        switch (i){
            case 0:
                fragmentManager.beginTransaction().replace(R.id.layout_main, new MainFragment()).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.layout_main, new SearchFragment()).commit();
//                fragmentManager.beginTransaction().addToBackStack("search");
//                fragmentManager.beginTransaction().commit();
                break;
        }

    }

    public void onRecomSelect(){
        Intent intent = new Intent(MainActivity.this, StoreActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        switch (fragmentIndex){
            case 0:
                break;
            case 1:
                break;

        }
        super.onBackPressed();
    }
}
