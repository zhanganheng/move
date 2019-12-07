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
import com.bw.movie.adapter.MyYuyueAdapter;
import com.bw.movie.bean.MyYuyueBean;
import com.bw.movie.contract.MyYuyueContract;
import com.bw.movie.presenter.MyYueyuePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class My_Yuyue_Activity extends BaseActivity<MyYueyuePresenter> implements MyYuyueContract.Iview {
    /**
     * @describe(描述)：My_Yuyue_Activity 预约
     * @data（日期）: 2019/12/3
     * @time（时间）: 20:24
     * @author（作者）: 张安恒
     **/

    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.yuyue_recycle)
    RecyclerView yuyueRecycle;
    @BindView(R.id.yu_layout)
    RelativeLayout yuLayout;

    @Override
    protected MyYueyuePresenter providePresenter() {
        return new MyYueyuePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my__yuyue_;
    }

    @Override
    protected void initData() {
        super.initData();

        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        int userId = sp.getInt("userId", 0);
        String sessionId = sp.getString("sessionId", null);
        mpresenter.myyuyue(userId + "", sessionId);
    }

    @Override
    public void Myyuyue(MyYuyueBean myYuyueBean) {
        Log.i("myYuyueBean", "Myyuyue: " + myYuyueBean.getMessage());
        List<MyYuyueBean.ResultBean> result = myYuyueBean.getResult();
        if (result != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
            yuyueRecycle.setLayoutManager(linearLayoutManager);
            MyYuyueAdapter myYuyueAdapter = new MyYuyueAdapter(result, this);
            yuyueRecycle.setAdapter(myYuyueAdapter);
        } else {
            yuyueRecycle.setVisibility(View.GONE);
            yuLayout.setVisibility(View.VISIBLE);
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
