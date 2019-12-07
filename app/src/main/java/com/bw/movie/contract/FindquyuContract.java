package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/20
 *@Time:13:54
 *@Description:${DESCRIPTION}
 **/

import com.bw.library.base.BaseView;
import com.bw.movie.bean.FindAddressBean;
import com.bw.movie.bean.FindquBean;
import com.bw.movie.bean.FindtimeBean;

public interface FindquyuContract {
    interface Iview extends BaseView {
        void onFindquSuccess(FindquBean findquBean);
        void onFindtimeSuccess(FindtimeBean findtimeBean);
        void  onFindAddress(FindAddressBean findAddressBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  findquyu(IModelCallBack iModelCallBack);
        void  findtime(IModelCallBack iModelCallBack);
        void  findaddress(String movieId, String regionId,String page, String count, FindquyuContract.Imodel.IModelCallBack1 iModelCallBack);
        void  findtimer(String movieId, String date,String page, String count, FindquyuContract.Imodel.IModelCallBack2 iModelCallBack);
        void  findmoney(String movieId, String page, String count, FindquyuContract.Imodel.IModelCallBack3 iModelCallBack);
        interface IModelCallBack {
            void onFindquSuccess(FindquBean findquBean);
            void onFindtimeSuccess(FindtimeBean findtimeBean);
            void onFraily(String e);
        }
        interface  IModelCallBack1{
            void  onFindAddress(FindAddressBean findAddressBean);
            void onFraily(String e);
        }
        interface  IModelCallBack2{
            void  onFindtimers(FindAddressBean findAddressBean);
            void onFraily(String e);
        }
        interface  IModelCallBack3{
            void  onFindmoney(FindAddressBean findAddressBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  findquyu();
        void  findtime();
        void   findaddress(String movieId, String regionId,String page, String count);
        void   findtimers(String movieId,  String date,String page, String count);
        void   findmoney(String movieId, String page, String count);
    }
}
