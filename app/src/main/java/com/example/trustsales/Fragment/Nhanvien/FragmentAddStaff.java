package com.example.trustsales.Fragment.Nhanvien;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trustsales.Data.Model.Model_nhanvien;
import com.example.trustsales.Data.MyDatabaseHelper;
import com.example.trustsales.R;

import java.util.Calendar;

public class FragmentAddStaff extends Fragment {
    MyDatabaseHelper dbHelp;
    Button button_calendarstaff, button_calendarngayvaolam, button_addstaff;
    TextView txt_daystaff, txt_ngayvaolam ;
    EditText edt_addressstaff,edt_namestaff,edt_genderstaff, edt_phonestaff, edt_emailstaff, edt_department, edt_role  ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.nhanvien_add, container, false);
        button_calendarstaff = view.findViewById(R.id.button_calendarstaff);
        button_calendarngayvaolam = view.findViewById(R.id.button_calendarngayvaolam);
        button_addstaff = view.findViewById(R.id.button_addstaff);
        txt_daystaff = view.findViewById(R.id.txt_daystaff);
        txt_ngayvaolam = view.findViewById(R.id.txt_ngayvaolam);
        edt_namestaff = view.findViewById(R.id.edt_namestaff);
        edt_genderstaff = view.findViewById(R.id.edt_genderstaff);
        edt_phonestaff = view.findViewById(R.id.edt_phonestaff);
        edt_addressstaff = view.findViewById(R.id.edt_addressstaff);
        edt_emailstaff = view.findViewById(R.id.edt_emailstaff);
        edt_department = view.findViewById(R.id.edt_department);
        edt_role = view.findViewById(R.id.edt_role);



        button_calendarstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDatePickerDialog();
            }
        });
//
        button_calendarngayvaolam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataPickerDialogngayvaolam();
            }
        });

        button_addstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStaff();
            }
        });

        return view;
    }

    private void addStaff() {
        String tennv = edt_namestaff.getText().toString().trim();
        String diachi = edt_addressstaff.getText().toString().trim();
        String ngaysinh = txt_daystaff.getText().toString().trim();
        String gioitinh = edt_genderstaff.getText().toString().trim();
        String sdt = edt_phonestaff.getText().toString().trim();
        String email = edt_emailstaff.getText().toString().trim();
        String ngaylam = txt_ngayvaolam.getText().toString().trim();
        String phongban = edt_department.getText().toString().trim();
        String chucvu = edt_role.getText().toString().trim();

        if (tennv.isEmpty()||diachi.isEmpty()||ngaysinh.isEmpty()||gioitinh.isEmpty()||sdt.isEmpty()||email.isEmpty()||ngaylam.isEmpty()||phongban.isEmpty()||chucvu.isEmpty()){
            Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }

        Model_nhanvien model_nhanvien = new Model_nhanvien(tennv,diachi, ngaysinh, gioitinh, sdt,email,ngaylam,phongban,chucvu);

        if(dbHelp == null){
            dbHelp = new MyDatabaseHelper(getContext());
        }

        dbHelp.addStaff(model_nhanvien);

        Toast.makeText(getContext(), "Đã thêm nhân viên thành công", Toast.LENGTH_SHORT).show();

        edt_namestaff.setText("");
        edt_addressstaff.setText("");
        txt_daystaff.setText("");
        edt_genderstaff.setText("");
        edt_phonestaff.setText("");
        edt_emailstaff.setText("");
        txt_ngayvaolam.setText("");
        edt_department.setText("");
        edt_role.setText("");
    }

    private void showDataPickerDialogngayvaolam() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog1 = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String datengayvaolam = dayOfMonth + "/" + (month+1) + "/" + year;
                txt_ngayvaolam.setText(datengayvaolam);
            }
        },year,month, day);
        datePickerDialog1.show();
    }

    private void ShowDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog2 = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectdate = dayOfMonth + "/" + (month+1) + "/" + year;
                txt_daystaff.setText(selectdate);
            }
        }, year, month, day);
        datePickerDialog2.show();
    }
}
