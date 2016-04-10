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
@Table(name = "Anlagenparameter")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Anlagenparameter extends Parameter implements Updateable {

    @Column(name = "Spalthöhe")
    private String spalthöhe;

    @Column(name = "Anlagengeschwindigkeit")
    @S7Variable(type= S7Type.REAL, byteOffset=0, bitOffset=0)
    public double anlagengeschwindigkeit;

    @Column(name = "Verfahren")
    private String verfahren;

    @Column(name = "Bahnverlauf")
    private String bahnverlauf;

    public Anlagenparameter(){}
    public Anlagenparameter(Anlagenparameter a){
        this.spalthöhe = a.spalthöhe;
        this.anlagengeschwindigkeit = a.anlagengeschwindigkeit;
        this.verfahren = a.verfahren;
        this.bahnverlauf = a.bahnverlauf;
    }

    public String getSpalthöhe() {
        return spalthöhe;
    }

    public void setSpalthöhe(String spalthöhe) {
        this.spalthöhe = spalthöhe;
    }

    public double getAnlagengeschwindigkeit() {
        return anlagengeschwindigkeit;
    }

    public void setAnlagengeschwindigkeit(double anlagengeschwindigkeit) {
        this.anlagengeschwindigkeit = anlagengeschwindigkeit;
    }

    public String getVerfahren() {
        return verfahren;
    }

    public void setVerfahren(String verfahren) {
        this.verfahren = verfahren;
    }

    public String getBahnverlauf() {
        return bahnverlauf;
    }

    public void setBahnverlauf(String bahnverlauf) {
        this.bahnverlauf = bahnverlauf;
    }
}
