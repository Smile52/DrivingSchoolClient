package com.yoflying.drivingschool.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.BuildConfig;


/**
 * Created by yaojiulong on 2016/12/22.
 */

public class RetrofitClient {
    public static Retrofit mRetrofit;
    private static final int DEFAULT_TIMEOUT = 5;


    public static Retrofit retrofit(final String token) {
        if (mRetrofit == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置 Debug Log 模式
                httpClientBuilder.addInterceptor(loggingInterceptor);
            }
            /**
             * 添加拦截器，设置请求header
             */
            httpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("accesstoken",token)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });


            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            Gson gson = new GsonBuilder()
                    //配置Gson
                    .setDateFormat("yyyy-MM-dd hh:mm:ss")
                    .create();

            OkHttpClient okHttpClient = httpClientBuilder.build();
            mRetrofit=new Retrofit.Builder()
                    .baseUrl(ApiStore.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

        }
        return mRetrofit;
    }

    public static void close(){
        mRetrofit=null;
    }

}
