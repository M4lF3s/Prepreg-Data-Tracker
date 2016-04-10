package de.fraas.prepregdatatracker.services;


import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by Marcel Fraas on 07.03.16.
 */

@Service
@PropertySource("classpath:application.properties")
public class ConfigurationService {

    @Value("${s7.cpu.ip}")
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
