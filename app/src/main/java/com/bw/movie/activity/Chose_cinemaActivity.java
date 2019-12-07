package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.Chose_cinemaAdapter;
import com.bw.movie.bean.FindAddressBean;
import com.bw.movie.bean.FindquBean;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.contract.FindquyuContract;
import com.bw.movie.presenter.FindquyuPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * @describe(描述)：Chose_cinemaActivity 选择影院
 * @data（日期）: 2019/11/20
 * @time（时间）: 13:48
 * @author（作者）: 张安恒
 **/
public class Chose_cinemaActivity extends BaseActivity<FindquyuPresenter> implements FindquyuContract.Iview {


    @BindView(R.id.chose_tv)
    JCVideoPlayer choseTv;
    @BindView(R.id.chose_name)
    TextView choseName;
    @BindView(R.id.chose_1)
    TextView chose1;
    @BindView(R.id.chose_time)
    TextView choseTime;
    @BindView(R.id.chose_2)
    TextView chose2;
    @BindView(R.id.chose_pin)
    TextView chosePin;
    @BindView(R.id.chose_3)
    TextView chose3;
    @BindView(R.id.chose_daoyan)
    TextView choseDaoyan;
    @BindView(R.id.but_address)
    Button butAddress;
    @BindView(R.id.but_time)
    Button butTime;
    @BindView(R.id.but_load)
    Button butLoad;

    @BindView(R.id.aa)
    LinearLayout aa;
    @BindView(R.id.chose_recycle)
    RecyclerView choseRecycle;
    private int movieIds;
    private String videoUrl;
    private String name;
    private String s;


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_chose_cinema;
    }

    @Override
    protected FindquyuPresenter providePresenter() {
        return new FindquyuPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        mpresenter.findquyu();
        mpresenter.findtime();
        EventBus.getDefault().register(this);


    }

    @Override
    public void onFindquSuccess(FindquBean findquBean) {
        Log.i("findquBean", "onFindquSuccess: " + findquBean.getMessage());
        List<FindquBean.ResultBean> result = findquBean.getResult();
        String regionName = result.get(0).getRegionName();
        butAddress.setText(regionName);
    }

    @Override
    public void onFindtimeSuccess(FindtimeBean findtimeBean) {
        Log.i("findtimeBean", "onFindtimeSuccess: " + findtimeBean.getMessage());
        List<String> result = findtimeBean.getResult();
        s = result.get(0);
        butTime.setText(s);

    }

    @Override
    public void onFindAddress(FindAddressBean findAddressBean) {
        Log.i("findAddressBean", "onFindAddress: " + findAddressBean.getMessage());
        final List<FindAddressBean.ResultBean> result = findAddressBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        choseRecycle.setLayoutManager(linearLayoutManager);
        final Chose_cinemaAdapter chose_cinemaAdapter = new Chose_cinemaAdapter(result,this);
        choseRecycle.setAdapter(chose_cinemaAdapter);
        chose_cinemaAdapter.setSetOnClickListen(new Chose_cinemaAdapter.setOnClickListen() {
            @Override
            public void onClick(String id) {
                //传cinemaId
                Intent intent=new Intent(Chose_cinemaActivity.this,FindInfo_Activity.class);
                intent.putExtra("cimenaId",id+"");
                intent.putExtra("videourl",videoUrl);
                intent.putExtra("movidID",movieIds);
                intent.putExtra("moviedname",name+"");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFraily(String e) {

    }


    //eventbus上面数据
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onEvent(XiangABean xiangABean) {

        Log.i("chosecinema", "XiangASuccess: " + xiangABean.getMessage());
        XiangABean.ResultBean result = xiangABean.getResult();
        movieIds = result.getMovieId();
        Log.i("ssssssss", "onEvent: "+movieIds);
        videoUrl = result.getShortFilmList().get(0).getVideoUrl();
        choseTv.setUp(result.getShortFilmList().get(0).getVideoUrl(), "");
        choseName.setText(result.getName());
        name = result.getName();
        choseTime.setText(result.getDuration());
        chosePin.setText(result.getScore() + "分");
        choseDaoyan.setText(result.getMovieDirector().get(0).getName());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_address, R.id.but_time, R.id.but_load})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_address:
                mpresenter.findaddress(movieIds + "", "1", "1", "5");
                break;
            case R.id.but_time:
                mpresenter.findtimers(movieIds + "", s, "1", "5");
                break;
            case R.id.but_load:
                mpresenter.findmoney(movieIds+"","1","5");
                break;
        }
    }
}
