package com.example.boulang.bean;

public class ContenirBean {
    private ProduitBean produitBean;
    private int quantite;

    /* -------------------------------------- */
    // Constructor
    /* -------------------------------------- */
    public ContenirBean(ProduitBean produitBean, int quantite) {
        this.produitBean = produitBean;
        this.quantite = quantite;
    }
    public ContenirBean() {
    }

    /* -------------------------------------- */
    // Get/Set
    /* -------------------------------------- */
    public ProduitBean getProduitBean() {
        return produitBean;
    }
    public void setProduitBean(ProduitBean produitBean) {
        this.produitBean = produitBean;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /* -------------------------------------- */
    // toString
    /* -------------------------------------- */
    @Override
    public String toString() {
        return "ContenirBean{" +
                "produitBean=" + produitBean +
                ", quantite=" + quantite +
                '}';
    }

}
