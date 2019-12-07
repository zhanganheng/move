package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/11/18
 *@Time:21:11
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class PinBean {

    /**
     * result : [{"commentContent":"这是在陆路","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204216.png","commentId":2111,"commentTime":1572869469000,"commentUserId":13708,"commentUserName":"郭转晨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"很好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025152747.jpg","commentId":1868,"commentTime":1572003461000,"commentUserId":13610,"commentUserName":"诺","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.5},{"commentContent":"评论8","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-23/20191023140542.3png.png","commentId":1769,"commentTime":1571647160000,"commentUserId":13645,"commentUserName":"太子10","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1748,"commentTime":1571626749000,"commentUserId":13665,"commentUserName":"123456789","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"3695","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1691,"commentTime":1571283415000,"commentUserId":13582,"commentUserName":"李云龙","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":6}]
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
         * commentContent : 这是在陆路
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204216.png
         * commentId : 2111
         * commentTime : 1572869469000
         * commentUserId : 13708
         * commentUserName : 郭转晨
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 10
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

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

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
