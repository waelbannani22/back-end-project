package com.stage.backend.SoapClasses;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name="getListReclamationByMatriculeResponse",namespace = "http://ws.meg.tn")

public class ReclamationDto {
    private TableReferentielDto canalReclamation;
    private String concerrne;
    private String dateCreation;
    private String dateDebut;
    private String dateFin;
    private String dateModification;
    private String descreptionReclamation;
    private String entite;
    private int id;
    private String justificatif;
    private String maticulePs;
    private String matriculeAdherent;
    private String motif;
    private String natureReclamation;
    private String nomJSP;
    private String noteMotif;
    private String numeroReclamation;
    private String objetReclamation;
    private PersonnePhysiqueDto personnePhysiqueDto;

    // getters and setters for all fields
}
