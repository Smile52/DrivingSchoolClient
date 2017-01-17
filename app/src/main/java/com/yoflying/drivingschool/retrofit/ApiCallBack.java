package com.yoflying.drivingschool.retrofit;

import android.util.Log;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**封装订阅者
 * Created by yaojiulong on 2016/12/27.
 */

public abstract class ApiCallBack<M> extends Subscriber<M> {
    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            Log.d("dandy","code=" + code);
            onFailure(msg);
            switch (code){
                case 401:

                    break;
            }
        } else {
            onFailure(e.getMessage());
        }
        Log.e("dandy","请求异常了 "+e.toString());
        onFinish();
    }

    @Override
    public void onCompleted() {
            onFinish();
    }

    @Override
    public void onNext(M m) {
        onSuccess(m);
    }
}
