package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:17:17
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.GuancinemaBean;
import com.bw.movie.bean.Guanzhu_dianyin;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.contract.GuanzhuContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GuanzhuModel implements GuanzhuContract.Imodel {
    @Override
    public void guanzhumovie(String userId, String sessionId,   String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .guanzhumovie(userId,sessionId,page,count)
                .compose(CommonSchedulers.<Guanzhu_dianyin>io2main())
                .subscribe(new Observer<Guanzhu_dianyin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Guanzhu_dianyin guanzhu_dianyin) {
                        iModelCallBack.GuanzhuMovie(guanzhu_dianyin);
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
    public void guanzhucinema(String userId, String sessionId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .guanzhucinema(userId,sessionId,page,count)
                .compose(CommonSchedulers.<GuancinemaBean>io2main())
                .subscribe(new Observer<GuancinemaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuancinemaBean guancinemaBean) {
                            iModelCallBack.GuanzhuCinema(guancinemaBean);
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
    public void quxiaomovie(String userId, String sessionId, String movieId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .quxiaomovie(userId,sessionId,movieId)
                .compose(CommonSchedulers.<QumovieBean>io2main())
                .subscribe(new Observer<QumovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(QumovieBean qumovieBean) {
                        iModelCallBack.Qumovie(qumovieBean);
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
