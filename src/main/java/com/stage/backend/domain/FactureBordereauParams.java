package com.stage.backend.domain;


public class FactureBordereauParams {
    String idFacture;
    String idfactBord;
    String commentaire;
    String numFacture;
    public FactureBordereauParams(String idFacture, String idfactBord, String commentaire, String numFacture) {
        super();
        this.idFacture = idFacture;
        this.idfactBord = idfactBord;
        this.commentaire = commentaire;
        this.numFacture = numFacture;
    }
    public FactureBordereauParams() {
    }
    public String getIdFacture() {
        return idFacture;
    }
    public void setIdFacture(String idFacture) {
        this.idFacture = idFacture;
    }
    public String getIdfactBord() {
        return idfactBord;
    }
    public void setIdfactBord(String idfactBord) {
        this.idfactBord = idfactBord;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public String getNumFacture() {
        return numFacture;
    }
    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }
    @Override
    public String toString() {
        return "FactureBordereauParams [idFacture=" + idFacture + ", idfactBord=" + idfactBord + ", commentaire="
                + commentaire + ", numFacture=" + numFacture + "]";
    }
}
