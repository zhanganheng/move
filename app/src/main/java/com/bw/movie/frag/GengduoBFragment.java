package com.bw.movie.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.BrecycleAdapter;
import com.bw.movie.adapter.GengduoA_Adapter;
import com.bw.movie.adapter.GengduoB_Adapter;
import com.bw.movie.bean.ACimemaBean;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CCinemaBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.BannerContract;
import com.bw.movie.presenter.BannerPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GengduoBFragment extends BaseFragment<BannerPresenter> implements BannerContract.Iview {


    @BindView(R.id.recycle_b)
    RecyclerView recycleB;
    Unbinder unbinder;

    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_gengduo_b;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getbcinema("2", "5");
    }

    @Override
    public void YuyueSuccess(YuyueBean yuyueBean) {

    }

    @Override
    public void onAcinemaSuccess(ACimemaBean aCimemaBean) {

    }

    @Override
    public void onBcinemaSuccess(BCinemaBean bCinemaBean) {
        List<BCinemaBean.ResultBean> result = bCinemaBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        recycleB.setLayoutManager(linearLayoutManager);
        GengduoB_Adapter findCinema_adapter = new GengduoB_Adapter(result, getActivity());
        recycleB.setAdapter(findCinema_adapter);
    }

    @Override
    public void onCcinemaSuccess(CCinemaBean cCinemaBean) {

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

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
