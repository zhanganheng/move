package com.bw.movie.contract;
/*
 *@auther:张安恒
 *@Date: 2019/11/14
 *@Time:8:53
 *@Description:${DESCRIPTION}
 **/
/**
 *@describe(描述)：FindInfoAContract      选座支付
 *@data（日期）: 2019/11/28
 *@time（时间）: 19:19
 *@author（作者）: 张安恒
 **/
import com.bw.library.base.BaseView;
import com.bw.movie.bean.FindInfoBean;
import com.bw.movie.bean.FindWatchTimeBean;
import com.bw.movie.bean.XiadanBean;
import com.bw.movie.bean.ZhifuBean;

public interface FindInfoAContract {
    interface Iview extends BaseView {
        void FindInfoSuccess(FindInfoBean findInfoBean);
        void FindWatchTime(FindWatchTimeBean findWatchTimeBean);
        void XiaDan(XiadanBean xiadanBean);
        void Zhifu(ZhifuBean zhifuBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  findinfo(String hallId, IModelCallBack iModelCallBack);
        void  findwatchtime(String movieId,String cinemaId, IModelCallBack iModelCallBack);
        void  xiadan(String userId,String sessionId,String scheduleId,String seat,String sign,IModelCallBack iModelCallBack);
        void  zhifu(String userId,String sessionId,String payType,String orderId,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void FindInfoSuccess(FindInfoBean findInfoBean);
            void FindWatchTime(FindWatchTimeBean findWatchTimeBean);
            void XiaDan(XiadanBean xiadanBean);
            void Zhifu(ZhifuBean zhifuBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  findinfo(String hallId);
        void  findwatchtime(String movieId,String cinemaId);
        void  xiadan(String userId,String sessionId,String scheduleId,String seat,String sign);
        void  zhifu(String userId,String sessionId,String payType,String orderId);
    }
}
