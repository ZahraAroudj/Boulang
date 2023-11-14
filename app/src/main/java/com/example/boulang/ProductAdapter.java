package com.example.boulang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boulang.Product;
import com.example.boulang.R;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewTitle;
        TextView textViewDescription;
        Button buttonMinus;
        Button buttonPlus;
        TextView textViewCount;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            buttonMinus = itemView.findViewById(R.id.buttonMinus);
            buttonPlus = itemView.findViewById(R.id.buttonPlus);
            textViewCount = itemView.findViewById(R.id.textViewCount);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.imageViewProduct.setImageResource(product.getImageResource());
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDescription.setText(product.getDescription());

        AtomicInteger count = new AtomicInteger(0);

        holder.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count.get() > 0) {
                    count.decrementAndGet();
                }
                holder.textViewCount.setText(String.valueOf(count.get()));
            }
        });

        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.incrementAndGet();
                holder.textViewCount.setText(String.valueOf(count.get()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}