package com.yoflying.drivingschool.ui;

import android.content.Intent;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseActivity;
import com.yoflying.drivingschool.modules.wecome.IWecomeView;
import com.yoflying.drivingschool.modules.wecome.WecomePresenter;

public class WecomActivity extends BaseActivity implements IWecomeView{
    private WecomePresenter mPresenter;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_wecome);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter=new WecomePresenter(this);
        mPresenter.checkData();
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
    public void toLoginActivity() {
        Intent intent=new Intent(WecomActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void toAdminActivity() {
        Intent intent=new Intent(WecomActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
