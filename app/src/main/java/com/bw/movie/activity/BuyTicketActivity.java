package com.bw.movie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bw.library.base.BaseActivity;
import com.bw.library.base.BasePresenter;
import com.bw.movie.R;
import com.bw.movie.frag.Ticket_buy_Fragment;
import com.bw.movie.frag.Ticket_wait_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuyTicketActivity extends BaseActivity {


    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.guan_tab)
    TabLayout guanTab;
    @BindView(R.id.attention_viewpager)
    ViewPager attentionViewpager;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_buy_ticket;
    }

    @Override
    protected void initData() {
        super.initData();
        final List<Fragment> fraglist = new ArrayList<>();
        fraglist.add(new Ticket_wait_Fragment());
        fraglist.add(new Ticket_buy_Fragment());
        final List<String> list = new ArrayList<>();
        list.add("待付款");
        list.add("已付款");
        guanTab.setTabMode(TabLayout.MODE_FIXED);
        guanTab.setupWithViewPager(attentionViewpager);
        attentionViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fraglist.get(i);
            }

            @Override
            public int getCount() {
                return fraglist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        guanTab.setupWithViewPager(attentionViewpager);
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
