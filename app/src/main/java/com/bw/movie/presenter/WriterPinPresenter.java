package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:19:08
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.WriterpinBean;
import com.bw.movie.contract.WriterPinAContract;
import com.bw.movie.model.WriterPinModel;

public class WriterPinPresenter extends BasePresenter<WriterPinAContract.Iview> implements WriterPinAContract.IPresenter {

    private WriterPinModel writerPinModel;

    @Override
    protected void initModel() {
        writerPinModel = new WriterPinModel();
    }

    @Override
    public void writerpin(String userId, String sessionId, String movieId, String commentContent, String score) {
            writerPinModel.writerpin(userId, sessionId, movieId, commentContent, score, new WriterPinAContract.Imodel.IModelCallBack() {
                @Override
                public void WriterSuccess(WriterpinBean writerpinBean) {
                    getView().WriterSuccess(writerpinBean);
                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }
}
