package com.stage.backend.SoapClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.StringReader;


//@JsonIgnoreProperties(ignoreUnknown = true)
public class ReclamationResponse {
    @JacksonXmlProperty(localName = "return")
    private ReclamationDto returnDto;

    @JacksonXmlProperty(localName = "contextLPResult")
    private String contextLPResult;

    public ReclamationDto getReturnDto() {
        return returnDto;
    }

    public void setReturnDto(ReclamationDto returnDto) {
        this.returnDto = returnDto;
    }

    public static ReclamationResponse fromXml(String xml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, ReclamationResponse.class);
    }
}


class TableReferentielDto {
    private String codeRubrique;
    private int id;
    private String langue;
    private String libelle;
    private TableReferentielDto statut;
    private TypeReferentielDto type;
    private String valeur1;
    private String valeur2;
    private String valeurLM;

    // getters and setters for all fields
}


class TypeReferentielDto {
    private String codeType;
    private String description;
    private int id;
    private String mere;
    private String nature;
    private String nomStatut;
    private String statut;

    // getters and setters for all fields
}


class PersonnePhysiqueDto {
    private String adressPrincipal;
    private String civilite;
    private String codePostal;
    private String dateNaissance;
    private String email;
    private String fax;
    private String id;
    private String mobile;
    private String nom;
    private String prenom;
    private String raisonSociale;
    private String region;
    private String tel;
    private String type;


    // getters and setters for all fields
}
