package com.example.trustsales.Fragment.Sanpham;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trustsales.Data.Model.Model_sanpham;
import com.example.trustsales.R;
import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder> {

    private List<Model_sanpham> productList;

    public AdapterProduct(List<Model_sanpham> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_sanpham, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Model_sanpham product = productList.get(position);
        holder.tvProductName.setText(product.getTensp());
        holder.tvProductPrice.setText(String.valueOf(product.getGia()));
        holder.tvProductCategory.setText(product.getMaloai());
        holder.tvProductID.setText(String.valueOf(product.getId()));
        holder.tvProductUnit.setText(product.getDonvi());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProductName, tvProductPrice, tvProductCategory,tvProductID, tvProductUnit;

        public ProductViewHolder(View view) {
            super(view);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvProductCategory = itemView.findViewById(R.id.tvProductCategory);
            tvProductID = itemView.findViewById(R.id.tvProductID);
            tvProductUnit = itemView.findViewById(R.id.tvProductUnit);
        }
    }
}
