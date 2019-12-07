package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/20
 *@Time:13:55
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FindAddressBean;
import com.bw.movie.bean.FindquBean;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.contract.FindquyuContract;

public class FindquyuModel implements FindquyuContract.Imodel {
    @Override
    public void findquyu(final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .quyu()
                .compose(CommonSchedulers.<FindquBean>io2main())
                .subscribe(new CommonObserver<FindquBean>() {
                    @Override
                    public void onNext(FindquBean findquBean) {
                            iModelCallBack.onFindquSuccess(findquBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void findtime(final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findtime()
                .compose(CommonSchedulers.<FindtimeBean>io2main())
                .subscribe(new CommonObserver<FindtimeBean>() {
                    @Override
                    public void onNext(FindtimeBean findtimeBean) {
                        iModelCallBack.onFindtimeSuccess(findtimeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });


    }

    @Override
    public void findaddress(String movieId, String regionId, String page, String count, final FindquyuContract.Imodel.IModelCallBack1 iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findaddress(movieId,regionId,page,count)
                .compose(CommonSchedulers.<FindAddressBean>io2main())
                .subscribe(new CommonObserver<FindAddressBean>() {
                    @Override
                    public void onNext(FindAddressBean findAddressBean) {
                    iModelCallBack.onFindAddress(findAddressBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void findtimer(String movieId, String date, String page, String count, final IModelCallBack2 iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findtimeer(movieId,date,page,count)
                .compose(CommonSchedulers.<FindAddressBean>io2main())
                .subscribe(new CommonObserver<FindAddressBean>() {
                    @Override
                    public void onNext(FindAddressBean findAddressBean) {
                        iModelCallBack.onFindtimers(findAddressBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }


    @Override
    public void findmoney(String movieId, String page, String count, final IModelCallBack3 iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findmoney(movieId,page,count)
                .compose(CommonSchedulers.<FindAddressBean>io2main())
                .subscribe(new CommonObserver<FindAddressBean>() {
                    @Override
                    public void onNext(FindAddressBean findAddressBean) {
                        iModelCallBack.onFindmoney(findAddressBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
