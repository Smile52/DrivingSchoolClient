package com.yoflying.drivingschool.student.order;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseFragment;

/**学生预约
 * Created by yaojiulong on 2017/1/4.
 */

public class OrderFragment extends BaseFragment {

    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_order_student,container,false);
        return view;
    }
}
