package com.stage.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ActeOptique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String nature;
    private String type;
    private String qte;
    private String ogod;
    private int mntDepense=0;
    private int mntRevise=0;
    private int decompteRO=0;
    private String nomPs;
    private String matriculeAdherent;
    //suppl
    private String ecart;
    private String natureVerres;
    private String typesVerres;
    private String colorverres;
    private String traitementVerres;
    private String verresSpec;
    //vision loin og
    private int logs;
    private int logc;
    private int loga=0;
    //vision loin od
    private int lods=0;
    private int lodc=0;
    private int loda=0;
    //vision pres og
    private int pods=0;
    private int podc=0;
    private int poda=0;
    //vision pres od
    private int pogs=0;
    private int pogc=0;
    private int poga=0;



}
