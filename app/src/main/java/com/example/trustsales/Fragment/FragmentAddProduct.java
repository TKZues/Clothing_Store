package com.example.trustsales.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trustsales.Data.Model.Model_sanpham;
import com.example.trustsales.Data.MyDatabaseHelper;
import com.example.trustsales.R;

import java.io.IOException;
import java.util.ArrayList;

public class FragmentAddProduct extends Fragment {
    private static final int MY_REQUEST_CODE = 10;
    private Button buttonadd;
    private MyDatabaseHelper dbHelper;
    private ImageView imageGalleryView;
    EditText edt_masp,edt_tensp, edt_gia, edt_maloai, edt_donvi, edt_imageSource;
    Button button_addproduct;
    //Khởi tạo listView
    ListView listView;
    private ArrayAdapter<String> productAdapter;
    private ArrayList<String> productList;

    public static final String TAG = FragmentAddProduct.class.getName();
    private ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    Log.e(TAG, "onActivityResult");
                    if (o.getResultCode() == Activity.RESULT_OK) {
                        Intent data = o.getData();
                        if (data == null) {
                            return;
                        }
                        Uri uri = data.getData();
                        try {
                            if (uri != null) {
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
                                imageGalleryView.setImageBitmap(bitmap);
                                edt_imageSource.setText(uri.toString());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
    );

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.product_additem, container, false);
        dbHelper = new MyDatabaseHelper(getContext());
        buttonadd = view.findViewById(R.id.btn_selectimage);
        button_addproduct = view.findViewById(R.id.button_addproduct);
        edt_masp = view.findViewById(R.id.edt_masp);
        edt_tensp = view.findViewById(R.id.edt_tensp);
        edt_gia = view.findViewById(R.id.edt_gia);
        edt_maloai = view.findViewById(R.id.edt_maloai);
        edt_donvi = view.findViewById(R.id.edt_donvi);
        edt_imageSource = view.findViewById(R.id.edt_image);


        imageGalleryView = view.findViewById(R.id.image_gallery);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRequestPermision();
            }
        });

        button_addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

        return view;
    }
    private void addProduct() {
        String masp = edt_masp.getText().toString().trim();
        String tensp = edt_tensp.getText().toString().trim();
        double gia = Double.parseDouble(edt_gia.getText().toString().trim());
        String maloai = edt_maloai.getText().toString().trim();
        String donvi = edt_donvi.getText().toString().trim();
        String imageSource = edt_imageSource.getText().toString().trim();

        // Kiểm tra xem các trường có rỗng không
        if (masp.isEmpty() || tensp.isEmpty() || maloai.isEmpty() || donvi.isEmpty() || imageSource.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tạo đối tượng Product
        Model_sanpham product = new Model_sanpham(masp, tensp, gia, maloai, donvi, imageSource);

        // Thêm sản phẩm vào cơ sở dữ liệu
        if (dbHelper == null) {
            dbHelper = new MyDatabaseHelper(getContext());
        }
        dbHelper.addProduct(product);

        // Hiển thị thông báo khi thêm sản phẩm thành công
        Toast.makeText(getContext(), "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();

        // Xóa các trường nhập liệu sau khi thêm thành công
        edt_masp.setText("");
        edt_tensp.setText("");
        edt_gia.setText("");
        edt_maloai.setText("");
        edt_donvi.setText("");
        edt_imageSource.setText("");
        imageGalleryView.setImageResource(android.R.color.transparent); // Xóa hình ảnh hiển thị
    }

    private void onClickRequestPermision() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            openGellary();
            return;
        }
        if (ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            openGellary();
        }else{
            String [] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, MY_REQUEST_CODE);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==MY_REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openGellary();
            }
        }
    }

    private void openGellary() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent,"Select Picture"));
    }


}