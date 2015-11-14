package trustme.jspiner.net.mysmartrestaurant.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class CustomViewPager extends ViewPager {

    private int mCurrentPagePosition = 0;
    private static final int MATCH_PARENT = 1073742592;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        if (getChildCount() != 0) {
            View child = getChildAt(mCurrentPagePosition);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height) height = h;
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void onPrevPage() {
        measure(MATCH_PARENT, 0);
    }

    public void onNextPage() {
        measure(MATCH_PARENT, 0);
    }

}
