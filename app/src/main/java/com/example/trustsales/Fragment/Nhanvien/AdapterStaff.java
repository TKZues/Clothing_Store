package com.example.trustsales.Fragment.Nhanvien;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trustsales.Data.Model.Model_khachhang;
import com.example.trustsales.Data.Model.Model_nhanvien;
import com.example.trustsales.R;

import java.util.List;

public class AdapterStaff  extends RecyclerView.Adapter<AdapterStaff.StaffViewHold> {
    private List<Model_nhanvien> staffList;
    public AdapterStaff(List<Model_nhanvien> staffList) {
        this.staffList = staffList;
    }
    @NonNull
    @Override
    public AdapterStaff.StaffViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_nhanvien, parent, false);

        return new StaffViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStaff.StaffViewHold holder, int position) {
        Model_nhanvien staff = staffList.get(position);
        holder.tvEmployeeCode.setText(String.valueOf(staff.getIdnv()));
        holder.tvEmployeeName.setText(staff.getTennv());
        holder.tvGender.setText(staff.getGtnv());
        holder.tvBirthDate.setText(staff.getNsnv());
        holder.tvPosition.setText(staff.getCvunv());
        holder.tvDepartment.setText(staff.getPbanvn());
        holder.tvWorkingDay.setText(staff.getNgaylam());
        holder.tvAddress.setText(staff.getDcnv());
        holder.tvPhone.setText(staff.getSdtnv());
        holder.tvEmail.setText(staff.getEmailnv());
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    public class StaffViewHold extends RecyclerView.ViewHolder {
        TextView tvEmployeeCode,tvEmployeeName, tvGender, tvBirthDate, tvPosition, tvDepartment, tvWorkingDay, tvAddress,tvPhone, tvEmail;
        public StaffViewHold(@NonNull View itemView) {
            super(itemView);
            tvEmployeeCode = itemView.findViewById(R.id.tvEmployeeCode);
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvBirthDate = itemView.findViewById(R.id.tvBirthDate);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvDepartment = itemView.findViewById(R.id.tvDepartment);
            tvWorkingDay = itemView.findViewById(R.id.tvWorkingDay);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}
