package com.stage.backend.config.profileadherent;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import com.stage.backend.config.UrlConfigService;
import com.stage.backend.constants.ConstantsList;

import com.stage.backend.web.soap.SoapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import static com.stage.backend.constants.ConstantsList.CHAINEVIDE;


@Service
public class ProfilAdherentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilAdherentService.class);
    SoapService soapservice;
    //UserParams userParams;
    UrlConfigService urlConfigService;

    public ProfilAdherentService(SoapService soapService ,UrlConfigService urlConfigService) {
        this.soapservice = soapService;

        this.urlConfigService = urlConfigService;
    }



    public String getContratAdherentByMatricule(String matricule,String numPolice) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soapenv:Header/><soapenv:Body><xsd:getContratAdherentByMatricule><matricule>" + matricule
                + "</matricule><numPolice>"+numPolice+"</numPolice></xsd:getContratAdherentByMatricule>"
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
    public String getContratAdherentByMatriculeForSearch(String matricule) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soapenv:Header/><soapenv:Body><xsd:getContratAdherentByMatricule><matricule>" + matricule
                + "</matricule>"+this.urlConfigService.getNumPoliceOfSelectedCont()+"</xsd:getContratAdherentByMatricule>"
                + "</soapenv:Body></soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLCONTRATADHERENT, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getContratAdherentByMatricule", e);
        }
        return null;
    }

 */



}
