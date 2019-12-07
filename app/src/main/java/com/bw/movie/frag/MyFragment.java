package com.bw.movie.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.library.base.BaseFragment;
import com.bw.library.base.BasePresenter;
import com.bw.movie.R;
import com.bw.movie.SettingActivity;
import com.bw.movie.activity.BuyTicketActivity;
import com.bw.movie.activity.Guanzhu_Activity;
import com.bw.movie.activity.MyData_Activity;
import com.bw.movie.activity.MyFankui_Activity;
import com.bw.movie.activity.MyMessage_Activity;
import com.bw.movie.activity.MyTicket_Activity;
import com.bw.movie.activity.MyWatch_Activity;
import com.bw.movie.activity.My_Yuyue_Activity;
import com.bw.movie.activity.Mypin_Activity;
import com.bw.movie.bean.LoginBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @describe(描述)：MyFragment 我的页面
 * @data（日期）: 2019/11/15
 * @time（时间）: 8:46
 * @author（作者）: 张安恒
 **/

public class MyFragment extends BaseFragment {

    @BindView(R.id.but_setting)
    ImageView butSetting;
    Unbinder unbinder;
    @BindView(R.id.pin_but)
    ImageView pinBut;
    @BindView(R.id.guanzhu_but)
    ImageView guanzhuBut;
    @BindView(R.id.myticket_but)
    RelativeLayout myticketBut;
    @BindView(R.id.buyticket_but)
    ImageView buyticketBut;
    @BindView(R.id.yuyue_but)
    ImageView yuyueBut;
    @BindView(R.id.mywatch_but)
    ImageView mywatchBut;
    @BindView(R.id.fankui_but)
    ImageView fankuiBut;
    @BindView(R.id.mymessage_but)
    ImageView mymessageBut;
    @BindView(R.id.my_data)
    RelativeLayout myData;
    @BindView(R.id.mysrc_but)
    ImageView mysrcBut;
    @BindView(R.id.myname_but)
    TextView mynameBut;


    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences mydata = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        String nickName = mydata.getString("nickName", null);
        String headPic = mydata.getString("headPic", null);
        mynameBut.setText(nickName);
        Glide.with(getActivity()).load(headPic).into(mysrcBut);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.pin_but, R.id.but_setting, R.id.guanzhu_but, R.id.myticket_but,
            R.id.buyticket_but, R.id.yuyue_but, R.id.mywatch_but, R.id.fankui_but, R.id.mymessage_but, R.id.my_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pin_but:
                startActivity(new Intent(getActivity(), Mypin_Activity.class));
                break;
            case R.id.but_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.guanzhu_but:
                startActivity(new Intent(getActivity(), Guanzhu_Activity.class));
                break;
            case R.id.myticket_but:
                startActivity(new Intent(getActivity(), MyTicket_Activity.class));
                break;
            case R.id.buyticket_but:
                startActivity(new Intent(getActivity(), BuyTicketActivity.class));
                break;
            case R.id.yuyue_but:
                startActivity(new Intent(getActivity(), My_Yuyue_Activity.class));
                break;
            case R.id.mywatch_but:
                startActivity(new Intent(getActivity(), MyWatch_Activity.class));
                break;
            case R.id.fankui_but:
                startActivity(new Intent(getActivity(), MyFankui_Activity.class));
                break;
            case R.id.mymessage_but:
                startActivity(new Intent(getActivity(), MyMessage_Activity.class));
                break;
            case R.id.my_data:
                startActivity(new Intent(getActivity(), MyData_Activity.class));
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
