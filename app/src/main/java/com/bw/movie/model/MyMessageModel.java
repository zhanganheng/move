package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:11:40
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MyMessageBean;
import com.bw.movie.contract.MyMessageContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyMessageModel implements MyMessageContract.Imodel {
    @Override
    public void mymessage(String userId, String sessionId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .mymessage(userId,sessionId,page,count)
                .compose(CommonSchedulers.<MyMessageBean>io2main())
                .subscribe(new Observer<MyMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyMessageBean myMessageBean) {
                            iModelCallBack.MyMessageSuccess(myMessageBean);
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
