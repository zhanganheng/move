package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/22
 *@Time:9:36
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MohuAddressBean;
import com.bw.movie.contract.MohuAddressContract;

public class MohuAddressModel implements MohuAddressContract.Imodel {
    @Override
    public void mohuaddress(String page, String count, String cinemaName, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .mohuaddres(page,count,cinemaName)
                .compose(CommonSchedulers.<MohuAddressBean>io2main())
                .subscribe(new CommonObserver<MohuAddressBean>() {
                    @Override
                    public void onNext(MohuAddressBean mohuAddressBean) {
                            iModelCallBack.mohuaddress(mohuAddressBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                             iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
