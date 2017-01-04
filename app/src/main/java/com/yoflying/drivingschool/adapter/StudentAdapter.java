package com.yoflying.drivingschool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yoflying.drivingschool.base.BaseFragment;

import java.util.List;

/**
 * Created by yaojiulong on 2016/12/29.
 */

public class StudentAdapter extends FragmentPagerAdapter {
    private List<String> mTitles;
    private List<BaseFragment> mFragments;

    public StudentAdapter(FragmentManager fm, List<String> mTitles,List<BaseFragment> mFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments=mFragments;
    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments==null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
