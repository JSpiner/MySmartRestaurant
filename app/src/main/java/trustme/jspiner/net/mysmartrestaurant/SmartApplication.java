package trustme.jspiner.net.mysmartrestaurant;

import android.app.Application;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class SmartApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    void init(){
        Util.context = getBaseContext();
    }
}
