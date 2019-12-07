package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:16:58
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MyWatchBean;
import com.bw.movie.contract.MyWatchContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class My_watchModel implements MyWatchContract.Imodel {
    @Override
    public void mywatch(String userId, String sessionId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .mywatch(userId,sessionId)
                .compose(CommonSchedulers.<MyWatchBean>io2main())
                .subscribe(new Observer<MyWatchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyWatchBean myWatchBean) {
                        iModelCallBack.Watchmovie(myWatchBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
