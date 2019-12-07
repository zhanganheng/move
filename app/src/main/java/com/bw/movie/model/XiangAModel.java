package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/15
 *@Time:13:51
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.contract.XiangAContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class XiangAModel implements XiangAContract.Imodel {
    @Override
    public void xiangA(String movieId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .xiangA(movieId)
                .compose(CommonSchedulers.<XiangABean>io2main())
                .subscribe(new CommonObserver<XiangABean>() {
                    @Override
                    public void onNext(XiangABean xiangABean) {
                        iModelCallBack.XiangASuccess(xiangABean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void guansmovie(String userId, String sessionId, String movieId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .guanmovie(userId,sessionId,movieId)
                .compose(CommonSchedulers.<Guan_movieBean>io2main())
                .subscribe(new Observer<Guan_movieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Guan_movieBean guan_movieBean) {
                                iModelCallBack.GuanMovieSuccess(guan_movieBean);
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
}
