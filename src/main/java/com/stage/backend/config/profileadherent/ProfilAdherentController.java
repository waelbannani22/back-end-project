package com.stage.backend.config.profileadherent;

import com.stage.backend.web.soap.SoapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soapWs/profileAdherent")
public class ProfilAdherentController {

    SoapService soapservice ;
    ProfilAdherentService profiladherentservice;
    public ProfilAdherentController(ProfilAdherentService profiladherentservice,SoapService soapService) {
        this.soapservice=soapService;
        this.profiladherentservice=profiladherentservice;
    }




    // Ps request
    @RequestMapping(value = "/getContratAdherentByMatricule", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getContratAdherentByMatriculeData( @RequestParam(value = "matricule", required = false) String matricule, @RequestParam(value = "numPolice", required = false) String numPolice) {
        return profiladherentservice.getContratAdherentByMatricule(matricule,numPolice);
    }




}
