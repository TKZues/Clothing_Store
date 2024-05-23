package com.example.trustsales.Fragment.Khachhang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trustsales.Data.Model.Model_khachhang;
import com.example.trustsales.Data.Model.Model_sanpham;
import com.example.trustsales.R;

import java.util.List;

public class AdapterCustomer extends RecyclerView.Adapter<AdapterCustomer.CustomerViewHolder> {
    private List<Model_khachhang> customerList;
    public AdapterCustomer(List<Model_khachhang> customerList) {
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_khachhang, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Model_khachhang customer = customerList.get(position);
        holder.tvnamecus.setText(customer.getNamecus());
        holder.tvaddresscus.setText(String.valueOf(customer.getAddresscus()));
        holder.tvdaycus.setText(customer.getDaycus());
        holder.tvgtcus.setText(String.valueOf(customer.getGender()));
        holder.tvphonecus.setText(customer.getPhonecus());
        holder.tvnotecus.setText(customer.getNotecus());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    protected class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView tvnamecus,tvaddresscus,tvdaycus,tvgtcus,tvphonecus,tvnotecus;
        public CustomerViewHolder(View view) {
            super(view);
            tvnamecus = itemView.findViewById(R.id.tvnamecus);
            tvaddresscus = itemView.findViewById(R.id.tvaddresscus);
            tvdaycus = itemView.findViewById(R.id.tvdaycus);
            tvgtcus = itemView.findViewById(R.id.tvgtcus);
            tvphonecus = itemView.findViewById(R.id.tvphonecus);
            tvnotecus = itemView.findViewById(R.id.tvnotecus);
        }
    }
}
