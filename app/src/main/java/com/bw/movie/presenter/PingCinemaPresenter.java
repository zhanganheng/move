package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:13:15
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.Ping_cinemaBean;
import com.bw.movie.contract.PingCinemaContract;
import com.bw.movie.model.PingCinemaModel;

public class PingCinemaPresenter extends BasePresenter<PingCinemaContract.Iview> implements PingCinemaContract.IPresenter {

    private PingCinemaModel pingCinemaModel;

    @Override
    protected void initModel() {
        pingCinemaModel = new PingCinemaModel();
    }

    @Override
    public void PingCinemaSuccess(String userId, String sessionId, String cinemaId, String page, String count) {
            pingCinemaModel.PingCinemaSuccess(userId, sessionId, cinemaId, page, count, new PingCinemaContract.Imodel.IModelCallBack() {
                @Override
                public void PingCinemaSuccess(Ping_cinemaBean ping_cinemaBean) {
                    getView().PingCinemaSuccess(ping_cinemaBean);
                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }
}
