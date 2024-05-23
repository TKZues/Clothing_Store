package com.example.trustsales.Data.Model;

import android.app.DatePickerDialog;

public class Model_khachhang {
    private long id_kh;
    private String namecus;
    private String addresscus;
    private String daycus;
    private String gender;
    private String phonecus;
    private String notecus;

     public Model_khachhang(){}

    public Model_khachhang(String namecus, String addresscus, String daycus, String gender, String phonecus, String notecus) {
        this.namecus = namecus;
        this.addresscus = addresscus;
        this.daycus = daycus;
        this.gender = gender;
        this.phonecus = phonecus;
        this.notecus = notecus;
    }

    public long getId_kh() {
        return id_kh;
    }

    public void setId_kh(long id_kh) {
        this.id_kh = id_kh;
    }

    public String getNamecus() {
        return namecus;
    }

    public void setNamecus(String namecus) {
        this.namecus = namecus;
    }

    public String getAddresscus() {
        return addresscus;
    }

    public void setAddresscus(String addresscus) {
        this.addresscus = addresscus;
    }

    public String getDaycus() {
        return daycus;
    }

    public void setDaycus(String daycus) {
        this.daycus = daycus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonecus() {
        return phonecus;
    }

    public void setPhonecus(String phonecus) {
        this.phonecus = phonecus;
    }

    public String getNotecus() {
        return notecus;
    }

    public void setNotecus(String notecus) {
        this.notecus = notecus;
    }
}
