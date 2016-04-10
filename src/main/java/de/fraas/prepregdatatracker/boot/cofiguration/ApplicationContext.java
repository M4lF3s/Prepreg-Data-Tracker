package de.fraas.prepregdatatracker.boot.cofiguration;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.data.repo.PersonRepository;
import de.fraas.prepregdatatracker.driver.S7Serializer;
import de.fraas.prepregdatatracker.services.ConnectionService;
import de.fraas.prepregdatatracker.threads.ReaderThread;
import de.fraas.prepregdatatracker.ui.controller.*;
import de.fraas.prepregdatatracker.ui.utils.SpringFXMLLoader;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Marcel Fraas on 28.02.16.
 */

@Lazy
@Configuration
@ComponentScan("de.fraas.prepregdatatracker")
public class ApplicationContext {


    // -----------------------------
    // This Bean is for loading
    // Properties from prop File
    // with @Value in Config Service
    // -----------------------------

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ReaderThread readerThread() {
        ReaderThread r = new ReaderThread();
        r.setDaemon(true);
        return r;
    }

    @Bean
    public S7Serializer s7Serializer(){
        return new S7Serializer();
    }

    // -----------------------------
    // Defining Entities
    // -----------------------------

    @Bean
    public Anlagenparameter anlagenparameter() {
        return new Anlagenparameter();
    }

    @Bean
    public Aufwickler aufwickler() {
        return new Aufwickler();
    }

    @Bean
    public Kalander kalander() {
        return new Kalander();
    }

    @Bean
    public Materialien materialien() {
        return new Materialien();
    }

    @Bean
    public Person person() {
        return new Person();
    }

    @Bean
    public Prepregeigenschaften prepregeigenschaften() {
        return new Prepregeigenschaften();
    }

    @Bean
    public Temperaturen temperaturen() {
        return new Temperaturen();
    }

    @Bean
    public Versuch versuch() {
        return new Versuch();
    }

    @Bean
    public Versuchsreihe versuchsreihe() {
        return new Versuchsreihe();
    }

    @Bean
    public Zugspannungen zugspannungen() {
        return new Zugspannungen();
    }

    @Bean
    public Zugstation zugstation() {
        return new Zugstation();
    }

    @Bean
    public DataBean dataBean() {
        return new DataBean();
    }

}
