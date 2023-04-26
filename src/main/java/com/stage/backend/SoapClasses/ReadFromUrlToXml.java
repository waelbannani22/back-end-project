package com.stage.backend.SoapClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadFromUrlToXml {
    static public String readXml(String url1){
        try {
            // Create a URL object
            URL url = new URL(url1);

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Create a BufferedReader object to read the XML
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            // Read the XML into a string variable
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            String xmlString = stringBuilder.toString();

            // Close the bufferedReader
            bufferedReader.close();

            // Print the XML string
            System.out.println(xmlString);
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
