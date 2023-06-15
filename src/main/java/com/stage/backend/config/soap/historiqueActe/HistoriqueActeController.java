package com.stage.backend.config.soap.historiqueActe;

import com.stage.backend.domain.BordereauByIdTierParams;
import com.stage.backend.domain.Facture;
import com.stage.backend.domain.FactureBordereauParams;
import com.stage.backend.web.soap.SoapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/Historique")
public class HistoriqueActeController {

    SoapService soapservice;
    HistoriqueActeService historiqueacteservice;

    public HistoriqueActeController(HistoriqueActeService historiqueacteservice, SoapService soapService) {
        this.soapservice = soapService;
        this.historiqueacteservice = historiqueacteservice;
    }

    @RequestMapping(value = "/getFactureBordereauByIdTier", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFactureBordereauByIdTierData(@RequestBody BordereauByIdTierParams bordereaubyidtierparams)
            throws IOException {
        return historiqueacteservice.getFactureBordereauByIdTier(bordereaubyidtierparams);
    }

    @RequestMapping(value = "/getFacturePsByIdTier", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFacturePsByIdTierData(@RequestBody BordereauByIdTierParams bordereaubyidtierparams) throws IOException {
        return historiqueacteservice.getFacturePsByIdTier(bordereaubyidtierparams);
    }

    @RequestMapping(value = "/deleteFactureBordereau", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteFactureBordereauData(@RequestBody FactureBordereauParams facturebordereauparams)
            throws IOException {
        return historiqueacteservice.deleteFactureBordereau(facturebordereauparams);
    }

    @RequestMapping(value = "/createFacture", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String createFactureData(@RequestBody Facture facture) throws IOException {
        return historiqueacteservice.createFacture(facture);
    }





}

