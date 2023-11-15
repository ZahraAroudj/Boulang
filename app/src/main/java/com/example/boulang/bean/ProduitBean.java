package com.example.boulang.bean;

public class ProduitBean {
    private int produit_id;
    private String produit_nom, produit_photo, produit_description;
    private Double produit_prix;

    /* -------------------------------------- */
    // Constructor
    /* -------------------------------------- */
    public ProduitBean(int produit_id, String produit_nom, String produit_photo, String produit_description, Double produit_prix) {
        this.produit_id = produit_id;
        this.produit_nom = produit_nom;
        this.produit_photo = produit_photo;
        this.produit_description = produit_description;
        this.produit_prix = produit_prix;
    }
    public ProduitBean() {
    }

    /* -------------------------------------- */
    // Get/Set
    /* -------------------------------------- */
    public int getProduit_id() {
        return produit_id;
    }
    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
    public String getProduit_nom() {
        return produit_nom;
    }
    public void setProduit_nom(String produit_nom) {
        this.produit_nom = produit_nom;
    }
    public String getProduit_photo() {
        return produit_photo;
    }
    public void setProduit_photo(String produit_photo) {
        this.produit_photo = produit_photo;
    }
    public String getProduit_description() {
        return produit_description;
    }
    public void setProduit_description(String produit_description) {
        this.produit_description = produit_description;
    }
    public Double getProduit_prix() {
        return produit_prix;
    }
    public void setProduit_prix(Double produit_prix) {
        this.produit_prix = produit_prix;
    }

    /* -------------------------------------- */
    // toString
    /* -------------------------------------- */
    @Override
    public String toString() {
        return "ProduitBean{" +
                "produit_id=" + produit_id +
                ", produit_nom='" + produit_nom + '\'' +
                ", produit_photo='" + produit_photo + '\'' +
                ", produit_texte='" + produit_description + '\'' +
                ", produit_prix=" + produit_prix +
                '}';
    }
}
