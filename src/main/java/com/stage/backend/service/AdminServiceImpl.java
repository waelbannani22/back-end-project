package com.stage.backend.service;

import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PharmacienRepository;
import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    PharmacienRepository pharmacienRepository;


    @Override
    public List<Pharmacien> getPharmaciensNonVerfied() {
        return null;
    }

    @Override
    public void acceptUsers(Long id) {
            try {
             Optional<Pharmacien> p= pharmacienRepository.findById(id);
                if (p.isPresent()) {
                   p.get().setIsActivated(true);
                   pharmacienRepository.save(p.get());
                }
            }catch (Exception e){
                System.out.println("An error occurred: " + e.getMessage());
            }
    }



}
