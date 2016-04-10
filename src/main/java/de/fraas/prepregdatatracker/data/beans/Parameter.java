package de.fraas.prepregdatatracker.data.beans;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcel Fraas on 13.09.15.
 */

@Entity
@Table(name = "Parameter")
@Inheritance(strategy = InheritanceType.JOINED)
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Parameter_ID")
    private long id;

    @ManyToMany(mappedBy = "parameter", cascade = CascadeType.MERGE)
    private Set<Versuch> versuche;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Versuch> getVersuche() {
        return versuche;
    }

    public void setVersuche(Set<Versuch> versuche) {
        this.versuche = versuche;
    }
}
