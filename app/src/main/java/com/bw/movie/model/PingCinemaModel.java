package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:13:10
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.Ping_cinemaBean;
import com.bw.movie.contract.PingCinemaContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PingCinemaModel implements PingCinemaContract.Imodel {
    @Override
    public void PingCinemaSuccess(String userId, String sessionId, String cinemaId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .pingcinema(userId,sessionId,cinemaId,page,count)
                .compose(CommonSchedulers.<Ping_cinemaBean>io2main())
                .subscribe(new Observer<Ping_cinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ping_cinemaBean ping_cinemaBean) {
                        iModelCallBack.PingCinemaSuccess(ping_cinemaBean);
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
