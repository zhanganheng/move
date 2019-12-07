package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/13
 *@Time:17:00
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.FindChildBean;
import com.bw.movie.bean.FindRegionBean;

public interface FindRegionContract {
    interface Iview extends BaseView {
        void  onFindRegionSuccess(FindRegionBean findRegionBean);
        void  onFindChildSuccess(FindChildBean findChildBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  findregion(IModelCallBack iModelCallBack);
        void  findchild(String regionId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void  onFindRegionSuccess(FindRegionBean findRegionBean);
            void  onFindChildSuccess(FindChildBean findChildBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  findregion();
        void  findchild(String regionId);
    }
}
