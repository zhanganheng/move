package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:11:52
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.Ticket_xiangBean;
import com.bw.movie.contract.Ticket_xiangContract;
import com.bw.movie.contract.XiangCinemaContract;
import com.bw.movie.model.Ticket_XiangModel;

public class Ticket_XiangPresenter extends BasePresenter<Ticket_xiangContract.Iview> implements Ticket_xiangContract.IPresenter {

    private Ticket_XiangModel ticket_xiangModel;

    @Override
    protected void initModel() {
        ticket_xiangModel = new Ticket_XiangModel();
    }

    @Override
    public void ticketxiang(String userId, String sessionId, String orderId) {
        ticket_xiangModel.ticketxiang(userId, sessionId, orderId, new Ticket_xiangContract.Imodel.IModelCallBack() {
            @Override
            public void TicketXiangSuccess(Ticket_xiangBean ticket_xiangBean) {
                getView().TicketXiangSuccess(ticket_xiangBean);
            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }
}
