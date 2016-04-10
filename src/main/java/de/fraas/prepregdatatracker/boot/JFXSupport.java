package de.fraas.prepregdatatracker.boot;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Marcel Fraas on 25.02.16.
 */
public abstract class JFXSupport extends Application {

    private static String[] savedArgs;

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(getClass());
        builder.headless(false);
        applicationContext = builder.run(savedArgs);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        applicationContext.close();
    }

    protected static void launchApp(Class<? extends JFXSupport> appClass, String[] args) {

        JFXSupport.savedArgs = args;
        //Application.launch(appClass, args);
        LauncherImpl.launchApplication(appClass, PrepregDataTrackerApplicationPreloader.class, args);
    }
}
