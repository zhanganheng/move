package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/29
 *@Time:20:58
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.XiangCinemaBean;

public interface XiangCinemaContract {
    interface Iview extends BaseView {
        void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean);
        void Guanzhucinema(Guan_movieBean guan_movieBean);
        void  Qucinema(QucinemaBean qucinemaBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  XiangCinemaSuccess(String userId,String sessionId, String cinemaId, IModelCallBack iModelCallBack);
        void  guanzhucinema(String userId,String sessionId, String cinemaId,IModelCallBack iModelCallBack);
        void  quxiaocinema(String userId,String sessionId,String cinemaId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean);
            void Guanzhucinema(Guan_movieBean guan_movieBean);
            void  Qucinema(QucinemaBean qucinemaBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  XiangCinemaSuccess(String userId,String sessionId, String cinemaId);
        void  guanzhucinema(String userId,String sessionId, String cinemaId);
        void  quxiaocinema(String userId,String sessionId,String cinemaId);
    }
}
