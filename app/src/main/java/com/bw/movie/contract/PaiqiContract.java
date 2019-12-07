package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/29
 *@Time:20:58
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.bean.XiangCinemaBean;

public interface PaiqiContract {
    interface Iview extends BaseView {
        void PaiqiSuccess(PaiqiBean paiqiBean);
        void onFindtimeSuccess(FindtimeBean findtimeBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  Paiqi(String cinemaId, String page,String count, IModelCallBack iModelCallBack);
        void  findtime(IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void PaiqiSuccess(PaiqiBean paiqiBean);
            void onFindtimeSuccess(FindtimeBean findtimeBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  Paiqi(String cinemaId, String page,String count);
        void  findtime();
    }
}
