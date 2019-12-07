package com.bw.movie.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.MyMessage_Adapter;
import com.bw.movie.bean.MyMessageBean;
import com.bw.movie.contract.MyMessageContract;
import com.bw.movie.presenter.MyMessagePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyMessage_Activity extends BaseActivity<MyMessagePresenter> implements MyMessageContract.Iview {


    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.mysuccess_view)
    RecyclerView mysuccessView;
    private int userId;
    private String sessionId;

    @Override
    protected MyMessagePresenter providePresenter() {
        return new MyMessagePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_message_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        mpresenter.mymessage(userId + "", sessionId, "1", "5");
    }

    @Override
    public void MyMessageSuccess(MyMessageBean myMessageBean) {
        Log.i("myMessageBean", "MyMessageSuccess: " + myMessageBean.getMessage());
        List<MyMessageBean.ResultBean> result = myMessageBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mysuccessView.setLayoutManager(linearLayoutManager);
        MyMessage_Adapter myMessage_adapter = new MyMessage_Adapter(result,this);
        mysuccessView.setAdapter(myMessage_adapter);
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
