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
import android.widget.Toast;

import com.example.boulang.bean.CommandeBean;
import com.example.boulang.bean.ContenirBean;
import com.example.boulang.bean.ListeProduitsBean;
import com.example.boulang.bean.ProduitBean;
import com.example.boulang.bean.ProduitListBean;
import com.example.boulang.bean.RequestUtils;
import com.example.boulang.databinding.ActivityMainBinding;
import com.google.gson.Gson;

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

        binding.buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editTextName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nom absent", Toast.LENGTH_SHORT).show();
                } else if (binding.editTextPhone.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Téléphone absent", Toast.LENGTH_SHORT).show();
                } else if (productAdapter.contenuCommande.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Aucun produit ajouté", Toast.LENGTH_SHORT).show();
                }  else {
                    //tout test ok on enregistre
                    CommandeBean commandeBean = new CommandeBean(-1, binding.editTextName.getText().toString(), Integer.parseInt(binding.editTextPhone.getText().toString()), 01012001);
                    System.out.println(commandeBean); //ok
                    System.out.println(productAdapter.contenuCommande); //ok
                    new Thread(() -> {
                        try {
                            RequestUtils.sendCommande(commandeBean, productAdapter.contenuCommande);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }).start();

                }


            }
        });



    }

}

