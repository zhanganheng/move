package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:20:20
 *@Description:${DESCRIPTION}
 **/

import android.util.Log;

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MyTicketBean;
import com.bw.movie.bean.MyerweimaBean;
import com.bw.movie.contract.MyTicketContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyTicketModel implements MyTicketContract.Imodel {
    @Override
    public void myticket(String userId, String sessionId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .myticket(userId,sessionId)
                .compose(CommonSchedulers.<MyTicketBean>io2main())
                .subscribe(new Observer<MyTicketBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyTicketBean ticketBean) {
                        iModelCallBack.myticket(ticketBean);
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

    @Override
    public void erweima(String userId, String sessionId, String recordId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .erweima(userId,sessionId,recordId)
                .compose(CommonSchedulers.<MyerweimaBean>io2main())
                .subscribe(new Observer<MyerweimaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyerweimaBean myerweimaBean) {
                        iModelCallBack.Erweima(myerweimaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
