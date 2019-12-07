package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.TuicinemaBean;

public interface TuicinemaContract {
    interface Iview extends BaseView {
        void TuicinemaSuccess(TuicinemaBean tuicinemaBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  tuicinema(int page, int count, IModelCallBack iModelCallBack );
        interface IModelCallBack {
            void TuicinemaSuccess(TuicinemaBean tuicinemaBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  tuicinema(int page, int count);
    }
}
