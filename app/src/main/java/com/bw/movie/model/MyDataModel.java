package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:15:22
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.MyDataBean;
import com.bw.movie.bean.MypicBean;
import com.bw.movie.bean.UpbitthdayBean;
import com.bw.movie.contract.MyDataContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

public class MyDataModel implements MyDataContract.Imodel {
    @Override
    public void mydata(String userId, String sessionId, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .mydata(userId,sessionId)
                .compose(CommonSchedulers.<MyDataBean>io2main())
                .subscribe(new Observer<MyDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyDataBean myDataBean) {
                        iModelCallBack.MyData(myDataBean);
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
    public void mypict(String userId, String sessionId, MultipartBody.Part image, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .setpict(userId,sessionId,image)
                .compose(CommonSchedulers.<MypicBean>io2main())
                .subscribe(new Observer<MypicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MypicBean mypicBean) {
                        iModelCallBack.MyPict(mypicBean);
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
    public void upday(String userId, String sessionId, String birthday, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .upday(userId,sessionId,birthday)
                .compose(CommonSchedulers.<UpbitthdayBean>io2main())
                .subscribe(new Observer<UpbitthdayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpbitthdayBean upbitthdayBean) {
                        iModelCallBack.Upday(upbitthdayBean);
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
