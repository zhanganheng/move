package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:16:55
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.MohuAddressBean;

public interface MohuAddressContract {
    interface Iview extends BaseView{
        void  mohuaddress(MohuAddressBean mohuAddressBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  mohuaddress(String page,String count, String cinemaName,IModelCallBack iModelCallBack);
         interface  IModelCallBack{
             void  mohuaddress(MohuAddressBean mohuAddressBean);
             void onFraily(String e);
         }
    }
    interface  Ipresenter{
        void  mohuaddre(String page,String count, String cinemaName);
    }
}
