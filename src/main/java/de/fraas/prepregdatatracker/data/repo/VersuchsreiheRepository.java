package de.fraas.prepregdatatracker.data.repo;


import de.fraas.prepregdatatracker.data.beans.Versuchsreihe;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Marcel Fraas on 19.09.15.
 */

public interface VersuchsreiheRepository extends BaseRepository<Versuchsreihe, Long>{

    Versuchsreihe save(Versuchsreihe persisted);

    void delete(Versuchsreihe deleted);

    // TODO: Implement Query update
    // Versuchsreihe update(Versuchsreihe updatet);

    // TODO: Implement Query addVersuche
    // void addVersuch(Versuch versuch);

    List<Versuchsreihe> findVersuchsreiheByDatum(Date datum);


}
