package com.bw.movie.activity;

import android.content.Context;
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
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.contract.XiangAContract;
import com.bw.movie.frag.XiangAFragment;
import com.bw.movie.frag.XiangBFragment;
import com.bw.movie.frag.XiangCFragment;
import com.bw.movie.frag.XiangDFragment;
import com.bw.movie.presenter.XiangAPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：XiangAActivity 首页详情
 * @data（日期）: 2019/11/15
 * @time（时间）: 20:19
 * @author（作者）: 张安恒
 **/
public class XiangAActivity extends BaseActivity<XiangAPresenter> implements XiangAContract.Iview {


    @BindView(R.id.xiang_img)
    SimpleDraweeView xiangImg;
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.details_mark)
    TextView detailsMark;
    @BindView(R.id.details_critic)
    TextView detailsCritic;
    @BindView(R.id.details_name)
    TextView detailsName;
    @BindView(R.id.details_type)
    TextView detailsType;
    @BindView(R.id.details_long)
    TextView detailsLong;
    @BindView(R.id.details_time)
    TextView detailsTime;
    @BindView(R.id.guanzhu_img)
    CheckBox guanzhuImg;
    @BindView(R.id.details_diqu)
    TextView detailsDiqu;
    @BindView(R.id.xiang_tab)
    TabLayout xiangTab;
    @BindView(R.id.xiang_vp)
    ViewPager xiangVp;
    @BindView(R.id.btn_reviews)
    Button btnReviews;
    @BindView(R.id.btn_seat)
    Button btnSeat;
    private int movieId;
    private String name;
    private int userId;
    private String sessionId;


    @Override
    protected XiangAPresenter providePresenter() {
        return new XiangAPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiang_a;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        Intent intent = getIntent();
        final String movieId = intent.getStringExtra("movieId");
        mpresenter.xiangA(movieId + "");

        guanzhuImg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if (isChecked){
                     mpresenter.guansmovie(userId+"",sessionId,movieId+"");
                     guanzhuImg.setBackgroundResource(R.mipmap.emptyheart1);
                 }else {
                     mpresenter.quxiaomovie(userId+"",sessionId,movieId+"");
                     guanzhuImg.setBackgroundResource(R.mipmap.emptyheart);
                 }
            }
        });
    }

    @Override
    public void XiangASuccess(XiangABean xiangABean) {
        Log.i("xiangABean", "XiangASuccess: " + xiangABean.getMessage());
        XiangABean.ResultBean result = xiangABean.getResult();
        movieId = result.getMovieId();
        name = result.getName();
        //设置图片
        String imageUrl = result.getImageUrl();
        Log.i("qwe", "XiangASuccess: " + imageUrl);
        xiangImg.setImageURI(imageUrl);
        //评分 评论
        detailsMark.setText("评分:" + result.getScore());
        detailsCritic.setText("评论:" + result.getCommentNum() + "万条");
        //电影名称，类型，时间
        detailsName.setText(result.getName());
        detailsType.setText(result.getMovieType());
        detailsTime.setText(result.getDuration());
        long time = result.getReleaseTime();
        //时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(time);
        detailsLong.setText(format);
        //地区
        detailsDiqu.setText(result.getPlaceOrigin());

        final List<Fragment> fraglist = new ArrayList<>();
        fraglist.add(new XiangAFragment());
        fraglist.add(new XiangBFragment());
        fraglist.add(new XiangCFragment());
        fraglist.add(new XiangDFragment());
        final List<String> list = new ArrayList<>();
        list.add("介绍");
        list.add("预告");
        list.add("剧照");
        list.add("影评");
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
        EventBus.getDefault().postSticky(xiangABean);
        EventBus.getDefault().postSticky(xiangABean);

        //判断是否关注
        if (result.getWhetherFollow()==1){
            guanzhuImg.setChecked(true);
        }else {
            guanzhuImg.setChecked(false);
        }
    }


    @Override
    public void GuanMovieSuccess(Guan_movieBean guan_movieBean) {
        Log.i("guan_movieBean", "GuanMovieSuccess: "+guan_movieBean.getMessage());
        if (guan_movieBean.getMessage().equals("关注成功")){
            Toast.makeText(this, "已关注", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Qumovie(QumovieBean qumovieBean) {
        if (qumovieBean.getStatus().equals("0000")){
            Toast.makeText(this, qumovieBean.getMessage(), Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.btn_reviews, R.id.btn_seat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reviews:
                Intent intent = new Intent(this, Writer_pinActivity.class);
                intent.putExtra("movieId", movieId);
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.btn_seat:
                startActivity(new Intent(this, Chose_cinemaActivity.class));
                break;
        }
    }

}
