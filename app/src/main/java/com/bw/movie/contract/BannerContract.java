package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/12
 *@Time:17:02
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.ACimemaBean;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CCinemaBean;
import com.bw.movie.bean.YuyueBean;


public interface BannerContract {
    interface  Iview extends BaseView{
        void  YuyueSuccess(YuyueBean yuyueBean);
        void  onAcinemaSuccess(ACimemaBean aCimemaBean);
        void  onBcinemaSuccess(BCinemaBean bCinemaBean);
        void  onCcinemaSuccess(CCinemaBean cCinemaBean);
        void onBannerSuccess(BannerBean bannerBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  yuyue(String userId, String sessionId,String movieId,IModelCallBack iModelCallBack);
        void acinema(String page,String count,IModelCallBack iModelCallBack);
        void bcinema(String page,String count,IModelCallBack iModelCallBack);
        void ccinema(String page,String count,IModelCallBack iModelCallBack);
        void banner(IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void  YuyueSuccess(YuyueBean yuyueBean);
            void  onAcinemaSuccess(ACimemaBean aCimemaBean);
            void  onBcinemaSuccess(BCinemaBean bCinemaBean);
            void  onCcinemaSuccess(CCinemaBean cCinemaBean);
            void onBannerSuccess(BannerBean bannerBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  yuyue(String userId, String sessionId,String movieId);
        void  getacinema(String page,String count);
        void  getbcinema(String page,String count);
        void  getccinema(String page,String count);
        void  getbanner();
    }
}
