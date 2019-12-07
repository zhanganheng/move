package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.GuancinemaBean;
import com.bw.movie.bean.Guanzhu_dianyin;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.QumovieBean;

public interface GuanzhuContract {
    interface Iview extends BaseView {
        void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin);
        void GuanzhuCinema(GuancinemaBean guancinemaBean);
        void  Qumovie(QumovieBean qumovieBean);
        void  Qucinema(QucinemaBean qucinemaBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  guanzhumovie(String userId,String sessionId,String page,String count, IModelCallBack iModelCallBack);
        void  guanzhucinema(String userId,String sessionId,String page,String count, IModelCallBack iModelCallBack);
        void  quxiaomovie(String userId,String sessionId,String movieId,IModelCallBack iModelCallBack);
        void  quxiaocinema(String userId,String sessionId,String cinemaId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin);
            void GuanzhuCinema(GuancinemaBean guancinemaBean);
            void  Qumovie(QumovieBean qumovieBean);
            void  Qucinema(QucinemaBean qucinemaBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  guanzhumovie(String userId,String sessionId,String page,String count);
        void  guanzhucinema(String userId,String sessionId,String page,String count);
        void  quxiaomovie(String userId,String sessionId,String movieId);
        void  quxiaocinema(String userId,String sessionId,String cinemaId);
    }
}
