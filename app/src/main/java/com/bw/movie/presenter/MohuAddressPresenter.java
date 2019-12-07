package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/11/22
 *@Time:9:51
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MohuAddressBean;
import com.bw.movie.contract.MohuAddressContract;
import com.bw.movie.model.MohuAddressModel;

public class MohuAddressPresenter extends BasePresenter<MohuAddressContract.Iview> implements MohuAddressContract.Ipresenter {

    private MohuAddressModel mohuAddressModel;

    @Override
    protected void initModel() {
        mohuAddressModel = new MohuAddressModel();
    }


    @Override
    public void mohuaddre(String page, String count, String cinemaName) {
        mohuAddressModel.mohuaddress(page, count, cinemaName, new MohuAddressContract.Imodel.IModelCallBack() {
            @Override
            public void mohuaddress(MohuAddressBean mohuAddressBean) {
                getView().mohuaddress(mohuAddressBean);
            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }

}




