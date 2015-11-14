package trustme.jspiner.net.mysmartrestaurant.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

import trustme.jspiner.net.mysmartrestaurant.Fragment.ReviewFragment;
import trustme.jspiner.net.mysmartrestaurant.Fragment.SearchFragment;
import trustme.jspiner.net.mysmartrestaurant.Fragment.StoreIntroFragment;
import trustme.jspiner.net.mysmartrestaurant.Fragment.StoreMenuFragment;

/**
 * Created by JSpiner on 2015. 6. 15..
 * Contact : jspiner@naver.com
 */
public class StorePagerAdapter extends FragmentStatePagerAdapter {

    //로그에 쓰일 tag
    public static final String TAG = StorePagerAdapter.class.getSimpleName();

    public Fragment[] FRAGMENTS;
    FragmentManager fm;

    public static Context context;

    public StorePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.fm = fm;
        this.context = context;
        FRAGMENTS = new Fragment[3];
        FRAGMENTS[0] = new StoreIntroFragment();
        FRAGMENTS[1] = new StoreMenuFragment();
        FRAGMENTS[2] = new ReviewFragment();
    }

    @Override
    public Fragment getItem(int position) {
        return FRAGMENTS[position];
    }

    @Override
    public int getCount() {
        return FRAGMENTS.length;
    }

    public void replace(Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fm.getFragments().get(0));

        ft.add(fragment, "");
        notifyDataSetChanged();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "정보";
            case 1:
                return "메뉴";
            case 2:
                return "리뷰(15)";
        }
        return "";
    }
}