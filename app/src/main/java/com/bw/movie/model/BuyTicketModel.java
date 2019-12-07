package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:10:10
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.BuyTicketBean;
import com.bw.movie.contract.BuyTickeyContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BuyTicketModel implements BuyTickeyContract.Imodel {
    @Override
    public void buytickey(String userId, String sessionId, String page, String count, String status, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .buytickey(userId,sessionId,page,count,status)
                .compose(CommonSchedulers.<BuyTicketBean>io2main())
                .subscribe(new Observer<BuyTicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BuyTicketBean buyTicketBean) {
                        iModelCallBack.BuyTicketSuccess(buyTicketBean);
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
