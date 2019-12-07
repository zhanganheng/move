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
import com.bw.movie.frag.Guan_cinema_Fragment;
import com.bw.movie.frag.Guan_movie_Fragment;
import com.bw.movie.frag.PinCinema_Fragment;
import com.bw.movie.frag.PinMovie_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Guanzhu_Activity extends BaseActivity {


    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.guan_tab)
    TabLayout guanTab;
    @BindView(R.id.guan_vp)
    ViewPager guanVp;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_guanzhu_;
    }

    @Override
    protected void initView() {
        super.initView();
        final List<Fragment> fraglist=new ArrayList<>();
        fraglist.add(new Guan_movie_Fragment());
        fraglist.add(new Guan_cinema_Fragment());
        final List<String> list=new ArrayList<>();
        list.add("电影");
        list.add("影院");
        guanVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        guanTab.setupWithViewPager(guanVp);
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
