package com.example.trustsales.Data.Model;

public class Model_donhang {
    private long id;
    private String makh;
    private String trangthai;
    private String vanchuyen;
    private String ghichu;
    private String sanpham;
    private double soluong;
    private double tongtien;
    private double tongcuoc;
    private String ngaytao;
    private String ngayxn;
    private String ngaychuyen;

    public  Model_donhang(){}

    public Model_donhang(String makh, String trangthai, String vanchuyen, String ghichu, String sanpham, double soluong, double tongtien, double tongcuoc, String ngaytao, String ngayxn, String ngaychuyen) {
        this.makh = makh;
        this.trangthai = trangthai;
        this.vanchuyen = vanchuyen;
        this.ghichu = ghichu;
        this.sanpham = sanpham;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.tongcuoc = tongcuoc;
        this.ngaytao = ngaytao;
        this.ngayxn = ngayxn;
        this.ngaychuyen = ngaychuyen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getVanchuyen() {
        return vanchuyen;
    }

    public void setVanchuyen(String vanchuyen) {
        this.vanchuyen = vanchuyen;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public double getSoluong() {
        return soluong;
    }

    public void setSoluong(double soluong) {
        this.soluong = soluong;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getTongcuoc() {
        return tongcuoc;
    }

    public void setTongcuoc(double tongcuoc) {
        this.tongcuoc = tongcuoc;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNgayxn() {
        return ngayxn;
    }

    public void setNgayxn(String ngayxn) {
        this.ngayxn = ngayxn;
    }

    public String getNgaychuyen() {
        return ngaychuyen;
    }

    public void setNgaychuyen(String ngaychuyen) {
        this.ngaychuyen = ngaychuyen;
    }
}
