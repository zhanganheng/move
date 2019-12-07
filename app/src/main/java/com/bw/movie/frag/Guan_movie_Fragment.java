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
import android.widget.Toast;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.Guan_movie_Adapter;
import com.bw.movie.bean.GuancinemaBean;
import com.bw.movie.bean.Guanzhu_dianyin;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.contract.GuanzhuContract;
import com.bw.movie.presenter.GuanzhuPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Guan_movie_Fragment extends BaseFragment<GuanzhuPresenter> implements GuanzhuContract.Iview {


    @BindView(R.id.guan_recycle)
    RecyclerView guanRecycle;
    Unbinder unbinder;
    @BindView(R.id.guan_layout)
    RelativeLayout guanLayout;
    private int userId;
    private String sessionId;

    @Override
    protected GuanzhuPresenter providePresenter() {
        return new GuanzhuPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_guan_movie_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        mPresenter.guanzhumovie(userId + "", sessionId, "1", "5");
    }

    @Override
    public void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin) {
            Log.i("guanzhu_dianyin", "GuanzhuMovie: " + guanzhu_dianyin.getMessage());
            final List<Guanzhu_dianyin.ResultBean> result = guanzhu_dianyin.getResult();
            if (result!=null){
                guanLayout.setVisibility(View.GONE);
                guanRecycle.setVisibility(View.VISIBLE);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
                guanRecycle.setLayoutManager(linearLayoutManager);
                final Guan_movie_Adapter guan_movie_adapter = new Guan_movie_Adapter(result, getActivity());
                guanRecycle.setAdapter(guan_movie_adapter);
                //点击删除
                guan_movie_adapter.setSetClickListen(new Guan_movie_Adapter.setClickListen() {
                    @Override
                    public void onclick(View view, int position, String id) {
                        mPresenter.quxiaomovie(userId + "", sessionId, id);
                        result.remove(position);
                        guan_movie_adapter.notifyItemChanged(position);
                        guan_movie_adapter.notifyItemRangeRemoved(position, result.size());
                    }
                });
            }else {
                guanRecycle.setVisibility(View.GONE);
                guanLayout.setVisibility(View.VISIBLE);
            }


    }

    @Override
    public void GuanzhuCinema(GuancinemaBean guancinemaBean) {

    }

    @Override
    public void Qumovie(QumovieBean qumovieBean) {

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
