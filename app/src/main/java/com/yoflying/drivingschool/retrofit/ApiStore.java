package com.yoflying.drivingschool.retrofit;

import com.yoflying.drivingschool.bean.Admin;
import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.Person;
import com.yoflying.drivingschool.student.bean.OrderInfo;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public interface ApiStore {
    String BASE_URL="http://waddwaw.vicp.cc:14858/";
   // String BASE_URL="http://192.168.0.103:8080/";

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
     * @return
     */
    @GET("coachstudent/coachstudentInfo")
    Observable<HttpsResult<Person>> getUserInfo();

    /**
     * 获取管理员信息
     * @return
     */
    @GET("manage/manageInfo")
    Observable<HttpsResult<Admin>> getAdminInfo();

    @GET("coachstudent/student/getAppointment")
    Observable<OrderInfo> getOrderInfo();

    /**
     * 获取学员列表
     * @param map
     * @return
     */
    @GET("manage/findStudentList")
    Observable<HttpsResult<List<Person>>> getStudentList(@QueryMap Map<String,String> map);

    /**
     * 获取教练列表
     * @param map
     * @return
     */
    @GET("manage/findCoachList")
    Observable<HttpsResult<List<Person>>> getTeacherList(@QueryMap  Map<String,String> map);

    /**
     * 搜索学员或者教练
     * @param map
     * @return
     */
    @GET("manage/searchCoachStList")
    Observable<HttpsResult<List<Person>>> searchPerson(@QueryMap Map<String,String> map);
}
