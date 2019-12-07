package com.bw.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.bw.library.utils.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment <P extends  BasePresenter> extends Fragment  implements  BaseView {

    protected P mPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(provideLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = providePresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        initView();
        initData();

    }
    protected  abstract  P providePresenter();
    protected void  initView(){}
    protected void  initData(){}
    protected abstract  int provideLayoutId();

    //释放资源

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    
    //释放资源

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
    
    //判断是否有网
    public  boolean hasNetwork(){
        return NetUtil.hasNetwork(context());
    }
    //无网提醒
    public  void  showNoNetTip(){
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return null;
    }
}
