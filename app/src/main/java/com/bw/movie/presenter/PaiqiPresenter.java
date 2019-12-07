package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:14:26
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.contract.PaiqiContract;
import com.bw.movie.model.PaiqiModel;

public class PaiqiPresenter extends BasePresenter<PaiqiContract.Iview> implements PaiqiContract.IPresenter {

    private PaiqiModel paiqiModel;

    @Override
    protected void initModel() {
        paiqiModel = new PaiqiModel();
    }

    @Override
    public void Paiqi(String cinemaId, String page, String count) {
            paiqiModel.Paiqi(cinemaId, page, count, new PaiqiContract.Imodel.IModelCallBack() {
                @Override
                public void PaiqiSuccess(PaiqiBean paiqiBean) {
                    getView().PaiqiSuccess(paiqiBean);
                }

                @Override
                public void onFindtimeSuccess(FindtimeBean findtimeBean) {

                }

                @Override
                public void onFraily(String e) {
                getView().onFraily(e);
                }
            });
    }

    @Override
    public void findtime() {
        paiqiModel.findtime(new PaiqiContract.Imodel.IModelCallBack() {
            @Override
            public void PaiqiSuccess(PaiqiBean paiqiBean) {

            }

            @Override
            public void onFindtimeSuccess(FindtimeBean findtimeBean) {
                    getView().onFindtimeSuccess(findtimeBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
