package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.bean.FankuiBean;
import com.bw.movie.contract.FankuiContract;
import com.bw.movie.presenter.FankuiPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFankui_Activity extends BaseActivity<FankuiPresenter> implements FankuiContract.Iview {


    @BindView(R.id.ider_img)
    ImageView iderImg;
    @BindView(R.id.ider_cheng)
    TextView iderCheng;
    @BindView(R.id.iderNei)
    TextView iderNei;
    @BindView(R.id.ider_text)
    EditText iderText;
    @BindView(R.id.ider_btn)
    Button iderBtn;
    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.suoyou)
    RelativeLayout suoyou;
    private int userId;
    private String sessionId;
    private String s;

    @Override
    protected FankuiPresenter providePresenter() {
        return new FankuiPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_fankui_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        s = iderText.getText().toString();
        iderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.fankui(userId + "", sessionId, s);
            }
        });
    }

    @Override
    public void Fankui(FankuiBean fankuiBean) {
        Log.i("fankuiBean", "Fankui: " + fankuiBean.getMessage());
        if (fankuiBean.getStatus().equals("0000")) {
            iderText.setVisibility(View.GONE);
            iderBtn.setVisibility(View.GONE);
            iderImg.setVisibility(View.VISIBLE);
            iderCheng.setVisibility(View.VISIBLE);
            iderNei.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.find_letf, R.id.suoyou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.find_letf:
                findLetf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
            case R.id.suoyou:
                suoyou.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;
        }
    }
}
