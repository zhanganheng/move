package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.library.app.App;
import com.bw.library.base.BaseActivity;
import com.bw.movie.R;
import com.bw.movie.adapter.Info_chose_Adapter;
import com.bw.movie.adapter.Info_paiqi_Adapter;
import com.bw.movie.bean.FindInfoBean;
import com.bw.movie.bean.FindWatchTimeBean;
import com.bw.movie.bean.XiadanBean;
import com.bw.movie.bean.ZhifuBean;
import com.bw.movie.contract.FindInfoAContract;
import com.bw.movie.presenter.FindInfoPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * @describe(描述)：FindInfo_Activity 选座
 * @data（日期）: 2019/11/21
 * @time（时间）: 9:46
 * @author（作者）: 张安恒
 **/
public class FindInfo_Activity extends BaseActivity<FindInfoPresenter> implements FindInfoAContract.Iview {

    @BindView(R.id.info_name)
    TextView infoName;
    @BindView(R.id.info_back)
    ImageView infoBack;
    @BindView(R.id.info_cinema)
    JCVideoPlayer infoCinema;
    @BindView(R.id.info_chose_recycle)
    RecyclerView infoChoseRecycle;
    @BindView(R.id.info_name2)
    TextView infoName2;
    @BindView(R.id.info_paiqi)
    RecyclerView infoPaiqi;
    @BindView(R.id.zhifu_but)
    Button zhifuBut;

    private String cimenaId;
    private String videourl;
    private String moviedname;
    private String num;

    private String s;
    private String mds;
    private int id;
    private int userId;
    private String sessionId;
    private double fare;
    private long sum;
    private double zf;
   // private String strings;
    private String str;
    private String orderId;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find_info_;
    }

    @Override
    protected FindInfoPresenter providePresenter() {
        return new FindInfoPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        //电影院id
        SharedPreferences ssp = getSharedPreferences("cinemaid", MODE_PRIVATE);
        int id = ssp.getInt("id", 0);

        Intent intent = getIntent();
        cimenaId = intent.getStringExtra("cimenaId");
        videourl = intent.getStringExtra("videourl");
        int movidID = intent.getIntExtra("movidID", 0);
        Log.i("cinemaidaa", "initData: " + cimenaId);
        Log.i("cinemaidDI", "initData: " + movidID);
        Log.i("spcinemaid", "initData: "+id);

        moviedname = intent.getStringExtra("moviedname");
        infoCinema.setUp(videourl, null);
        infoName.setText(moviedname);
        mpresenter.findwatchtime(movidID + "", id+"");
        mpresenter.findwatchtime(movidID + "", cimenaId);

        SharedPreferences mydata = getSharedPreferences("mydata", MODE_PRIVATE);

        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        this.userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);

    }

    //选座
    @Override
    public void FindInfoSuccess(FindInfoBean findInfoBean) {
        Log.i("findInfoBean", "FindInfoSuccess: " + findInfoBean.getMessage());
        final List<FindInfoBean.ResultBean> result = findInfoBean.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 8);
        infoChoseRecycle.setLayoutManager(gridLayoutManager);
        Info_chose_Adapter info_chose_adapter = new Info_chose_Adapter(result, this);
        infoChoseRecycle.setAdapter(info_chose_adapter);

        info_chose_adapter.setSetColor(new Info_chose_Adapter.SetColor() {
            @Override
            public void getBack(String s) {
             //   Toast.makeText(FindInfo_Activity.this, s, Toast.LENGTH_SHORT).show();
                //strings =s;
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getStatus()==3){
                        sum++;
                    }
                }
                    //设置价格
                    if (sum!=0){
                        zf=sum*fare;
                        zhifuBut.setText("￥:"+sum*fare);
                    }
                }

            @Override
            public void getString(ArrayList<String> list) {
                    str ="";
                for (int i = 0; i < list.size(); i++) {
                    if (str.length()==0){
                      str+=list.get(i);
                    }else {
                        str+=","+list.get(i);
                    }
                }
                zhifuBut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击下单成功
                        mpresenter.xiadan(userId +"", sessionId,id+"",str,mds);
                    }
                });
            }
        });
    }

    //影厅排期表
    @Override
    public void FindWatchTime(FindWatchTimeBean findWatchTimeBean) {
        Log.i("findWatchTimeBean", "FindWatchTime: " + findWatchTimeBean.getMessage());
        final List<FindWatchTimeBean.ResultBean> result = findWatchTimeBean.getResult();
        Log.i("logissss", "FindWatchTime: " + result);
        infoName2.setText("选择影厅和时间 " + "(" + result.size() + ")");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        infoPaiqi.setLayoutManager(linearLayoutManager);
        Info_paiqi_Adapter info_paiqi_adapter = new Info_paiqi_Adapter(result, this);
        infoPaiqi.setAdapter(info_paiqi_adapter);
        info_paiqi_adapter.setSetonClicklist(new Info_paiqi_Adapter.setonClicklist() {
            @Override
            public void onClick(int postition) {
                mpresenter.findinfo(result.get(postition).getHallId()+"");
                //单价
                fare = result.get(postition).getFare();
                id = result.get(postition).getId();
                String str = Integer.toString(id);
                //拼接参数加密
                s = userId + str + "movie";
                mds = EncryptUtil.MD5(FindInfo_Activity.this.s);
                Log.i("pingjie", "onClick: "+mds);
            }
        });
    }

    @Override
    public void XiaDan(XiadanBean xiadanBean) {
        //下单成功
        Log.i("xiadanBean", "XiaDan: "+xiadanBean.getMessage());
        initPopWindow();
        //下单号
        orderId = xiadanBean.getOrderId();
        Log.i("orderId", "XiaDan: "+ orderId);

    }

    //支付成功
    @Override
    public void Zhifu(ZhifuBean zhifuBean) {
        String message = zhifuBean.getMessage();
        Log.i("xxx", "Zhifu: "+message);
        if (zhifuBean.getStatus().equals("0000")){
            PayReq req = new PayReq();
            req.appId = zhifuBean.getAppId();
            req.partnerId = zhifuBean.getPartnerId();
            req.prepayId = zhifuBean.getPrepayId();
            req.nonceStr = zhifuBean.getNonceStr();
            req.timeStamp = zhifuBean.getTimeStamp();
            req.packageValue = zhifuBean.getPackageValue();
            req.sign = zhifuBean.getSign();
            App.api.sendReq(req);//api为 IWXAPI
        }
    }

    private void initPopWindow() {
        View view = LayoutInflater.from(context()).inflate(R.layout.zhifu_layout, null, false);
        ImageView weixin_but = (ImageView) view.findViewById(R.id.weixin_but);
        ImageView zhifubao_but = (ImageView) view.findViewById(R.id.zhifubao_but);

        final PopupWindow popWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        //wx支付
        weixin_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FindInfo_Activity.this, "正在跳转....", Toast.LENGTH_SHORT).show();

              mpresenter.zhifu(userId+"",sessionId,"1",orderId);
                popWindow.dismiss();
            }
        });
        zhifubao_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popWindow.dismiss();
            }
        });
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindow.showAtLocation(view, Gravity.BOTTOM,0, 0);
    }

    @Override
    public void onFraily(String e) {

    }

    //点击返回
    @OnClick(R.id.info_back)
    public void onViewClicked() {
        infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
