package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/29
 *@Time:21:04
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.XiangCinemaBean;
import com.bw.movie.contract.XiangCinemaContract;
import com.bw.movie.model.XiangCinemaModel;

public class XiangCinemaPresenter extends BasePresenter<XiangCinemaContract.Iview> implements XiangCinemaContract.IPresenter {

    private XiangCinemaModel xiangCinemaModel;

    @Override
    protected void initModel() {
        xiangCinemaModel = new XiangCinemaModel();
    }

    @Override
    public void XiangCinemaSuccess(String userId, String sessionId, String cinemaId) {
            xiangCinemaModel.XiangCinemaSuccess(userId, sessionId, cinemaId, new XiangCinemaContract.Imodel.IModelCallBack() {
                @Override
                public void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean) {
                    getView().XiangCinemaSuccess(xiangCinemaBean);
                }

                @Override
                public void Guanzhucinema(Guan_movieBean guan_movieBean) {

                }

                @Override
                public void Qucinema(QucinemaBean qucinemaBean) {

                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }

    @Override
    public void guanzhucinema(String userId, String sessionId, String cinemaId) {
        xiangCinemaModel.guanzhucinema(userId, sessionId, cinemaId, new XiangCinemaContract.Imodel.IModelCallBack() {
            @Override
            public void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean) {

            }

            @Override
            public void Guanzhucinema(Guan_movieBean guan_movieBean) {
                getView().Guanzhucinema(guan_movieBean);
            }

            @Override
            public void Qucinema(QucinemaBean qucinemaBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void quxiaocinema(String userId, String sessionId, String cinemaId) {
        xiangCinemaModel.quxiaocinema(userId, sessionId, cinemaId, new XiangCinemaContract.Imodel.IModelCallBack() {
            @Override
            public void XiangCinemaSuccess(XiangCinemaBean xiangCinemaBean) {

            }

            @Override
            public void Guanzhucinema(Guan_movieBean guan_movieBean) {

            }

            @Override
            public void Qucinema(QucinemaBean qucinemaBean) {
                    getView().Qucinema(qucinemaBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
