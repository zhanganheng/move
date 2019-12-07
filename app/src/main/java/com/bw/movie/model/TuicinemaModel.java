package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:55
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.TuicinemaBean;
import com.bw.movie.contract.TuicinemaContract;

public class TuicinemaModel implements TuicinemaContract.Imodel {
    @Override
    public void tuicinema(int page, int count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .tuicinema(page,count)
                .compose(CommonSchedulers.<TuicinemaBean>io2main())
                .subscribe(new CommonObserver<TuicinemaBean>() {
                    @Override
                    public void onNext(TuicinemaBean tuicinemaBean) {
                        iModelCallBack.TuicinemaSuccess(tuicinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
