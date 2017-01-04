package com.yoflying.drivingschool.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseActivity;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.admin.AdminFragment;
import com.yoflying.drivingschool.home.HomePresenter;
import com.yoflying.drivingschool.home.IHomeView;
import com.yoflying.drivingschool.student.StudentFragment;
import com.yoflying.drivingschool.teacher.TeacherFragment;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

/**
 * 管理员主界面
 */
public class HomeActivity extends BaseActivity  implements NavigationView.OnNavigationItemSelectedListener,IHomeView {
    private android.support.v7.widget.Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private TextView mUserTypetv,mUserNametv;
    private HomePresenter mPresenter;
    private FrameLayout mContentLayout;
    private FragmentManager mManager;
    private android.support.v4.app.FragmentTransaction mTransaction;
    private AdminFragment mAdminFragment;
    private TeacherFragment mTeacherFragment;
    private StudentFragment mStudentFragment;

    public void initView() {
        setContentView(R.layout.activity_admin);
        mToolbar=findView(R.id.admin_layout_toolbar);
        mContentLayout=findView(R.id.home_contant_layout);
        mDrawerLayout=findView(R.id.content_layout);
        mNavigationView=findView(R.id.nav_view);
        View view = mNavigationView.inflateHeaderView(R.layout.nav_header_content);

        mUserTypetv= (TextView) view.findViewById(R.id.nav_header_type_tv);
        mUserNametv= (TextView) view.findViewById(R.id.nav_header_username);

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
        mManager=getSupportFragmentManager();
        mTransaction=mManager.beginTransaction();
        mPresenter=new HomePresenter(this);


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
            //驾校信息
            case R.id.nav_shcool_info:
                Intent intent=new Intent(HomeActivity.this,CreateActivity.class);
                intent.putExtra(Config.CREATE_USER_TYPE,Config.USER_TYPE_TEACHER);
                startActivity(intent);
                break;
            //联系我们
            case R.id.nav_contact:
                Intent student=new Intent(HomeActivity.this,CreateActivity.class);
                student.putExtra(Config.CREATE_USER_TYPE,Config.USER_TYPE_STUDENT);
                startActivity(student);
                break;
            //分享
            case R.id.nav_share:
                break;
            //关于
            case R.id.nav_aboult:
                break;
            //设置
            case R.id.nav_seeting:
                break;
            case R.id.nav_exit_user:
                //清除当前用户的token，并跳转到登录页面
                UtilSharedPreferences.saveStringData(DriverApplication.getContextObject(),Config.KEY_TOKEN,"");
                Intent toLogin=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(toLogin);
                break;
        }
        return true;
    }

    @Override
    public void showUserName(String name) {

        mUserNametv.setText(name);
    }

    @Override
    public void showUserType(String type) {
        mUserTypetv.setText(type);

    }

    @Override
    public void showAdminFragment() {

        mAdminFragment=new AdminFragment();
        mTransaction.replace(R.id.home_contant_layout,mAdminFragment);
        mTransaction.commit();
    }

    @Override
    public void showTeacherFragment() {

        mTeacherFragment=new TeacherFragment();
        mTransaction.replace(R.id.home_contant_layout,mTeacherFragment);
        mTransaction.commit();

    }

    @Override
    public void showStudentFragment() {
        mStudentFragment=new StudentFragment();
        mTransaction.replace(R.id.home_contant_layout,mStudentFragment);
        mTransaction.commit();

    }
}
