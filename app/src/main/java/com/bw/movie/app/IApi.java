package com.bw.movie.app;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:16:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.bean.ACimemaBean;
import com.bw.movie.bean.BCinemaBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.BuyTicketBean;
import com.bw.movie.bean.CCinemaBean;
import com.bw.movie.bean.FankuiBean;
import com.bw.movie.bean.FindAddressBean;
import com.bw.movie.bean.FindChildBean;
import com.bw.movie.bean.FindCinemaBean;
import com.bw.movie.bean.FindInfoBean;
import com.bw.movie.bean.FindRegionBean;
import com.bw.movie.bean.FindWatchTimeBean;
import com.bw.movie.bean.FindquBean;
import com.bw.movie.bean.FindtimeBean;
import com.bw.movie.bean.FujingBean;
import com.bw.movie.bean.Guan_movieBean;
import com.bw.movie.bean.GuancinemaBean;
import com.bw.movie.bean.Guanzhu_dianyin;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MohuAddressBean;
import com.bw.movie.bean.MyAPinBean;
import com.bw.movie.bean.MyDataBean;
import com.bw.movie.bean.MyMessageBean;
import com.bw.movie.bean.MyTicketBean;
import com.bw.movie.bean.MyWatchBean;
import com.bw.movie.bean.MyYuyueBean;
import com.bw.movie.bean.MyerweimaBean;
import com.bw.movie.bean.MypicBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.bean.PinBean;
import com.bw.movie.bean.Ping_cinemaBean;
import com.bw.movie.bean.Ping_yingyuanBean;
import com.bw.movie.bean.QucinemaBean;
import com.bw.movie.bean.QumovieBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.Ticket_xiangBean;
import com.bw.movie.bean.TuicinemaBean;
import com.bw.movie.bean.UpbitthdayBean;
import com.bw.movie.bean.WXLoginBean;
import com.bw.movie.bean.WriterpinBean;
import com.bw.movie.bean.XiadanBean;
import com.bw.movie.bean.XiangABean;
import com.bw.movie.bean.XiangCinemaBean;
import com.bw.movie.bean.YuyueBean;
import com.bw.movie.bean.ZhifuBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface IApi {
    //http://172.17.8.100/movieApi/user/v2/login
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> login(@Field("email") String email, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<RegisterBean> regist(@Field("nickName") String nickName, @Field("email") String email, @Field("pwd") String pwd, @Field("code") String code);

    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<RegisterBean> email(@Field("email") String email);

    //banner http://172.17.8.100/movieApi/tool/v2/banner

    @GET("tool/v2/banner")
    Observable<BannerBean> banner();

    //http://172.17.8.100/movieApi/movie/v2/findHotMovieList
    @GET("movie/v2/findHotMovieList")
    Observable<ACimemaBean> acinema(@Query("page") String page, @Query("count") String count);

    //http://172.17.8.100/movieApi/movie/v2/findReleaseMovieList
    @GET("movie/v2/findReleaseMovieList")
    Observable<BCinemaBean> bcinema(@Query("page") String page, @Query("count") String count);

    //http://172.17.8.100/movieApi/movie/v2/findComingSoonMovieList
    @GET("movie/v2/findReleaseMovieList")
    Observable<CCinemaBean> ccinema(@Query("page") String page, @Query("count") String count);

    //http://172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("tool/v2/findRegionList")
    Observable<FindRegionBean> findregion();

    //http://172.17.8.100/movieApi/cinema/v2/findCinemaByRegion
    @GET("cinema/v2/findCinemaByRegion")
    Observable<FindChildBean> findchild(@Query("regionId") String regionId);

    public static final String BASE_URL = "http://172.17.8.100/";

    @Streaming
    @GET
    Observable<ResponseBody> executeDownload(@Header("Range") String range, @Url() String url);

    //查询推荐影院
    //http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuicinemaBean> tuicinema(@Query("page") int page, @Query("count") int count);

    //附近影院
    //http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas
    @GET("cinema/v1/findNearbyCinemas")
    Observable<FujingBean> fujing(@Query("page") int page, @Query("count") int count);

    //电影详情
    //http://172.17.8.100/movieApi/movie/v2/findMoviesDetail
    @GET("movie/v2/findMoviesDetail")
    Observable<XiangABean> xiangA(@Query("movieId") String movieId);

    //评论http://172.17.8.100/movieApi/movie/v2/findAllMovieComment
    @GET("movie/v2/findAllMovieComment")
    Observable<PinBean> pinlun(@Header("userId")String userId,@Header("sessionId")String sessionId,@Query("movieId") String movieId, @Query("page") String page, @Query("count") String count);

    //首页查询电影//http://172.17.8.100/movieApi/movie/v2/findMovieByKeyword
    @GET("movie/v2/findMovieByKeyword")
    Observable<FindCinemaBean> findcinema(@Query("keyword") String keyword, @Query("page") String page, @Query("count") String count);

    //查询区域列表http://172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("tool/v2/findRegionList")
    Observable<FindquBean> quyu();

    //排期时间http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("tool/v2/findDateList")
    Observable<FindtimeBean> findtime();

    //根据电影id区域id查看影院信息http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByRegion
    @GET("movie/v2/findCinemasInfoByRegion")
    Observable<FindAddressBean> findaddress(@Query("movieId") String movieId, @Query("regionId") String regionId, @Query("page") String page, @Query("count") String count);

    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByDate
    @GET("movie/v2/findCinemasInfoByDate")
    Observable<FindAddressBean> findtimeer(@Query("movieId") String movieId, @Query("date") String date, @Query("page") String page, @Query("count") String count);

    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByPrice
    @GET("movie/v2/findCinemasInfoByPrice")
    Observable<FindAddressBean> findmoney(@Query("movieId") String movieId, @Query("page") String page, @Query("count") String count);

    //根据影厅id 查询座位信息http://172.17.8.100/movieApi/movie/v2/findSeatInfo
    @GET("movie/v2/findSeatInfo")
    Observable<FindInfoBean> findinfo(@Query("hallId") String hallId);

    //根据影厅id 查询座位信息http://172.17.8.100/movieApi/movie/v2/findSeatInfo
    @GET("movie/v2/findMovieSchedule")
    Observable<FindWatchTimeBean> findwatchtime(@Query("movieId") String movieId, @Query("cinemaId") String cinemaId);
    //模糊查询电影院http://172.17.8.100/movieApi/cinema/v1/findAllCinemas
    @GET("cinema/v1/findAllCinemas")
    Observable<MohuAddressBean> mohuaddres(@Query("page") String page, @Query("count") String count, @Query("cinemaName") String cinemaName);
    //购票下单http://172.17.8.100/movieApi/movie/v2/verify/buyMovieTickets
    @FormUrlEncoded
    @POST("movie/v2/verify/buyMovieTickets")
    Observable<XiadanBean> xiadan(@Header("userId")String userId,@Header("sessionId")String sessionId,@Field("scheduleId") String scheduleId,@Field("seat")String seat,@Field("sign")String sign);

    //支付http://172.17.8.100/movieApi/movie/v2/verify/pay
    @FormUrlEncoded
    @POST("movie/v2/verify/pay")
    Observable<ZhifuBean> zhifu(@Header("userId")String userId,@Header("sessionId")String sessionId,@Field("payType") String payType,@Field("orderId")String orderId);

    //影院详情http://172.17.8.100/movieApi/cinema/v1/findCinemaInfo
    @GET("cinema/v1/findCinemaInfo")
    Observable<XiangCinemaBean> xiangcinema(@Header("userId")String userId,@Header("sessionId")String sessionId, @Query("cinemaId") String cinemaId);

    //查询影院用户评论列表http://172.17.8.100/movieApi/cinema/v1/findAllCinemaComment
    @GET("cinema/v1/findAllCinemaComment")
    Observable<Ping_cinemaBean> pingcinema(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("cinemaId") String cinemaId,@Query("page") String page,@Query("count") String count);
    //查询影院下的电影排期http://172.17.8.100/movieApi/cinema/v2/findCinemaScheduleList
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<PaiqiBean> paiqi(@Query("cinemaId") String cinemaId, @Query("page") String page, @Query("count") String count);
    //影片的评论http://172.17.8.100/movieApi/movie/v1/verify/movieComment
    @FormUrlEncoded
    @POST("movie/v1/verify/movieComment")
    Observable<WriterpinBean> writerpin(@Header("userId")String userId, @Header("sessionId")String sessionId, @Field("movieId") String movieId,@Field("commentContent") String commentContent,@Field("score") String score);
    //查询我对电影的评论列表http://172.17.8.100/movieApi/user/v2/verify/findMyMovieCommentList
    @GET("user/v2/verify/findMyMovieCommentList")
    Observable<MyAPinBean> pinmovie(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //查询用户关注电影列表http://172.17.8.100/movieApi/user/v2/verify/findUserFollowMovieList
    @GET("user/v2/verify/findUserFollowMovieList")
    Observable<Guanzhu_dianyin> guanzhumovie(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //查询用户关注电影列表http://http://172.17.8.100/movieApi/user/v2/verify/findUserFollowCinemaList
    @GET("user/v2/verify/findUserFollowCinemaList")
    Observable<GuancinemaBean> guanzhucinema(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //查询我对影院评论列表http://172.17.8.100/movieApi/user/v2/verify/findMyCinemaCommentList
    @GET("user/v2/verify/findMyCinemaCommentList")
    Observable<Ping_yingyuanBean> pinyingyuan(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("longitude") String longitude, @Query("latitude") String latitude,@Query("page") String page,@Query("count") String count);
    //我的电影票http://172.17.8.100/movieApi/user/v2/verify/findMyMovieTicket
    @GET("user/v2/verify/findMyMovieTicket")
    Observable<MyTicketBean> myticket(@Header("userId")String userId, @Header("sessionId")String sessionId);
    //取消关注电影http://172.17.8.100/movieApi/movie/v1/verify/cancelFollowMovie
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<QumovieBean> quxiaomovie(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("movieId")String movieId);
    //取消关注影院http://172.17.8.100/movieApi/cinema/v1/verify/cancelFollowCinema
    @GET("cinema/v1/verify/cancelFollowCinema")
    Observable<QucinemaBean> quxiaocinema(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("cinemaId")String cinemaId);
    //关注电影http://172.17.8.100/movieApi/movie/v1/verify/followMovie
    @GET("movie/v1/verify/followMovie")
    Observable<Guan_movieBean> guanmovie(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("movieId")String movieId);
    //购票记录http://172.17.8.100/movieApi/user/v2/verify/findUserBuyTicketRecord
    @GET("user/v2/verify/findUserBuyTicketRecord")
    Observable<BuyTicketBean> buytickey(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count,@Query("status") String status);
    //查看订单详情http://172.17.8.100/movieApi/user/v2/verify/findBuyTicketRecordByOrderId
    @GET("user/v2/verify/findBuyTicketRecordByOrderId")
    Observable<Ticket_xiangBean> tickeyxiang(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("orderId")String orderId);
    //查询预约http://172.17.8.100/movieApi/user/v2/verify/findUserReserve
    @GET("user/v2/verify/findUserReserve")
    Observable<MyYuyueBean> myyuyue(@Header("userId")String userId, @Header("sessionId")String sessionId);
    //预约http://172.17.8.100/movieApi/movie/v2/verify/reserve
    @FormUrlEncoded
    @POST("movie/v2/verify/reserve")
    Observable<YuyueBean> yuyue(@Header("userId")String userId, @Header("sessionId")String sessionId, @Field("movieId") String movieId);
    //查询看过的电影http://172.17.8.100/movieApi/user/v2/verify/findSeenMovie
    @GET("user/v2/verify/findSeenMovie")
    Observable<MyWatchBean> mywatch(@Header("userId")String userId, @Header("sessionId")String sessionId);
    //意见反馈:http://172.17.8.100/movieApi/tool/v1/verify/recordFeedBack
    @FormUrlEncoded
    @POST("tool/v1/verify/recordFeedBack")
    Observable<FankuiBean> fankui(@Header("userId")String userId, @Header("sessionId")String sessionId, @Field("content") String content);
    //查询取票码http://172.17.8.100/movieApi/user/v2/verify/findExchangeCode
    @GET("user/v2/verify/findExchangeCode")
    Observable<MyerweimaBean> erweima(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("recordId")String recordId);
    //查询系统消息列表http://172.17.8.100/movieApi/tool/v1/verify/findAllSysMsgList
    @GET("tool/v1/verify/findAllSysMsgList")
    Observable<MyMessageBean> mymessage(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("page")String page, @Query("count")String count);
    //个人信息http://172.17.8.100/movieApi/user/v1/verify/getUserInfoByUserId
    @GET("user/v1/verify/getUserInfoByUserId")
    Observable<MyDataBean> mydata(@Header("userId")String userId, @Header("sessionId")String sessionId);
    //关注影院http://172.17.8.100/movieApi/cinema/v1/verify/followCinema
    @GET("cinema/v1/verify/followCinema")
    Observable<Guan_movieBean> guancinema(@Header("userId")String userId, @Header("sessionId")String sessionId, @Query("cinemaId")String cinemaId);

    //微信登录http://172.17.8.100/movieApi/user/v1/weChatBindingLogin
    @FormUrlEncoded
    @POST("user/v1/weChatBindingLogin")
    Observable<WXLoginBean> wx(@Field("code") String code);
    //上传头像http://172.17.8.100/movieApi/user/v1/verify/uploadHeadPic
    @Multipart
    @POST("user/v1/verify/uploadHeadPic")
    Observable<MypicBean> setpict(@Header("userId")String userId, @Header("sessionId")String sessionId, @Part MultipartBody.Part image);
    //修改日期http://172.17.8.100/movieApi/user/v2/verify/updateUserBirthday
    @POST("user/v2/verify/updateUserBirthday")
    Observable<UpbitthdayBean> upday(@Header("userId")String userId, @Header("sessionId")String sessionId,@Query("birthday") String birthday);

}
