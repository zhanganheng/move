package com.bw.movie.frag;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.library.base.BaseFragment;
import com.bw.movie.R;
import com.bw.movie.activity.Findcinema_Activity;
import com.bw.movie.activity.GengduoActivity;
import com.bw.movie.activity.XiangAActivity;
import com.bw.movie.adapter.ArecycleAdapter;
import com.bw.movie.adapter.BrecycleAdapter;
import com.bw.movie.adapter.CrecycleAdapter;
import com.bw.movie.bean.ACimemaBean;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CCinemaBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.BannerContract;
import com.bw.movie.presenter.BannerPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 * @describe(描述)：CinemaFragment 展示首页页面
 * @data（日期）: 2019/11/14
 * @time（时间）: 11:52
 * @author（作者）: 张安恒
 **/
public class CinemaFragment extends BaseFragment<BannerPresenter> implements BannerContract.Iview {


    @BindView(R.id.x_banner)
    XBanner xBanner;
    Unbinder unbinder;
    @BindView(R.id.recycle_a)
    RecyclerView recycleA;
    @BindView(R.id.recycle_b)
    RecyclerView recycleB;
    @BindView(R.id.recycle_c)
    RecyclerView recycleC;
    @BindView(R.id.sou_cinema)
    ImageView souCinema;
    @BindView(R.id.icon_location3)
    ImageView iconLocation3;
    @BindView(R.id.gengduo1_but)
    TextView gengduo1But;
    @BindView(R.id.gengduo2_but)
    TextView gengduo2But;
    @BindView(R.id.gengduo3_but)
    TextView gengduo3But;
    @BindView(R.id.icon_location)
    ImageView iconLocation;
    @BindView(R.id.weizhi_text)
    TextView weizhiText;
    private List<BannerBean.ResultBean> result;
    private int movieId;
    private int userId;
    private String sessionId;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;


    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }


    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        sessionId = sp.getString("sessionId", null);
        SharedPreferences movieIdsp = getActivity().getSharedPreferences("movieId", MODE_PRIVATE);
        movieId = movieIdsp.getInt("movieId", 0);
        mPresenter.getbanner();
        mPresenter.getacinema("1", "10");
        mPresenter.getbcinema("2", "5");
        mPresenter.getccinema("3", "6");

        iconLocation.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(getActivity());//开始定位
                }
            }
        });
    }


    @Override
    public void YuyueSuccess(YuyueBean yuyueBean) {
        Log.i("yuyueBean", "YuyueSuccess: " + yuyueBean.getMessage());
        if (yuyueBean.getMessage().equals("已预约")) {
            Toast.makeText(getActivity(), "已预约", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "预约成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAcinemaSuccess(ACimemaBean aCimemaBean) {
        Log.i("aCimemaBean", "onAcinemaSuccess: " + aCimemaBean.getMessage());
        List<ACimemaBean.ResultBean> result = aCimemaBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        recycleA.setLayoutManager(linearLayoutManager);
        ArecycleAdapter arecycleAdapter = new ArecycleAdapter(result, getActivity());
        recycleA.setAdapter(arecycleAdapter);

    }

    @Override
    public void onBcinemaSuccess(BCinemaBean bCinemaBean) {
        Log.i("bCinemaBean", "onBcinemaSuccess: " + bCinemaBean.getMessage());
        List<BCinemaBean.ResultBean> result = bCinemaBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        recycleB.setLayoutManager(linearLayoutManager);
        BrecycleAdapter brecycleAdapter = new BrecycleAdapter(result, getContext());
        recycleB.setAdapter(brecycleAdapter);
        //点击预约
        brecycleAdapter.setSetonClickListe(new BrecycleAdapter.setonClickListe() {
            @Override
            public void onclick() {
                mPresenter.yuyue(userId + "", sessionId, movieId + "");
            }
        });
    }

    @Override
    public void onCcinemaSuccess(CCinemaBean cCinemaBean) {
        Log.i("cCinemaBean", "onBcinemaSuccess: " + cCinemaBean.getMessage());
        List<CCinemaBean.ResultBean> result = cCinemaBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        recycleC.setLayoutManager(linearLayoutManager);
        CrecycleAdapter crecycleAdapter = new CrecycleAdapter(result, getActivity());
        recycleC.setAdapter(crecycleAdapter);

    }

    @Override
    public void onBannerSuccess(final BannerBean bannerBean) {
        if (bannerBean.getResult()!=null){
        Log.i("bannerBean", "onBannerSuccess: " + bannerBean.getMessage());
        final List<BannerBean.ResultBean> result = bannerBean.getResult();

            xBanner.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
                @Override
                public int size() {
                    return result.size();
                }

                @Override
                public SimpleBannerInfo get(int index) {
                    return null;
                }
            });
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, final int position) {

                    SimpleDraweeView my_image_view = view.findViewById(R.id.my_image_view);
                    AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                            .setUri(result.get(position).getImageUrl())
                            .setAutoPlayAnimations(true)
                            .build();
                    my_image_view.setController(controller);

                    //获取轮播图id
                    String jumpUrl = result.get(position).getJumpUrl();
                    Log.i("jumpUrl", "loadBanner: " + jumpUrl);
                    final String[] split = jumpUrl.split("=");

                    TextView viewById = (TextView) view.findViewById(R.id.tv);
                    viewById.setText(bannerBean.getResult().get(position).getRank() + "/5");
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), XiangAActivity.class);
                            intent.putExtra("movieId", split[1]);
                            startActivity(intent);
                        }
                    });
                }
            });
        }else {
            Toast.makeText(getActivity(), "当前无数据", Toast.LENGTH_SHORT).show();
        }

    }

    /*
     * 定位 判断是否开启权限
     * 有 执行
     * 无 弹框提示进入设置开启权限
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200://刚才的识别码
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意权限,执行我们的操作
                    MyLocation(getActivity());//开始定位
                } else {//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(getActivity(), "未开启定位权限,请手动到设置去开启权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onFraily(String e) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @OnClick(R.id.sou_cinema)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), Findcinema_Activity.class));
    }

    @OnClick({R.id.gengduo1_but, R.id.gengduo2_but, R.id.gengduo3_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gengduo1_but:
                startActivity(new Intent(getActivity(), GengduoActivity.class));
                break;
            case R.id.gengduo2_but:
                startActivity(new Intent(getActivity(), GengduoActivity.class));
                break;
            case R.id.gengduo3_but:
                startActivity(new Intent(getActivity(), GengduoActivity.class));
                break;
        }
    }
    /*
     * 定位成功回调信息，设置相关消息
     * */
    public void MyLocation(Context context) {
        mlocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            weizhiText.setText(amapLocation.getAoiName());
                            String aoiName = amapLocation.getAoiName();
                            SharedPreferences address = getActivity().getSharedPreferences("address", MODE_PRIVATE);
                            SharedPreferences.Editor edit = address.edit();
                            edit.putString("aoiName",aoiName);
                            edit.commit();
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(getActivity(), "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(getActivity());//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }

    //内存泄露和定位
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
        }
    }
}
