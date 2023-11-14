package com.example.boulang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);


        // Initialisez la liste des produits
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(R.drawable.paindecampagne, "Pain de campagne", "2euros"));
        productList.add(new Product(R.drawable.bread, "Bread", "1euros"));
        productList.add(new Product(R.drawable.bag, "Baguette", "0euros90"));
        productList.add(new Product(R.drawable.painnoix, "Pain noix", "2euros20"));
        productList.add(new Product(R.drawable.raison, "Pain Raison", "2euros90"));
        // Ajoutez d'autres produits à la liste si nécessaire

        // Initialisez l'adaptateur avec la liste des produits
        productAdapter = new ProductAdapter(productList);

        // Configurez le RecyclerView avec un gestionnaire de disposition (LayoutManager) et l'adaptateur ProductAdapter
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProducts.setAdapter(productAdapter);
    }


}
