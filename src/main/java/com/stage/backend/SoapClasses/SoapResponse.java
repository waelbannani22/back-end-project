package com.stage.backend.SoapClasses;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Map;

@XmlRootElement(name = "getListReclamationByMatriculeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapResponse {
    @JacksonXmlProperty(isAttribute = true)
    private Map<String, String> attributes;

}
