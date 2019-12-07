package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/13
 *@Time:17:02
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FindChildBean;
import com.bw.movie.bean.FindRegionBean;
import com.bw.movie.contract.FindRegionContract;

public class FindRegionModel implements FindRegionContract.Imodel {
    @Override
    public void findregion(final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findregion()
                .compose(CommonSchedulers.<FindRegionBean>io2main())
                .subscribe(new CommonObserver<FindRegionBean>() {
                    @Override
                    public void onNext(FindRegionBean findRegionBean) {
                        iModelCallBack.onFindRegionSuccess(findRegionBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void findchild(String regionId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findchild(regionId)
                .compose(CommonSchedulers.<FindChildBean>io2main())
                .subscribe(new CommonObserver<FindChildBean>() {
                    @Override
                    public void onNext(FindChildBean findChildBean) {
                        iModelCallBack.onFindChildSuccess(findChildBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
