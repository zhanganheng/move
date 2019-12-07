package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:17:01
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WXLoginBean;
import com.bw.movie.contract.LoginContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginModel implements LoginContract.Imodel {
    @Override
    public void login(String email, String pwd, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .login(email, pwd)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModelCallBack.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });

     }

    @Override
    public void wxlogin(String code, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .wx(code)
                .compose(CommonSchedulers.<WXLoginBean>io2main())
                .subscribe(new Observer<WXLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WXLoginBean wxLoginBean) {
                    iModelCallBack.onWxLoginSuccess(wxLoginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
