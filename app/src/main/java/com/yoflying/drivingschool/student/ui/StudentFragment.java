package com.yoflying.drivingschool.student.ui;

import android.content.Context;

import com.yoflying.drivingschool.base.BaseFragment;
import com.yoflying.drivingschool.base.BaseHomeFragment;
import com.yoflying.drivingschool.student.info.MyInfoFragment;
import com.yoflying.drivingschool.student.schedule.ScheduleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaojiulong on 2016/12/29.
 */

public class StudentFragment extends BaseHomeFragment {

    private List<String> mTitles;
    private List<BaseFragment> mFragments;
    private OrderFragment mOrderFragment;
    private ScheduleFragment mSceduleFragment;
    private MyInfoFragment mMyInfoFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mTitles=new ArrayList<>();
        mTitles.add("预约");
        mTitles.add("日程");
        mTitles.add("我的");
        mFragments=new ArrayList<>();
        mOrderFragment=new OrderFragment();
        mSceduleFragment=new ScheduleFragment();
        mMyInfoFragment=new MyInfoFragment();

        mFragments.add(mOrderFragment);
        mFragments.add(mSceduleFragment);
        mFragments.add(mMyInfoFragment);
        setData(mFragments,mTitles);
    }

    @Override
    public void initData() {
        super.initData();

    }
}
