package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/20
 *@Time:13:58
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.FindAddressBean;
import com.bw.movie.bean.FindquBean;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.contract.FindquyuContract;
import com.bw.movie.model.FindquyuModel;

public class FindquyuPresenter extends BasePresenter<FindquyuContract.Iview> implements FindquyuContract.IPresenter {

    private FindquyuModel findquyuModel;

    @Override
    protected void initModel() {
        findquyuModel = new FindquyuModel();
    }


    @Override
    public void findquyu() {
         findquyuModel.findquyu(new FindquyuContract.Imodel.IModelCallBack() {
             @Override
             public void onFindquSuccess(FindquBean findquBean) {
                  getView().onFindquSuccess(findquBean);
             }

             @Override
             public void onFindtimeSuccess(FindtimeBean findtimeBean) {

             }

             @Override
             public void onFraily(String e) {

             }
         });
    }

    @Override
    public void findtime() {
            findquyuModel.findtime(new FindquyuContract.Imodel.IModelCallBack() {
                @Override
                public void onFindquSuccess(FindquBean findquBean) {

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

    @Override
    public void findaddress(String movieId, String regionId, String page, String count) {
            findquyuModel.findaddress(movieId, regionId, page, count, new FindquyuContract.Imodel.IModelCallBack1() {
                @Override
                public void onFindAddress(FindAddressBean findAddressBean) {
                    getView().onFindAddress(findAddressBean);
                }

                @Override
                public void onFraily(String e) {

                }
            });
    }

    @Override
    public void findtimers(String movieId, String regionId, String page, String count) {
            findquyuModel.findtimer(movieId, regionId, page, count, new FindquyuContract.Imodel.IModelCallBack2() {
                @Override
                public void onFindtimers(FindAddressBean findAddressBean) {
                    getView().onFindAddress(findAddressBean);
                }

                @Override
                public void onFraily(String e) {

                }
            });
    }

    @Override
    public void findmoney(String movieId, String page, String count) {
            findquyuModel.findmoney(movieId, page, count, new FindquyuContract.Imodel.IModelCallBack3() {
                @Override
                public void onFindmoney(FindAddressBean findAddressBean) {
                    getView().onFindAddress(findAddressBean);
                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }
}
