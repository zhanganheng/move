package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/3
 *@Time:10:05
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class BuyTicketBean {

    /**
     * result : [{"amount":1,"createTime":1571905426000,"id":1687,"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieName":"找到你","orderId":"20191024162346303","price":0.01},{"amount":1,"createTime":1571970911000,"id":1974,"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieName":"找到你","orderId":"20191025103511739","price":0.01},{"amount":1,"createTime":1571971175000,"id":1977,"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieName":"找到你","orderId":"20191025103935027","price":0.01},{"amount":1,"createTime":1571971217000,"id":1978,"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieName":"找到你","orderId":"20191025104017401","price":0.01},{"amount":1,"createTime":1575095571000,"id":5416,"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieName":"中国机长","orderId":"20191130143251930","price":0.01}]
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
         * amount : 1
         * createTime : 1571905426000
         * id : 1687
         * imageUrl : http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg
         * movieName : 找到你
         * orderId : 20191024162346303
         * price : 0.01
         */

        private int amount;
        private long createTime;
        private int id;
        private String imageUrl;
        private String movieName;
        private String orderId;
        private double price;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
