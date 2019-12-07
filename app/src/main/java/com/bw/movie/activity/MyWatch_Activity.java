package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.My_Seen_Movie_Adapter;
import com.bw.movie.bean.MyWatchBean;
import com.bw.movie.contract.MyWatchContract;
import com.bw.movie.presenter.MyWatchPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyWatch_Activity extends BaseActivity<MyWatchPresenter> implements MyWatchContract.Iview {


    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.lin_visi)
    RelativeLayout linVisi;

    @Override
    protected MyWatchPresenter providePresenter() {
        return new MyWatchPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_watch_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);
        mpresenter.mywatch(userId + "", sessionId);
    }

    @Override
    public void Watchmovie(MyWatchBean myWatchBean) {
        Log.i("myWatchBean", "Watchmovie: " + myWatchBean.getMessage());
        List<MyWatchBean.ResultBean> result = myWatchBean.getResult();
        if (result != null) {
            recyclerView.setVisibility(View.VISIBLE);
            linVisi.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
            recyclerView.setLayoutManager(linearLayoutManager);
            My_Seen_Movie_Adapter guan_cinema_adapter = new My_Seen_Movie_Adapter(result, this);
            recyclerView.setAdapter(guan_cinema_adapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFraily(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.find_letf)
    public void onViewClicked() {
        findLetf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
