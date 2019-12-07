package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.WriterpinBean;
import com.bw.movie.bean.XiangABean;

public interface WriterPinAContract {
    interface Iview extends BaseView {
        void WriterSuccess(WriterpinBean writerpinBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  writerpin(String userId,String sessionId, String movieId,String commentContent,String score, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void WriterSuccess(WriterpinBean writerpinBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  writerpin(String userId,String sessionId, String movieId,String commentContent,String score);
    }
}
