package com.stage.backend.config.soap.ajoutActe;

import com.stage.backend.config.UrlConfigService;
import com.stage.backend.constants.ConstantsList;
import com.stage.backend.domain.LigneFacture;
import com.stage.backend.domain.PaginationParams;
import com.stage.backend.domain.Plafond;
import com.stage.backend.web.soap.SoapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Objects;

@Service
public class AjoutActeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AjoutActeService.class);
    SoapService soapservice;
    UrlConfigService urlConfigService;
    //UserParams userParams;
    public AjoutActeService(SoapService soapService, UrlConfigService urlConfigService) {
        this.soapservice = soapService;
        this.urlConfigService = urlConfigService;

    }

    public String getPrestationsPsByIdTierPS(String idtiers,String numPolice) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getPrestationsPsByIdTierPS> <idTiers>" + idtiers
                + "</idTiers><numPolice>"+numPolice+"</numPolice>"
                + "</xsd:getPrestationsPsByIdTierPS> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getPrestationsPsByIdTierPS", e);
        }
        return null;

    }



    public String getMntRemboursementPs(String id) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getMntRemboursementPs> <extranetWsInputDto>" + id
                + "</extranetWsInputDto> </xsd:getMntRemboursementPs> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLPRESTATIARE, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getMntRemboursementPs", e);
        }
        return null;

    }

    public String getPsByNomOrCodeCnam(String searchcriteria) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getPsByNomOrCodeCnam> <searchCriteria>" + searchcriteria
                + "</searchCriteria> </xsd:getPsByNomOrCodeCnam> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLCONTRATPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getPsByNomOrCodeCnam", e);
        }
        return null;

    }
    public String getContratAdherentByMatriculeForSearch(String matricule,String numPolice) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soapenv:Header/><soapenv:Body><xsd:getContratAdherentByMatricule><matricule>" + matricule
                + "</matricule><numPolice>"+numPolice+ "</numPolice></xsd:getContratAdherentByMatricule>"
                + "</soapenv:Body></soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLCONTRATADHERENT, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getContratAdherentByMatricule", e);
        }
        return null;
    }
