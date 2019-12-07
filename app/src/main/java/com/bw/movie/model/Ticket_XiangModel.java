package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:11:50
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.Ticket_xiangBean;
import com.bw.movie.contract.Ticket_xiangContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Ticket_XiangModel implements Ticket_xiangContract.Imodel {
    @Override
    public void ticketxiang(String userId, String sessionId, String orderId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .tickeyxiang(userId,sessionId,orderId)
                .compose(CommonSchedulers.<Ticket_xiangBean>io2main())
                .subscribe(new Observer<Ticket_xiangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ticket_xiangBean ticket_xiangBean) {
                        iModelCallBack.TicketXiangSuccess(ticket_xiangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
