package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:20:21
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MyTicketBean;
import com.bw.movie.bean.MyerweimaBean;
import com.bw.movie.contract.MyTicketContract;
import com.bw.movie.model.MyTicketModel;

public class MyTicketPresenter extends BasePresenter<MyTicketContract.Iview> implements MyTicketContract.IPresenter {

    private MyTicketModel myTicketModel;

    @Override
    protected void initModel() {
        myTicketModel = new MyTicketModel();
    }

    @Override
    public void myticket(String userId, String sessionId) {
        myTicketModel.myticket(userId, sessionId, new MyTicketContract.Imodel.IModelCallBack() {
            @Override
            public void myticket(MyTicketBean ticketBean) {
                getView().MyTicket(ticketBean);
            }

            @Override
            public void Erweima(MyerweimaBean myerweimaBean) {

            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }

    @Override
    public void erweima(String userId, String sessionId, String recordId) {
        myTicketModel.erweima(userId, sessionId, recordId, new MyTicketContract.Imodel.IModelCallBack() {
            @Override
            public void myticket(MyTicketBean ticketBean) {

            }

            @Override
            public void Erweima(MyerweimaBean myerweimaBean) {
                    getView().Erweima(myerweimaBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
