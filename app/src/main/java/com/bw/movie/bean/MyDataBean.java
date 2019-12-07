package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/4
 *@Time:14:32
 *@Description:${DESCRIPTION}
 **/

public class MyDataBean {

    /**
     * result : {"email":"2467337415@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/2019-12-04/20191204114710.unknown","id":13692,"lastLoginTime":1575440522000,"nickName":"Tow Smelly","sex":1}
     * message : 查询成功
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
         * email : 2467337415@qq.com
         * headPic : http://172.17.8.100/images/movie/head_pic/2019-12-04/20191204114710.unknown
         * id : 13692
         * lastLoginTime : 1575440522000
         * nickName : Tow Smelly
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
