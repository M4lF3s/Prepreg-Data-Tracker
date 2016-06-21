package de.fraas.prepregdatatracker.data.beans;

import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * Created by Marcel Fraas on 01.10.15.
 */
public class DataBean {


    @Autowired
    private Anlagenparameter anlagenparameter;

    @Autowired
    private Aufwickler aufwickler;

    @Autowired
    private Kalander kalander;

    @Autowired
    private Materialien materialien;

    @Autowired
    private Person person;

    @Autowired
    private Prepregeigenschaften prepregeigenschaften;

    @Autowired
    private Temperaturen temperaturen;

    @Autowired
    private Versuch versuch;

    @Autowired
    private Versuchsreihe versuchsreihe;

    @Autowired
    private Zugspannungen zugspannungen;

    @Autowired
    private Zugstation zugstation;

    public Anlagenparameter getAnlagenparameter() {
        return anlagenparameter;
    }

    public void setAnlagenparameter(Anlagenparameter anlagenparameter) {
        this.anlagenparameter = anlagenparameter;
    }

    public Aufwickler getAufwickler() {
        return aufwickler;
    }

    public void setAufwickler(Aufwickler aufwickler) {
        this.aufwickler = aufwickler;
    }

    public Kalander getKalander() {
        return kalander;
    }

    public void setKalander(Kalander kalander) {
        this.kalander = kalander;
    }

    public Materialien getMaterialien() {
        return materialien;
    }

    public void setMaterialien(Materialien materialien) {
        this.materialien = materialien;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Prepregeigenschaften getPrepregeigenschaften() {
        return prepregeigenschaften;
    }

    public void setPrepregeigenschaften(Prepregeigenschaften prepregeigenschaften) {
        this.prepregeigenschaften = prepregeigenschaften;
    }

    public Temperaturen getTemperaturen() {
        return temperaturen;
    }

    public void setTemperaturen(Temperaturen temperaturen) {
        this.temperaturen = temperaturen;
    }

    public Versuch getVersuch() {
        return versuch;
    }

    public void setVersuch(Versuch versuch) {
        this.versuch = versuch;
    }

    public Versuchsreihe getVersuchsreihe() {
        return versuchsreihe;
    }

    public void setVersuchsreihe(Versuchsreihe versuchsreihe) {
        this.versuchsreihe = versuchsreihe;
    }

    public Zugspannungen getZugspannungen() {
        return zugspannungen;
    }

    public void setZugspannungen(Zugspannungen zugspannungen) {
        this.zugspannungen = zugspannungen;
    }

    public Zugstation getZugstation() {
        return zugstation;
    }

    public void setZugstation(Zugstation zugstation) {
        this.zugstation = zugstation;
    }


    /*
    public <T> void merge(T t) {
        Field[] fields = t.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(t);
                if(value != null) {
                    f.set(anlagenparameter, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    */

    public void merge(Anlagenparameter anlagenparameter) {
        boolean updated = false;
        Field[] fields = anlagenparameter.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.anlagenparameter);
                Object newValue = f.get(anlagenparameter);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.anlagenparameter, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.anlagenparameter);
        }
    }

    public void merge(Aufwickler aufwickler) {
        boolean updated = false;
        Field[] fields = aufwickler.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.aufwickler);
                Object newValue = f.get(aufwickler);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.aufwickler, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.aufwickler);
        }
    }

    public void merge(Kalander kalander) {
        boolean updated = false;
        Field[] fields = kalander.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.kalander);
                Object newValue = f.get(kalander);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.kalander, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.kalander);
        }
    }

    public void merge(Materialien materialien) {
        boolean updated = false;
        Field[] fields = materialien.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.materialien);
                Object newValue = f.get(materialien);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.materialien, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.materialien);
        }
    }

    public void merge(Person person) {
        boolean updated = false;
        Field[] fields = person.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.person);
                Object newValue = f.get(person);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.person, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Prepregeigenschaften prepregeigenschaften) {
        boolean updated = false;
        Field[] fields = prepregeigenschaften.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.prepregeigenschaften);
                Object newValue = f.get(prepregeigenschaften);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.prepregeigenschaften, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.prepregeigenschaften);
        }
    }

    public void merge(Temperaturen temperaturen) {
        boolean updated = false;
        Field[] fields = temperaturen.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.temperaturen);
                Object newValue = f.get(temperaturen);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.temperaturen, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.temperaturen);
        }
    }

    public void merge(Versuch versuch) {
        boolean updated = false;
        Field[] fields = versuch.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.versuch);
                Object newValue = f.get(versuch);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.versuch, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.versuch);
        }
    }

    public void merge(Versuchsreihe versuchsreihe) {
        boolean updated = false;
        Field[] fields = versuchsreihe.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.versuchsreihe);
                Object newValue = f.get(versuchsreihe);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.versuchsreihe, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.versuchsreihe);
        }
    }

    public void merge(Zugspannungen zugspannungen) {
        boolean updated = false;
        Field[] fields = zugspannungen.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.zugspannungen);
                Object newValue = f.get(zugspannungen);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.zugspannungen, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.zugspannungen);
        }
    }

    public void merge(Zugstation zugstation) {
        boolean updated = false;
        Field[] fields = zugstation.getClass().getFields();
        for(Field f : fields) {
            try {
                Object oldValue = f.get(this.zugstation);
                Object newValue = f.get(zugstation);
                if(newValue != null) {
                    if(!newValue.equals(oldValue)) {
                        updated = true;
                    }
                    f.set(this.zugstation, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(updated) {
            ObserverManager.notifyAllObservers(this.zugstation);
        }
    }


}
