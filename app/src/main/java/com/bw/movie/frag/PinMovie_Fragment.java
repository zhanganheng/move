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
import com.bw.movie.adapter.Pin_movie_Adapter;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.contract.MyPinContract;
import com.bw.movie.presenter.MyPinPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PinMovie_Fragment extends BaseFragment<MyPinPresenter> implements MyPinContract.Iview {


    @BindView(R.id.movie_recycle)
    RecyclerView movieRecycle;
    Unbinder unbinder;
    @BindView(R.id.pin_layout)
    RelativeLayout pinLayout;

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_pin_movie_;
    }

    @Override
    protected MyPinPresenter providePresenter() {
        return new MyPinPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);
        mPresenter.moviepin(userId + "", sessionId, "1", "5");
    }

    @Override
    public void MoviePinSuccess(MyAPinBean myAPinBean) {
        Log.i("myAPinBean", "MoviePinSuccess: " + myAPinBean.getMessage());
        List<MyAPinBean.ResultBean> result = myAPinBean.getResult();
        if (result != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            movieRecycle.setLayoutManager(linearLayoutManager);
            Pin_movie_Adapter pin_movie_adapter = new Pin_movie_Adapter(result, getActivity());
            movieRecycle.setAdapter(pin_movie_adapter);
        } else {
            movieRecycle.setVisibility(View.GONE);
            pinLayout.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void CinemaPinSuccess(Ping_yingyuanBean ping_yingyuanBean) {

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
