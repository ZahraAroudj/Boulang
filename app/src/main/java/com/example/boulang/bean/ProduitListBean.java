package com.example.boulang.bean;

import java.util.List;

public class ProduitListBean {
    private List<ProduitBean> listeProduits;

    /* -------------------------------------- */
    // Constructor
    /* -------------------------------------- */
    public ProduitListBean(List<ProduitBean> listeProduits) {
        this.listeProduits = listeProduits;
    }
    public ProduitListBean() {
    }

    /* -------------------------------------- */
    // Get/Set
    /* -------------------------------------- */
    public List<ProduitBean> getListeProduits() {
        return listeProduits;
    }
    public void setListeProduits(List<ProduitBean> listeProduits) {
        this.listeProduits = listeProduits;
    }

    /* -------------------------------------- */
    // toString
    /* -------------------------------------- */
    @Override
    public String toString() {
        return "ProduitListBean{" +
                "listeProduits=" + listeProduits +
                '}';
    }
}
