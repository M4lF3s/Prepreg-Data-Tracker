package de.fraas.prepregdatatracker.data.repo;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by Marcel Fraas on 06.09.15.
 */
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    /*
    void delete(T deleted);

    List<T> findAll();

    Optional<T> findOne(ID id);

    T save(T persisted);
    */
}