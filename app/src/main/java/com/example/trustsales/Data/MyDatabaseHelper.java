package com.example.trustsales.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.trustsales.Data.Model.Model_donhang;
import com.example.trustsales.Data.Model.Model_khachhang;
import com.example.trustsales.Data.Model.Model_nhanvien;
import com.example.trustsales.Data.Model.Model_sanpham;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "p3";
    private static final int DATABASE_VERSION = 1;

    // Tên bảng và các cột
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MASP = "masp";
    private static final String COLUMN_TENSP = "tensp";
    private static final String COLUMN_GIA = "gia";
    private static final String COLUMN_MALOAI = "maloai";
    private static final String COLUMN_DONVI = "donvi";
    private static final String COLUMN_IMAGE_SOURCE = "image_source";
    ///Bảng khách hàng và cột
    private static final String TABLE_KH = "customer";
    private static final String KH_ID = "idkh";
    private static final String KH_TENKH = "tenkh";
    private static final String KH_DIACHI = "diachikh";
    private static final String KH_NGAYSINH  = "ngaysinhkh";
    private static final String KH_GIOITINH = "gioitinh";
    private static final String KH_SODT = "sdtkh";
    private static final String KH_GHICHU = "ghichu";

    private static final String TABLE_DONHANG = "donhang";
    private static final String DH_ID = "iddh";
    private static final String DH_KH = "kh";
    private static final String DH_trangthai = "trangthai";
    private static final String DH_vanchuyen = "vanchuyen";
    private static final String DH_ghichu = "ghichu";
    private static final String DH_sanpham = "sanpham";
    private static final String DH_soluong = "soluong";
    private static final String DH_tongtien = "tongtien";
    private static final String DH_tongcuoc = "tongcuoc";
    private static final String DH_ngaytao = "ngaytao";
    private static final String DH_ngayxn = "ngayxn";
    private static final String DH_ngaychuyen = "ngaychuyen";

    private static final String TABLE_NHANVIEN = "nhanvien";
    private static final String NV_ID = "idnv";
    private static final String NV_ten = "tennv";
    private static final String NV_gioitinh = "gtnv";
    private static final String NV_namsinh = "nsnv";
    private static final String NV_chucvu = "cvunv";
    private static final String NV_phongban = "pbanvn";
    private static final String NV_ngaylam = "ngaylam";
    private static final String NV_diachi = "dcnv";
    private static final String NV_sdt = "sdtnv";
    private static final String NV_email = "emailnv";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Tạo bảng sản phẩm
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_MASP + " TEXT,"
                + COLUMN_TENSP + " TEXT,"
                + COLUMN_GIA + " REAL,"
                + COLUMN_MALOAI + " TEXT,"
                + COLUMN_DONVI + " TEXT,"
                + COLUMN_IMAGE_SOURCE + " TEXT"
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        String CREATE_KH_TABLE = "CREATE TABLE " + TABLE_KH + "("
                + KH_ID + " INTEGER PRIMARY KEY,"
                + KH_TENKH + " TEXT,"
                + KH_DIACHI + " TEXT,"
                + KH_NGAYSINH + " REAL,"
                + KH_GIOITINH + " TEXT,"
                + KH_SODT + " TEXT,"
                + KH_GHICHU + " TEXT"
                + ")";
        db.execSQL(CREATE_KH_TABLE);

        String CREATE_DH_TABLE = "CREATE TABLE " + TABLE_DONHANG + "("
                + DH_ID + " INTEGER PRIMARY KEY,"
                + DH_KH + " TEXT,"
                + DH_trangthai + " TEXT,"
                + DH_vanchuyen + " REAL,"
                + DH_ghichu + " TEXT,"
                + DH_sanpham + " TEXT,"
                + DH_soluong + " TEXT,"
                + DH_tongtien + " TEXT,"
                + DH_tongcuoc + " TEXT,"
                + DH_ngaytao + " TEXT,"
                + DH_ngayxn + " TEXT,"
                + DH_ngaychuyen + " TEXT"
                + ")";
        db.execSQL(CREATE_DH_TABLE);

        //Tạo bảng khách hàng
        String CREATE_NV_TABLE = "CREATE TABLE " + TABLE_NHANVIEN + "("
                + NV_ID + " INTEGER PRIMARY KEY,"
                + NV_ten + " TEXT,"
                + NV_gioitinh + " REAL,"
                + NV_namsinh + " TEXT,"
                + NV_chucvu + " TEXT,"
                + NV_phongban + " TEXT,"
                + NV_ngaylam + " TEXT,"
                + NV_diachi + " TEXT,"
                + NV_sdt + " TEXT,"
                + NV_email + " TEXT"
                + ")";
        db.execSQL(CREATE_NV_TABLE);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KH);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_DONHANG);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NHANVIEN);
        onCreate(db);
    }
    //THêm dữ liệu vào bảng nhân viên
    public void addStaff(Model_nhanvien staff){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NV_ten, staff.getTennv());
        values.put(NV_gioitinh, staff.getGtnv());
        values.put(NV_namsinh, staff.getNsnv());
        values.put(NV_chucvu, staff.getCvunv());
        values.put(NV_phongban, staff.getPbanvn());
        values.put(NV_ngaylam, staff.getNgaylam());
        values.put(NV_diachi, staff.getDcnv());
        values.put(NV_sdt, staff.getSdtnv());
        values.put(NV_email, staff.getEmailnv());
        db.insert(TABLE_NHANVIEN, null, values);
    }
