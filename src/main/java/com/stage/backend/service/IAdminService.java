package com.stage.backend.service;

import com.stage.backend.entity.Pharmacien;

import java.util.List;

public interface IAdminService {

    List<Pharmacien> getPharmaciensNonVerfied();

    void acceptUsers(Long id);

}
