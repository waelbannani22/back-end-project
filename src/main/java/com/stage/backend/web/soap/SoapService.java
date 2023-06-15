package com.stage.backend.web.soap;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;

import com.stage.backend.config.UrlConfigService;
import com.stage.backend.constants.ConstantsList;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;



@Service
public class SoapService {

    UrlConfigService urlconfigservice;

    public SoapService(UrlConfigService urlconfigservice) {
        this.urlconfigservice = urlconfigservice;
    }

    public String getEnvelopeResult(String urlws, String soap) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SAXException, IOException, ParserConfigurationException {
        String wsURL = this.urlconfigservice.getUrl() + urlws;
        return this.getResult(wsURL, soap);
    }



    public String getResult(String wsURL, String soap) throws SAXException, IOException, ParserConfigurationException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Code to make a webservice HTTP request
        String responseString = "";
        String outputString = "";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        String xmlInput = soap;
        httpConn.setConnectTimeout(ConstantsList.TIME_OUT);
        byte[] buffer = new byte[xmlInput.length()];
        //buffer = xmlInput.getBytes();
        InputStream input = new ByteArrayInputStream(xmlInput.getBytes());


        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length", String.valueOf(xmlInput.length()));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

        httpConn.setReadTimeout(ConstantsList.TIME_OUT);

        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        // The HttpUrlConnection will send 1024 bytes to the server every write
        // recommended in the case of large envelope
        httpConn.setChunkedStreamingMode(4096);// 1Ko
        OutputStream out = httpConn.getOutputStream();
        // Write the content of the request to the outputstream of the HTTP Connection.
        int len;
        while ((len = input.read(buffer)) != -1) {
            out.write(buffer, 0, len);// Write the content of the soap to the server
        }
        //out.write(b);
        out.close();
        // Ready with sending the request.

        // Read the response.
        InputStreamReader isr = null;
        if (httpConn.getResponseCode() == ConstantsList.HTTPRESPONSE) {
            isr = new InputStreamReader(httpConn.getInputStream());
        } else {
            isr = new InputStreamReader(httpConn.getErrorStream());
        }

        BufferedReader in = new BufferedReader(isr);

        // Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        return outputString;
    }

}
