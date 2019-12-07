package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:13:47
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.bean.XiangABean;

public interface MyPinContract {
    interface  Iview extends BaseView{
        void  MoviePinSuccess(MyAPinBean myAPinBean);
        void  CinemaPinSuccess(Ping_yingyuanBean ping_yingyuanBean);
        void  Fraily(String e);
    }
    interface  Imodel{
        void  moviepin(String userId,String sessionId,String page,String count, IModelCallBack iModelCallBack);
        void  cinemapin(String userId,String sessionId,String longitude,String latitude,String page,String count, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void  MoviePinSuccess(MyAPinBean myAPinBean);
            void  CinemaPinSuccess(Ping_yingyuanBean ping_yingyuanBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  moviepin(String userId,String sessionId,String page,String count);
        void  cinemapin(String userId,String sessionId,String longitude,String latitude,String page,String count);
    }
}
