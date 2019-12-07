package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MyDataBean;
import com.bw.movie.bean.MypicBean;
import com.bw.movie.bean.UpbitthdayBean;
import com.bw.movie.bean.WriterpinBean;

import okhttp3.MultipartBody;

public interface MyDataContract {
    interface Iview extends BaseView {
        void MyData(MyDataBean myDataBean);
        void MyPict(MypicBean mypicBean);
        void Upday(UpbitthdayBean upbitthdayBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  mydata(String userId, String sessionId, IModelCallBack iModelCallBack);
        void  mypict(String userId, String sessionId, MultipartBody.Part image, IModelCallBack iModelCallBack);
        void  upday(String userId, String sessionId, String birthday, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void MyData(MyDataBean myDataBean);
            void MyPict(MypicBean mypicBean);
            void Upday(UpbitthdayBean upbitthdayBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  mydata(String userId, String sessionId);
        void  mypict(String userId, String sessionId, MultipartBody.Part image);
        void  upday(String userId, String sessionId, String birthday);
    }
}
