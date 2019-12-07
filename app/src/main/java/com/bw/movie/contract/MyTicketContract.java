package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MyTicketBean;
import com.bw.movie.bean.MyerweimaBean;
import com.bw.movie.bean.WriterpinBean;

public interface MyTicketContract {
    interface Iview extends BaseView {
        void MyTicket(MyTicketBean ticketBean);
        void Erweima(MyerweimaBean myerweimaBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  myticket(String userId, String sessionId,IModelCallBack iModelCallBack);
        void  erweima(String userId, String sessionId,String recordId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void myticket(MyTicketBean ticketBean);
            void Erweima(MyerweimaBean myerweimaBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  myticket(String userId, String sessionId);
        void  erweima(String userId, String sessionId,String recordId);
    }
}
