package com.stage.backend.config.soap.reclamation;

import com.stage.backend.constants.ConstantsList;
import com.stage.backend.domain.ReclamationParams;
import com.stage.backend.domain.ValuesByCodeTypeAndValClmAndcodeTypeClm;
import com.stage.backend.web.soap.SoapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.swing.plaf.synth.SynthTextAreaUI;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Base64;

@Service
public class ReclamationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReclamationService.class);
    SoapService soapservice;

    public ReclamationService(SoapService soapservice) {
        this.soapservice = soapservice;

    }

    /**
     */
    public String createReclamation(String matriculeAdherent, String matriculePs, String numPolice,
                                    String nomPs , String description, MultipartFile byteFile, String nameFile, String typeFile,
                                    String entite, String titre, String nature, String typeReclamation) throws IOException {
        StringBuffer soapenv = new StringBuffer();
        String encoded = null;
        if (byteFile != null) {
            encoded = Base64.getEncoder().encodeToString(byteFile.getBytes());
        } else {
            nameFile="";
        }
        soapenv.append(ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:createReclamation>"
                + "<matriculeAdherent>"+ matriculeAdherent + "</matriculeAdherent>"
                + "<matriculePs>"+ matriculePs + "</matriculePs>"
                + "<numPolice>"+ numPolice + "</numPolice>"
                + "<nomPs>"+ nomPs + "</nomPs>"
                + "<description>"+ description + "</description>"
                + "<byteFile>" + encoded + "</byteFile>");
        soapenv.append("<nameFile>" + nameFile + "</nameFile><typeFile>" + typeFile
                + "</typeFile>" + "<entite>" + Integer.parseInt(entite) + "</entite><titre>"
                + titre + "</titre><nature>" + nature + "</nature>"
                + "<typeReclamation>" + typeReclamation + "</typeReclamation>"
                + "</xsd:createReclamation> </soapenv:Body> </soapenv:Envelope>");
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLRECLAMATION, soapenv.toString());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("createReclamation", e);
        }
        return null;
    }
    public String getListReclamationByMatricule(ReclamationParams params) {
        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getListReclamationByMatricule>"
                + "<dateMinRec>" + params.getDateMinRec() + "</dateMinRec>"
                + "<dateMaxRec>" + params.getDateMaxRec() + "</dateMaxRec>"
                + "<numReclamtion>" + params.getNumReclamtion() + "</numReclamtion>"
                + "<entite>" + Integer.parseInt(params.getEntite()) + "</entite>"
                + "<numPolice>" + params.getNumPolice() + "</numPolice>"
                + "<nomPS>" + params.getNomPS() + "</nomPS>"
                + "<TypeRecl>" + params.getTypeRecl() + "</TypeRecl>"
                + "<nature>" + params.getNature() + "</nature>"
                + "<staut>" + params.getStaut() + "</staut>"
                + "<matriculeAdherent>" + params.getMatriculeAdherent() + "</matriculeAdherent>"
                + "<matriculePs>" + params.getMatriculePs() + "</matriculePs>"
                + "<page>" + params.getPage() + "</page> <pageSize>" + params.getPageSize() + "</pageSize>"
                + "</xsd:getListReclamationByMatricule> </soapenv:Body> </soapenv:Envelope>";
        try {
          //  System.out.println(soapservice.getEnvelopeResult(ConstantsList.WSURLRECLAMATION, soapenv));
          //  LOGGER.info(soapservice.getEnvelopeResult(ConstantsList.WSURLRECLAMATION, soapenv).toString());
            return soapservice.getEnvelopeResult(ConstantsList.WSURLRECLAMATION, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException |
                 SAXException | IOException |
                 ParserConfigurationException e) {
            LOGGER.debug("getListReclamationByMatricule", e);
        }
        return null;
    }
    public String getTableReferentielByCodeType(ValuesByCodeTypeAndValClmAndcodeTypeClm values) {

        String soapenv = ConstantsList.ENVELOPENAMESPACE
                + "<soap:Header/><soapenv:Body> <xsd:getTableReferentielByCodeType><codeType>"
                + values.getCodeTypeRef() + "</codeType></xsd:getTableReferentielByCodeType> </soapenv:Body> </soapenv:Envelope>";
        try {
            return soapservice.getEnvelopeResult(ConstantsList.WSURLREFERENTIEL, soapenv);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException
                 | SAXException | IOException | ParserConfigurationException e) {
            LOGGER.debug("getTableReferentielByCodeType", e);
        }
        return null;
    }
}