package com.bw.movie.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.XiangCinemaBean;
import com.bw.movie.contract.XiangCinemaContract;
import com.bw.movie.presenter.XiangCinemaPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *@describe(描述)：Xiang_cinema_frag  影院详情
 *@data（日期）: 2019/12/1
 *@time（时间）: 13:55
 *@author（作者）: 张安恒
 **/
public class Xiang_cinema_frag extends BaseFragment<XiangCinemaPresenter> implements XiangCinemaContract.Iview {


    @BindView(R.id.xiang_address)
    TextView xiangAddress;
    @BindView(R.id.xiang_phone)
    TextView xiangPhone;
    @BindView(R.id.xiang_type)
    TextView xiangType;
    Unbinder unbinder;

    @Override
    protected XiangCinemaPresenter providePresenter() {
        return new XiangCinemaPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiang_cinema_frag;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);

        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        Log.i("xiangid", "initData: "+id);
        mPresenter.XiangCinemaSuccess(userId + "", sessionId, id + "");
    }

    @Override
    public void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean) {
        XiangCinemaBean.ResultBean result = xiangCinemaBean.getResult();
        xiangAddress.setText(result.getAddress());
        xiangPhone.setText(result.getPhone());
        xiangType.setText(result.getVehicleRoute());
    }

    @Override
    public void Guanzhucinema(Guan_movieBean guan_movieBean) {

    }

    @Override
    public void Qucinema(QucinemaBean qucinemaBean) {

    }

    @Override
    public void onFraily(String e) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
