package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:18:51
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FankuiBean;
import com.bw.movie.contract.FankuiContract;
import com.bw.movie.model.FankuiModel;

public class FankuiPresenter extends BasePresenter<FankuiContract.Iview> implements FankuiContract.IPresenter {

    private FankuiModel fankuiModel;

    @Override
    protected void initModel() {
        fankuiModel = new FankuiModel();
    }

    @Override
    public void fankui(String userId, String sessionId, String content) {
        fankuiModel.fankui(userId, sessionId, content, new FankuiContract.Imodel.IModelCallBack() {
            @Override
            public void Fankui(FankuiBean fankuiBean) {
                getView().Fankui(fankuiBean);
            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }
}
