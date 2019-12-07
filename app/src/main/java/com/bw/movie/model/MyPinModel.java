package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:13:52
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.contract.MyPinContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyPinModel implements MyPinContract.Imodel {
    @Override
    public void moviepin(String userId, String sessionId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .pinmovie(userId,sessionId,page,count)
                .compose(CommonSchedulers.<MyAPinBean>io2main())
                .subscribe(new Observer<MyAPinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyAPinBean myAPinBean) {
                            iModelCallBack.MoviePinSuccess(myAPinBean);
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
    public void cinemapin(String userId, String sessionId, String longitude, String latitude, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .pinyingyuan(userId,sessionId,longitude,latitude,page,count)
                .compose(CommonSchedulers.<Ping_yingyuanBean>io2main())
                .subscribe(new Observer<Ping_yingyuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ping_yingyuanBean ping_yingyuanBean) {
                        iModelCallBack.CinemaPinSuccess(ping_yingyuanBean);
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
