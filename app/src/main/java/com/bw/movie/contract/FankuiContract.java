package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.FankuiBean;

public interface FankuiContract {
    interface Iview extends BaseView {
        void Fankui(FankuiBean fankuiBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  fankui(String userId, String sessionId, String content, IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void Fankui(FankuiBean fankuiBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  fankui(String userId, String sessionId, String content);
    }
}
