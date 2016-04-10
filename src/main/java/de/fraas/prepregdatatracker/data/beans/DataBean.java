package de.fraas.prepregdatatracker.data.beans;

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
        Field[] fields = anlagenparameter.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(anlagenparameter);
                if(value != null) {
                    f.set(this.anlagenparameter, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Aufwickler aufwickler) {
        Field[] fields = aufwickler.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(aufwickler);
                if(value != null) {
                    f.set(this.aufwickler, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Kalander kalander) {
        Field[] fields = kalander.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(kalander);
                if(value != null) {
                    f.set(this.kalander, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Materialien materialien) {
        Field[] fields = materialien.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(materialien);
                if(value != null) {
                    f.set(this.materialien, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Person person) {
        Field[] fields = person.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(person);
                if(value != null) {
                    f.set(this.person, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Prepregeigenschaften prepregeigenschaften) {
        Field[] fields = prepregeigenschaften.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(prepregeigenschaften);
                if(value != null) {
                    f.set(this.prepregeigenschaften, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Temperaturen temperaturen) {
        Field[] fields = temperaturen.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(temperaturen);
                if(value != null) {
                    f.set(this.temperaturen, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Versuch versuch) {
        Field[] fields = versuch.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(versuch);
                if(value != null) {
                    f.set(this.versuch, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Versuchsreihe versuchsreihe) {
        Field[] fields = versuchsreihe.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(versuchsreihe);
                if(value != null) {
                    f.set(this.versuchsreihe, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Zugspannungen zugspannungen) {
        Field[] fields = zugspannungen.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(zugspannungen);
                if(value != null) {
                    f.set(this.zugspannungen, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void merge(Zugstation zugstation) {
        Field[] fields = zugstation.getClass().getFields();
        for(Field f : fields) {
            try {
                Object value = f.get(zugstation);
                if(value != null) {
                    f.set(this.zugstation, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
