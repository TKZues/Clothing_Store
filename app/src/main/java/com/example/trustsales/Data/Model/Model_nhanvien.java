package com.example.trustsales.Data.Model;

public class Model_nhanvien {
    private long idnv;
    private String tennv;
    private String gtnv;
    private String nsnv;
    private String cvunv;
    private String pbanvn;
    private String ngaylam;
    private String dcnv;
    private String sdtnv;
    private String emailnv;

    public Model_nhanvien(){}

    public Model_nhanvien(String tennv, String gtnv, String nsnv, String cvunv, String pbanvn, String ngaylam, String dcnv, String sdtnv, String emailnv) {
        this.tennv = tennv;
        this.gtnv = gtnv;
        this.nsnv = nsnv;
        this.cvunv = cvunv;
        this.pbanvn = pbanvn;
        this.ngaylam = ngaylam;
        this.dcnv = dcnv;
        this.sdtnv = sdtnv;
        this.emailnv = emailnv;
    }

    public long getIdnv() {
        return idnv;
    }

    public void setIdnv(long idnv) {
        this.idnv = idnv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getGtnv() {
        return gtnv;
    }

    public void setGtnv(String gtnv) {
        this.gtnv = gtnv;
    }

    public String getNsnv() {
        return nsnv;
    }

    public void setNsnv(String nsnv) {
        this.nsnv = nsnv;
    }

    public String getCvunv() {
        return cvunv;
    }

    public void setCvunv(String cvunv) {
        this.cvunv = cvunv;
    }

    public String getPbanvn() {
        return pbanvn;
    }

    public void setPbanvn(String pbanvn) {
        this.pbanvn = pbanvn;
    }

    public String getNgaylam() {
        return ngaylam;
    }

    public void setNgaylam(String ngaylam) {
        this.ngaylam = ngaylam;
    }

    public String getDcnv() {
        return dcnv;
    }

    public void setDcnv(String dcnv) {
        this.dcnv = dcnv;
    }

    public String getSdtnv() {
        return sdtnv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }

    public String getEmailnv() {
        return emailnv;
    }

    public void setEmailnv(String emailnv) {
        this.emailnv = emailnv;
    }
}
