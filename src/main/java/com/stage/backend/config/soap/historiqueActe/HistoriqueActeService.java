package com.stage.backend.config.soap.historiqueActe;

import com.stage.backend.config.UrlConfigService;
import com.stage.backend.constants.ConstantsList;
import com.stage.backend.domain.BordereauByIdTierParams;
import com.stage.backend.domain.Facture;
import com.stage.backend.domain.FactureBordereauParams;
import com.stage.backend.web.soap.SoapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Service
public class HistoriqueActeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HistoriqueActeService.class);
    UrlConfigService urlConfigService;
    SoapService soapservice;

    public HistoriqueActeService(SoapService soapService, UrlConfigService urlConfigService) {
        this.soapservice = soapService;
        this.urlConfigService = urlConfigService;
    }

    public String getFactureBordereauByIdTier(BordereauByIdTierParams bordereaubyIdtierparams) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getFactureBordereauByIdTier> <idTier>"
                + bordereaubyIdtierparams.getIdTiers() + "</idTier> <facture>" + bordereaubyIdtierparams.getType()
                + "</facture> <page>" + bordereaubyIdtierparams.getPage() + "</page> <pageSize>"
                + bordereaubyIdtierparams.getPagesize() + "</pageSize>" + "<nature>"
                + bordereaubyIdtierparams.getNature() + "</nature>" + "<dateDeb>" + bordereaubyIdtierparams.getDateDeb()
                + "</dateDeb>" + "<dateFin>" + bordereaubyIdtierparams.getDateFin() + "</dateFin>" + "<refFact>"
                + bordereaubyIdtierparams.getRefFact() + "</refFact>" + "<natureDent>"
                + bordereaubyIdtierparams.getNatureDent() + "</natureDent><numPolice>" + bordereaubyIdtierparams.getNumPolice()+"</numPolice>"
                + "</xsd:getFactureBordereauByIdTier> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException |
                 SAXException | IOException |
                 ParserConfigurationException e) {
            LOGGER.debug("getFactureBordereauByIdTier", e);
        }
        return null;

    }

    public String getFacturePsByIdTier(BordereauByIdTierParams bordereaubyIdtierparams) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getFacturePsByIdTier> <idTier>"
                + bordereaubyIdtierparams.getIdTiers() + "</idTier> <facture>" + bordereaubyIdtierparams.getType()
                + "</facture><numPolice>" + bordereaubyIdtierparams.getNumPolice()+"</numPolice>"
                + "<page>" + bordereaubyIdtierparams.getPage() + "</page>" + " <pageSize>"
                + bordereaubyIdtierparams.getPagesize() + "</pageSize>"
                + "<nature>CONS</nature><dateDeb></dateDeb><dateFin></dateFin><refFact></refFact><natureDent></natureDent>"
                + "</xsd:getFacturePsByIdTier> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getFacturePsByIdTier", e);
        }
        return null;

    }

    public String deleteFactureBordereau(FactureBordereauParams facturebordereauparams) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:deleteFactureBordereau> <idFacture>"
                + facturebordereauparams.getIdFacture() + "</idFacture> <idfactBord>"
                + facturebordereauparams.getIdfactBord() + "</idfactBord> <commentaire>"
                + facturebordereauparams.getCommentaire() + "</commentaire> <numFacture>"
                + facturebordereauparams.getNumFacture()
                + "</numFacture></xsd:deleteFactureBordereau> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("deleteFactureBordereau", e);
        }
        return null;

    }

    public String createFacture(Facture facture) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE + "<soap:Header/><soapenv:Body> <xsd:createFacture>"
                + "<idPs>" + facture.getIdPs() + "</idPs><montantFacture>"
                + facture.getMontantFacture() + "</montantFacture>" + "<numFacture>"
                + facture.getNumFacture() + "</numFacture><dateFacture>" + facture.getDateFacture()
                + "</dateFacture><idfactBord>" + facture.getIdfactBord() + "</idfactBord><commentaire>"
                + facture.getCommentaire() + "</commentaire><numPolice>" +facture.getNumPolice()+"</numPolice>"
                + "</xsd:createFacture> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("createFacture", e);
        }
        return null;

    }
    /*
       public String CreateRedSeance(RedSeancePEC redSeance) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE + "<soap:Header/><soapenv:Body> <xsd:CreateRedSeance> <idRed>"
                + redSeance.getIdRed() + "</idRed><numSeance>" + redSeance.getNumSeance() + "</numSeance>"
                + "<dateSeance>" + redSeance.getDateSeance() + "</dateSeance><horaireSeance>"
                + redSeance.getHoraireSeance() + "</horaireSeance>"
                + "</xsd:CreateRedSeance> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("createFacture", e);
        }
        return null;
    }
     */



}