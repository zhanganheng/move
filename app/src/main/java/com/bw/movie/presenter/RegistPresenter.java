package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:21:13
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.RegistContract;
import com.bw.movie.model.RegistModel;

public class RegistPresenter extends BasePresenter<RegistContract.Iview> implements RegistContract.IPresenter {


    private RegistModel registModel;

    @Override
    protected void initModel() {
        registModel = new RegistModel();
    }

    @Override
    public void email(String email) {
            registModel.email(email, new RegistContract.Imodel.IModelCallBack() {
                @Override
                public void onemailSuccess(RegisterBean registerBean) {
                    getView().onemailSuccess(registerBean);
                }

                @Override
                public void onRegistSuccess(RegisterBean registerBean) {

                }

                @Override
                public void onFraily(String e) {
                getView().onFraily(e);
                }
            });
    }

    @Override
    public void regist(String nickName,String email, String pwd, String code) {
        registModel.regist(nickName,email, pwd, code, new RegistContract.Imodel.IModelCallBack() {
            @Override
            public void onemailSuccess(RegisterBean registerBean) {
                getView().onemailSuccess(registerBean);
            }

            @Override
            public void onRegistSuccess(RegisterBean registerBean) {
                getView().onRegistSuccess(registerBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }


}
