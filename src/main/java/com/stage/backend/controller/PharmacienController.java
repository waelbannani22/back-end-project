package com.stage.backend.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.fabric.Response;
import com.stage.backend.Dto.AuthRequest;
import com.stage.backend.entity.EmailDetails;
import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PharmacienRepository;
import com.stage.backend.service.EmailService;
import com.stage.backend.service.IPharmarcienService;
import com.stage.backend.service.JwtService;
import jakarta.persistence.EntityManager;
import lombok.NonNull;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/Pharmacien")
@CrossOrigin("*")
public class PharmacienController {

    @Autowired
    private IPharmarcienService iPharmarcienService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PharmacienRepository pharmacienRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('PHARMACIEN')")
    public String welcome() {
        return "Welcome pharcamcien";
    }

    @GetMapping("/welcomeADMIN")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String welcomeAdmin() {
        return "Welcome ADMIN";
    }


    @PostMapping(value = "/register-pharmacien",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addClient( @RequestBody Pharmacien pharmacien){
        EmailDetails details = new EmailDetails();
        details.setRecipient(pharmacien.getEmail());
        details.setSubject("account created");
        details.setAttachment("");
        System.out.println(pharmacien.getEmail());
        if(Objects.equals(pharmacien.getRole(), "ADMIN")){
            iPharmarcienService.registerPharmacien(pharmacien);
            details.setMsgBody("admin account created");
            String status=emailService.sendSimpleMail(details);
            System.out.println(status);
           return ResponseEntity.status(200).body("admin created");
        }else{
            if (pharmacienRepository.existsByEmail(pharmacien.getEmail())) {

                return ResponseEntity
                        .badRequest()
                        .body("email exists");
            }
            iPharmarcienService.registerPharmacien(pharmacien);
            details.setMsgBody("pharmacien account created,just wait for the admin to approuve your account");

            String status=emailService.sendSimpleMail(details);
            System.out.println(status);
            return ResponseEntity.status(200).body("pharmacien created");
        }
    }
    @PostMapping(value="/authenticate",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception {
        Pharmacien pharmacien = pharmacienRepository.findByEmail(authRequest.getEmail()).orElse(null);
        if(pharmacien==null){
           return  ResponseEntity.status(404).body("user non found !");
        }else {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //*******ADMIN******************
            if(Objects.equals(pharmacien.getRole(), "ADMIN")){
                String jwt = jwtService.generateToken(authRequest.getEmail());
                //jwtService.generateToken(String.valueOf(authentication));
                HashMap<String, Object > map = new HashMap<>();
                map.put("success",true);
                map.put("token",jwt);
                map.put("user", pharmacien);
                return ResponseEntity.status(200).body(map);

            }else {
            //********PHARMACIEN****************
                if (authentication.isAuthenticated()) {

                    if(pharmacien.getIsActivated()){
                        String jwt= jwtService.generateToken(authRequest.getEmail());
                        HashMap<String, Object > map = new HashMap<>();
                        map.put("success",true);
                        map.put("token",jwt);
                        map.put("user", pharmacien);
                        return ResponseEntity.status(200).body(map);
                    }else{
                        HashMap<String, Object > map = new HashMap<>();
                        map.put("success",false);
                        map.put("message","user not verified!");
                        return ResponseEntity.status(405).body(map);
                    }

                } else {
                    return ResponseEntity.badRequest().body("check your credentials");
                }

            }
        }
    }

    @PostMapping("/approuveUser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void  approuveUser(@RequestHeader("id") Long id){

        iPharmarcienService.approveUser(id);
        System.out.println("approved");

    }
    @PostMapping("/block-user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void  blockUser(@RequestHeader("id") Long id){

        iPharmarcienService.blockUser(id);
        System.out.println("blocked");

    }
    @PutMapping("/update-pharmacien")
    @PreAuthorize("hasAuthority('PHARMACIEN')")
    public ResponseEntity<?> updatePharmacien(@RequestBody Pharmacien pharmacien){
        iPharmarcienService.updatePharmacien(pharmacien);
        HashMap<String, Object > map = new HashMap<>();
        map.put("success",true);
        map.put("user", pharmacien);
        return ResponseEntity.status(200).body(map);
    }


}
