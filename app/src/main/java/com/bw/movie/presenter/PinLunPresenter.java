package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/18
 *@Time:21:21
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.PinBean;
import com.bw.movie.contract.PinlunContract;
import com.bw.movie.model.PinLunModel;

public class PinLunPresenter extends BasePresenter <PinlunContract.Iview> implements PinlunContract.IPresenter {

    private PinLunModel pinLunModel;

    @Override
    protected void initModel() {
        pinLunModel = new PinLunModel();
    }

    @Override
    public void getpin(String userId,String sessionId,String movieId, String page, String count) {
        pinLunModel.getpin(userId,sessionId,movieId, page, count, new PinlunContract.Imodel.IModelCallBack() {
            @Override
            public void onpinSuccess(PinBean pinBean) {
                getView().onpinSuccess(pinBean);
            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }
}
