package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/13
 *@Time:17:04
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FindChildBean;
import com.bw.movie.bean.FindRegionBean;
import com.bw.movie.contract.FindRegionContract;
import com.bw.movie.model.FindRegionModel;

public class FindRegionPresenter extends BasePresenter<FindRegionContract.Iview> implements FindRegionContract.IPresenter {

    private FindRegionModel findRegionModel;

    @Override
    protected void initModel() {
        findRegionModel = new FindRegionModel();
    }

    @Override
    public void findregion() {
            findRegionModel.findregion(new FindRegionContract.Imodel.IModelCallBack() {
                @Override
                public void onFindRegionSuccess(FindRegionBean findRegionBean) {
                    getView().onFindRegionSuccess(findRegionBean);
                }

                @Override
                public void onFindChildSuccess(FindChildBean findChildBean) {

                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }

    @Override
    public void findchild(String regionId) {
            findRegionModel.findchild(regionId, new FindRegionContract.Imodel.IModelCallBack() {
                @Override
                public void onFindRegionSuccess(FindRegionBean findRegionBean) {

                }

                @Override
                public void onFindChildSuccess(FindChildBean findChildBean) {
                    getView().onFindChildSuccess(findChildBean);
                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }
}
