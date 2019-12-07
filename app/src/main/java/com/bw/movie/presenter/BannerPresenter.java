package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/12
 *@Time:18:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.ACimemaBean;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CCinemaBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.BannerContract;
import com.bw.movie.model.BannerModel;

public class BannerPresenter extends BasePresenter<BannerContract.Iview> implements BannerContract.IPresenter  {

    private BannerModel bannerModel;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
    }


    @Override
    public void yuyue(String userId, String sessionId, String movieId) {
        bannerModel.yuyue(userId, sessionId, movieId, new BannerContract.Imodel.IModelCallBack() {
            @Override
            public void YuyueSuccess(YuyueBean yuyueBean) {
                getView().YuyueSuccess(yuyueBean);
            }

            @Override
            public void onAcinemaSuccess(ACimemaBean aCimemaBean) {

            }

            @Override
            public void onBcinemaSuccess(BCinemaBean bCinemaBean) {

            }

            @Override
            public void onCcinemaSuccess(CCinemaBean cCinemaBean) {

            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void getacinema(String page,String count) {
        bannerModel.acinema(page, count, new BannerContract.Imodel.IModelCallBack() {
            @Override
            public void YuyueSuccess(YuyueBean yuyueBean) {

            }

            @Override
            public void onAcinemaSuccess(ACimemaBean aCimemaBean) {
                getView().onAcinemaSuccess(aCimemaBean);
            }

            @Override
            public void onBcinemaSuccess(BCinemaBean bCinemaBean) {

            }

            @Override
            public void onCcinemaSuccess(CCinemaBean cCinemaBean) {

            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }

    @Override
    public void getbcinema(String page, String count) {
            bannerModel.bcinema(page, count, new BannerContract.Imodel.IModelCallBack() {
                @Override
                public void YuyueSuccess(YuyueBean yuyueBean) {

                }

                @Override
                public void onAcinemaSuccess(ACimemaBean aCimemaBean) {

                }

                @Override
                public void onBcinemaSuccess(BCinemaBean bCinemaBean) {
                    getView().onBcinemaSuccess(bCinemaBean);
                }

                @Override
                public void onCcinemaSuccess(CCinemaBean cCinemaBean) {

                }

                @Override
                public void onBannerSuccess(BannerBean bannerBean) {

                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }

    @Override
    public void getccinema(String page, String count) {
        bannerModel.ccinema(page, count, new BannerContract.Imodel.IModelCallBack() {
            @Override
            public void YuyueSuccess(YuyueBean yuyueBean) {

            }

            @Override
            public void onAcinemaSuccess(ACimemaBean aCimemaBean) {

            }

            @Override
            public void onBcinemaSuccess(BCinemaBean bCinemaBean) {

            }

            @Override
            public void onCcinemaSuccess(CCinemaBean cCinemaBean) {
                getView().onCcinemaSuccess(cCinemaBean);
            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {

            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }

    @Override
    public void getbanner() {
        bannerModel.banner(new BannerContract.Imodel.IModelCallBack() {
            @Override
            public void YuyueSuccess(YuyueBean yuyueBean) {

            }

            @Override
            public void onAcinemaSuccess(ACimemaBean aCimemaBean) {

            }

            @Override
            public void onBcinemaSuccess(BCinemaBean bCinemaBean) {

            }

            @Override
            public void onCcinemaSuccess(CCinemaBean cCinemaBean) {

            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }
}
