package com.stage.backend.service;

import com.stage.backend.entity.Pharmacien;
import org.springframework.stereotype.Service;



public interface IPharmarcienService {

    Pharmacien registerPharmacien(Pharmacien pharmacien);

    void approveUser(Long idpharmacien);

    void blockUser(Long idpharmacien);

    void updatePharmacien(Pharmacien pharmacien);
}
