package com.yoflying.drivingschool.student;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.adapter.StudentAdapter;
import com.yoflying.drivingschool.base.BaseFragment;
import com.yoflying.drivingschool.student.info.MyInfoFragment;
import com.yoflying.drivingschool.student.order.OrderFragment;
import com.yoflying.drivingschool.student.schedule.ScheduleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaojiulong on 2016/12/29.
 */

public class StudentFragment extends BaseFragment {
    private ViewPager mContentPager;
    private TabLayout mTab;
    private List<String> mTitles;
    private List<BaseFragment> mFragments;
    private OrderFragment mOrderFragment;
    private ScheduleFragment mSceduleFragment;
    private MyInfoFragment mMyInfoFragment;
    private StudentAdapter mAdapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_student,container,false);
        return view;
    }

    @Override
    protected void initFindViewById(View view) {
        mContentPager= (ViewPager) view.findViewById(R.id.viewpager_student);
        mTab= (TabLayout) view.findViewById(R.id.tab_student);
    }

    @Override
    public void initData() {
        super.initData();
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

        mAdapter=new StudentAdapter(getChildFragmentManager(),mTitles,mFragments);
        mContentPager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mContentPager);
    }
}
