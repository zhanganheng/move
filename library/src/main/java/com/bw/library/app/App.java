package com.bw.library.app;
/*
 *@auther:张安恒
 *@Date: 2019/11/5
 *@Time:18:47
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class App extends Application {
    public static App sContext;
    // APP_ID 替换为你的应用从官方网站申请到的合法appID
    public static final String APP_ID = "wxb3852e6a6b7d9516";
    // IWXAPI 是第三方app和微信通信的openApi接口
    public static IWXAPI api;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Fresco.initialize(this);

        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(APP_ID);

//        //建议动态监听微信启动广播进行注册到微信
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//                // 将该app注册到微信
//                api.registerApp(Constants.APP_ID);
//            }
//        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));

    }

    public static App getAppContext() {
        return sContext;
    }

}