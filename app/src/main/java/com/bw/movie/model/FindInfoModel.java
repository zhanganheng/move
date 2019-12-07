package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/21
 *@Time:9:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FindInfoBean;
import com.bw.movie.bean.FindWatchTimeBean;
import com.bw.movie.bean.XiadanBean;
import com.bw.movie.bean.ZhifuBean;
import com.bw.movie.contract.FindInfoAContract;

public class FindInfoModel implements FindInfoAContract.Imodel {
    @Override
    public void findinfo(String hallId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findinfo(hallId)
                .compose(CommonSchedulers.<FindInfoBean>io2main())
                .subscribe(new CommonObserver<FindInfoBean>() {
                    @Override
                    public void onNext(FindInfoBean findInfoBean) {
                        iModelCallBack.FindInfoSuccess(findInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void findwatchtime(String movieId, String cinemaId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findwatchtime(movieId,cinemaId)
                .compose(CommonSchedulers.<FindWatchTimeBean>io2main())
                .subscribe(new CommonObserver<FindWatchTimeBean>() {
                    @Override
                    public void onNext(FindWatchTimeBean findWatchTimeBean) {
                        iModelCallBack.FindWatchTime(findWatchTimeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void xiadan(String userId, String sessionId, String scheduleId, String seat, String sign, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .xiadan(userId,sessionId,scheduleId,seat,sign)
                .compose(CommonSchedulers.<XiadanBean>io2main())
                .subscribe(new CommonObserver<XiadanBean>() {
                    @Override
                    public void onNext(XiadanBean xiadanBean) {
                        iModelCallBack.XiaDan(xiadanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void zhifu(String userId, String sessionId, String payType, String orderId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .zhifu(userId,sessionId,payType,orderId)
                .compose(CommonSchedulers.<ZhifuBean>io2main())
                .subscribe(new CommonObserver<ZhifuBean>() {
                    @Override
                    public void onNext(ZhifuBean zhifuBean) {
                        iModelCallBack.Zhifu(zhifuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });

    }
}
