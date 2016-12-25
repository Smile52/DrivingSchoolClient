package com.yoflying.drivingschool.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseActivity;
import com.yoflying.drivingschool.config.Config;

/**
 * 创建学员or教练界面
 */
public class CreateActivity extends BaseActivity {
    private Toolbar mToolBar;
    private Intent mIntent;
    private RadioGroup mTypeGroup,mSexGroup;
    private RadioButton mManRbtn,mWomanRbtn,mTeacherRbtn,mStudentRbtn;
    private int mUserType;//创建的用户类别


    @Override
    protected void initView() {
        setContentView(R.layout.activity_create);

        mTypeGroup=findView(R.id.create_type_group);
        mSexGroup=findView(R.id.create_sex_group);
        mManRbtn=findView(R.id.create_sex_man);
        mWomanRbtn=findView(R.id.create_sex_woman);
        mTeacherRbtn=findView(R.id.create_type_teacher);
        mStudentRbtn=findView(R.id.create_type_student);
        addToolbar();
    }

    @Override
    protected void initData() {
        mIntent=getIntent();
        mUserType=mIntent.getExtras().getInt(Config.CREATE_USER_TYPE);
        Log.e("dandy","注册用户类型 "+mUserType);
        if (mUserType==Config.USER_TYPE_STUDENT){

            mStudentRbtn.setChecked(true);
        }else {

            mTeacherRbtn.setChecked(true);
        }

     /*   mToolBar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }


    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    protected String[] getNeedPermissions() {
        return new String[0];
    }

    @Override
    protected void permissionGrantedSuccess() {

    }

    @Override
    protected void permissionGrantedFail() {

    }
}
