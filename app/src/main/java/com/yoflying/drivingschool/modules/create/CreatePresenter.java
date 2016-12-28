package com.yoflying.drivingschool.modules.create;

import android.util.Log;

import com.google.gson.Gson;
import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.NewPerson;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.retrofit.ApiCallBack;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;

/**创建学员or教练控制器
 * Created by yaojiulong on 2016/12/26.
 */

public class CreatePresenter extends BasePresenter<ICreateView>{
    private ICreateView mCreateView;
    private NewPerson mNewPerson;
    private String mToken;
    public CreatePresenter(ICreateView createView) {
        this.mCreateView=createView;
        attachView(mCreateView);
    }

    public void getInfo(){
        NewPerson.Builder builder=new NewPerson.Builder(mCreateView.getPassword(),
                mCreateView.getUserName(),mCreateView.getIDnum(),mCreateView.getUserType(),mCreateView.getPhone(),1);
        mNewPerson=builder.address("民乐")
                .wechat("15845587")
                .sex(mCreateView.getSex())
                .course(mCreateView.getCourse())
                .userName("田老师").build();
        Gson gson=new Gson();
        String body=gson.toJson(mNewPerson);
        //Log.e("dandy","注册信息  "+body);
        Log.e("dandy","科目 "+mCreateView.getCourse());
        mToken= UtilSharedPreferences.getStringData(DriverApplication.getContextObject(), Config.KEY_TOKEN);
        create(body);

    }

    private void checkInfo(){


    }

    private void create(String route){
        ApiCallBack<HttpsResult> callBack=new ApiCallBack<HttpsResult>() {
            @Override
            public void onSuccess(HttpsResult model) {
                Log.e("dandy","注册成功 "+model.toString());
            }

            @Override
            public void onFailure(String msg) {
                Log.e("dandy","注册用户失败 "+msg);
            }

            @Override
            public void onFinish() {

            }
        };

        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Map<String,String> header=new HashMap<>();
        header.put("accesstoken",mToken);
        Log.e("dandy","注册信息 "+route);
        addSubscription(mApiStore.create(body,header),callBack);

    }




}
