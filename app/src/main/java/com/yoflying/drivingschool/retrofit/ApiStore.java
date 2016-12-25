package com.yoflying.drivingschool.retrofit;

import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.Person;
import com.yoflying.drivingschool.bean.Person1;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public interface ApiStore {
    String BASE_URL="https://www.yoflying.com/restful/";

    @POST("loginPost")
    Observable<HttpsResult<Person1>> login(@Body RequestBody args);

}
