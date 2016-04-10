package de.fraas.prepregdatatracker.data.repo;


import de.fraas.prepregdatatracker.data.beans.Parameter;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcel Fraas on 19.09.15.
 */

public interface ParameterRepository extends BaseRepository<Parameter, Long> {

    Parameter save(Parameter parameter);

    void delete(Parameter parameter);

    Parameter findById(long PaId);

}
