package com.yoflying.drivingschool.base;

import com.yoflying.drivingschool.retrofit.ApiStore;
import com.yoflying.drivingschool.retrofit.RetrofitClient;


import rx.Observable;
import rx.Subscriber;


import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**控制器基类
 * Created by yaojiulong on 2016/12/22.
 */

public class BasePresenter<V> {
    public V mvpView;
    protected ApiStore mApiStore;
    private CompositeSubscription mCompositeSubscription;

    public void attachView(V mvpView){
        this.mvpView=mvpView;
        mApiStore = RetrofitClient.retrofit().create(ApiStore.class);

    }

    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    /**
     * rxJava取消注册
     */
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }

        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
