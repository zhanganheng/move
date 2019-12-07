package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/19
 *@Time:16:17
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FindCinemaBean;
import com.bw.movie.contract.FindCinemaContract;

public class FindCinemaModel implements FindCinemaContract.Imodel {
    @Override
    public void findcinema(String keyword, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findcinema(keyword,page,count)
                .compose(CommonSchedulers.<FindCinemaBean>io2main())
                .subscribe(new CommonObserver<FindCinemaBean>() {
                    @Override
                    public void onNext(FindCinemaBean findCinemaBean) {
                                iModelCallBack.onFindcinema(findCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
