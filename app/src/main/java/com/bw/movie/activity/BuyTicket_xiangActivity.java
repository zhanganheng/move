package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.bean.Ticket_xiangBean;
import com.bw.movie.contract.Ticket_xiangContract;
import com.bw.movie.presenter.Ticket_XiangPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：BuyTicket_xiangActivity 购票详情
 * @data（日期）: 2019/12/3
 * @time（时间）: 11:54
 * @author（作者）: 张安恒
 **/
public class BuyTicket_xiangActivity extends BaseActivity<Ticket_XiangPresenter> implements Ticket_xiangContract.Iview {

    @BindView(R.id.movie_name_seat)
    TextView movieNameSeat;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.position)
    TextView position;
    @BindView(R.id.home)
    TextView home;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.seat)
    TextView seat;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.orderId)
    TextView orderId;
    @BindView(R.id.createtime)
    TextView createtime;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.left)
    ImageView left;
    @BindView(R.id.dianxiang_layout)
    RelativeLayout dianxiangLayout;

    private int userId;
    private String sessionId;

    @Override
    protected Ticket_XiangPresenter providePresenter() {
        return new Ticket_XiangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_buy_ticket_xiang;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        String orderId = intent.getStringExtra("orderId");
        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        mpresenter.ticketxiang(userId + "", sessionId, orderId);
    }

    @Override
    public void TicketXiangSuccess(Ticket_xiangBean ticket_xiangBean) {
        Log.i("ticket_xiangBean", "TicketXiangSuccess: " + ticket_xiangBean.getMessage());
        Ticket_xiangBean.ResultBean result = ticket_xiangBean.getResult();
        if (result!=null){
            name.setText(result.getCinemaName());
            position.setText(result.getCinemaName());
            home.setText(result.getScreeningHall());
            count.setText(result.getAmount() + "张");
            seat.setText(result.getSeat());
            orderId.setText(result.getOrderId());
            price.setText("￥" + result.getPrice() + "");
        }else {
            name.setVisibility(View.GONE);
            position.setVisibility(View.GONE);
            home.setVisibility(View.GONE);
            count.setVisibility(View.GONE);
            seat.setVisibility(View.GONE);
            orderId.setVisibility(View.GONE);
            price.setVisibility(View.GONE);
            dianxiangLayout.setVisibility(View.VISIBLE);
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

    @OnClick(R.id.left)
    public void onViewClicked() {
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
