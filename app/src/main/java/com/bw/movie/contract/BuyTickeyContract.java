package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.BuyTicketBean;


public interface BuyTickeyContract {
    interface Iview extends BaseView {
        void BuyTicketSuccess(BuyTicketBean buyTicketBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  buytickey(String userId, String sessionId, String page, String count,String status, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void BuyTicketSuccess(BuyTicketBean buyTicketBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  buytickey(String userId, String sessionId, String page, String count,String status);
    }
}
