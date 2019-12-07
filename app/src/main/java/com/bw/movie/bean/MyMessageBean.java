package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:11:38
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class MyMessageBean {

    /**
     * result : [{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8679,"pushTime":1575427686000,"status":0,"title":"系统通知","userId":13692},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8667,"pushTime":1575379062000,"status":0,"title":"系统通知","userId":13692},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8613,"pushTime":1575359111000,"status":0,"title":"系统通知","userId":13692},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8611,"pushTime":1575358480000,"status":0,"title":"系统通知","userId":13692},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8485,"pushTime":1575258828000,"status":0,"title":"系统通知","userId":13692}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 您已购买电影票,请尽快完成支付,以免影响到您的观影
         * id : 8679
         * pushTime : 1575427686000
         * status : 0
         * title : 系统通知
         * userId : 13692
         */

        private String content;
        private int id;
        private long pushTime;
        private int status;
        private String title;
        private int userId;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPushTime() {
            return pushTime;
        }

        public void setPushTime(long pushTime) {
            this.pushTime = pushTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
