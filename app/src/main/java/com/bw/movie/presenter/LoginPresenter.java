package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:18:47
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WXLoginBean;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginContract.Iview> implements LoginContract.IPresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void logins(String email, String pwd) {
            loginModel.login(email, pwd,new LoginContract.Imodel.IModelCallBack() {
                @Override
                public void onLoginSuccess(LoginBean loginBean) {
                    getView().onLoginSuccess(loginBean);
                }

                @Override
                public void onWxLoginSuccess(WXLoginBean wxLoginBean) {

                }


                @Override
                public void onFraily(String e) {
                getView().onFraily(e);
                }
            });
    }

    @Override
    public void wxlogin(String code) {
        loginModel.wxlogin(code, new LoginContract.Imodel.IModelCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {

            }

            @Override
            public void onWxLoginSuccess(WXLoginBean wxLoginBean) {
                getView().onWxLoginSuccess(wxLoginBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }


}
