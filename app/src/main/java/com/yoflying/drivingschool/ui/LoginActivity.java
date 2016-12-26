package com.yoflying.drivingschool.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseActivity;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.modules.login.IUserLoginView;
import com.yoflying.drivingschool.modules.login.UserLoginPresenter;


/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements IUserLoginView{
    private UserLoginPresenter mUserLoginPresenter=new UserLoginPresenter(this);
    private AutoCompleteTextView mUserName;
    private EditText mPassword;
    private RadioGroup mRadioGroup;
    private RadioButton mAdmin,mTeacher,mStudent;
    private ProgressDialog mDialog;
    private Button mSingIn;
    private int mUserType= Config.USER_TYPE_ADMIN;
    private LinearLayout mLoginLayout;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);

        mLoginLayout=findView(R.id.longin_layout);
        mUserName=findView(R.id.login_username);
        mPassword=findView(R.id.login_password);
        mRadioGroup=findView(R.id.login_group);
        mAdmin=findView(R.id.login_admin);
        mTeacher=findView(R.id.login_teacher);
        mStudent=findView(R.id.login_student);
        mSingIn=findView(R.id.login_sing_in);

        addToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    @Override
    protected void initData() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.login_admin:
                        mUserType=Config.USER_TYPE_ADMIN;
                        break;
                    case R.id.login_teacher:
                        mUserType=Config.USER_TYPE_TEACHER;
                        break;
                    case R.id.login_student:
                        mUserType=Config.USER_TYPE_STUDENT;
                        break;
                    default:

                        break;

                }
            }
        });

        mSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.login();
                Log.e("dandy","点击了");
            }
        });

        mAdmin.setChecked(true);
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
    public String getUseName() {

        return mUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showDialog() {
        mDialog=ProgressDialog.show(LoginActivity.this,"提示","正在登录...");

    }

    @Override
    public void cancelDialog() {
        mDialog.cancel();
    }

    @Override
    public void toastMeassager(String msg) {
        Snackbar.make(mLoginLayout, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void toMainActivity() {
        startActivity(new Intent(LoginActivity.this, AdminActivity.class));
        finish();
    }

    @Override
    public void showFailedError() {
    }

    /**
     * 获取用户类型
     * @return
     */
    @Override
    public int getUserType() {
        return mUserType;
    }

    @Override
    public void userOrPwdIsNull() {
        Toast.makeText(LoginActivity.this,"用户名或者密码不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserLoginPresenter.destory();
    }
}

