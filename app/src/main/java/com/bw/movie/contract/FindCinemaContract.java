package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/19
 *@Time:16:15
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.FindCinemaBean;


public interface FindCinemaContract  {
    interface Iview extends BaseView {
        void  onFindcinema(FindCinemaBean findCinemaBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  findcinema(String keyword,String page,String count,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void  onFindcinema(FindCinemaBean findCinemaBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  findcinema(String keyword,String page,String count);
    }
}
