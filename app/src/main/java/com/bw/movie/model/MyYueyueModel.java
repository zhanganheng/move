package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:14:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MyYuyueBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.MyYuyueContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyYueyueModel implements MyYuyueContract.Imodel {
    @Override
    public void myyuyue(String userId, String sessionId,  final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .myyuyue(userId,sessionId)
                .compose(CommonSchedulers.<MyYuyueBean>io2main())
                .subscribe(new Observer<MyYuyueBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyYuyueBean myYuyueBean) {
                        iModelCallBack.Myyuyue(myYuyueBean);
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
