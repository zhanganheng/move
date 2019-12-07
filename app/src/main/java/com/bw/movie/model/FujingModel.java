package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:19:54
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FujingBean;
import com.bw.movie.contract.FujingContract;

public class FujingModel implements FujingContract.Imodel {
    @Override
    public void fujing(int page, int count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .fujing(page,count)
                .compose(CommonSchedulers.<FujingBean>io2main())
                .subscribe(new CommonObserver<FujingBean>() {
                    @Override
                    public void onNext(FujingBean fujingBean) {
                        iModelCallBack.FujingSuccess(fujingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
