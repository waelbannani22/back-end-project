package com.stage.backend.controller;

import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PharmacienRepository;
import com.stage.backend.service.EmailService;
import com.stage.backend.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("*")
public class AdminController {

    private final PharmacienRepository pharmacienRepository;

    @Autowired
    private EmailService emailService;


    private final IAdminService iAdminService;

    public AdminController(PharmacienRepository pharmacienRepository,IAdminService iAdminService) {
        this.pharmacienRepository = pharmacienRepository;
        this.iAdminService = iAdminService;
    }

    @GetMapping("/getAllPharmacienNonVerified")
    public List<Pharmacien> getAllPharmacist(){
        return pharmacienRepository.getAllPharamcien();
    }


    @PostMapping("/AcceptPharamacien/{id}")
    public ResponseEntity<?> acceptPharamcien(@PathVariable Long id){

        try {
            iAdminService.acceptUsers(id);
            return ResponseEntity.status(200).body("pharmacien accepted");
        }catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
            return ResponseEntity.status(404).body("error occured");
        }

    }
    @PostMapping("/DeclinePharamacien")
    public ResponseEntity<?> declinePharamcien(Pharmacien pharmacien){
        pharmacien.setIsActivated(false);
        pharmacienRepository.save(pharmacien);
        return ResponseEntity.status(200).body("pharmacien declined");
    }
}
