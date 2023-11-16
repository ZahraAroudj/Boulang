package com.example.boulang.bean;

import java.util.ArrayList;

public class ContenuCommandeBean {
    private CommandeBean commande;
    private ArrayList<ContenirBean> listeProduits;

    public ContenuCommandeBean(CommandeBean commande, ArrayList<ContenirBean> listeProduits) {
        this.commande = commande;
        this.listeProduits = listeProduits;
    }

    public ContenuCommandeBean() {
    }

    public CommandeBean getCommande() {
        return commande;
    }

    public void setCommande(CommandeBean commande) {
        this.commande = commande;
    }

    public ArrayList<ContenirBean> getListeProduits() {
        return listeProduits;
    }

    public void setListeProduits(ArrayList<ContenirBean> listeProduits) {
        this.listeProduits = listeProduits;
    }

    @Override
    public String toString() {
        return "ContenuCommandeBean{" +
                "commande=" + commande +
                ", listeProduits=" + listeProduits +
                '}';
    }
}
