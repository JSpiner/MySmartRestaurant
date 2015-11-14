package trustme.jspiner.net.mysmartrestaurant.Model;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Copyright 2015 JSpiner. All rights reserved.
 *
 * @author JSpiner (jspiner@naver.com)
 * @project MySmartRestaurant
 * @since 2015. 11. 14.
 */
public interface HttpService {
        // 모든 REST API들은 이곳에 기입됨.
        @FormUrlEncoded
        @POST("/realtime/signup.php")
        void signUp(@Field("name") String name,
                    @Field("pw") String pw,
                    @Field("id") String email,
                    @Field("inscode") String inscode,
                    @Field("inscodee") String inscodee,
                    @Field("inscodeee") String inscodeee,
                    Callback<String> ret);
}
