package com.stage.backend.service;

import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PharmacienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PharmacienService  implements IPharmarcienService{
    @Autowired
    PharmacienRepository pharmacienRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Pharmacien registerPharmacien(Pharmacien pharmacien) {

       pharmacien.setPassword(passwordEncoder.encode(pharmacien.getPassword()));

       return pharmacienRepository.save(pharmacien);

    }
}
