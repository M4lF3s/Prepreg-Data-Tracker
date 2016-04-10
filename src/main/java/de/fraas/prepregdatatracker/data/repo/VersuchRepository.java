package de.fraas.prepregdatatracker.data.repo;


import de.fraas.prepregdatatracker.data.beans.Versuch;
import de.fraas.prepregdatatracker.data.beans.Versuchsreihe;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marcel Fraas on 19.09.15.
 */

public interface VersuchRepository extends BaseRepository<Versuch, Long> {

    Versuch save(Versuch persisted);

    void delete(Versuch deleted);

    Versuch findById(long vId);

    List<Versuch> findAll();

    List<Versuch> findByVersuchsreihe(Versuchsreihe versuchsreihe);

    // TODO: Implement Query addParameter
    // void addParameter(Parameter parameter);

    // TODO: Implement Query removeParameter
    // void removeParameter(Parameter parameter);

}
