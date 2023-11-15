package com.example.boulang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.boulang.bean.ProduitBean;
import com.example.boulang.bean.ProduitListBean;
import com.example.boulang.bean.RequestUtils;

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
    private ProductAdapter productAdapter;
    private ProductApi productApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);

        // Initialisez la liste des produits
        ProduitListBean productList = new ProduitListBean;
        try {
            productList = RequestUtils.getProduits();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // Initialisez l'adaptateur avec la liste des produits
        productAdapter = new ProductAdapter(productList);

        // Configurez le RecyclerView avec un gestionnaire de disposition (LayoutManager) et l'adaptateur ProductAdapter
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProducts.setAdapter(productAdapter);

        // Initialisez Retrofit et l'API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://90.55.230.244:8080/GetProduits/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productApi = retrofit.create(ProductApi.class);
    }

    public void addProduct() {
//        Product product = new Product(1, "Product 1", "photo1.jpg", "Description of product 1", 10.0);
//        Call<Product> call = productApi.addProduct(product);
//
//        call.enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                if (response.isSuccessful()) {
//                    // Handle successful response
//                } else {
//                    // Handle error response
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                // Handle failure
//            }
//        });
    }

    public void deleteProduct() {
//        Call<Void> call = productApi.deleteProduct(1);
//
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    // Handle successful response
//                } else {
//                    // Handle error response
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                // Handle failure
//            }
//        });
    }

    public void updateProduct() {
//        Product updatedProduct = new Product(1, "Updated Product 1", "photo1_updated.jpg", "Updated description of product 1", 15.0);
//        Call<Product> call = productApi.updateProduct(1, updatedProduct);
//
//        call.enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                if (response.isSuccessful()) {
//                    // Handle successful response
//                } else {
//                    // Handle error response
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                // Handle failure
//            }
//        });
    }

    //public List<ProduitBean> getProduits() {
   //    List<ProduitBean> call = productApi.getProduct();

       /*call.enqueue(new Callback<ProduitBean>() {
            @Override
            public void onResponse(Call<ProduitBean> call, Response<ProduitBean> response) {
                if (response.isSuccessful()) {
                    ProduitBean product = response.body();
                    // Handle successful response
                } else {
                    // Handle error response
                }
            }

            @Override
            public void onFailure(Call<ProduitBean> call, Throwable t) {
                // Handle failure
            }*/
//                return call;
       // });
    //}

    public interface ProductApi {
        @POST("products")
        Call<ProduitBean> addProduct(@Body ProduitBean product);

        @DELETE("products/{id}")
        Call<Void> deleteProduct(@Path("id") int id);

        @PUT("products/{id}")
        Call<ProduitBean> updateProduct(@Path("id") int id, @Body ProduitBean product);

        @GET("products/{id}")
        Call<ProduitBean> getProduct(@Path("id") int id);

        @GET("produits/")
        Call<List<ProduitBean>> getProduct();
    }
}

