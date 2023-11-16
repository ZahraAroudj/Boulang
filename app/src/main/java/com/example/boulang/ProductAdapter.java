package com.example.boulang;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boulang.bean.ContenirBean;
import com.example.boulang.bean.ProduitBean;
import com.example.boulang.databinding.ItemProductBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class ProductAdapter extends ListAdapter<ProduitBean, ProductAdapter.ViewHolder> {

    ArrayList<ProduitBean> list;
    ArrayList<ContenirBean> contenuCommande = new ArrayList<ContenirBean>();


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
        ProduitBean datum = getItem(position); //Le produit correspondant à la ligne
        Picasso.get().load(datum.getProduit_photo()).into(holder.binding.imageViewProduct);
        holder.binding.textViewTitle.setText(datum.getProduit_nom());
        holder.binding.textViewPrix.setText(datum.getProduit_prix().toString() + " €");
        holder.binding.textViewDescription.setText(datum.getProduit_description());
        AtomicInteger count = new AtomicInteger(0);

        //récupératrion donnée de la ligne
        contenuCommande.add(new ContenirBean(datum.getProduit_id(), 0));

        holder.binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count.get() > 0) {
                    count.decrementAndGet();
                }
                holder.binding.textViewCount.setText(String.valueOf(count.get()));
                contenuCommande.get(holder.getLayoutPosition()).setQuantite(count.intValue());
            }
        });

        holder.binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.incrementAndGet();
                holder.binding.textViewCount.setText(String.valueOf(count.get()));
                contenuCommande.get(holder.getLayoutPosition()).setQuantite(count.intValue());
            }
        });
    }
//    @Override
//    public int getItemCount() {
//        return.parent.size();
//    }
}


