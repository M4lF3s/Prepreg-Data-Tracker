package de.fraas.prepregdatatracker.data.beans;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Marcel Fraas on 12.09.15.
 */

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Versuchsreihe> versuchsreihen;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Versuchsreihe> getVersuchreihen() {
        return versuchsreihen;
    }

    public void addVersuchsreihe(Versuchsreihe versuchreihe) {
        this.versuchsreihen.add(versuchreihe);
    }

    @Override
    public String toString(){
        return new String(this.name);
    }
}
