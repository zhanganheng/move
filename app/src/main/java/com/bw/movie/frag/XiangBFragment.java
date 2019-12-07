package com.bw.movie.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.Xiang_yugaoAdapter;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.contract.XiangAContract;
import com.bw.movie.presenter.XiangAPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class XiangBFragment extends BaseFragment<XiangAPresenter> implements XiangAContract.Iview {


    @BindView(R.id.recycle_yugao)
    RecyclerView recycleYugao;
    Unbinder unbinder;

    @Override
    protected XiangAPresenter providePresenter() {
        return new XiangAPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiang_b;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent=getActivity().getIntent();
        String movieId = intent.getStringExtra("movieId");
        mPresenter.xiangA(movieId);
    }

    @Override
    public void XiangASuccess(XiangABean xiangABean) {
        List<XiangABean.ResultBean.ShortFilmListBean> shortFilmList = xiangABean.getResult().getShortFilmList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        recycleYugao.setLayoutManager(linearLayoutManager);
        Xiang_yugaoAdapter xiang_yugaoAdapter = new Xiang_yugaoAdapter(shortFilmList,getActivity());
        recycleYugao.setAdapter(xiang_yugaoAdapter);
    }

    @Override
    public void GuanMovieSuccess(Guan_movieBean guan_movieBean) {

    }

    @Override
    public void Qumovie(QumovieBean qumovieBean) {

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
