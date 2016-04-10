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
@Table(name = "Prepreg_Eigenschaften")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Prepregeigenschaften extends Parameter implements Updateable {

    @Column(name = "Flächengewicht")
    private String flächengewicht;

    @Column(name = "Harzgehalt")
    private String harzgehalt;

    @Column(name = "Prepregbreite")
    private String prepregbreite;

    @Column(name = "Laufmeter")
    @S7Variable(type= S7Type.REAL, byteOffset=158, bitOffset=0)
    public double laufmeter;

    public Prepregeigenschaften(){}
    public Prepregeigenschaften(Prepregeigenschaften p){
        this.flächengewicht = p.getFlächengewicht();
        this.harzgehalt = p.getHarzgehalt();
        this.prepregbreite = p.getPrepregbreite();
        this.laufmeter = p.getLaufmeter();
    }

    public String getFlächengewicht() {
        return flächengewicht;
    }

    public void setFlächengewicht(String flächengewicht) {
        this.flächengewicht = flächengewicht;
    }

    public String getHarzgehalt() {
        return harzgehalt;
    }

    public void setHarzgehalt(String harzgehalt) {
        this.harzgehalt = harzgehalt;
    }

    public String getPrepregbreite() {
        return prepregbreite;
    }

    public void setPrepregbreite(String prepregbreite) {
        this.prepregbreite = prepregbreite;
    }

    public double getLaufmeter() {
        return laufmeter;
    }

    public void setLaufmeter(double laufmeter) {
        this.laufmeter = laufmeter;
    }
}
