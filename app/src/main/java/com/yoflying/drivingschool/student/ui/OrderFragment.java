package com.yoflying.drivingschool.student.ui;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BaseFragment;
import com.yoflying.drivingschool.student.order.IOrderView;
import com.yoflying.drivingschool.student.order.OrderPresenter;

/**学生预约
 * Created by yaojiulong on 2017/1/4.
 */

public class OrderFragment extends BaseFragment implements IOrderView {
    private OrderPresenter mOrderPresenter;


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.fragment_order_student,container,false);
        return view;
    }

    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    public void initData() {
        super.initData();
        mOrderPresenter=new OrderPresenter(this);
    }
}
