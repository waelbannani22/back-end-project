package com.stage.backend.config.profileadherent.soap.verifierMedicament;

import com.stage.backend.config.UrlConfigService;
import com.stage.backend.constants.ConstantsList;
import com.stage.backend.web.soap.SoapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Service
public class VerifierMedicamentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifierMedicamentService.class);
    SoapService soapservice;
    UrlConfigService urlConfigService;


    public VerifierMedicamentService(SoapService soapService, UrlConfigService urlConfigService) {
        this.soapservice = soapService;
        this.urlConfigService = urlConfigService;
    }

    public String getListActesPhar(String codeActe,String numPolice) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getListActesPhar> <codeActe>" + codeActe
                + "</codeActe> <numPolice>"+numPolice+"</numPolice>"
                + "</xsd:getListActesPhar> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLACTEPHRCWS, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException |
                 SAXException | IOException |
                 ParserConfigurationException e) {
            LOGGER.debug("getListActesPhar", e);
        }
        return null;

    }
}