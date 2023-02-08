package com.stage.backend.controller;

import com.stage.backend.Dto.AuthRequest;
import com.stage.backend.entity.Pharmacien;
import com.stage.backend.repository.PharmacienRepository;
import com.stage.backend.service.IPharmarcienService;
import com.stage.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/register-pharmacien")
    @ResponseBody
    public Pharmacien addClient(@RequestBody Pharmacien c){

        return iPharmarcienService.registerPharmacien(c);

    }
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception {
        Pharmacien pharmacien = pharmacienRepository.findByEmail(authRequest.getEmail()).orElse(null);
        if(pharmacien==null){
            throw new Exception("user unknown");
        }else {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

            if(Objects.equals(pharmacien.getRole(), "ADMIN")){
                return jwtService.generateToken(authRequest.getEmail());
            }else {

                if (authentication.isAuthenticated()) {

                    if(pharmacien.getIsActivated()){
                        return jwtService.generateToken(authRequest.getEmail());
                    }else{
                        throw new Exception("user not verified");
                    }

                } else {
                    throw new UsernameNotFoundException("invalid user request !");
                }
            }



        }


    }

}
