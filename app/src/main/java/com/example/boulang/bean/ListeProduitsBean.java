package com.example.boulang.bean;

import java.util.ArrayList;

public class ListeProduitsBean {
    private ArrayList<ProduitBean> liste;

    public ListeProduitsBean(ArrayList<ProduitBean> liste) {
        this.liste = liste;
    }

    public ListeProduitsBean() {
    }

    public ArrayList<ProduitBean> getListe() {
        return liste;
    }

    public void setListe(ArrayList<ProduitBean> liste) {
        this.liste = liste;
    }

    @Override
    public String toString() {
        return "ListeProduitsBean{" +
                "liste=" + liste +
                '}';
    }
}
