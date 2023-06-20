package com.stage.backend.service;

import com.stage.backend.entity.ActeOptique;

import java.util.List;
import java.util.Optional;

public interface ActeOptiqueService {
    ActeOptique addActe(ActeOptique acteOptique);

    ActeOptique updateActe(Long id , ActeOptique acteOptique);

    void deleteActe(Long id);

    List<ActeOptique> getAllActes();

    Optional<ActeOptique> getActe(Long id);
    List <ActeOptique>getListActeByMatricule(String id);
}
