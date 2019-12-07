package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:19:55
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FujingBean;
import com.bw.movie.contract.FujingContract;
import com.bw.movie.model.FujingModel;

public class FujingPresenter extends BasePresenter<FujingContract.Iview> implements  FujingContract.IPresenter {

    private FujingModel fujingModel;

    @Override
    protected void initModel() {
        fujingModel = new FujingModel();
    }

    @Override
    public void fujing(int page, int count) {
            fujingModel.fujing(page, count, new FujingContract.Imodel.IModelCallBack() {
                @Override
                public void FujingSuccess(FujingBean fujingBean) {
                    getView().FujingSuccess(fujingBean);
                }

                @Override
                public void onFraily(String e) {
                        getView().onFraily(e);
                }
            });
    }
}
