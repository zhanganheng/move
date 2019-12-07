package com.bw.library.utils;
/*
 *@auther:张安恒
 *@Date: 2019/11/6
 *@Time:13:54
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    public static  boolean hasNetwork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isConnected()){
            return true;
        }else {
            return false;
        }
    }
}
