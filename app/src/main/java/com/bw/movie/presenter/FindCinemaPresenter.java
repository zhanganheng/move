package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/19
 *@Time:16:26
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FindCinemaBean;
import com.bw.movie.contract.FindCinemaContract;
import com.bw.movie.model.FindCinemaModel;

public class FindCinemaPresenter extends BasePresenter<FindCinemaContract.Iview> implements FindCinemaContract.IPresenter {

    private FindCinemaModel findCinemaModel;

    @Override
    protected void initModel() {
        findCinemaModel = new FindCinemaModel();
    }

    @Override
    public void findcinema(String keyword, String page, String count) {
            findCinemaModel.findcinema(keyword, page, count, new FindCinemaContract.Imodel.IModelCallBack() {
                @Override
                public void onFindcinema(FindCinemaBean findCinemaBean) {
                    getView().onFindcinema(findCinemaBean);
                }

                @Override
                public void onFraily(String e) {
                getView().onFraily(e);
                }
            });
    }
}
