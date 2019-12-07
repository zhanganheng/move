package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.XiangCinemaBean;
import com.bw.movie.contract.XiangCinemaContract;
import com.bw.movie.frag.Xiang_cinema_frag;
import com.bw.movie.frag.Xiang_pin_frag;
import com.bw.movie.presenter.XiangCinemaPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：XiangCinemaActivity 影院详情
 * @data（日期）: 2019/12/1
 * @time（时间）: 13:56
 * @author（作者）: 张安恒
 **/
public class XiangCinemaActivity extends BaseActivity<XiangCinemaPresenter> implements XiangCinemaContract.Iview {


    @BindView(R.id.xiang_name)
    TextView xiangName;
    @BindView(R.id.xiang_but)
    Button xiangBut;
    @BindView(R.id.xiang_tab)
    TabLayout xiangTab;
    @BindView(R.id.xiang_vp)
    ViewPager xiangVp;
    @BindView(R.id.paiqi_but)
    Button paiqiBut;
    @BindView(R.id.find_letf)
    ImageView findLetf;
    @BindView(R.id.guanzhu_img)
    CheckBox guanzhuImg;
    private String id;
    private int userId;
    private String sessionId;


    @Override
    protected XiangCinemaPresenter providePresenter() {
        return new XiangCinemaPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiang_cinema;
    }

    @Override
    protected void initView() {
        super.initView();
        final List<Fragment> fraglist = new ArrayList<>();
        fraglist.add(new Xiang_cinema_frag());
        fraglist.add(new Xiang_pin_frag());
        final List<String> list = new ArrayList<>();
        list.add("影院详情");
        list.add("影院评论");
        xiangVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        xiangTab.setupWithViewPager(xiangVp);
    }

    @Override
    protected void initData() {
        super.initData();
        findLetf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        mpresenter.XiangCinemaSuccess(userId + "", sessionId, id);

        //点击关注
        guanzhuImg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mpresenter.guanzhucinema(userId + "", sessionId, id);
                    guanzhuImg.setBackgroundResource(R.mipmap.emptyheart1);
                }else {
                    mpresenter.quxiaocinema(userId+"",sessionId,id);
                     guanzhuImg.setBackgroundResource(R.mipmap.emptyheart);
                    Toast.makeText(XiangCinemaActivity.this, "取消关注", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean) {
        Log.i("xiangCinemaBean", "XiangCinemaSuccess: " + xiangCinemaBean.getMessage());
        XiangCinemaBean.ResultBean result = xiangCinemaBean.getResult();

        xiangName.setText(result.getName());
        xiangBut.setText(result.getLabel());
        if (result.getFollowCinema()==1){
            guanzhuImg.setChecked(true);
        }else {
            guanzhuImg.setChecked(false);
        }
    }

    @Override
    public void Guanzhucinema(Guan_movieBean guan_movieBean) {
        if (guan_movieBean.getStatus().equals("0000")) {
            Toast.makeText(this, guan_movieBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Qucinema(QucinemaBean qucinemaBean) {

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

    //排期
    @OnClick({R.id.paiqi_but})
    public void onViewClicked() {
        Intent intent = new Intent(this, Paiqi_Activity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }


}
