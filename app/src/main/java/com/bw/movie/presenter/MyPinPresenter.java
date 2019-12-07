package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:13:54
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.contract.MyPinContract;
import com.bw.movie.model.MyPinModel;

public class MyPinPresenter extends BasePresenter<MyPinContract.Iview> implements MyPinContract.IPresenter {

    private MyPinModel myPinModel;

    @Override
    protected void initModel() {
        myPinModel = new MyPinModel();
    }

    @Override
    public void moviepin(String userId, String sessionId, String page, String count) {
            myPinModel.moviepin(userId, sessionId, page, count, new MyPinContract.Imodel.IModelCallBack() {
                @Override
                public void MoviePinSuccess(MyAPinBean myAPinBean) {
                    getView().MoviePinSuccess(myAPinBean);
                }

                @Override
                public void CinemaPinSuccess(Ping_yingyuanBean ping_yingyuanBean) {

                }

                @Override
                public void onFraily(String e) {
                    getView().Fraily(e);
                }
            });
    }

    @Override
    public void cinemapin(String userId, String sessionId, String longitude, String latitude, String page, String count) {
        myPinModel.cinemapin(userId, sessionId, longitude, latitude, page, count, new MyPinContract.Imodel.IModelCallBack() {
            @Override
            public void MoviePinSuccess(MyAPinBean myAPinBean) {

            }

            @Override
            public void CinemaPinSuccess(Ping_yingyuanBean ping_yingyuanBean) {
                    getView().CinemaPinSuccess(ping_yingyuanBean);
            }

            @Override
            public void onFraily(String e) {
                getView().Fraily(e);
            }
        });
    }
}
