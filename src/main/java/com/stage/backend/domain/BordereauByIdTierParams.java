package com.stage.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BordereauByIdTierParams {
    private String idTiers;
    private String numPolice;
    private int page;
    private int pagesize;
    private String nature;
    private String dateFin;
    private String refFact;
    private String natureDent;
    private String dateDeb;
    private String type;
}
