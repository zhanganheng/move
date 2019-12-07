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

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.Findmohu_Address_Adapter;
import com.bw.movie.bean.MohuAddressBean;
import com.bw.movie.contract.MohuAddressContract;
import com.bw.movie.presenter.MohuAddressPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindCinema_address_Activity extends BaseActivity<MohuAddressPresenter> implements MohuAddressContract.Iview {


    @BindView(R.id.findaddress_letf)
    ImageView findaddressLetf;
    @BindView(R.id.findaddress_edit)
    EditText findaddressEdit;
    @BindView(R.id.findaddress_but)
    Button findaddressBut;
    @BindView(R.id.findaddress_recycle)
    RecyclerView findaddressRecycle;
    @BindView(R.id.tickets_layout)
    RelativeLayout ticketsLayout;
    private String s;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find_cinema_address_;
    }


    @Override
    protected MohuAddressPresenter providePresenter() {
        return new MohuAddressPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        s = findaddressEdit.getText().toString();

    }

    @Override
    public void mohuaddress(MohuAddressBean mohuAddressBean) {
        Log.i("mohuAddressBean", "mohuaddress: " + mohuAddressBean.getMessage());
        List<MohuAddressBean.ResultBean> result = mohuAddressBean.getResult();
        if (result!=null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
            findaddressRecycle.setLayoutManager(linearLayoutManager);
            Findmohu_Address_Adapter findmohu_address_adapter = new Findmohu_Address_Adapter(result, this);
            findaddressRecycle.setAdapter(findmohu_address_adapter);
        }else {
            findaddressRecycle.setVisibility(View.GONE);
            ticketsLayout.setVisibility(View.VISIBLE);
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


    @OnClick({R.id.findaddress_letf, R.id.findaddress_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.findaddress_letf:
                finish();
                break;
            case R.id.findaddress_but:
                mpresenter.mohuaddre("1", "10", s);
                break;
        }
    }
}
