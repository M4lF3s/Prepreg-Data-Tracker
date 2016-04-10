package de.fraas.prepregdatatracker.driver.utils;


import de.fraas.prepregdatatracker.data.beans.*;

/**
 * Created by Marcel Fraas on 31.08.15.
 */
public interface PropertyChangeObserver {

    void update(Anlagenparameter anlagenparameter);
    void update(Kalander kalander);
    void update(Prepregeigenschaften prepregeigenschaften);
    void update(Temperaturen temperaturen);
    void update(Zugspannungen zugspannungen);
    void update(Zugstation zugstation);
    void update(Materialien materialien);
    void update(Aufwickler aufwickler);
    void update(Versuch versuch);
    void update(Versuchsreihe versuchsreihe);

    default void update(Updateable u) {
        if(u.getClass().equals(Anlagenparameter.class)) {
            Anlagenparameter param = Anlagenparameter.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Kalander.class)) {
            Kalander param = Kalander.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Prepregeigenschaften.class)) {
            Prepregeigenschaften param = Prepregeigenschaften.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Temperaturen.class)) {
            Temperaturen param = Temperaturen.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Zugspannungen.class)) {
            Zugspannungen param = Zugspannungen.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Zugstation.class)) {
            Zugstation param = Zugstation.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Aufwickler.class)) {
            Aufwickler param = Aufwickler.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Materialien.class)) {
            Materialien param = Materialien.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Versuch.class)) {
            Versuch param = Versuch.class.cast(u);
            update(param);
        }
        else if(u.getClass().equals(Versuchsreihe.class)) {
            Versuchsreihe param = Versuchsreihe.class.cast(u);
            update(param);
        }
    }



}
