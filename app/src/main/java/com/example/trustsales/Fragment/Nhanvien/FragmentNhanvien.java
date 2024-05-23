package com.example.trustsales.Fragment.Nhanvien;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trustsales.Data.Model.Model_khachhang;
import com.example.trustsales.Data.Model.Model_nhanvien;
import com.example.trustsales.Data.MyDatabaseHelper;
import com.example.trustsales.Fragment.Khachhang.AdapterCustomer;
import com.example.trustsales.Fragment.Khachhang.FragmentAddKhachhang;
import com.example.trustsales.R;

import java.util.List;

public class FragmentNhanvien extends Fragment {
    MyDatabaseHelper dbHelper;
    Button btnaddstaff;
    private AdapterStaff staffAdapter;
    private List<Model_nhanvien> stafflist;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.nhanvien_fragment, container, false);

        btnaddstaff = view.findViewById(R.id.button_newstaff);

        btnaddstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FragmentAddStaff()).addToBackStack(null).commit();
            }
        });
        dbHelper = new MyDatabaseHelper(getContext());
        recyclerView = view.findViewById(R.id.ryr_staff);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadStaff();


        return view;
    }

    private void loadStaff() {
        stafflist = dbHelper.getAllStaffsList();
        if (stafflist.size() > 0) {
            staffAdapter = new AdapterStaff(stafflist);
            recyclerView.setAdapter(staffAdapter);
        } else {
            Toast.makeText(getContext(), "Không có nhân viên nào nào", Toast.LENGTH_SHORT).show();
        }
    }
}
