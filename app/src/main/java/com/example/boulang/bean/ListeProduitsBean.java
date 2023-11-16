package com.example.boulang.bean;

import java.util.ArrayList;
import java.util.List;

public class ListeProduitsBean {
    private List<ProduitBean> liste;

    public ListeProduitsBean(List<ProduitBean> liste) {
        this.liste = liste;
    }

    public ListeProduitsBean() {
    }

    public List<ProduitBean> getListe() {
        return liste;
    }

    public void setListe(List<ProduitBean> liste) {
        this.liste = liste;
    }

    @Override
    public String toString() {
        return "ListeProduitsBean{" +
                "liste=" + liste +
                '}';
    }
}
