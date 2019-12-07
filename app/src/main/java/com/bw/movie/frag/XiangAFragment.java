package com.bw.movie.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.Xiang_daoAdapter;
import com.bw.movie.adapter.Xiang_yanAdapter;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.contract.XiangAContract;
import com.bw.movie.presenter.XiangAPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class XiangAFragment extends BaseFragment<XiangAPresenter> implements XiangAContract.Iview {


    Unbinder unbinder;
    @BindView(R.id.textq)
    TextView textq;
    @BindView(R.id.xiang_jianjie)
    TextView xiangJianjie;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.xiang_dao_number)
    TextView xiangDaoNumber;
    @BindView(R.id.recycle_dao)
    RecyclerView recycleDao;
    @BindView(R.id.xiang_yan_number)
    TextView xiangYanNumber;
    @BindView(R.id.recycle_yan)
    RecyclerView recycleYan;

    @Override
    protected XiangAPresenter providePresenter() {
        return new XiangAPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_xiang_a;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        String movieId = intent.getStringExtra("movieId");
        mPresenter.xiangA(movieId + "");
    }

    @Override
    public void XiangASuccess(XiangABean xiangABean) {
        XiangABean.ResultBean result = xiangABean.getResult();
        xiangJianjie.setText(result.getSummary());
        //导员
        List<XiangABean.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
        int size1 = movieDirector.size();
        xiangDaoNumber.setText("导员" + "("+size1+")");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        recycleDao.setLayoutManager(linearLayoutManager);
        Xiang_daoAdapter xiang_daoAdapter = new Xiang_daoAdapter(movieDirector, getActivity());
        recycleDao.setAdapter(xiang_daoAdapter);
        //演员
        List<XiangABean.ResultBean.MovieActorBean> movieActor = result.getMovieActor();
        int size = movieActor.size();
        xiangYanNumber.setText("演员" + "("+size+")");
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        recycleYan.setLayoutManager(linearLayoutManager1);
        Xiang_yanAdapter xiang_yanAdapter = new Xiang_yanAdapter(movieActor, getActivity());
        recycleYan.setAdapter(xiang_yanAdapter);
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
