package com.stage.backend.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginationParams {
    String id;
    String type;
    String statut;
    String dateDebut;
    String dateFin;
    String page;
    String pagesize;
    String idPs;
    String idBenef;
}
