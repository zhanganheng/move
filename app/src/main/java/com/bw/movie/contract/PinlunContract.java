package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:21:09
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.PinBean;

public interface PinlunContract {
    interface Iview extends BaseView {
        void  onpinSuccess(PinBean pinBean);
        void onFraily(String e);
    }
    interface  Imodel{
       void  getpin(String userId,String sessionId,String movieId,String page,String count,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void  onpinSuccess(PinBean pinBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
    void  getpin(String userId,String sessionId, String movieId,String page,String count);
    }
}
