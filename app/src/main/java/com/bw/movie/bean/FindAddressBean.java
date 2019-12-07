package com.bw.movie.bean;
/*
 *@auther:张安恒
 *@Date: 2019/11/20
 *@Time:16:04
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class FindAddressBean {


    /**
     * result : [{"address":"滨河路乙1号雍和航星园74-76号楼","cinemaId":1,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","name":"青春光线电影院","price":0},{"address":"天桥南大街3号楼一层、二层（天桥艺术大厦南侧）","cinemaId":3,"logo":"http://172.17.8.100/images/movie/logo/sd.jpg","name":"首都电影院","price":0},{"address":"远大路1号B座5层魔影国际影城","cinemaId":4,"logo":"http://172.17.8.100/images/movie/logo/mygj.jpg","name":"魔影国际影城","price":0}]
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
         * address : 滨河路乙1号雍和航星园74-76号楼
         * cinemaId : 1
         * logo : http://172.17.8.100/images/movie/logo/qcgx.jpg
         * name : 青春光线电影院
         * price : 0
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;
        private double price;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
