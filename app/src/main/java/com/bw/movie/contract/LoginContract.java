package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:16:55
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WXLoginBean;

public interface LoginContract {
    interface Iview extends BaseView{
        void  onLoginSuccess(LoginBean loginBean);
        void  onWxLoginSuccess(WXLoginBean wxLoginBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  login(String email,String pwd,IModelCallBack iModelCallBack);
        void  wxlogin(String code,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void  onLoginSuccess(LoginBean loginBean);
            void  onWxLoginSuccess(WXLoginBean wxLoginBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  logins(String email,String pwd);
        void  wxlogin(String code);
    }
}
