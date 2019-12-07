package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:19:05
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.WriterpinBean;
import com.bw.movie.contract.WriterPinAContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WriterPinModel implements WriterPinAContract.Imodel {
    @Override
    public void writerpin(String userId, String sessionId, String movieId, String commentContent, String score, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .writerpin(userId,sessionId,movieId,commentContent,score)
                .compose(CommonSchedulers.<WriterpinBean>io2main())
                .subscribe(new Observer<WriterpinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WriterpinBean writerpinBean) {
                            iModelCallBack.WriterSuccess(writerpinBean);
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
