package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.Ticket_xiangBean;
import com.bw.movie.bean.WriterpinBean;

public interface Ticket_xiangContract {
    interface Iview extends BaseView {
        void TicketXiangSuccess(Ticket_xiangBean ticket_xiangBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  ticketxiang(String userId, String sessionId, String orderId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void TicketXiangSuccess(Ticket_xiangBean ticket_xiangBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  ticketxiang(String userId, String sessionId, String orderId);
    }
}
