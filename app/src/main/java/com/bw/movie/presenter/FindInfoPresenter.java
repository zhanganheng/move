package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/21
 *@Time:9:42
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FindInfoBean;
import com.bw.movie.bean.FindWatchTimeBean;
import com.bw.movie.bean.XiadanBean;
import com.bw.movie.bean.ZhifuBean;
import com.bw.movie.contract.FindInfoAContract;
import com.bw.movie.model.FindInfoModel;

public class FindInfoPresenter extends BasePresenter<FindInfoAContract.Iview> implements FindInfoAContract.IPresenter {

    private FindInfoModel findInfoModel;

    @Override
    protected void initModel() {
        findInfoModel = new FindInfoModel();
    }

    @Override
    public void findinfo(String hallId) {
            findInfoModel.findinfo(hallId, new FindInfoAContract.Imodel.IModelCallBack() {
                @Override
                public void FindInfoSuccess(FindInfoBean findInfoBean) {
                    getView().FindInfoSuccess(findInfoBean);
                }

                @Override
                public void FindWatchTime(FindWatchTimeBean findWatchTimeBean) {

                }

                @Override
                public void XiaDan(XiadanBean xiadanBean) {

                }

                @Override
                public void Zhifu(ZhifuBean zhifuBean) {

                }

                @Override
                public void onFraily(String e) {
                getView().onFraily(e);
                }
            });
    }

    @Override
    public void findwatchtime(String movieId, String cinemaId) {
        findInfoModel.findwatchtime(movieId, cinemaId, new FindInfoAContract.Imodel.IModelCallBack() {
            @Override
            public void FindInfoSuccess(FindInfoBean findInfoBean) {

            }

            @Override
            public void FindWatchTime(FindWatchTimeBean findWatchTimeBean) {
                    getView().FindWatchTime(findWatchTimeBean);
            }

            @Override
            public void XiaDan(XiadanBean xiadanBean) {

            }

            @Override
            public void Zhifu(ZhifuBean zhifuBean) {

            }

            @Override
            public void onFraily(String e) {
                    getView().onFraily(e);
            }
        });
    }

    @Override
    public void xiadan(String userId, String sessionId, String scheduleId, String seat, String sign) {
        findInfoModel.xiadan(userId, sessionId, scheduleId, seat, sign, new FindInfoAContract.Imodel.IModelCallBack() {
            @Override
            public void FindInfoSuccess(FindInfoBean findInfoBean) {

            }

            @Override
            public void FindWatchTime(FindWatchTimeBean findWatchTimeBean) {

            }

            @Override
            public void XiaDan(XiadanBean xiadanBean) {
                    getView().XiaDan(xiadanBean);
            }

            @Override
            public void Zhifu(ZhifuBean zhifuBean) {

            }

            @Override
            public void onFraily(String e) {
                    getView().onFraily(e);
            }
        });
    }

    @Override
    public void zhifu(String userId, String sessionId, String payType, String orderId) {
        findInfoModel.zhifu(userId, sessionId, payType, orderId, new FindInfoAContract.Imodel.IModelCallBack() {
            @Override
            public void FindInfoSuccess(FindInfoBean findInfoBean) {

            }

            @Override
            public void FindWatchTime(FindWatchTimeBean findWatchTimeBean) {

            }

            @Override
            public void XiaDan(XiadanBean xiadanBean) {

            }

            @Override
            public void Zhifu(ZhifuBean zhifuBean) {
                    getView().Zhifu(zhifuBean);
            }

            @Override
            public void onFraily(String e) {
                    getView().onFraily(e);
            }
        });
    }
}
