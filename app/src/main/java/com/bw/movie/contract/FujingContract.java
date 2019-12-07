package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.FujingBean;

public interface FujingContract {
    interface Iview extends BaseView {
        void FujingSuccess(FujingBean fujingBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  fujing(int page, int count, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void FujingSuccess(FujingBean fujingBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  fujing(int page, int count);
    }
}
