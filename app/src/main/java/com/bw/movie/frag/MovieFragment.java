package com.bw.movie.frag;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.library.base.BaseFragment;
import com.bw.library.base.BasePresenter;
import com.bw.movie.R;
import com.bw.movie.activity.FindCinema_address_Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @describe(描述)：MovieFragment 电影页面
 * @data（日期）: 2019/11/15
 * @time（时间）: 8:45
 * @author（作者）: 张安恒
 **/
public class MovieFragment extends BaseFragment {


    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    Unbinder unbinder;
    @BindView(R.id.movie_but)
    ImageView movieBut;
    @BindView(R.id.address_but)
    TextView addressBut;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences address = getActivity().getSharedPreferences("address", Context.MODE_PRIVATE);
        String aoiName = address.getString("aoiName", null);
        addressBut.setText(aoiName);

        final List<Fragment> fraglist = new ArrayList<>();
        fraglist.add(new TuiFragment());
        fraglist.add(new FuFragment());
        fraglist.add(new DiquFragment());
        final List<String> list = new ArrayList<>();

        list.add("推荐影院");
        list.add("附近影院");
        list.add("海淀区");
        vpPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        tabLayout.setupWithViewPager(vpPager);
        vpPager.setOffscreenPageLimit(3);
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

    @OnClick(R.id.movie_but)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), FindCinema_address_Activity.class));
    }
}
