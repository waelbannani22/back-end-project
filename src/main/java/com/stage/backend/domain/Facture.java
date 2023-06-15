package com.stage.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    private  long idPs;
    private  double montantFacture;
    private  String numFacture;
    private  String dateFacture;
    private  String idfactBord;
    private  String commentaire;
    private  String numPolice;
}
