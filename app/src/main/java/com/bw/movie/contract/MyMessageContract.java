package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MyMessageBean;
import com.bw.movie.bean.WriterpinBean;

public interface MyMessageContract {
    interface Iview extends BaseView {
        void MyMessageSuccess(MyMessageBean myMessageBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  mymessage(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void MyMessageSuccess(MyMessageBean myMessageBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  mymessage(String userId, String sessionId, String page, String count);
    }
}
