package de.fraas.prepregdatatracker.data.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Marcel Fraas on 12.09.15.
 */

@Entity
@Table(name = "Versuchsreihe")
public class Versuchsreihe implements Updateable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Versuchsanlage")
    private String versuchsanlage;

    @Column(name = "Datum")
    private Date datum;

    @ManyToOne
    @JoinColumn(name = "PeId")
    private Person person;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "versuchsreihe")
    private Set<Versuch> versuche;

    public Long getvId() {
        return id;
    }

    public void setvId(Long vId) {
        this.id = vId;
    }

    public String getVersuchsanlage() {
        return versuchsanlage;
    }

    public void setVersuchsanlage(String versuchsanlage) {
        this.versuchsanlage = versuchsanlage;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Versuch> getVersuche() {
        return versuche;
    }

    public void setVersuche(Set<Versuch> versuche) {
        this.versuche = versuche;
    }
}
