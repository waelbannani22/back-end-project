package com.stage.backend.config.profileadherent.soap.verifierMedicament;

import com.stage.backend.web.soap.SoapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soapWs/VerifMed")
public class VerifierMedicamentController {

    SoapService soapservice;
    VerifierMedicamentService verifiermedicamentservice;

    public VerifierMedicamentController(VerifierMedicamentService verifiermedicamentservice, SoapService soapService) {
        this.soapservice = soapService;
        this.verifiermedicamentservice = verifiermedicamentservice;
    }

    @RequestMapping(value = "/getListActesPhar", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getListActesPharData(@RequestParam(value = "codeActe", required = false) String codeActe,
                                       @RequestParam(value = "numPolice", required = false) String numPolice) {
        return verifiermedicamentservice.getListActesPhar(codeActe,numPolice);
    }
}
