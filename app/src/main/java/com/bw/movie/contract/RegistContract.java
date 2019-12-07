package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:21:09
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.RegisterBean;

public interface RegistContract {
    interface Iview extends BaseView {
        void onemailSuccess(RegisterBean registerBean);
        void  onRegistSuccess(RegisterBean registerBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void email(String email,IModelCallBack iModelCallBack);
        void  regist(String nickName,String email, String pwd, String code, IModelCallBack iModelCallBack );
        interface IModelCallBack {
            void onemailSuccess(RegisterBean registerBean);
            void  onRegistSuccess(RegisterBean registerBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  email(String email);
        void  regist(String nickName,String email,String pwd,String code);
    }
}
