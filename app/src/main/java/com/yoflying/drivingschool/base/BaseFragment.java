package com.yoflying.drivingschool.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.ui.HomeActivity;

/**
 * Created by yaojiulong on 2016/12/29.
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment{
    private Activity mActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        View view = initView(inflater,container);
        initFindViewById(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        setLinstener();
    }



    protected abstract View initView(LayoutInflater inflater,ViewGroup container);
    protected abstract void initFindViewById(View view);

    public void initData(){

    }

    public void setLinstener(){

    }


}
