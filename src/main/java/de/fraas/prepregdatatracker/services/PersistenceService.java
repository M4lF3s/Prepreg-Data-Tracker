package de.fraas.prepregdatatracker.services;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.data.repo.ParameterRepository;
import de.fraas.prepregdatatracker.data.repo.PersonRepository;
import de.fraas.prepregdatatracker.data.repo.VersuchRepository;
import de.fraas.prepregdatatracker.data.repo.VersuchsreiheRepository;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import de.fraas.prepregdatatracker.driver.utils.PropertyChangeObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Marcel Fraas on 10.03.16.
 */

@Service
public class PersistenceService implements PropertyChangeObserver {

    @Autowired
    private Versuchsreihe versuchsreihe;

    @Autowired
    private Versuch versuch;

    @Autowired
    private Person person;

    @Autowired
    private VersuchsreiheRepository versuchsreiheRepository;

    @Autowired
    private VersuchRepository versuchRepository;

    @Autowired
    private ParameterRepository parameterRepository;

    @Autowired
    private PersonRepository personRepository;

    private boolean anlagenparameterInitialized = false;
    private boolean kalanderInitialized = false;
    private boolean prepregeigenschaftenInitialized = false;
    private boolean temperaturenInitialized = false;
    private boolean zugspannungenInitialized = false;
    private boolean zugstationInitialized = false;
    private boolean aufwicklerInitialized = false;
    private boolean materialienInitialized = false;

    private Anlagenparameter anlagenparameter;
    private Kalander kalander;
    private Prepregeigenschaften prepregeigenschaften;
    private Temperaturen temperaturen;
    private Zugspannungen zugspannungen;
    private Zugstation zugstation;
    private Aufwickler aufwickler;
    private Materialien materialien;

    private int versuchcount = 1;

    @PostConstruct
    public void init() {
        ObserverManager.register(this);
        versuchsreihe.setDatum(new Date());
        personRepository.save(person);
        versuchsreihe.setPerson(person);
        versuchsreiheRepository.save(versuchsreihe);
    }

    @Override
    public void update(Anlagenparameter anlagenparameter) {
        anlagenparameterInitialized = true;
        this.anlagenparameter = new Anlagenparameter(anlagenparameter);
        parameterRepository.save(this.anlagenparameter);
        persist();
    }

    @Override
    public void update(Kalander kalander) {
        kalanderInitialized = true;
        this.kalander = kalander;
        parameterRepository.save(this.kalander);
        persist();
    }

    @Override
    public void update(Prepregeigenschaften prepregeigenschaften) {
        prepregeigenschaftenInitialized = true;
        this.prepregeigenschaften = new Prepregeigenschaften(prepregeigenschaften);
        //parameterRepository.save(this.prepregeigenschaften);
        //persist();
    }

    @Override
    public void update(Temperaturen temperaturen) {
        temperaturenInitialized = true;
        List<String> diffs = new ArrayList<>();
        if (!(this.temperaturen == null)){
            diffs = creatediff(temperaturen);
        }
        if (!(diffs.size() == 1 && diffs.contains("tKühlplatte"))) {
            this.temperaturen = new Temperaturen(temperaturen);
            parameterRepository.save(this.temperaturen);
            persist();
        } else {
            this.temperaturen = new Temperaturen(temperaturen);
        }
    }

    @Override
    public void update(Zugspannungen zugspannungen) {
        zugspannungenInitialized = true;
        this.zugspannungen = new Zugspannungen(zugspannungen);
        parameterRepository.save(this.zugspannungen);
        persist();
    }

    @Override
    public void update(Zugstation zugstation) {
        zugstationInitialized = true;
        this.zugstation = new Zugstation(zugstation);
        parameterRepository.save(this.zugstation);
        persist();
    }

    @Override
    public void update(Aufwickler aufwickler) {
        aufwicklerInitialized = true;
        this.aufwickler = new Aufwickler(aufwickler);
        parameterRepository.save(this.aufwickler);
        persist();
    }

    @Override
    public void update(Materialien materialien) {
        materialienInitialized = true;
        this.materialien = new Materialien(materialien);
        parameterRepository.save(this.materialien);
        persist();
    }

    @Override
    public void update(Versuch versuch) {

    }

    @Override
    public void update(Versuchsreihe versuchsreihe) {

    }

    private void persist() {

        System.out.println(anlagenparameterInitialized);
        System.out.println(kalanderInitialized);
        System.out.println(prepregeigenschaftenInitialized); //
        System.out.println(temperaturenInitialized); //
        System.out.println(zugspannungenInitialized);
        System.out.println(zugstationInitialized);
        System.out.println(aufwicklerInitialized); //
        System.out.println();

        if (
                anlagenparameterInitialized
                        && kalanderInitialized
                        && prepregeigenschaftenInitialized
                        && temperaturenInitialized
                        && zugspannungenInitialized
                        && zugstationInitialized
                        && aufwicklerInitialized
                        && materialienInitialized
                ) {
            parameterRepository.save(this.prepregeigenschaften);

            Versuch v = new Versuch();
            Set<Parameter> parameterSet = new HashSet<>();
            parameterSet.add(this.anlagenparameter);
            parameterSet.add(this.kalander);
            parameterSet.add(this.prepregeigenschaften);
            parameterSet.add(this.temperaturen);
            parameterSet.add(this.zugspannungen);
            parameterSet.add(this.zugstation);
            parameterSet.add(this.aufwickler);
            parameterSet.add(this.materialien);

            v.setVnr(this.versuchcount++);
            v.setParameter(parameterSet);
            v.setVersuchsreihe(this.versuchsreihe);
            //versuchsreiheRepository.save(versuchsreihe);
            versuchRepository.save(v);
        }
    }

    public List<String> creatediff(Temperaturen t) {
        List<String> diffs = new ArrayList<>();
        Field[] fields = t.getClass().getFields();
        for (Field f : fields) {
            try {
                if (!f.get(t).equals(f.get(this.temperaturen))) {
                    diffs.add(f.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return diffs;
    }
}
