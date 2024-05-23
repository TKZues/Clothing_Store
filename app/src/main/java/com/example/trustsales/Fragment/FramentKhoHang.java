package com.example.trustsales.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trustsales.Data.Model.Model_sanpham;
import com.example.trustsales.Data.MyDatabaseHelper;
import com.example.trustsales.Fragment.Sanpham.AdapterProduct;
import com.example.trustsales.R;

import java.util.List;

public class FramentKhoHang extends Fragment {

    private MyDatabaseHelper dbHelper;
    private AdapterProduct productAdapter;
    private List<Model_sanpham> productList;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.khohang_fragment, container, false);

        // Danh sách các lựa chọn
        String[] categories = {"Chọn một mục","Lựa chọn 1", "Lựa chọn 2", "Lựa chọn 3"};

        // Tạo một ArrayAdapter từ mảng chuỗi
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Thiết lập adapter cho Spinner
        Spinner spinner = rootView.findViewById(R.id.category_spinner);
        spinner.setAdapter(adapter);

        // Thiết lập hint text bằng cách chọn phần tử đầu tiên trong Spinner
        spinner.setSelection(0, false);

        // Bắt sự kiện chọn mục
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Nếu mục đầu tiên được chọn (hint text), không làm gì cả
                if (position == 0) {
                    // Đặt hint text lại nếu người dùng chọn lại mục đầu tiên
                    spinner.setSelection(0, false);
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

        Button buttonadd = rootView.findViewById(R.id.button_add);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FragmentAddProduct()).addToBackStack(null).commit();
            }
        });
            dbHelper = new MyDatabaseHelper(getContext());
         recyclerView = rootView.findViewById(R.id.recyclerview);
         recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadProducts();
        return rootView;


    }
    private void loadProducts() {
        productList = dbHelper.getAllProductsList();
        if (productList.size() > 0) {
            productAdapter = new AdapterProduct( productList);
            recyclerView.setAdapter(productAdapter);
        } else {
            Toast.makeText(getContext(), "Không có sản phẩm nào", Toast.LENGTH_SHORT).show();
        }
    }
}
