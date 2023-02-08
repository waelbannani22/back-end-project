package com.stage.backend.service;

import com.stage.backend.entity.Pharmacien;


public interface IPharmarcienService {

    Pharmacien registerPharmacien(Pharmacien pharmacien);

    void approveUser(Long idpharmacien);

    void blockUser(Long idpharmacien);
}
