package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/1
 *@Time:13:02
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class Ping_cinemaBean {

    /**
     * result : [{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":145,"commentTime":1575108873000,"commentUserId":13794,"commentUserName":"蜕变","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很棒","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":138,"commentTime":1575006830000,"commentUserId":13689,"commentUserName":"婉珍","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"月考","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-26/20191126154902.jpg","commentId":134,"commentTime":1574753199000,"commentUserId":13819,"commentUserName":"你的益达854131562","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"帮","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-26/20191126154750.jpg","commentId":133,"commentTime":1574753128000,"commentUserId":13624,"commentUserName":"赵阳","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"123","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-26/20191126151014.png","commentId":126,"commentTime":1574253771000,"commentUserId":13774,"commentUserName":"你的益达啊","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0}]
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
         * commentContent : 很棒
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 145
         * commentTime : 1575108873000
         * commentUserId : 13794
         * commentUserName : 蜕变
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
