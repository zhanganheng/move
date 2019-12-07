package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:14:24
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.contract.PaiqiContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PaiqiModel implements PaiqiContract.Imodel {
    @Override
    public void Paiqi(String cinemaId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .paiqi(cinemaId,page,count)
                .compose(CommonSchedulers.<PaiqiBean>io2main())
                .subscribe(new Observer<PaiqiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PaiqiBean paiqiBean) {
                        iModelCallBack.PaiqiSuccess(paiqiBean);
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
    public void findtime(final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findtime()
                .compose(CommonSchedulers.<FindtimeBean>io2main())
                .subscribe(new Observer<FindtimeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindtimeBean findtimeBean) {
                        iModelCallBack.onFindtimeSuccess(findtimeBean);
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
