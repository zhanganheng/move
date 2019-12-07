package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MyYuyueBean;
import com.bw.movie.bean.WriterpinBean;
import com.bw.movie.bean.YuyueBean;

public interface MyYuyueContract {
    interface Iview extends BaseView {
        void Myyuyue(MyYuyueBean myYuyueBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  myyuyue(String userId, String sessionId,  IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void Myyuyue(MyYuyueBean myYuyueBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  myyuyue(String userId, String sessionId);
    }
}
