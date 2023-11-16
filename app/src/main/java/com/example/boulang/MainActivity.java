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
    private ActivityMainBinding binding = null;

    private List<ProduitBean> myList;
    ArrayList<ProduitBean> fakeList = new ArrayList<ProduitBean>();

    private ProductAdapter productAdapter = new ProductAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        productAdapter = new ProductAdapter();
        binding.recyclerViewProducts.setAdapter(productAdapter);

        new Thread(() -> {
            System.out.println("refreshlist thread lancé");
            try {
//                System.out.println("Le thread lance RequestUtils.getProduits");
                ArrayList<ProduitBean> myList = RequestUtils.getProduits();

                //RecyclerView
                if (myList != null) {
                    runOnUiThread(() -> {
                        binding.recyclerViewProducts.setAdapter(productAdapter);
                        binding.recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
                        productAdapter.submitList(myList);
                    });
                }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }).start();


//        refreshList();

//        ProduitBean p1 = new ProduitBean(1, "pain1", "urlbidon", "description1", 1.50 );
//        ProduitBean p2 = new ProduitBean(2, "pain2", "urlbidon", "description2", 1.60 );
//        ProduitBean p3 = new ProduitBean(3, "pain3", "urlbidon", "description3", 1.70 );
//        fakeList.add(p1);
//        fakeList.add(p2);
//        fakeList.add(p3);
//        System.out.println("fakelist" + fakeList);
//        productAdapter.submitList(fakeList);

    }

//    public void refreshList() {
//        new Thread(() -> {
//            System.out.println("refreshlist thread lancé");
//            try {
//                System.out.println("Le thread lance RequestUtils.getProduits");
//                ArrayList<ProduitBean> myList = RequestUtils.getProduits();
//                //RecyclerView
//                runOnUiThread(() -> {
//                    productAdapter.submitList(myList);
////                    productAdapter.submitList(fakeList);
//
//                });
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        }).start();
//
//
//
//    }





}

