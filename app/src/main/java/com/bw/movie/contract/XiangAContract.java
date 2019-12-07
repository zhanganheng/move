package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.GuancinemaBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.XiangABean;

public interface XiangAContract {
    interface Iview extends BaseView {
        void XiangASuccess(XiangABean xiangABean);
        void GuanMovieSuccess(Guan_movieBean guan_movieBean);
        void  Qumovie(QumovieBean qumovieBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  xiangA(String movieId, IModelCallBack iModelCallBack);
        void  guansmovie(String userId,String sessionId,String movieId,IModelCallBack iModelCallBack);
        void  quxiaomovie(String userId,String sessionId,String movieId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void XiangASuccess(XiangABean xiangABean);
            void GuanMovieSuccess(Guan_movieBean guan_movieBean);
            void  Qumovie(QumovieBean qumovieBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  xiangA(String movieId);
        void  guansmovie(String userId,String sessionId,String movieId);
        void  quxiaomovie(String userId,String sessionId,String movieId);
    }
}
