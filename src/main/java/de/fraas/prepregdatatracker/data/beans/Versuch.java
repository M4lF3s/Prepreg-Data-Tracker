package de.fraas.prepregdatatracker.data.beans;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcel Fraas on 13.09.15.
 */

@Entity
@Table(name = "Versuch")
public class Versuch implements Updateable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Versuchsnummer")
    private int vnr;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "VRId")
    private Versuchsreihe versuchsreihe;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<de.fraas.prepregdatatracker.data.beans.Parameter> parameter;

    public long getVid() {
        return id;
    }

    public void setVid(long vid) {
        this.id = vid;
    }

    public int getVnr() {
        return vnr;
    }

    public void setVnr(int vnr) {
        this.vnr = vnr;
    }

    public Versuchsreihe getVersuchsreihe() {
        return versuchsreihe;
    }

    public void setVersuchsreihe(Versuchsreihe versuchsreihe) {
        this.versuchsreihe = versuchsreihe;
    }

    public Set<Parameter> getParameter() {
        return parameter;
    }

    public void setParameter(Set<de.fraas.prepregdatatracker.data.beans.Parameter> parameter) {
        //System.out.println(this.parameter);
        this.parameter = parameter;
    }
}
