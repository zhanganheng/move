package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:11:42
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MyMessageBean;
import com.bw.movie.contract.MyMessageContract;
import com.bw.movie.model.MyMessageModel;

public class MyMessagePresenter extends BasePresenter<MyMessageContract.Iview> implements MyMessageContract.IPresenter {

    private MyMessageModel myMessageModel;

    @Override
    protected void initModel() {
        myMessageModel = new MyMessageModel();
    }

    @Override
    public void mymessage(String userId, String sessionId, String page, String count) {
        myMessageModel.mymessage(userId, sessionId, page, count, new MyMessageContract.Imodel.IModelCallBack() {
            @Override
            public void MyMessageSuccess(MyMessageBean myMessageBean) {
                getView().MyMessageSuccess(myMessageBean);
            }

            @Override
            public void onFraily(String e) {
            getView().onFraily(e);
            }
        });
    }
}
