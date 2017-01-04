package com.yoflying.drivingschool.admin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseFragment;

/**
 * Created by yaojiulong on 2016/12/29.
 */

public class AdminFragment extends BaseFragment {



    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_admin,container,false);
        return view;
    }
}
