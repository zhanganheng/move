package com.bw.movie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bw.library.base.BaseActivity;
import com.bw.library.base.BasePresenter;
import com.bw.movie.frag.CinemaFragment;
import com.bw.movie.frag.MovieFragment;
import com.bw.movie.frag.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：SendActivity fragment框架
 * @data（日期）: 2019/11/12
 * @time（时间）: 9:33
 * @author（作者）: 张安恒
 **/
public class CinemaActivity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.yingpian)
    LinearLayout yingpian;
    @BindView(R.id.movie)
    LinearLayout movie;
    @BindView(R.id.relat_a)
    RelativeLayout relatA;
    @BindView(R.id.shapes)
    LinearLayout shapes;
    @BindView(R.id.cinema)
    LinearLayout cinema;
    @BindView(R.id.relat_b)
    RelativeLayout relatB;
    @BindView(R.id.my)
    LinearLayout my;
    @BindView(R.id.my_a)
    LinearLayout myA;
    @BindView(R.id.relat_c)
    RelativeLayout relatC;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_send;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        final List<Fragment> fraglist=new ArrayList<>();
        fraglist.add(new CinemaFragment());
        fraglist.add(new MovieFragment());
        fraglist.add(new MyFragment());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fraglist.get(i);
            }

            @Override
            public int getCount() {
                return fraglist.size();
            }

        });
    }


    @OnClick({R.id.relat_a, R.id.relat_b, R.id.relat_c})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relat_a:
                yingpian.setVisibility ( View.VISIBLE );
                movie.setVisibility ( View.GONE );
                shapes.setVisibility ( View.GONE );
                cinema.setVisibility ( View.VISIBLE );
                my.setVisibility ( View.GONE );
                myA.setVisibility ( View.VISIBLE );
                vp.setCurrentItem ( 0 );
                break;
            case R.id.relat_b:
                yingpian.setVisibility ( View.GONE );
                movie.setVisibility ( View.VISIBLE );
                shapes.setVisibility ( View.VISIBLE );
                cinema.setVisibility ( View.GONE );
                my.setVisibility ( View.GONE );
                myA.setVisibility ( View.VISIBLE );
                vp.setCurrentItem ( 1 );
                break;
            case R.id.relat_c:
                yingpian.setVisibility ( View.GONE );
                movie.setVisibility ( View.VISIBLE );
                shapes.setVisibility ( View.GONE );
                cinema.setVisibility ( View.VISIBLE );
                my.setVisibility ( View.VISIBLE );
                myA.setVisibility ( View.GONE );
                vp.setCurrentItem ( 2 );
                break;
        }
    }
}
