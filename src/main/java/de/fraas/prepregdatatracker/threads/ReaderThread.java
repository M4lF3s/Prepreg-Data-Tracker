package de.fraas.prepregdatatracker.threads;


import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.driver.S7Serializer;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import de.fraas.prepregdatatracker.services.ConfigurationService;
import de.fraas.prepregdatatracker.services.ConnectionService;
import io.rudin.s7connector.exception.S7Exception;
import io.rudin.s7connector.impl.S7Connector;
import io.rudin.s7connector.impl.S7TCPConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by Marcel Fraas on 01.09.15.
 */

@Component
public class ReaderThread extends Thread {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private DataBean dataBean;

    private io.rudin.s7connector.bean.S7Serializer s7Serializer;

    private boolean isPaused = false;

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        synchronized (this) {
            isPaused = paused;
            notifyAll();
        }
    }

    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            synchronized (this) {
                while(this.isPaused){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {


                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Anlagenparameter anlagenparameter = this.s7Serializer.dispense(Anlagenparameter.class, 204, 0);
                    dataBean.merge(anlagenparameter);
                }

                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Kalander kalander = this.s7Serializer.dispense(Kalander.class, 204, 0);
                    dataBean.merge(kalander);
                }

                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Prepregeigenschaften prepregeigenschaften = s7Serializer.dispense(Prepregeigenschaften.class, 204, 0);
                    dataBean.merge(prepregeigenschaften);
                }

                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Temperaturen temperaturen = s7Serializer.dispense(Temperaturen.class, 204, 0);
                    dataBean.merge(temperaturen);
                }

                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Zugspannungen zugspannungen = s7Serializer.dispense(Zugspannungen.class, 204, 0);
                    dataBean.merge(zugspannungen);
                }

                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Zugstation zugstation = s7Serializer.dispense(Zugstation.class, 204, 0);
                    dataBean.merge(zugstation);
                }

                try (
                        S7Connector connector = new S7TCPConnection(configurationService.getIp());
                        ) {
                    this.s7Serializer = new io.rudin.s7connector.bean.S7Serializer(connector);
                    Aufwickler aufwickler = s7Serializer.dispense(Aufwickler.class, 204, 0);
                    dataBean.merge(aufwickler);
                }


            } catch (Exception e){
                System.out.println("EXCEPTION");
                e.printStackTrace();
                run();
            }

        }

        System.out.println("Thread got Interrupted!");

        return;

    }


}