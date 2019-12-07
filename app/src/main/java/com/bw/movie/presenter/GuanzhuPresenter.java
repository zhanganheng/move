package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/2
 *@Time:17:19
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.GuancinemaBean;
import com.bw.movie.bean.Guanzhu_dianyin;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.contract.GuanzhuContract;
import com.bw.movie.model.GuanzhuModel;

public class GuanzhuPresenter extends BasePresenter<GuanzhuContract.Iview> implements GuanzhuContract.IPresenter {

    private GuanzhuModel guanzhuModel;

    @Override
    protected void initModel() {
        guanzhuModel = new GuanzhuModel();
    }

    @Override
    public void guanzhumovie(String userId, String sessionId, String page, String count) {
            guanzhuModel.guanzhumovie(userId, sessionId, page, count, new GuanzhuContract.Imodel.IModelCallBack() {
                @Override
                public void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin) {
                    getView().GuanzhuMovie(guanzhu_dianyin);
                }

                @Override
                public void GuanzhuCinema(GuancinemaBean guancinemaBean) {

                }

                @Override
                public void Qumovie(QumovieBean qumovieBean) {

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
    public void guanzhucinema(String userId, String sessionId, String page, String count) {
        guanzhuModel.guanzhucinema(userId, sessionId, page, count, new GuanzhuContract.Imodel.IModelCallBack() {
            @Override
            public void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin) {

            }

            @Override
            public void GuanzhuCinema(GuancinemaBean guancinemaBean) {
                    getView().GuanzhuCinema(guancinemaBean);
            }

            @Override
            public void Qumovie(QumovieBean qumovieBean) {

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
    public void quxiaomovie(String userId, String sessionId, String movieId) {
        guanzhuModel.quxiaomovie(userId, sessionId, movieId, new GuanzhuContract.Imodel.IModelCallBack() {
            @Override
            public void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin) {

            }

            @Override
            public void GuanzhuCinema(GuancinemaBean guancinemaBean) {

            }

            @Override
            public void Qumovie(QumovieBean qumovieBean) {
                    getView().Qumovie(qumovieBean);
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
    public void quxiaocinema(String userId, String sessionId, String cinemaId) {
            guanzhuModel.quxiaocinema(userId, sessionId, cinemaId, new GuanzhuContract.Imodel.IModelCallBack() {
                @Override
                public void GuanzhuMovie(Guanzhu_dianyin guanzhu_dianyin) {

                }

                @Override
                public void GuanzhuCinema(GuancinemaBean guancinemaBean) {

                }

                @Override
                public void Qumovie(QumovieBean qumovieBean) {

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
