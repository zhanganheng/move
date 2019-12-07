package com.bw.movie.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:15:25
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BasePresenter;
import com.bw.movie.bean.MyDataBean;
import com.bw.movie.bean.MypicBean;
import com.bw.movie.bean.UpbitthdayBean;
import com.bw.movie.contract.MyDataContract;
import com.bw.movie.model.MyDataModel;

import okhttp3.MultipartBody;

public class MyDataPresenter extends BasePresenter<MyDataContract.Iview> implements MyDataContract.IPresenter {

    private MyDataModel myDataModel;

    @Override
    protected void initModel() {
        myDataModel = new MyDataModel();
    }

    @Override
    public void mydata(String userId, String sessionId) {
            myDataModel.mydata(userId, sessionId, new MyDataContract.Imodel.IModelCallBack() {
                @Override
                public void MyData(MyDataBean myDataBean) {
                    getView().MyData(myDataBean);
                }

                @Override
                public void MyPict(MypicBean mypicBean) {

                }

                @Override
                public void Upday(UpbitthdayBean upbitthdayBean) {

                }

                @Override
                public void onFraily(String e) {
                    getView().onFraily(e);
                }
            });
    }

    @Override
    public void mypict(String userId, String sessionId,  MultipartBody.Part image) {
        myDataModel.mypict(userId, sessionId, image, new MyDataContract.Imodel.IModelCallBack() {
            @Override
            public void MyData(MyDataBean myDataBean) {

            }

            @Override
            public void MyPict(MypicBean mypicBean) {
                getView().MyPict(mypicBean);
            }

            @Override
            public void Upday(UpbitthdayBean upbitthdayBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void upday(String userId, String sessionId, final String birthday) {
        myDataModel.upday(userId, sessionId, birthday, new MyDataContract.Imodel.IModelCallBack() {
            @Override
            public void MyData(MyDataBean myDataBean) {

            }

            @Override
            public void MyPict(MypicBean mypicBean) {

            }

            @Override
            public void Upday(UpbitthdayBean upbitthdayBean) {
                getView().Upday(upbitthdayBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
