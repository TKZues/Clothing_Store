package com.example.trustsales.Fragment.Khachhang;

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

import com.example.trustsales.Data.Model.Model_khachhang;
import com.example.trustsales.Data.MyDatabaseHelper;
import com.example.trustsales.R;

import java.util.Calendar;

public class FragmentAddKhachhang extends Fragment {
    MyDatabaseHelper dbHepler;
    TextView txtdaycus ;
    EditText edt_namecus, edt_addresscus,edt_gendercus,edt_phonecus,edt_notecus;
    Button button_addcus;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.khachhang_add, container, false);

        Button btncalendar = view.findViewById(R.id.button_calendar);
        txtdaycus = view.findViewById(R.id.txt_daycus);
        edt_namecus = view.findViewById(R.id.edt_namecus);
        edt_addresscus = view.findViewById(R.id.edt_addresscus);
        edt_gendercus = view.findViewById(R.id.edt_gendercus);
        edt_phonecus = view.findViewById(R.id.edt_phonecus);
        edt_notecus = view.findViewById(R.id.edt_notecus);
        button_addcus = view.findViewById(R.id.button_addcus);


        btncalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }


        });
        button_addcus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomer();
            }
        });

        return view;
    }

    private void addCustomer() {
        String tenkh = edt_namecus.getText().toString().trim();
        String diachikh = edt_addresscus.getText().toString().trim();
        String ngaysinhkh = txtdaycus.getText().toString().trim();
        String gioitinhkh = edt_gendercus.getText().toString().trim();
        String sodtkh = edt_phonecus.getText().toString().trim();
        String ghichukh = edt_notecus.getText().toString().trim();

        if(tenkh.isEmpty()|| diachikh.isEmpty()||ngaysinhkh.isEmpty()||gioitinhkh.isEmpty()||sodtkh.isEmpty()||ghichukh.isEmpty()){
            Toast.makeText(getContext(), "Vui lòng nhập dầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }
        Model_khachhang model_khachhang = new Model_khachhang(tenkh, diachikh, ngaysinhkh, gioitinhkh, sodtkh, ghichukh);
        if(dbHepler == null){
            dbHepler = new MyDatabaseHelper(getContext());
        }
        dbHepler.addCustomer(model_khachhang);

        Toast.makeText(getContext(), "Thêm khách hàng mới thành công", Toast.LENGTH_SHORT).show();

        edt_namecus.setText("");
        edt_addresscus.setText("");
        txtdaycus.setText("");
        edt_gendercus.setText("");
        edt_phonecus.setText("");
        edt_notecus.setText("");
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                txtdaycus.setText(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }
}
