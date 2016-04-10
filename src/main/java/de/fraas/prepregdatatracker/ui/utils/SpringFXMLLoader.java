package de.fraas.prepregdatatracker.ui.utils;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Marcel Fraas on 04.10.15.
 */

@Component
public class SpringFXMLLoader implements ApplicationContextAware {

    //private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(de.fraas.prepregdatatracker.boot.SpringContextConfig.class);

    private static ApplicationContext applicationContext;

    private static SpringFXMLLoader provider;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public static <T> T load(URL url) {
        try  {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setControllerFactory(applicationContext::getBean);
            return loader.load();
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public synchronized static SpringFXMLLoader getInstance() throws ExceptionInInitializerError {
        SpringFXMLLoader tempProvider;
        if(provider == null) {
            provider = new SpringFXMLLoader();
            tempProvider = provider;
        } else if(provider.getApplicationContext() == null) {
            provider = new SpringFXMLLoader();
            tempProvider = provider;
        } else {
            tempProvider = provider;
        }

        return tempProvider;
    }
}