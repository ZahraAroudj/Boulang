package com.example.boulang.bean;

public class ContenirBean {
    private Integer produit_id;
    private int quantite;

    public ContenirBean(Integer produit_id, int quantite) {
        this.produit_id = produit_id;
        this.quantite = quantite;
    }

    public ContenirBean() {
    }

    public Integer getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(Integer produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "ContenirBean{" +
                "produit_id=" + produit_id +
                ", quantite=" + quantite +
                '}';
    }

    //    private ProduitBean produitBean;
//    private int quantite;
//
//    /* -------------------------------------- */
//    // Constructor
//    /* -------------------------------------- */
//    public ContenirBean(ProduitBean produitBean, int quantite) {
//        this.produitBean = produitBean;
//        this.quantite = quantite;
//    }
//    public ContenirBean() {
//    }
//
//    /* -------------------------------------- */
//    // Get/Set
//    /* -------------------------------------- */
//    public ProduitBean getProduitBean() {
//        return produitBean;
//    }
//    public void setProduitBean(ProduitBean produitBean) {
//        this.produitBean = produitBean;
//    }
//    public int getQuantite() {
//        return quantite;
//    }
//    public void setQuantite(int quantite) {
//        this.quantite = quantite;
//    }
//
//    /* -------------------------------------- */
//    // toString
//    /* -------------------------------------- */
//    @Override
//    public String toString() {
//        return "ContenirBean{" +
//                "produitBean=" + produitBean +
//                ", quantite=" + quantite +
//                '}';
//    }

}
