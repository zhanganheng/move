package com.bw.movie.frag;

import android.content.Intent;
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
import com.bw.movie.adapter.Paiqi_Adapter;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.contract.PaiqiContract;
import com.bw.movie.presenter.PaiqiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Paiqi_Fragment extends BaseFragment<PaiqiPresenter> implements PaiqiContract.Iview {

    @BindView(R.id.paiqi_recycle)
    RecyclerView paiqiRecycle;
    Unbinder unbinder;
    @BindView(R.id.pai_layout)
    RelativeLayout paiLayout;

    @Override
    protected PaiqiPresenter providePresenter() {
        return new PaiqiPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_paiqi_;
    }


    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        Log.i("paiqiid", "initData: " + id);
        mPresenter.Paiqi(id, "1", "5");
    }

    @Override
    public void PaiqiSuccess(PaiqiBean paiqiBean) {
        Log.i("paiqiBean", "PaiqiSuccess: " + paiqiBean.getMessage());
        List<PaiqiBean.ResultBean> result = paiqiBean.getResult();
        if (result != null) {
            paiqiRecycle.setVisibility(View.VISIBLE);
            paiLayout.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            paiqiRecycle.setLayoutManager(linearLayoutManager);
            Paiqi_Adapter paiqi_adapter = new Paiqi_Adapter(result, getActivity());
            paiqiRecycle.setAdapter(paiqi_adapter);
        }else {
            paiqiRecycle.setVisibility(View.GONE);
            paiLayout.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onFindtimeSuccess(FindtimeBean findtimeBean) {

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
