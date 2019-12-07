package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:16:59
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MyWatchBean;
import com.bw.movie.contract.MyWatchContract;
import com.bw.movie.model.My_watchModel;

public class MyWatchPresenter extends BasePresenter<MyWatchContract.Iview> implements MyWatchContract.IPresenter {

    private My_watchModel my_watchModel;

    @Override
    protected void initModel() {
        my_watchModel = new My_watchModel();
    }

    @Override
    public void mywatch(String userId, String sessionId) {
            my_watchModel.mywatch(userId, sessionId, new MyWatchContract.Imodel.IModelCallBack() {
                @Override
                public void Watchmovie(MyWatchBean myWatchBean) {
                    getView().Watchmovie(myWatchBean);
                }

                @Override
                public void onFraily(String e) {

                }
            });
    }
}