/*
    public String createLigneFactureTmp(LigneFacture lignefacture, String idPrestation) {
        String totalOrdenance = null;
        String idPrestationTag = "<idPrestation></idPrestation>";

        if (idPrestation != null || idPrestation != "null" || idPrestation != "") {
            idPrestationTag = "<idPrestation>" + idPrestation + "</idPrestation>";
        }

        if (lignefacture.getTotalOrdenance() != null) {
            totalOrdenance = ConstantsList.QUOTE.concat(lignefacture.getTotalOrdenance()).concat(ConstantsList.QUOTE);
        }
        String cleCotation = null;
        if (lignefacture.getCleCotation() != null) {
            cleCotation = ConstantsList.QUOTE.concat(lignefacture.getCleCotation()).concat(ConstantsList.QUOTE);
        }
        String dateConsultation = null;
        if (lignefacture.getDateConsultation() != null) {
            dateConsultation = ConstantsList.QUOTE.concat(lignefacture.getDateConsultation()).concat(ConstantsList.QUOTE);
        }

        String json = "<json>{\"listeDetail\":[{\"totalOrdenance\":" + totalOrdenance + ",\"dateConsultation\":"
                + dateConsultation + ",\"totalMedRemboursable\":"
                + lignefacture.getTotalMedRemboursable() + ",\"totalMedNonRemboursable\":"
                + lignefacture.getTotalMedNonRemboursable() + ",\"nbreCoatationB\":" + lignefacture.getNbreCoatationB()
                + ",\"nbreCoatationABP\":" + lignefacture.getNbreCoatationABP() + ",\"nbreCoatation\":"
                + lignefacture.getNbreCoatation() + ",\"cleCotation\":" + cleCotation + ",\"typePrestation\":\""
                + lignefacture.getTypePrestation() + "\",\"commentaire\":\"" + lignefacture.getCommentaire()
                + "\",\"natureTransaction\":\"" + lignefacture.getNatureTransaction() + "\"}]}</json>";

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:createLigneFactureTmp>"+urlConfigService.getNumPoliceOfSelectedCont()+
                "<idBeneficiare>"+lignefacture.getIdBeneficiare() + "</idBeneficiare> <idAdherent>" + lignefacture.getIdAdherent()
                + "</idAdherent>" + "<matriculeAdherent>" + lignefacture.getMatriculeAdherent()
                + "</matriculeAdherent> <dateVisite>" + lignefacture.getDateVisite() + "</dateVisite><ticketModerateur>"
                + lignefacture.getTicketModerateur() + "</ticketModerateur>" + "<mntRestePayer>"
                + lignefacture.getMntRestePayer() + "</mntRestePayer><idTiers>" + lignefacture.getIdTiers()
                + "</idTiers><nid>0</nid>" + json + "<idMedecin>" + lignefacture.getIdMedecin()
                + "</idMedecin><reference>" + lignefacture.getReference() + "</reference><natureActe>"
                + lignefacture.getNatureActe()
                + "</natureActe>" + idPrestationTag
                + "</xsd:createLigneFactureTmp> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("createLigneFactureTmp", e);
        }
        return null;

    }

    public String createLigneFactureTmpForMC(LigneFacture lignefacture) {
        String totalOrdenance = null;
        if (lignefacture.getTotalOrdenance() != null) {
            totalOrdenance = ConstantsList.QUOTE.concat(lignefacture.getTotalOrdenance()).concat(ConstantsList.QUOTE);
        }
        String cleCotation = null;
        if (lignefacture.getCleCotation() != null) {
            cleCotation = ConstantsList.QUOTE.concat(lignefacture.getCleCotation()).concat(ConstantsList.QUOTE);
        }
        String dateConsultation = null;
        if (lignefacture.getDateConsultation() != null) {
            dateConsultation = ConstantsList.QUOTE.concat(lignefacture.getDateConsultation()).concat(ConstantsList.QUOTE);
        }

        String json = "<json>{\"listeDetail\":[{\"totalOrdenance\":" + totalOrdenance + ",\"dateConsultation\":"
                + dateConsultation + ",\"totalMedRemboursable\":"
                + lignefacture.getTotalMedRemboursable() + ",\"totalMedNonRemboursable\":"
                + lignefacture.getTotalMedNonRemboursable() + ",\"nbreCoatationB\":" + lignefacture.getNbreCoatationB()
                + ",\"nbreCoatationABP\":" + lignefacture.getNbreCoatationABP() + ",\"nbreCoatation\":"
                + lignefacture.getNbreCoatation() + ",\"cleCotation\":" + cleCotation + ",\"typePrestation\":\""
                + lignefacture.getTypePrestation() + "\",\"commentaire\":\"" + lignefacture.getCommentaire()
                + "\",\"natureTransaction\":\"" + lignefacture.getNatureTransaction() + "\"}]}</json>";

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:createLigneFactureTmp><numPolice>"+lignefacture.getContractant().getNom()+"</numPolice>"+
                "<idBeneficiare>"+lignefacture.getIdBeneficiare() + "</idBeneficiare> <idAdherent>" + lignefacture.getIdAdherent()
                + "</idAdherent>" + "<matriculeAdherent>" + lignefacture.getMatriculeAdherent()
                + "</matriculeAdherent> <dateVisite>" + lignefacture.getDateVisite() + "</dateVisite><ticketModerateur>"
                + lignefacture.getTicketModerateur() + "</ticketModerateur>" + "<mntRestePayer>"
                + lignefacture.getMntRestePayer() + "</mntRestePayer><idTiers>" + lignefacture.getIdTiers()
                + "</idTiers><nid>0</nid>" + json + "<idMedecin>" + lignefacture.getIdMedecin()
                + "</idMedecin><reference>" + lignefacture.getReference() + "</reference><natureActe>"
                + lignefacture.getNatureActe()
                + "</natureActe></xsd:createLigneFactureTmp> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("createLigneFactureTmp", e);
        }
        return null;

    }

    public String getFactureBordereauByIdAdherent(PaginationParams params) {
        String idPsElement = "<idPs></idPs>";
        if (!(params.getIdPs().equals("")) || params.getIdPs() != null) {
            idPsElement = "<idPs>" + params.getIdPs().trim() + "</idPs>";
        }
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getFactureBordereauByIdAdherent> <idAdherent>" + params.getId()
                + "</idAdherent> <consultation>true</consultation>" + idPsElement
                + "<page>" + params.getPage() + "</page> <pageSize>"
                + params.getPagesize() + "</pageSize>"
                + "</xsd:getFactureBordereauByIdAdherent> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getFactureBordereauByIdAdherent", e);
        }
        return null;
    }

    public String generateRefFactBord(String natureTransaction) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:generateRefFactBord> <natureTransaction>" + natureTransaction
                + "</natureTransaction>" + "</xsd:generateRefFactBord> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("generateRefFactBord", e);
        }
        return null;

    }
*/
    public String getMontantDisponibleByBenef(Plafond plafond) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE;
        if (plafond.getIdPrestation() == null || Objects.equals(plafond.getIdPrestation(), "") || Objects.equals(plafond.getIdPrestation(), "null")) {
            soapenv = ConstantsList.ENVELOPENAMESPACE
                    + "<soap:Header/><soapenv:Body> <xsd:getMontantDisponibleByBenef> <matricule>" + plafond.getMatricule()
                    + "</matricule><idBenef>" + plafond.getIdBenef()
                    + "</idBenef>" + "<idPs>" + plafond.getIdPs() + "</idPs>"
                    + "</xsd:getMontantDisponibleByBenef> </soapenv:Body> </soapenv:Envelope>";
        } else {
            soapenv = ConstantsList.ENVELOPENAMESPACE
                    + "<soap:Header/><soapenv:Body> <xsd:getMontantDisponibleByBenef> <matricule>" + plafond.getMatricule()
                    + "</matricule><idBenef>" + plafond.getIdBenef()
                    + "</idBenef>" + "<idPs>" + plafond.getIdPs() + "</idPs><idPrestation>" + plafond.getIdPrestation() + "</idPrestation>"
                    + "</xsd:getMontantDisponibleByBenef> </soapenv:Body> </soapenv:Envelope>";
        }

        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLCONTRATADHERENT, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("generateRefFactBord", e);
        }
        return null;
    }
    public String createLigneFactureTmp(LigneFacture lignefacture) {
        String totalOrdenance = null;
        String idPrestationTag = "<idPrestation></idPrestation>";

        idPrestationTag = "<idPrestation>" + lignefacture.getIdPrestation() + "</idPrestation>";

        if (lignefacture.getTotalOrdenance() != null) {
            totalOrdenance = ConstantsList.QUOTE.concat(lignefacture.getTotalOrdenance()).concat(ConstantsList.QUOTE);
        }
        String cleCotation = null;
        if (lignefacture.getCleCotation() != null) {
            cleCotation = ConstantsList.QUOTE.concat(lignefacture.getCleCotation()).concat(ConstantsList.QUOTE);
        }
        String dateConsultation = null;
        if (lignefacture.getDateConsultation() != null) {
            dateConsultation = ConstantsList.QUOTE.concat(lignefacture.getDateConsultation()).concat(ConstantsList.QUOTE);
        }

        String json = "<json>{\"listeDetail\":[{\"totalOrdenance\":" + totalOrdenance + ",\"dateConsultation\":"
                + dateConsultation + ",\"totalMedRemboursable\":"
                + lignefacture.getTotalMedRemboursable() + ",\"totalMedNonRemboursable\":"
                + lignefacture.getTotalMedNonRemboursable() + ",\"nbreCoatationB\":" + lignefacture.getNbreCoatationB()
                + ",\"nbreCoatationABP\":" + lignefacture.getNbreCoatationABP() + ",\"nbreCoatation\":"
                + lignefacture.getNbreCoatation() + ",\"cleCotation\":" + cleCotation + ",\"typePrestation\":\""
                + lignefacture.getTypePrestation() + "\",\"commentaire\":\"" + lignefacture.getCommentaire()
                + "\",\"natureTransaction\":\"" + lignefacture.getNatureTransaction() + "\"}]}</json>";

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:createLigneFactureTmp><numPolice>"+lignefacture.getContractant()+
                "</numPolice><idBeneficiare>"+lignefacture.getIdBeneficiare() + "</idBeneficiare> <idAdherent>" + lignefacture.getIdAdherent()
                + "</idAdherent>" + "<matriculeAdherent>" + lignefacture.getMatriculeAdherent()
                + "</matriculeAdherent> <dateVisite>" + lignefacture.getDateVisite() + "</dateVisite><ticketModerateur>"
                + lignefacture.getTicketModerateur() + "</ticketModerateur>" + "<mntRestePayer>"
                + lignefacture.getMntRestePayer() + "</mntRestePayer><idTiers>" + lignefacture.getIdTiers()
                + "</idTiers><nid>0</nid>" + json + "<idMedecin>" + lignefacture.getIdMedecin()
                + "</idMedecin><reference>" + lignefacture.getReference() + "</reference><natureActe>"
                + lignefacture.getNatureActe()
                + "</natureActe>" + idPrestationTag
                + "</xsd:createLigneFactureTmp> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("createLigneFactureTmp", e);
        }
        return null;

    }


    public String getFactureBordereauByIdAdherent(PaginationParams params) {
        String idPsElement = "<idPs></idPs>";
        if (!(params.getIdPs().equals("")) || params.getIdPs() != null) {
            idPsElement = "<idPs>" + params.getIdPs().trim() + "</idPs>";
        }
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getFactureBordereauByIdAdherent> <idAdherent>" + params.getId()
                + "</idAdherent> <consultation>true</consultation>" + idPsElement
                + "<page>" + params.getPage() + "</page> <pageSize>"
                + params.getPagesize() + "</pageSize>"
                + "</xsd:getFactureBordereauByIdAdherent> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLFACTUREPS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getFactureBordereauByIdAdherent", e);
        }
        return null;
    }




}
