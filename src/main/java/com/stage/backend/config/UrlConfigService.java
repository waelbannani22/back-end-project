package com.stage.backend.config;

import org.springframework.stereotype.Service;

@Service
public class UrlConfigService {



    public UrlConfigService() {

    }

    public String getUrl()  {
            return "http://192.168.111.102:8080/axis2/services";

    }
}
