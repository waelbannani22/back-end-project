package com.stage.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.stage.backend.SoapClasses.Note;
import com.stage.backend.SoapClasses.ReadFromUrlToXml;
import com.stage.backend.SoapClasses.ReclamationDto;
import com.stage.backend.SoapClasses.ReclamationResponse;
import jakarta.xml.bind.JAXBException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws JAXBException, JsonProcessingException {
		SpringApplication.run(BackendApplication.class, args);
		//*** xml fetch simple
		/**
		 * RestTemplate restTemplate = new RestTemplate();
		 * 		String url = "https://www.w3schools.com/xml/note.xml";
		 * 		//String url ="http://192.168.111.102:8080/axis2/services/reclamationWS/getListReclamationByMatricule?dateMinRec=&dateMaxRec=&numReclamtion=2023REC00002&entite=3&numPolice=&nomPS=&TypeRecl=&nature=&staut=&matriculeAdherent=&matriculePs=&page=0&pageSize=99";
		 * 		String xml = restTemplate.getForObject(url, String.class);
		 *
		 * 		XmlMapper xmlMapper = new XmlMapper();
		 * 		ObjectMapper objectMapper = new ObjectMapper();
		 *
		 * 		try {
		 * 			// Parse the XML into a Java object
		 * 			Note note = xmlMapper.readValue(xml, Note.class);
		 *
		 * 			// Convert the Java object to JSON
		 * 			String json = objectMapper.writeValueAsString(note);
		 *
		 * 			// Output the JSON
		 * 			System.out.println(json);
		 *                } catch (IOException e) {
		 * 			e.printStackTrace();
		 *        }
		 *
		 */

		//***************end xml fetch simple

		//***********complex
		/*
		String xml2 = ReadFromUrlToXml.readXml("http://192.168.111.102:8080/axis2/services/reclamationWS/getListReclamationByMatricule?dateMinRec=&dateMaxRec=&numReclamtion=2023REC00002&entite=3&numPolice=&nomPS=&TypeRecl=&nature=&staut=&matriculeAdherent=&matriculePs=&page=0&pageSize=99"); // the XML response
		ReclamationResponse response = ReclamationResponse.fromXml(xml2);
		System.out.println("response"+response);
		ReclamationDto reclamation = response.getReturnDto();
		System.out.println(reclamation.getObjetReclamation());
		 */

		//

		//end complex


	}

}
