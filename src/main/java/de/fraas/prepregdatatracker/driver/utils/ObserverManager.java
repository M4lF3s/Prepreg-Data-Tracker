package de.fraas.prepregdatatracker.driver.utils;


import de.fraas.prepregdatatracker.data.beans.Updateable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcel Fraas on 01.10.15.
 */
public abstract class ObserverManager {

    public static List<PropertyChangeObserver> pcoList = new ArrayList<PropertyChangeObserver>();

    public static void register(PropertyChangeObserver pco) {
        pcoList.add(pco);
    }


    public static void notifyAllObservers(Updateable updateable) {
        for(PropertyChangeObserver pco : pcoList) {
            pco.update(updateable);
        }
    }

}
