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

import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.adapter.My_Ticket_Adapter;
import com.bw.movie.adapter.My_Ticket_buy_Adapter;
import com.bw.movie.bean.BuyTicketBean;
import com.bw.movie.contract.BuyTickeyContract;
import com.bw.movie.presenter.BuyTicketPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Ticket_buy_Fragment extends BaseFragment<BuyTicketPresenter> implements BuyTickeyContract.Iview {

    @BindView(R.id.cinema_recycler)
    RecyclerView cinemaRecycler;
    @BindView(R.id.lin_visi)
    RelativeLayout linVisi;
    Unbinder unbinder;
    private int userId;
    private String sessionId;

    @Override
    protected BuyTicketPresenter providePresenter() {
        return new BuyTicketPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_ticket_buy_;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        mPresenter.buytickey(userId + "", sessionId, "1", "5", "2");
    }

    @Override
    public void BuyTicketSuccess(BuyTicketBean buyTicketBean) {
        Log.i("buyTicketBean", "BuyTicketSuccess: " + buyTicketBean.getMessage());
        List<BuyTicketBean.ResultBean> result = buyTicketBean.getResult();
        if (result != null) {
            cinemaRecycler.setVisibility(View.VISIBLE);
            linVisi.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            cinemaRecycler.setLayoutManager(linearLayoutManager);
            My_Ticket_buy_Adapter my_ticket_buy_adapter = new My_Ticket_buy_Adapter(result, getActivity());
            cinemaRecycler.setAdapter(my_ticket_buy_adapter);
        } else {
            cinemaRecycler.setVisibility(View.GONE);
            linVisi.setVisibility(View.VISIBLE);
        }
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
