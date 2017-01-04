package com.yoflying.drivingschool.retrofit;

import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.Person;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public interface ApiStore {
    String BASE_URL="http://waddwaw.vicp.cc:14858/";

    @POST("restful/loginPost")
    Observable<HttpsResult<Person>> login(@Body RequestBody body);

    /**
     * 创建教练和学员
     * @param body
     * @param map
     * @return
     */
    @POST("manage/createCoachSt")
    Observable<HttpsResult> create(@Body RequestBody body, @HeaderMap Map<String,String> map);

    /**
     * 获取教练和学员的信息
     * @param map
     * @return
     */
    @GET("coachstudent/coachstudentInfo")
    Observable<HttpsResult> getUserInfo(@HeaderMap Map<String,String> map);

}
