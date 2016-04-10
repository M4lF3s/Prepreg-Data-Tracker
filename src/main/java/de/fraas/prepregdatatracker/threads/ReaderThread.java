package de.fraas.prepregdatatracker.threads;


import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.driver.S7Serializer;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Marcel Fraas on 01.09.15.
 */

@Component
public class ReaderThread extends Thread {

    @Autowired
    private S7Serializer s7Serializer;

    @Autowired
    private DataBean dataBean;

    @Autowired
    private Anlagenparameter anlagenparameter;

    @Autowired
    private Kalander kalander;

    @Autowired
    private Prepregeigenschaften prepregeigenschaften;

    @Autowired
    private Temperaturen temperaturen;

    @Autowired
    private Zugspannungen zugspannungen;

    @Autowired
    private Zugstation zugstation;

    @Autowired
    private Aufwickler aufwickler;

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

    /*
    public ReaderThread(S7Serializer serializer) {
        this.s = serializer;
    }
    */

    public void setSerializer(S7Serializer s){
        this.s7Serializer = s;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public void run() {

    // System.out.println(s);

        this.anlagenparameter = s7Serializer.dispense(Anlagenparameter.class, 204, 0);
        dataBean.merge(this.anlagenparameter);
        ObserverManager.notifyAllObservers(dataBean.getAnlagenparameter());

        this.kalander = s7Serializer.dispense(Kalander.class, 204, 0);
        dataBean.merge(this.kalander);
        ObserverManager.notifyAllObservers(dataBean.getKalander());

        this.prepregeigenschaften = s7Serializer.dispense(Prepregeigenschaften.class, 204, 0);
        dataBean.merge(this.prepregeigenschaften);
        ObserverManager.notifyAllObservers(dataBean.getPrepregeigenschaften());

        this.temperaturen = s7Serializer.dispense(Temperaturen.class, 204, 0);
        dataBean.merge(this.temperaturen);
        ObserverManager.notifyAllObservers(dataBean.getTemperaturen());

        this.zugspannungen = s7Serializer.dispense(Zugspannungen.class, 204, 0);
        dataBean.merge(this.zugspannungen);
        ObserverManager.notifyAllObservers(dataBean.getZugspannungen());

        this.zugstation = s7Serializer.dispense(Zugstation.class, 204, 0);
        dataBean.merge(this.zugstation);
        ObserverManager.notifyAllObservers(dataBean.getZugstation());

        this.aufwickler = s7Serializer.dispense(Aufwickler.class, 204, 0);
        dataBean.merge(this.aufwickler);
        ObserverManager.notifyAllObservers(dataBean.getAufwickler());


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
                Optional<Anlagenparameter> anlagenparameterOptional = s7Serializer.update(anlagenparameter, 204, 0);
                if (anlagenparameterOptional.isPresent()) {
                    System.out.println("Anlagenparameter wurde geupdated!");
                    this.anlagenparameter = anlagenparameterOptional.get();
                    dataBean.merge(this.anlagenparameter);
                    ObserverManager.notifyAllObservers(dataBean.getAnlagenparameter());
                }

                Optional<Kalander> kalanderOptional = s7Serializer.update(kalander, 204, 0);
                if (kalanderOptional.isPresent()) {
                    System.out.println("Kalander wurde geupdated!");
                    this.kalander = kalanderOptional.get();
                    dataBean.merge(this.kalander);
                    ObserverManager.notifyAllObservers(dataBean.getKalander());
                }

                Optional<Prepregeigenschaften> prepregeigenschaftenOptional = s7Serializer.update(prepregeigenschaften, 204, 0);
                if (prepregeigenschaftenOptional.isPresent()) {
                    System.out.println("Prepregeigenschaften wurde geupdated!");
                    this.prepregeigenschaften = prepregeigenschaftenOptional.get();
                    dataBean.merge(this.prepregeigenschaften);
                    ObserverManager.notifyAllObservers(dataBean.getPrepregeigenschaften());
                }

                Optional<Temperaturen> temperaturenOptional = s7Serializer.update(temperaturen, 204, 0);
                if (temperaturenOptional.isPresent()) {
                    System.out.println("Temperaturen wurde geupdated!");
                    this.temperaturen = temperaturenOptional.get();
                    dataBean.merge(this.temperaturen);
                    ObserverManager.notifyAllObservers(dataBean.getTemperaturen());
                }

                Optional<Zugspannungen> zugspannungenOptional = s7Serializer.update(zugspannungen, 204, 0);
                if (zugspannungenOptional.isPresent()) {
                    System.out.println("Zugspannungen wurde geupdated!");
                    this.zugspannungen = zugspannungenOptional.get();
                    dataBean.merge(this.zugspannungen);
                    ObserverManager.notifyAllObservers(dataBean.getZugspannungen());
                }

                Optional<Zugstation> zugstationOptional = s7Serializer.update(zugstation, 204, 0);
                if (zugspannungenOptional.isPresent()) {
                    System.out.println("Zugstation wurde geupdated!");
                    this.zugstation = zugstationOptional.get();
                    dataBean.merge(this.zugstation);
                    ObserverManager.notifyAllObservers(dataBean.getZugstation());
                }

                Optional<Aufwickler> aufwicklerOptional = s7Serializer.update(aufwickler, 204, 0);
                if (aufwicklerOptional.isPresent()) {
                    System.out.println("Aufwickler wurde geupdated!");
                    this.aufwickler = aufwicklerOptional.get();
                    dataBean.merge(this.zugstation);
                    ObserverManager.notifyAllObservers(dataBean.getAufwickler());
                }

            } catch (Exception e){
                System.out.println("EXCEPTION");
                //e.printStackTrace();
            }

        }

        System.out.println("Thread got Interrupted!");

        return;

    }

}