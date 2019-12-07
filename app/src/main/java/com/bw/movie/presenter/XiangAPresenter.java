package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/15
 *@Time:13:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.contract.XiangAContract;
import com.bw.movie.model.XiangAModel;

public class XiangAPresenter extends BasePresenter<XiangAContract.Iview> implements XiangAContract.IPresenter {

    private XiangAModel xiangAModel;

    @Override
    protected void initModel() {
        xiangAModel = new XiangAModel();
    }

    @Override
    public void xiangA(String movieId) {
            xiangAModel.xiangA(movieId, new XiangAContract.Imodel.IModelCallBack() {
                @Override
                public void XiangASuccess(XiangABean xiangABean) {
                    getView().XiangASuccess(xiangABean);
                }

                @Override
                public void GuanMovieSuccess(Guan_movieBean guan_movieBean) {

                }

                @Override
                public void Qumovie(QumovieBean qumovieBean) {

                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }

    @Override
    public void guansmovie(String userId, String sessionId, String movieId) {
        xiangAModel.guansmovie(userId, sessionId, movieId, new XiangAContract.Imodel.IModelCallBack() {
            @Override
            public void XiangASuccess(XiangABean xiangABean) {

            }

            @Override
            public void GuanMovieSuccess(Guan_movieBean guan_movieBean) {
                        getView().GuanMovieSuccess(guan_movieBean);
            }

            @Override
            public void Qumovie(QumovieBean qumovieBean) {

            }

            @Override
            public void onFraily(String e) {
                    getView().onFraily(e);
            }
        });
    }

    @Override
    public void quxiaomovie(String userId, String sessionId, String movieId) {
        xiangAModel.quxiaomovie(userId, sessionId, movieId, new XiangAContract.Imodel.IModelCallBack() {
            @Override
            public void XiangASuccess(XiangABean xiangABean) {

            }

            @Override
            public void GuanMovieSuccess(Guan_movieBean guan_movieBean) {

            }

            @Override
            public void Qumovie(QumovieBean qumovieBean) {
                    getView().Qumovie(qumovieBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
