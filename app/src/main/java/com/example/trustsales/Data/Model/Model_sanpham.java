package com.example.trustsales.Data.Model;

public class Model_sanpham {
        private long id;
        private String masp;
        private String tensp;
        private double gia;
        private String maloai;
        private String donvi;
        private String imageSource;

        public Model_sanpham() {
        }

        public Model_sanpham(String masp, String tensp, double gia, String maloai, String donvi, String imageSource) {
            this.masp = masp;
            this.tensp = tensp;
            this.gia = gia;
            this.maloai = maloai;
            this.donvi = donvi;
            this.imageSource = imageSource;
        }

        // Getters and Setters

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMasp() {
            return masp;
        }

        public void setMasp(String masp) {
            this.masp = masp;
        }

        public String getTensp() {
            return tensp;
        }

        public void setTensp(String tensp) {
            this.tensp = tensp;
        }

        public double getGia() {
            return gia;
        }

        public void setGia(double gia) {
            this.gia = gia;
        }

        public String getMaloai() {
            return maloai;
        }

        public void setMaloai(String maloai) {
            this.maloai = maloai;
        }

        public String getDonvi() {
            return donvi;
        }

        public void setDonvi(String donvi) {
            this.donvi = donvi;
        }

        public String getImageSource() {
            return imageSource;
        }

        public void setImageSource(String imageSource) {
            this.imageSource = imageSource;
        }

    }

