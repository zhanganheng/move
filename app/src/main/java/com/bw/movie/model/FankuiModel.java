package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:18:48
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FankuiBean;
import com.bw.movie.contract.FankuiContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FankuiModel implements FankuiContract.Imodel {
    @Override
    public void fankui(String userId, String sessionId, String content, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .fankui(userId,sessionId,content)
                .compose(CommonSchedulers.<FankuiBean>io2main())
                .subscribe(new Observer<FankuiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FankuiBean fankuiBean) {
                        iModelCallBack.Fankui(fankuiBean);
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
