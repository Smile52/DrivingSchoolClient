package com.yoflying.drivingschool.student.order;

import android.util.Log;

import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.retrofit.ApiCallBack;
import com.yoflying.drivingschool.student.bean.OrderInfo;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaojiulong on 2017/1/7.
 */

public class OrderPresenter extends BasePresenter<IOrderView>{
    private IOrderView mOrderView;
    private String mToken;

    public OrderPresenter(IOrderView mOrderView) {
        this.mOrderView = mOrderView;
        attachView(mOrderView);

        getOrderInfo();

    }

    private void getOrderInfo(){
        ApiCallBack<OrderInfo> subscriber=new ApiCallBack<OrderInfo>() {
            @Override
            public void onSuccess(OrderInfo model) {
                Log.e("dandy","成功了 "+model.toString());
            }

            @Override
            public void onFailure(String msg) {
                Log.e("dandy","错误了 "+msg);
            }

            @Override
            public void onFinish() {

            }
        };

        addSubscription(mApiStore.getOrderInfo(),subscriber);
    }

}
