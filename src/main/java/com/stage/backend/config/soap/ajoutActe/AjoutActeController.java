package com.stage.backend.config.soap.ajoutActe;


import com.stage.backend.domain.LigneFacture;
import com.stage.backend.domain.PaginationParams;
import com.stage.backend.domain.Plafond;
import com.stage.backend.web.soap.SoapService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;


@RestController
@RequestMapping("/acte")
public class AjoutActeController {

        SoapService soapService;
        AjoutActeService ajoutActeService;

    public AjoutActeController(SoapService soapService, AjoutActeService ajoutActeService) {
        this.soapService = soapService;
        this.ajoutActeService = ajoutActeService;
    }
    @RequestMapping (value = "/getPrestationsPSByIdTiersPS", method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE)
     public String getPrestationsPSByIdTiersPS(@RequestParam(value = "idtiers" ) String idtiers,
                                               @RequestParam(value = "numPolice", required = false) String numPolice)
     {
         return ajoutActeService.getPrestationsPsByIdTierPS(idtiers,numPolice);
     }

    @RequestMapping(value = "/getMntRemboursementPs", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getMntRemboursementPsData(@RequestBody String id) {
        return ajoutActeService.getMntRemboursementPs(id);
    }
    @RequestMapping(value = "/getContratAdherentByMatriculeForSearch", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getContratAdherentByMatriculeForSearchData(@RequestParam(value = "matricule" ) String matricule,
                                                             @RequestParam(value = "numPolice" ) String numPolice) {
        return ajoutActeService.getContratAdherentByMatriculeForSearch(matricule,numPolice);
    }
    @RequestMapping(value = "/getMontantDisponibleByBenef",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE)
    public String getMontantDisponibleByBenef(@RequestBody Plafond plafond
                                             ){
        return ajoutActeService.getMontantDisponibleByBenef(plafond);

    }
    @RequestMapping(value = "/createLigneFactureTemporaire",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE)
    public String createLigneFactureTemporaire(@RequestBody LigneFacture LigneFacture){
        return ajoutActeService.createLigneFactureTmp(LigneFacture);
    }
    @RequestMapping(value = "/getFactureBordereauByIdAdherent",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFactureBordereauByIdAdherent(@RequestBody PaginationParams paginationParams){
        return ajoutActeService.getFactureBordereauByIdAdherent(paginationParams);
    }

}
