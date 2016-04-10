package de.fraas.prepregdatatracker.data.beans;

import io.rudin.s7connector.bean.annotation.S7Variable;
import io.rudin.s7connector.impl.utils.S7Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Marcel Fraas on 18.09.15.
 */

@Entity
@Table(name = "Aufwickler")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Aufwickler extends Parameter implements Updateable {

    @Column(name = "Taper_Deckpapier")
    @S7Variable(type= S7Type.REAL, byteOffset=50)
    public double taperDeckpapier;

    @Column(name = "Taper_PrePreg")
    @S7Variable(type= S7Type.REAL, byteOffset=62)
    public double taperPrepreg;

    public Aufwickler(){}
    public Aufwickler(Aufwickler a){
        this.taperDeckpapier = a.getTaperDeckpapier();
        this.taperPrepreg = a.getTaperPrepreg();
    }

    public double getTaperDeckpapier() {
        return taperDeckpapier;
    }

    public void setTaperDeckpapier(double taperDeckpapier) {
        this.taperDeckpapier = taperDeckpapier;
    }

    public double getTaperPrepreg() {
        return taperPrepreg;
    }

    public void setTaperPrepreg(double taperPrepreg) {
        this.taperPrepreg = taperPrepreg;
    }
}
