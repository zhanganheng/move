package com.bw.movie.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bw.library.base.BaseActivity;
import com.bw.library.base.BasePresenter;
import com.bw.movie.R;
import com.bw.movie.frag.GengduoAFragment;
import com.bw.movie.frag.GengduoBFragment;
import com.bw.movie.frag.GengduoCFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GengduoActivity extends BaseActivity {

    @BindView(R.id.gengduo_letf)
    ImageView gengduoLetf;
    @BindView(R.id.geng_tab)
    TabLayout gengTab;
    @BindView(R.id.geng_vp)
    ViewPager gengVp;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gengduo;
    }

    @Override
    protected void initData() {
        super.initData();
        final List<Fragment> fraglist=new ArrayList<>();
        fraglist.add(new GengduoAFragment());
        fraglist.add(new GengduoBFragment());
        fraglist.add(new GengduoCFragment());
        final List<String> list=new ArrayList<>();
        list.add("正在热映");
        list.add("即将上映");
        list.add("热门电影");
        gengVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        gengTab.setupWithViewPager(gengVp);
    }

    @OnClick(R.id.gengduo_letf)
    public void onViewClicked() {
        gengduoLetf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
