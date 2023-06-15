package com.stage.backend.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LigneFacture {

    private String idMedecin;


    private String idBeneficiare;


    private String idAdherent;


    private String matriculeAdherent;


    private String dateVisite;


    private String ticketModerateur;


    private String mntRestePayer;


    private String idTiers;


    private String nid;


    private String totalOrdenance;


    private String dateConsultation;


    private String totalMedRemboursable;


    private String totalMedNonRemboursable;


    private String nbreCoatationB;


    private String nbreCoatationABP;


    private String nbreCoatation;


    private String cleCotation;


    private String typePrestation;


    private String commentaire;


    private String natureTransaction;


    private String reference;

    private String natureActe;

    private int statut = 1; // validé ou bien refusé : (circuit mixte)

    private String nomMedecin; // nom du medecin : (circuit mixte)

    private String traitePar; // traité par

    private String user;

    private String  contractant;

    private String idPrestation;
}
