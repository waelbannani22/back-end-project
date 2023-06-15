package com.stage.backend.domain;

public class ReclamationParams {
    String idReclamation;
    String dateMinRec;
    String dateMaxRec;
    String numReclamtion;
    String entite; // 0 || 1
    String numPolice;
    String nomPS;
    String typeRecl;
    String nature;
    String staut;
    String page;
    String pageSize;
    String matriculeAdherent;
    String matriculePs;
    public ReclamationParams() {
    }
    public ReclamationParams(String idReclamation, String dateMinRec, String dateMaxRec, String numReclamtion,
                             String entite, String numPolice, String nomPS, String typeRecl, String nature, String staut, String page,
                             String pageSize, String matriculeAdherent, String matriculePs) {
        super();
        this.idReclamation = idReclamation;
        this.dateMinRec = dateMinRec;
        this.dateMaxRec = dateMaxRec;
        this.numReclamtion = numReclamtion;
        this.entite = entite;
        this.numPolice = numPolice;
        this.nomPS = nomPS;
        this.typeRecl = typeRecl;
        this.nature = nature;
        this.staut = staut;
        this.page = page;
        this.pageSize = pageSize;
        this.matriculeAdherent = matriculeAdherent;
        this.matriculePs = matriculePs;
    }
    public String getIdReclamation() {
        return idReclamation;
    }
    public void setIdReclamation(String idReclamation) {
        this.idReclamation = idReclamation;
    }
    public String getDateMinRec() {
        return dateMinRec;
    }
    public void setDateMinRec(String dateMinRec) {
        this.dateMinRec = dateMinRec;
    }
    public String getDateMaxRec() {
        return dateMaxRec;
    }
    public void setDateMaxRec(String dateMaxRec) {
        this.dateMaxRec = dateMaxRec;
    }
    public String getNumReclamtion() {
        return numReclamtion;
    }
    public void setNumReclamtion(String numReclamtion) {
        this.numReclamtion = numReclamtion;
    }
    public String getEntite() {
        return entite;
    }
    public void setEntite(String entite) {
        this.entite = entite;
    }
    public String getNumPolice() {
        return numPolice;
    }
    public void setNumPolice(String numPolice) {
        this.numPolice = numPolice;
    }
    public String getNomPS() {
        return nomPS;
    }
    public void setNomPS(String nomPS) {
        this.nomPS = nomPS;
    }
    public String getTypeRecl() {
        return typeRecl;
    }
    public void setTypeRecl(String typeRecl) {
        this.typeRecl = typeRecl;
    }
    public String getNature() {
        return nature;
    }
    public void setNature(String nature) {
        this.nature = nature;
    }
    public String getStaut() {
        return staut;
    }
    public void setStaut(String staut) {
        this.staut = staut;
    }
    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getPageSize() {
        return pageSize;
    }
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
    public String getMatriculeAdherent() {
        return matriculeAdherent;
    }
    public void setMatriculeAdherent(String matriculeAdherent) {
        this.matriculeAdherent = matriculeAdherent;
    }
    public String getMatriculePs() {
        return matriculePs;
    }
    public void setMatriculePs(String matriculePs) {
        this.matriculePs = matriculePs;
    }
    @Override
    public String toString() {
        return "ReclamationParams [idReclamation=" + idReclamation + ", dateMinRec=" + dateMinRec + ", dateMaxRec="
                + dateMaxRec + ", numReclamtion=" + numReclamtion + ", entite=" + entite + ", numPolice=" + numPolice
                + ", nomPS=" + nomPS + ", TypeRecl=" + typeRecl + ", nature=" + nature + ", staut=" + staut + ", page="
                + page + ", pageSize=" + pageSize + ", matriculeAdherent=" + matriculeAdherent + ", matriculePs="
                + matriculePs + "]";
    }
}

