package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/18
 *@Time:21:18
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.PinBean;
import com.bw.movie.contract.PinlunContract;

public class PinLunModel implements PinlunContract.Imodel {
    @Override
    public void getpin(String userId,String sessionId,String movieId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .pinlun(userId,sessionId,movieId,page,count)
                .compose(CommonSchedulers.<PinBean>io2main())
                .subscribe(new CommonObserver<PinBean>() {
                    @Override
                    public void onNext(PinBean pinBean) {
                        iModelCallBack.onpinSuccess(pinBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
