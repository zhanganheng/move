package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:56
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.TuicinemaBean;
import com.bw.movie.contract.TuicinemaContract;
import com.bw.movie.model.TuicinemaModel;

public class TuicinemaPresenter extends BasePresenter<TuicinemaContract.Iview> implements TuicinemaContract.IPresenter {

    private TuicinemaModel tuicinemaModel;

    @Override
    protected void initModel() {
        tuicinemaModel = new TuicinemaModel();
    }

    @Override
    public void tuicinema(int page, int count) {
            tuicinemaModel.tuicinema(page, count, new TuicinemaContract.Imodel.IModelCallBack() {
                @Override
                public void TuicinemaSuccess(TuicinemaBean tuicinemaBean) {
                    getView().TuicinemaSuccess(tuicinemaBean);
                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }
}
