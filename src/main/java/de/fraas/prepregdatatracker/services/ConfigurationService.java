package de.fraas.prepregdatatracker.services;


import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.DefaultPropertiesPersister;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

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
        //this.ip = ip;


        try {
            // create and set properties into properties object
            Properties props = new Properties();
            props.setProperty("s7.cpu.ip", ip);
            // get or create the file
            File f = new File("application.properties");
            OutputStream out = new FileOutputStream( f );
            // write into it
            DefaultPropertiesPersister p = new DefaultPropertiesPersister();
            p.store(props, out, null);
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
