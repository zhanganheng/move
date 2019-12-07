package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MyWatchBean;
import com.bw.movie.bean.WriterpinBean;

public interface MyWatchContract {
    interface Iview extends BaseView {
        void Watchmovie(MyWatchBean myWatchBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  mywatch(String userId, String sessionId, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void Watchmovie(MyWatchBean myWatchBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  mywatch(String userId, String sessionId);
    }
}
