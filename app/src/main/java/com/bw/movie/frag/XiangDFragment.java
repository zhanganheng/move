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
import com.bw.movie.adapter.Xiang_pinLun_Adapter;
import com.bw.movie.bean.PinBean;
import com.bw.movie.contract.PinlunContract;
import com.bw.movie.presenter.PinLunPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class XiangDFragment extends BaseFragment<PinLunPresenter> implements PinlunContract.Iview {


    @BindView(R.id.recycle_pinlun)
    RecyclerView recyclePinlun;
    Unbinder unbinder;

    @Override
    protected PinLunPresenter providePresenter() {
        return new PinLunPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiang_d;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);
        Intent intent = getActivity().getIntent();
        String movieId = intent.getStringExtra("movieId");
        mPresenter.getpin(userId+"",sessionId,movieId, "1", "5");
    }

    @Override
    public void onpinSuccess(PinBean pinBean) {
        Log.i("pinBean1", "onpinSuccess: " + pinBean.getMessage());
        List<PinBean.ResultBean> result = pinBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        recyclePinlun.setLayoutManager(linearLayoutManager);
        Xiang_pinLun_Adapter xiang_pinLun_adapter = new Xiang_pinLun_Adapter(result,getActivity());
        recyclePinlun.setAdapter(xiang_pinLun_adapter);
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

