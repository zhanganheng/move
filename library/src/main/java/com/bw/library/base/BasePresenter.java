package com.bw.library.base;
/*
 *@auther:张安恒
 *@Date: 2019/11/5
 *@Time:18:56
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;

import com.bw.library.app.App;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends BaseView>{

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        initModel();
    }
//初始化model
    protected abstract void initModel();

    //绑定view
    protected   void attachView(V  v){
        vWeakReference = new WeakReference<>(v);
    }

    //解绑View
    protected  void  detachView(){
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    /*
    * 判断view是否挂载
    * 防止出现presenter层vie调用控指针
    * 每次调用业务请求的时候都要先调用方法检查是否与view绑定
    * 只有返回true才进行回调
    * */
        protected boolean isViewAttached(){
            if (vWeakReference==null|| vWeakReference.get()==null){
                return false;
            }
            return true;
        }
       /*获取view接口
       * 只有isviewAttached返回true的时候，才能调用它
       * */
       protected V getView(){
           return  vWeakReference.get();
       }

       private Context context(){
           if (isViewAttached()&&getView().context()!=null){
               return getView().context();
           }
           return App.getAppContext();
       }
}