//    public void addOrder(Model_donhang order){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DH_KH, customer.getNamecus());
//        values.put(DH_trangthai, customer.getAddresscus());
//        values.put(DH_vanchuyen, customer.getDaycus());
//        values.put(DH_ghichu, customer.getGender());
//        values.put(DH_sanpham, customer.getPhonecus());
//        values.put(DH_soluong, customer.getNotecus());
//        values.put(DH_tongtien, customer.getDaycus());
//        values.put(KH_GIOITINH, customer.getGender());
//        values.put(KH_SODT, customer.getPhonecus());
//        values.put(KH_GHICHU, customer.getNotecus());
//        db.insert(TABLE_KH, null, values);
//    }
    // Thêm sản phẩm mới
    public void addProduct(Model_sanpham product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MASP, product.getMasp());
        values.put(COLUMN_TENSP, product.getTensp());
        values.put(COLUMN_GIA, product.getGia());
        values.put(COLUMN_MALOAI, product.getMaloai());
        values.put(COLUMN_DONVI, product.getDonvi());
        values.put(COLUMN_IMAGE_SOURCE, product.getImageSource());
        db.insert(TABLE_PRODUCTS, null, values);
    }

    public void addCustomer(Model_khachhang customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KH_TENKH, customer.getNamecus());
        values.put(KH_DIACHI, customer.getAddresscus());
        values.put(KH_NGAYSINH, customer.getDaycus());
        values.put(KH_GIOITINH, customer.getGender());
        values.put(KH_SODT, customer.getPhonecus());
        values.put(KH_GHICHU, customer.getNotecus());
        db.insert(TABLE_KH, null, values);
    }



    // Lấy thông tin tất cả sản phẩm
    public List<Model_sanpham> getAllProductsList() {
        List<Model_sanpham> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTS, null);
        if (cursor.moveToFirst()) {
            do {
                Model_sanpham product = new Model_sanpham();
                product.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                product.setMasp(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MASP)));
                product.setTensp(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TENSP)));
                product.setGia(cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_GIA)));
                product.setMaloai(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MALOAI)));
                product.setDonvi(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DONVI)));
                product.setImageSource(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_SOURCE)));
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return productList;
    }

    public List<Model_khachhang> getAllCustomersList() {
        List<Model_khachhang> customerlist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_KH, null);
        if (cursor.moveToFirst()) {
            do {
                Model_khachhang customer = new Model_khachhang();
                customer.setId_kh(cursor.getInt(cursor.getColumnIndexOrThrow(KH_ID)));
                customer.setNamecus(cursor.getString(cursor.getColumnIndexOrThrow(KH_TENKH)));
                customer.setAddresscus(cursor.getString(cursor.getColumnIndexOrThrow(KH_DIACHI)));
                customer.setDaycus(cursor.getString(cursor.getColumnIndexOrThrow(KH_NGAYSINH)));
                customer.setGender(cursor.getString(cursor.getColumnIndexOrThrow(KH_GIOITINH)));
                customer.setPhonecus(cursor.getString(cursor.getColumnIndexOrThrow(KH_SODT)));
                customer.setNotecus(cursor.getString(cursor.getColumnIndexOrThrow(KH_GHICHU)));
                customerlist.add(customer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return customerlist;
    }

    public List<Model_nhanvien> getAllStaffsList() {
        List<Model_nhanvien> stafflist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NHANVIEN, null);
        if (cursor.moveToFirst()) {
            do {
                Model_nhanvien staff = new Model_nhanvien();
                staff.setIdnv(cursor.getInt(cursor.getColumnIndexOrThrow(NV_ID)));
                staff.setTennv(cursor.getString(cursor.getColumnIndexOrThrow(NV_ten)));
                staff.setGtnv(cursor.getString(cursor.getColumnIndexOrThrow(NV_gioitinh)));
                staff.setNsnv(cursor.getString(cursor.getColumnIndexOrThrow(NV_namsinh)));
                staff.setCvunv(cursor.getString(cursor.getColumnIndexOrThrow(NV_chucvu)));
                staff.setPbanvn(cursor.getString(cursor.getColumnIndexOrThrow(NV_phongban)));
                staff.setNgaylam(cursor.getString(cursor.getColumnIndexOrThrow(NV_ngaylam)));
                staff.setDcnv(cursor.getString(cursor.getColumnIndexOrThrow(NV_diachi)));
                staff.setSdtnv(cursor.getString(cursor.getColumnIndexOrThrow(NV_sdt)));
                staff.setEmailnv(cursor.getString(cursor.getColumnIndexOrThrow(NV_email)));
                stafflist.add(staff);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return stafflist;
    }


    // Cập nhật thông tin sản phẩm
    public void updateProduct(Model_sanpham product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MASP, product.getMasp());
        values.put(COLUMN_TENSP, product.getTensp());
        values.put(COLUMN_GIA, product.getGia());
        values.put(COLUMN_MALOAI, product.getMaloai());
        values.put(COLUMN_DONVI, product.getDonvi());
        values.put(COLUMN_IMAGE_SOURCE, product.getImageSource());
        db.update(TABLE_PRODUCTS, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
        db.close();
    }

    // Xóa sản phẩm
    public void deleteProduct(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}
