package com.bw.movie.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.MyPin_cinema_Adapter;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.contract.MyPinContract;
import com.bw.movie.presenter.MyPinPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class PinCinema_Fragment extends BaseFragment<MyPinPresenter> implements MyPinContract.Iview {


    @BindView(R.id.pin_cinema_recycle)
    RecyclerView pinCinemaRecycle;
    Unbinder unbinder;
    @BindView(R.id.dian_layout)
    RelativeLayout dianLayout;

    @Override
    protected MyPinPresenter providePresenter() {
        return new MyPinPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_pin_cinema_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);
        mPresenter.cinemapin(userId + "", sessionId, "0", "0", "1", "5");
    }

    @Override
    public void MoviePinSuccess(MyAPinBean myAPinBean) {

    }

    @Override
    public void CinemaPinSuccess(Ping_yingyuanBean ping_yingyuanBean) {
        Log.i("ping_yingyuanBean", "CinemaPinSuccess: " + ping_yingyuanBean.getMessage());
        List<Ping_yingyuanBean.ResultBean> result = ping_yingyuanBean.getResult();
        if (result != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            pinCinemaRecycle.setLayoutManager(linearLayoutManager);
            MyPin_cinema_Adapter myPin_cinema_adapter = new MyPin_cinema_Adapter(result, getActivity());
            pinCinemaRecycle.setAdapter(myPin_cinema_adapter);
        } else {
            pinCinemaRecycle.setVisibility(View.GONE);
            dianLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void Fraily(String e) {

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
