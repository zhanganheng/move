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

import com.bumptech.glide.Glide;
import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.My_Movie_Adapter;
import com.bw.movie.bean.MyTicketBean;
import com.bw.movie.bean.MyerweimaBean;
import com.bw.movie.contract.MyTicketContract;
import com.bw.movie.presenter.MyTicketPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTicket_Activity extends BaseActivity<MyTicketPresenter> implements MyTicketContract.Iview {

    /**
     * @describe(描述)：MyTicket_Activity 我的票二维码
     * @data（日期）: 2019/12/3
     * @time（时间）: 20:25
     * @author（作者）: 张安恒
     **/
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.erwema_src)
    ImageView erwemaSrc;
    @BindView(R.id.relayout_gone)
    RelativeLayout relayoutGone;
    @BindView(R.id.ticket_layout)
    RelativeLayout ticketLayout;
    private int userId;
    private String sessionId;

    @Override
    protected MyTicketPresenter providePresenter() {
        return new MyTicketPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_ticket_;
    }

    @Override
    protected void initData() {
        super.initData();

        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        mpresenter.myticket(userId + "", sessionId);
    }

    @Override
    public void MyTicket(MyTicketBean ticketBean) {
        Log.i("ticketBean", "MyTicket: " + ticketBean.getMessage());
        List<MyTicketBean.ResultBean> result = ticketBean.getResult();
        if (result!=null){
            My_Movie_Adapter my_movie_adapter = new My_Movie_Adapter(result, this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(my_movie_adapter);
            my_movie_adapter.setSetClicketListen(new My_Movie_Adapter.setClicketListen() {
                @Override
                public void onclick(int id) {
                    mpresenter.erweima(userId + "", sessionId, id + "");
                }
            });
        }else {
            recyclerView.setVisibility(View.GONE);
            ticketLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void Erweima(MyerweimaBean myerweimaBean) {
        Log.i("myerweimaBean", "Erweima: " + myerweimaBean.getMessage());
        MyerweimaBean.ResultBean result = myerweimaBean.getResult();
        if (myerweimaBean.getStatus().equals("0000")) {
            recyclerView.setVisibility(View.GONE);
            relayoutGone.setVisibility(View.VISIBLE);
            Glide.with(this).load(result.getExchangeCode()).into(erwemaSrc);
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

    @OnClick({R.id.find_letf, R.id.ider_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.find_letf:
                finish();
                break;
            case R.id.ider_btn:
                finish();
                break;
        }
    }
}
