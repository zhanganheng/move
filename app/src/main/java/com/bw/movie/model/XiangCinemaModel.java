package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/29
 *@Time:21:01
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.XiangCinemaBean;
import com.bw.movie.contract.XiangCinemaContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class XiangCinemaModel implements XiangCinemaContract.Imodel {
    @Override
    public void XiangCinemaSuccess(String userId, String sessionId, String cinemaId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .xiangcinema(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.<XiangCinemaBean>io2main())
                .subscribe(new CommonObserver<XiangCinemaBean>() {
                    @Override
                    public void onNext(XiangCinemaBean xiangCinemaBean) {
                        iModelCallBack.XiangCinemaSuccess(xiangCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void guanzhucinema(String userId, String sessionId, String cinemaId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .guancinema(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.<Guan_movieBean>io2main())
                .subscribe(new Observer<Guan_movieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Guan_movieBean guan_movieBean) {
                            iModelCallBack.Guanzhucinema(guan_movieBean);
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

    @Override
    public void quxiaocinema(String userId, String sessionId, String cinemaId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .quxiaocinema(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.<QucinemaBean>io2main())
                .subscribe(new Observer<QucinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(QucinemaBean qucinemaBean) {
                        iModelCallBack.Qucinema(qucinemaBean);
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
