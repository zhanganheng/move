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
import android.widget.Toast;

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.Guan_cinema_Adapter;
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


public class Guan_cinema_Fragment extends BaseFragment<GuanzhuPresenter> implements GuanzhuContract.Iview {


    @BindView(R.id.guan_crecycle)
    RecyclerView guanCrecycle;
    Unbinder unbinder;
    private int userId;
    private String sessionId;
    private Guan_cinema_Adapter guan_cinema_adapter;

    @Override
    protected GuanzhuPresenter providePresenter() {
        return new GuanzhuPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_guan_cinema_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        mPresenter.guanzhucinema(userId + "", sessionId, "1", "5");
    }

    @Override
    public void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin) {

    }

    @Override
    public void GuanzhuCinema(GuancinemaBean guancinemaBean) {
        if (guancinemaBean.getMessage().equals("无关注影院")){
            Toast.makeText(getActivity(), "暂无关注影院", Toast.LENGTH_SHORT).show();
        }else {
            Log.i("guancinemaBean", "GuanzhuMovie: " + guancinemaBean.getMessage());
            final List<GuancinemaBean.ResultBean> result = guancinemaBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            guanCrecycle.setLayoutManager(linearLayoutManager);
            guan_cinema_adapter = new Guan_cinema_Adapter(result,getActivity());
            guanCrecycle.setAdapter(guan_cinema_adapter);
            //点击删除
            guan_cinema_adapter.setSetClickListen(new Guan_cinema_Adapter.setClickListen() {
                @Override
                public void onclick(View view, int position, String id) {
                    mPresenter.quxiaomovie(userId+"",sessionId,id);
                    mPresenter.quxiaocinema(userId+"",sessionId,id);
                    result.remove(position);
                    guan_cinema_adapter.notifyItemChanged(position);
                    guan_cinema_adapter.notifyItemRangeRemoved(position,result.size());
                }
            });
        }

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
