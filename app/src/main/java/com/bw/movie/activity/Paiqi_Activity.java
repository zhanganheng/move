package com.bw.movie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.contract.PaiqiContract;
import com.bw.movie.frag.Paiqi_Fragment;
import com.bw.movie.presenter.PaiqiPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Paiqi_Activity extends BaseActivity<PaiqiPresenter> implements PaiqiContract.Iview {


    @BindView(R.id.paiqi_tab)
    TabLayout paiqiTab;
    @BindView(R.id.paiqi_vp)
    ViewPager paiqiVp;
    @BindView(R.id.find_letf)
    ImageView findLetf;
    private List<PaiqiBean.ResultBean> result;
    private ArrayList<Object> list;
    private ArrayList<Fragment> fragments;

    @Override
    protected PaiqiPresenter providePresenter() {
        return new PaiqiPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_paiqi_;
    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.findtime();
    }


    @Override
    public void PaiqiSuccess(PaiqiBean paiqiBean) {


    }

    @Override
    public void onFindtimeSuccess(FindtimeBean findtimeBean) {
        Log.i("paiqitime", "onFindtimeSuccess: " + findtimeBean.getMessage());
        List<String> result = findtimeBean.getResult();
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add(result.get(i));
        }
        paiqiVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                Paiqi_Fragment paiqi_fragment = new Paiqi_Fragment();
                return paiqi_fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        paiqiTab.setupWithViewPager(paiqiVp);
        paiqiVp.setOffscreenPageLimit(result.size());
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
