package com.yoflying.drivingschool.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseActivity;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.modules.create.ICreateView;

/**
 * 创建学员or教练界面
 */
public class CreateActivity extends BaseActivity implements ICreateView {
    private Intent mIntent;
    private RadioGroup mTypeGroup,mSexGroup;
    private RadioButton mManRbtn,mWomanRbtn,mTeacherRbtn,mStudentRbtn;
    private int mUserType;//创建的用户类别
    private int mSexType=1;
    private EditText mUserName,mIdNum,mPassword,mPhone,mWechat;
    private int mCourse=1;
    private Spinner mCourseView;
    private String[] mCourses;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_create);
        mTypeGroup=findView(R.id.create_type_group);
        mSexGroup=findView(R.id.create_sex_group);
        mManRbtn=findView(R.id.create_sex_man);
        mWomanRbtn=findView(R.id.create_sex_woman);
        mTeacherRbtn=findView(R.id.create_type_teacher);
        mStudentRbtn=findView(R.id.create_type_student);
        mUserName=findView(R.id.create_name);
        mIdNum=findView(R.id.create_identity);
        mPassword=findView(R.id.create_psd);
        mPhone=findView(R.id.create_phone);
        mWechat=findView(R.id.create_wechat);
        mCourseView=findView(R.id.create_course);
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

        mSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.create_sex_man:
                        mSexType=Config.SEX_MAN;
                        break;
                    case R.id.create_sex_woman:
                        mSexType=Config.SEX_WOMAN;
                        break;
                }
            }
        });

        mTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.create_type_student:
                        mUserType=Config.USER_TYPE_STUDENT;
                        break;
                    case R.id.create_type_teacher:
                        mUserType=Config.USER_TYPE_TEACHER;
                        break;
                }
            }
        });
        mCourses= getResources().getStringArray(R.array.course_array);
        mCourseView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("dandy","选中了 "+mCourses[position]);
                mCourse=position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getIDnum() {
        return mIdNum.getText().toString();
    }

    @Override
    public int getSex() {
        return mSexType;
    }

    @Override
    public int getUserType() {
        return mUserType;
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public String getPhone() {
        return mPhone.getText().toString();
    }

    @Override
    public String getWechat() {
        return mWechat.getText().toString();
    }

    @Override
    public int getCourse() {
        return mCourse;
    }
}
