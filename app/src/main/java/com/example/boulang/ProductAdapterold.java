package com.example.boulang;

import android.view.LayoutInflater;

import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.example.boulang.bean.ProduitBean;
import com.example.boulang.databinding.ItemProductBinding;


public class ProductAdapterold extends ListAdapter<ProduitBean, ProductAdapterold.ViewHolder> {
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

    public ProductAdapterold() {
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


//            buttonMinus = itemView.findViewById(R.id.buttonMinus);
//            buttonPlus = itemView.findViewById(R.id.buttonPlus);
//            textViewCount = itemView.findViewById(R.id.textViewCount);

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
