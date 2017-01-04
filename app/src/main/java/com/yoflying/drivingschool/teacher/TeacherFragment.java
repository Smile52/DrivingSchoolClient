package com.yoflying.drivingschool.teacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseFragment;

/**
 * Created by yaojiulong on 2016/12/29.
 */

public class TeacherFragment extends BaseFragment {
    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_teacher,container);
        return view;
    }
}
