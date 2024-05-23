package com.example.trustsales.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trustsales.Data.Model.Model_khachhang;
import com.example.trustsales.Data.Model.Model_sanpham;
import com.example.trustsales.Data.MyDatabaseHelper;
import com.example.trustsales.Fragment.Khachhang.AdapterCustomer;
import com.example.trustsales.Fragment.Khachhang.FragmentAddKhachhang;
import com.example.trustsales.Fragment.Sanpham.AdapterProduct;
import com.example.trustsales.R;

import java.util.Calendar;
import java.util.List;

public class FragmentKhachHang extends Fragment {
    TextView txtdaycus;
    private MyDatabaseHelper dbHelper;
    private AdapterCustomer customerAdapter;
    private List<Model_khachhang> customerList;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.khachhang_fragment, container, false);

        String[] loaikhachhang = {"Chọn Loại KH","Khách hàng 1", "Khách hàng 2", "Khách hàng 3"};
        String[] gioitinh = {"Chọn giới tính","Nam", "Nữ", "Chưa rõ"};
        String[] tinhthanh = {"Tỉnh thành","TPHCM", "Đồng Nai", "Bình Dương"};

        // Tạo một ArrayAdapter từ mảng chuỗi
        ArrayAdapter<String> adapterloaikh = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, loaikhachhang);
        adapterloaikh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adaptergt = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, gioitinh);
        adaptergt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adaptertinhthanh = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, tinhthanh);
        adaptertinhthanh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Thiết lập adapter cho Spinner
        Spinner spinnerloaikh = view.findViewById(R.id.category_spinnerloaikh);
        spinnerloaikh.setAdapter(adapterloaikh);
        Spinner spinnergt = view.findViewById(R.id.category_spinnergt);
        spinnergt.setAdapter(adaptergt);
        Spinner spinnertinhthanh = view.findViewById(R.id.category_spinnertinhthanh);
        spinnertinhthanh.setAdapter(adaptertinhthanh);

        // Thiết lập hint text bằng cách chọn phần tử đầu tiên trong Spinner
        spinnerloaikh.setSelection(0, false);
        spinnergt.setSelection(0, false);
        spinnertinhthanh.setSelection(0, false);

        // Bắt sự kiện chọn mục
        spinnerloaikh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Nếu mục đầu tiên được chọn (hint text), không làm gì cả
                if (position == 0) {
                    // Đặt hint text lại nếu người dùng chọn lại mục đầu tiên
                    spinnerloaikh.setSelection(0, false);
                } else {
                    // Xử lý khi một mục khác được chọn
                    String selectedCategory = (String) parent.getItemAtPosition(position);
                    // Thực hiện các hành động khác tùy thuộc vào mục được chọn
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không cần xử lý khi không có mục nào được chọn
            }
        });

        spinnergt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Nếu mục đầu tiên được chọn (hint text), không làm gì cả
                if (position == 0) {
                    // Đặt hint text lại nếu người dùng chọn lại mục đầu tiên
                    spinnergt.setSelection(0, false);
                } else {
                    // Xử lý khi một mục khác được chọn
                    String selectedCategory = (String) parent.getItemAtPosition(position);
                    // Thực hiện các hành động khác tùy thuộc vào mục được chọn
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không cần xử lý khi không có mục nào được chọn
            }
        });

        spinnertinhthanh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Nếu mục đầu tiên được chọn (hint text), không làm gì cả
                if (position == 0) {
                    // Đặt hint text lại nếu người dùng chọn lại mục đầu tiên
                    spinnertinhthanh.setSelection(0, false);
                } else {
                    // Xử lý khi một mục khác được chọn
                    String selectedCategory = (String) parent.getItemAtPosition(position);
                    // Thực hiện các hành động khác tùy thuộc vào mục được chọn
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không cần xử lý khi không có mục nào được chọn
            }
        });

        Button buttonadd = view.findViewById(R.id.button_newcus);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FragmentAddKhachhang()).addToBackStack(null).commit();
            }
        });
//
        dbHelper = new MyDatabaseHelper(getContext());
        recyclerView = view.findViewById(R.id.recyclerviewcus);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadCustomer();

        return view;
    }
    private void loadCustomer() {
        customerList = dbHelper.getAllCustomersList();
        if (customerList.size() > 0) {
            customerAdapter = new AdapterCustomer(customerList);
            recyclerView.setAdapter(customerAdapter);
        } else {
            Toast.makeText(getContext(), "Không có sản phẩm nào", Toast.LENGTH_SHORT).show();
        }
    }
}

