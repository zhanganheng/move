package com.bw.movie.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.FindCinema_Adapter;
import com.bw.movie.bean.FindCinemaBean;
import com.bw.movie.contract.FindCinemaContract;
import com.bw.movie.presenter.FindCinemaPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Findcinema_Activity extends BaseActivity<FindCinemaPresenter> implements FindCinemaContract.Iview {

    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.find_edit)
    EditText findEdit;
    @BindView(R.id.find_recycle)
    RecyclerView findRecycle;
    @BindView(R.id.find_but)
    Button findBut;
    @BindView(R.id.sou_layout)
    RelativeLayout souLayout;

    @Override
    protected FindCinemaPresenter providePresenter() {
        return new FindCinemaPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_findcinema_;
    }

    @Override
    protected void initData() {
        super.initData();
        findBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = findEdit.getText().toString();
                mpresenter.findcinema(s, "1", "5");
            }
        });
    }

    @Override
    public void onFindcinema(FindCinemaBean findCinemaBean) {
        Log.i("findCinemaBean", "onFindcinema: " + findCinemaBean.getMessage());
        List<FindCinemaBean.ResultBean> result = findCinemaBean.getResult();
        if (result!=null){
            findRecycle.setVisibility(View.VISIBLE);
            souLayout.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
            findRecycle.setLayoutManager(linearLayoutManager);
            FindCinema_Adapter findCinema_adapter = new FindCinema_Adapter(result, this);
            findRecycle.setAdapter(findCinema_adapter);
        }else {
            souLayout.setVisibility(View.VISIBLE);
            findRecycle.setVisibility(View.GONE);
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
        finish();
    }
}
