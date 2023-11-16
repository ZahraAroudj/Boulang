package com.example.boulang;

import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.example.boulang.bean.ProduitBean;
import com.example.boulang.databinding.ItemProductBinding;


public class ProductAdapter extends ListAdapter<ProduitBean, ProductAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder {

        ItemProductBinding binding;
        public ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class Comparator extends DiffUtil.ItemCallback<ProduitBean> {

        @Override
        public boolean areItemsTheSame(@NonNull ProduitBean oldItem, @NonNull ProduitBean newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ProduitBean oldItem, @NonNull ProduitBean newItem) {
            return false;
        }
    }

    public ProductAdapter() {
        super(new Comparator());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new ViewHolder(ItemProductBinding.inflate(li));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProduitBean datum = getItem(position);
//        holder.binding.imageViewProduct.setImageResource(datum.getProduit_photo().toString());
        holder.binding.textViewTitle.setText(datum.getProduit_nom());
        holder.binding.textViewDescription.setText(datum.getProduit_description());


    }


}




//public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
//    private ListeProduitsBean productList;
//
//    public ProductAdapter(ListeProduitsBean productList) {
//        this.productList = productList;
//    }
//
//    public static class ProductViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageViewProduct;
//        TextView textViewTitle;
//        TextView textViewDescription;
//        Button buttonMinus;
//        Button buttonPlus;
//        TextView textViewCount;
//
//        public ProductViewHolder(View itemView) {
//            super(itemView);
//            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
//            textViewTitle = itemView.findViewById(R.id.textViewTitle);
//            textViewDescription = itemView.findViewById(R.id.textViewDescription);
//            buttonMinus = itemView.findViewById(R.id.buttonMinus);
//            buttonPlus = itemView.findViewById(R.id.buttonPlus);
//            textViewCount = itemView.findViewById(R.id.textViewCount);
//        }
//    }
//
//    @NonNull
//    @Override
//    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
//        return new ProductViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
//        ProduitBean product = productList.getListe().get(position);
//       // holder.imageViewProduct.setImageResource(product.getProduit_photo().toString();
//        holder.textViewTitle.setText(product.getProduit_nom());
//        holder.textViewDescription.setText(product.getProduit_description());
//
//        AtomicInteger count = new AtomicInteger(0);
//
//        holder.buttonMinus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (count.get() > 0) {
//                    count.decrementAndGet();
//                }
//                holder.textViewCount.setText(String.valueOf(count.get()));
//            }
//        });
//
//        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count.incrementAndGet();
//                holder.textViewCount.setText(String.valueOf(count.get()));
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return productList.getListe().size();
//    }
//}
