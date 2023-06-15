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
    private String ecart;
    private String natureVerres;
    private String typesVerres;
    private String colorverres;
    private String traitementVerres;
    private String verresSpec;


}
