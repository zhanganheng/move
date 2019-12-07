package com.bw.movie.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.Ping_cinema_Adapter;
import com.bw.movie.bean.Ping_cinemaBean;
import com.bw.movie.contract.PingCinemaContract;
import com.bw.movie.presenter.PingCinemaPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *@describe(描述)：Xiang_pin_frag 影院评论
 *@data（日期）: 2019/12/1
 *@time（时间）: 13:56
 *@author（作者）: 张安恒
 **/
public class Xiang_pin_frag extends BaseFragment<PingCinemaPresenter> implements PingCinemaContract.Iview {


    @BindView(R.id.ping_cinema_view)
    RecyclerView pingCinemaView;
    Unbinder unbinder;

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiang_pin_frag;
    }

    @Override
    protected PingCinemaPresenter providePresenter() {
        return new PingCinemaPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.PingCinemaSuccess(userId + "", sessionId, id, "1", "5");
    }


    @Override
    public void PingCinemaSuccess(Ping_cinemaBean ping_cinemaBean) {
        Log.i("ping_cinemaBean", "PingCinemaSuccess: " + ping_cinemaBean.getMessage());
        List<Ping_cinemaBean.ResultBean> result = ping_cinemaBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        pingCinemaView.setLayoutManager(linearLayoutManager);
        Ping_cinema_Adapter ping_cinema_adapter = new Ping_cinema_Adapter(result,getActivity());
        pingCinemaView.setAdapter(ping_cinema_adapter);
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
