package trustme.jspiner.net.mysmartrestaurant.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;

import trustme.jspiner.net.mysmartrestaurant.R;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    void init(){

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);


                finish();

            }
        };

        handler.sendEmptyMessageDelayed(0,500);

    }
}
