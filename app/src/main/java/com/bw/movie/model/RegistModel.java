package com.bw.movie.model;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:21:12
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.utils.CommonObserver;
import com.bw.library.utils.CommonSchedulers;
import com.bw.library.utils.RetrofitManager;
import com.bw.movie.app.IApi;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegistContract;

public class RegistModel implements RegistContract.Imodel {
    @Override
    public void email(String email, final IModelCallBack iModelCallBack) {
            RetrofitManager.getInstance().create(IApi.class)
                    .email(email)
                    .compose(CommonSchedulers.<RegisterBean>io2main())
                    .subscribe(new CommonObserver<RegisterBean>() {
                        @Override
                        public void onNext(RegisterBean registerBean) {
                            iModelCallBack.onemailSuccess(registerBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                        }
                    });
    }

    @Override
    public void regist(String nickName,String email, String pwd, String code, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .regist(nickName,email,pwd,code)
                .compose(CommonSchedulers.<RegisterBean>io2main())
                .subscribe(new CommonObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iModelCallBack.onRegistSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
