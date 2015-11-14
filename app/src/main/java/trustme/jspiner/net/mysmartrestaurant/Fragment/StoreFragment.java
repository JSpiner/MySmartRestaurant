package trustme.jspiner.net.mysmartrestaurant.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import trustme.jspiner.net.mysmartrestaurant.Activity.OrderActivity;
import trustme.jspiner.net.mysmartrestaurant.Activity.StoreActivity;
import trustme.jspiner.net.mysmartrestaurant.Adapter.StorePagerAdapter;
import trustme.jspiner.net.mysmartrestaurant.R;
import trustme.jspiner.net.mysmartrestaurant.Util;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class StoreFragment extends Fragment implements OnMapReadyCallback {

    //로그에 쓰일 tag
    public static final String TAG = StoreFragment.class.getSimpleName();


    @Bind(R.id.tab_main) TabLayout tabLayout;
    @Bind(R.id.pager_store) ViewPager pager;
    @Bind(R.id.btn_menu_order) Button btnOrder;

    int layoutId;
    Context context;

    public StoreFragment(){
        this.layoutId = R.layout.fragment_store;
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

        StorePagerAdapter adapter = new StorePagerAdapter(context, getChildFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        initMap();
    }

    void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @OnClick(R.id.btn_menu_order)
    void onOrderClick(){
        Intent intent = new Intent(context, OrderActivity.class);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG,"map ready");

        // Add a marker in Sydney and move the camera
        LatLng store = new LatLng(37.4987870, 127.0289790);
        googleMap.addMarker(new MarkerOptions().position(store).title("갓덴스시"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(store));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (store, 12.0f));

    }
}
