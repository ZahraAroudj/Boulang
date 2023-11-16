package com.example.boulang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.boulang.bean.ListeProduitsBean;
import com.example.boulang.bean.ProduitBean;
import com.example.boulang.bean.ProduitListBean;
import com.example.boulang.bean.RequestUtils;
import com.example.boulang.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProducts;
//    private ProductApi productApi;
    private ActivityMainBinding binding = null;

    private List<ProduitBean> myList;
    private ListeProduitsBean listeProduitsBean;
    private ProductAdapter productAdapter = new ProductAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerViewProducts = binding.recyclerViewProducts;
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(this,1));
        refreshList();



    }

    public void refreshList() {
        new Thread(() -> {
            System.out.println("refreshlist thread lancé");
            try {
                System.out.println("Le thread lance RequestUtils.getProduits");
                myList = RequestUtils.getProduits().getListe();
                System.out.println(myList.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        //RecyclerView
//        productAdapter.submitList(new ArrayList<>(myList));

    }





}

