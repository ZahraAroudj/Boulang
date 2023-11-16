package com.example.boulang.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestUtils {

    /* -------------------------------------- */
    // sendGet
    /* -------------------------------------- */
    public static String sendGet(String url) throws Exception {
        System.out.println("senGet se lance avec GET url : " + url);
        OkHttpClient client = new OkHttpClient();

        //Création de la requête
        Request request = new Request.Builder().url(url).build();

        //Le try-with ressource doc ici
        //Nous permet de fermer la réponse en cas de succès ou d'échec (dans le finally)
        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                if(!response.body().toString().isEmpty()){
                    ErrorMessageBean errorMessage = new Gson().fromJson(response.body().string(), ErrorMessageBean.class);
                    throw new IOException("Error code : " + errorMessage.getCod()+ " => " + errorMessage.getMessage());
                }
            }
            return response.body().string();
        }
    }

    /* -------------------------------------- */
    // sendPost
    /* -------------------------------------- */
    public static String sendPost(String url, String jsonAEnvoyer ) throws Exception {
        System.out.println("RequestUtils POST url : " + url);
        OkHttpClient client = new OkHttpClient();

        //Corps de la requête
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonAEnvoyer);

        //Création de la requête
        Request request = new Request.Builder().url(url).post(body).build();

        //Le try-with ressource doc ici
        //Nous permet de fermer la réponse en cas de succès ou d'échec (dans le finally)
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public static ArrayList<ProduitBean> getProduits() throws Exception {

        System.out.println("GetProduits se lance et lance sendget");
        String json = sendGet("http://90.55.230.244:8080/getProduits");

        System.out.println("Le Json est récupéré dans GetProduits");
        System.out.println(json);
        Gson gson = new Gson();
        ArrayList<ProduitBean> liste = gson.fromJson(json, new TypeToken<List<ProduitBean>>(){}.getType());
        System.out.println(liste);

        return liste;

    }
}
