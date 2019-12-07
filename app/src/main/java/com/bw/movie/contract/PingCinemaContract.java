package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/29
 *@Time:20:58
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.Ping_cinemaBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.bean.XiangCinemaBean;

public interface PingCinemaContract {
    interface Iview extends BaseView {
        void PingCinemaSuccess(Ping_cinemaBean ping_cinemaBean);

        void onFraily(String e);
    }
    interface  Imodel{
        void  PingCinemaSuccess(String userId, String sessionId, String cinemaId, String page,String count, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void PingCinemaSuccess(Ping_cinemaBean ping_cinemaBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  PingCinemaSuccess(String userId, String sessionId, String cinemaId, String page,String count);
    }
}
