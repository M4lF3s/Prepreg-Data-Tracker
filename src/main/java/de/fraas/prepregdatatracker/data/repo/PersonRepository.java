package de.fraas.prepregdatatracker.data.repo;


import de.fraas.prepregdatatracker.data.beans.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marcel Fraas on 19.09.15.
 */

public interface PersonRepository extends BaseRepository<Person, Long> {

    Person save(Person persisted);

    void delete(Person deleted);

    // TODO: Implement Query update
    // Person update(Person updated);

    // TODO: Implement Query addVersuchsreihe
    // void addVersuchsreihe(Versuchsreihe versuchsreihe);

    List<Person> findPersonByName(String name);

    List<Person> findAll();

    // TODO: Implement Query findAllVersuchsreiheByPerson
    // List<Versuchsreihe> findAllVersuchsreiheByPerson(Person person);

}
