package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/11/11
 *@Time:16:45
 *@Description:${DESCRIPTION}
 **/

public class LoginBean {

    /**
     * result : {"sessionId":"157346150087213795","userId":13795,"userInfo":{"email":"3092294940@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13795,"lastLoginTime":1573461496000,"nickName":"你的益达h","sex":1}}
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
         * sessionId : 157346150087213795
         * userId : 13795
         * userInfo : {"email":"3092294940@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13795,"lastLoginTime":1573461496000,"nickName":"你的益达h","sex":1}
         */

        private String sessionId;
        private int userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
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
             * email : 3092294940@qq.com
             * headPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
             * id : 13795
             * lastLoginTime : 1573461496000
             * nickName : 你的益达h
             * sex : 1
             */

            private String email;
            private String headPic;
            private int id;
            private long lastLoginTime;
            private String nickName;
            private int sex;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(long lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }
    }
}
