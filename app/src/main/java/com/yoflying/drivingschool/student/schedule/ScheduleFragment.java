package com.yoflying.drivingschool.student.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseFragment;

/**日程
 * Created by yaojiulong on 2017/1/4.
 */

public class ScheduleFragment extends BaseFragment {
    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_schedule_student,container,false);
        return view;
    }
}
