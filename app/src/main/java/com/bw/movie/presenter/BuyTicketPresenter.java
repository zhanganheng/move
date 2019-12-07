package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:10:19
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.BuyTicketBean;
import com.bw.movie.contract.BuyTickeyContract;
import com.bw.movie.model.BuyTicketModel;

public class BuyTicketPresenter extends BasePresenter<BuyTickeyContract.Iview> implements BuyTickeyContract.IPresenter {

    private BuyTicketModel buyTicketModel;

    @Override
    protected void initModel() {
        buyTicketModel = new BuyTicketModel();
    }

    @Override
    public void buytickey(String userId, String sessionId, String page, String count, String status) {
        buyTicketModel.buytickey(userId, sessionId, page, count, status, new BuyTickeyContract.Imodel.IModelCallBack() {
            @Override
            public void BuyTicketSuccess(BuyTicketBean buyTicketBean) {
                    getView().BuyTicketSuccess(buyTicketBean);
            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }
}
