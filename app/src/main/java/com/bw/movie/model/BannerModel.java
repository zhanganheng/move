package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/12
 *@Time:18:40
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.ACimemaBean;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CCinemaBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.BannerContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BannerModel implements BannerContract.Imodel {
    @Override
    public void yuyue(String userId, String sessionId, String movieId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .yuyue(userId,sessionId,movieId)
                .compose(CommonSchedulers.<YuyueBean>io2main())
                .subscribe(new Observer<YuyueBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YuyueBean yuyueBean) {
                                iModelCallBack.YuyueSuccess(yuyueBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void acinema(String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .acinema(page,count)
                .compose(CommonSchedulers.<ACimemaBean>io2main())
                .subscribe(new CommonObserver<ACimemaBean>() {
                    @Override
                    public void onNext(ACimemaBean aCimemaBean) {
                        iModelCallBack.onAcinemaSuccess(aCimemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void bcinema(String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .bcinema(page,count)
                .compose(CommonSchedulers.<BCinemaBean>io2main())
                .subscribe(new CommonObserver<BCinemaBean>() {
                    @Override
                    public void onNext(BCinemaBean bCinemaBean) {
                        iModelCallBack.onBcinemaSuccess(bCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void ccinema(String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .ccinema(page,count)
                .compose(CommonSchedulers.<CCinemaBean>io2main())
                .subscribe(new CommonObserver<CCinemaBean>() {
                    @Override
                    public void onNext(CCinemaBean cCinemaBean) {
                        iModelCallBack.onCcinemaSuccess(cCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }


    @Override
    public void banner(final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .banner()
                .compose(CommonSchedulers.<BannerBean>io2main())
                .subscribe(new CommonObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        iModelCallBack.onBannerSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
