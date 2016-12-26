package com.yoflying.drivingschool.ui;

import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseActivity;
import com.yoflying.drivingschool.config.Config;

/**
 * 管理员主界面
 */
public class AdminActivity extends BaseActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private android.support.v7.widget.Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;



    public void initView() {
        setContentView(R.layout.activity_admin);
        mToolbar=findView(R.id.admin_layout_toolbar);
        mDrawerLayout=findView(R.id.content_layout);
        mNavigationView=findView(R.id.nav_view);
        mToolbar.setTitle("Driver");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle=new ActionBarDrawerToggle
                (this,mDrawerLayout,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.nav_creat_teacher:
                Intent intent=new Intent(AdminActivity.this,CreateActivity.class);
                intent.putExtra(Config.CREATE_USER_TYPE,Config.USER_TYPE_TEACHER);
                startActivity(intent);
                break;
            case R.id.nav_creat_student:

                Intent student=new Intent(AdminActivity.this,CreateActivity.class);
                student.putExtra(Config.CREATE_USER_TYPE,Config.USER_TYPE_STUDENT);
                startActivity(student);
                break;
            case R.id.nav_binding:
                break;
            case R.id.nav_add_vacate:
                break;
            case R.id.nav_seeting:
                break;
            case R.id.nav_exit_user:
                break;
        }
        return true;
    }
}
