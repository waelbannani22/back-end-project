package com.stage.backend.config.soap.reclamation;

import com.stage.backend.domain.ReclamationParams;
import com.stage.backend.domain.ValuesByCodeTypeAndValClmAndcodeTypeClm;
import com.stage.backend.web.soap.SoapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/soapWs")
public class ReclamationController {
    SoapService soapservice;
    ReclamationService reclamationService;

    //constructor Injection of services
    public ReclamationController(SoapService soapservice, ReclamationService reclamationService) {
        this.soapservice = soapservice;
        this.reclamationService = reclamationService;
    }

    //get reclamations
    @PostMapping(value = "/getListReclamationByMatricule", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getListReclamationByMatricule(@RequestBody ReclamationParams params) {
        return reclamationService.getListReclamationByMatricule(params);
    }
    //create reclamation
    @PostMapping(value = "/createReclamation",produces=MediaType.TEXT_PLAIN_VALUE)
    public String createReclamationData(
            @RequestPart(value = "byteFile", required = false) MultipartFile byteFile,
            @RequestParam(value = "nameFile", required = false) String nameFile,
            @RequestParam(value = "typeFile", required = false) String typeFile,
            @RequestParam(value = "matriculeAdherent", required = false) String matriculeAdherent,
            @RequestParam(value = "matriculePs", required = false) String matriculePs,
            @RequestParam(value = "numPolice", required = false) String numPolice,
            @RequestParam(value = "nomPs", required = false) String nomPs,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "entite", required = false) String entite,
            @RequestParam(value = "titre", required = false) String titre,
            @RequestParam(value = "nature", required = false) String nature,
            @RequestParam(value = "typeReclamation", required = false) String typeReclamation) throws IOException, IOException {
        return reclamationService.createReclamation(matriculeAdherent, matriculePs, numPolice, nomPs, description, byteFile, nameFile, typeFile, entite, titre, nature, typeReclamation);
    }

    @RequestMapping(value = "/getTableReferentielByCodeType", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTableReferentielByCodeTypeData(@RequestBody ValuesByCodeTypeAndValClmAndcodeTypeClm values) {
        return reclamationService.getTableReferentielByCodeType(values);
    }




}