package com.example.boulang.bean;

import java.util.List;

public class CommandeBean {
    private int commande_id, commande_tel_client;
    private String commande_nom_client;
    private long commande_date;
    private List<ContenirBean> listeCommande;

    /* -------------------------------------- */
    // Constructor
    /* -------------------------------------- */
    public CommandeBean(int commande_id, String commande_nom_client, int commande_tel_client, long commande_date, List<ContenirBean> listeCommande) {
        this.commande_id = commande_id;
        this.commande_tel_client = commande_tel_client;
        this.commande_nom_client = commande_nom_client;
        this.commande_date = commande_date;
        this.listeCommande = listeCommande;
    }
    public CommandeBean() {
    }

    /* -------------------------------------- */
    // Get/Set
    /* -------------------------------------- */
    public int getCommande_id() {
        return commande_id;
    }
    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }
    public int getCommande_tel_client() {
        return commande_tel_client;
    }
    public void setCommande_tel_client(int commande_tel_client) {
        this.commande_tel_client = commande_tel_client;
    }
    public String getCommande_nom_client() {
        return commande_nom_client;
    }
    public void setCommande_nom_client(String commande_nom_client) {
        this.commande_nom_client = commande_nom_client;
    }
    public List<ContenirBean> getListeCommande() {
        return listeCommande;
    }
    public void setListeCommande(List<ContenirBean> listeCommande) {
        this.listeCommande = listeCommande;
    }
    public long getCommande_date() {
        return commande_date;
    }
    public void setCommande_date(long commande_date) {
        this.commande_date = commande_date;
    }

    /* -------------------------------------- */
    // toString
    /* -------------------------------------- */
    @Override
    public String toString() {
        return "CommandeBean{" +
                "commande_id=" + commande_id +
                ", commande_tel_client=" + commande_tel_client +
                ", commande_nom_client='" + commande_nom_client + '\'' +
                ", commande_date=" + commande_date +
                ", listeCommande=" + listeCommande +
                '}';
    }
}
