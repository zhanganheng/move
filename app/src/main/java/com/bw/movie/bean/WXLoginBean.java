package com.bw.movie.bean;

/**
 * 作者:dongyanjun
 * 时间：2019/12/5
 * 描述:DongMovieDeom
 * 功能：
 **/
public class WXLoginBean {

    /**
     * result : {"sessionId":"157554318486213866","userId":13866,"userInfo":{"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/N5aWt7TBRQ6ia220EBs8hNy2smNb2KY9WujiaH7hnhBFHqMkNs0oh8vIVWCJTvuroFIOz04V7iaa6xjzjGWa9fgPg/132","id":13866,"lastLogStringime":1575543184000,"nickName":"我爱你_TR6","sex":1}}
     * message : 登陆成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * sessionId : 157554318486213866
         * userId : 13866
         * userInfo : {"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/N5aWt7TBRQ6ia220EBs8hNy2smNb2KY9WujiaH7hnhBFHqMkNs0oh8vIVWCJTvuroFIOz04V7iaa6xjzjGWa9fgPg/132","id":13866,"lastLogStringime":1575543184000,"nickName":"我爱你_TR6","sex":1}
         */

        private String sessionId;
        private String userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * headPic : http://thirdwx.qlogo.cn/mmopen/vi_32/N5aWt7TBRQ6ia220EBs8hNy2smNb2KY9WujiaH7hnhBFHqMkNs0oh8vIVWCJTvuroFIOz04V7iaa6xjzjGWa9fgPg/132
             * id : 13866
             * lastLogStringime : 1575543184000
             * nickName : 我爱你_TR6
             * sex : 1
             */

            private String headPic;
            private String id;
            private long lastLogStringime;
            private String nickName;
            private String sex;

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public long getLastLogStringime() {
                return lastLogStringime;
            }

            public void setLastLogStringime(long lastLogStringime) {
                this.lastLogStringime = lastLogStringime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }
        }
    }
}
