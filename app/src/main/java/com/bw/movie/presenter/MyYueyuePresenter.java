package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:14:43
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MyYuyueBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.contract.MyYuyueContract;
import com.bw.movie.model.MyYueyueModel;

public class MyYueyuePresenter extends BasePresenter<MyYuyueContract.Iview> implements MyYuyueContract.IPresenter {

    private MyYueyueModel myYueyueModel;

    @Override
    protected void initModel() {
        myYueyueModel = new MyYueyueModel();
    }

    @Override
    public void myyuyue(String userId, String sessionId) {
            myYueyueModel.myyuyue(userId, sessionId, new MyYuyueContract.Imodel.IModelCallBack() {
                @Override
                public void Myyuyue(MyYuyueBean myYuyueBean) {
                    getView().Myyuyue(myYuyueBean);
                }

                @Override
                public void onFraily(String e) {
                        getView().onFraily(e);
                }
            });
    }

}
