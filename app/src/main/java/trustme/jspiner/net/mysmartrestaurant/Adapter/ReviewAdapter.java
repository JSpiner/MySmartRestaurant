package trustme.jspiner.net.mysmartrestaurant.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import trustme.jspiner.net.mysmartrestaurant.R;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class ReviewAdapter   extends BaseAdapter {

    //로그에 쓰일 tag
    public static final String TAG = ReviewAdapter.class.getSimpleName();

    ArrayList<String> arrayList;
    Context context;

    LayoutInflater inflater;

    public ReviewAdapter(Context context, ArrayList<String> arrayList){
        this.arrayList = arrayList;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null) {
            view = inflater.inflate(R.layout.item_review_row, null);
//            ((TextView)view.findViewById(R.id.tv_setting_row)).setText(arrayList.get(i));
        }
        return view;
    }
}
