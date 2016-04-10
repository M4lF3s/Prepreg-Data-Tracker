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
@Table(name = "Kalander")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Kalander extends Parameter implements Updateable {

    @Column(name = "Drehmomhent")
    private String drehmoment;

    @Column(name = "Drehzahl")
    @S7Variable(type = S7Type.REAL, byteOffset = 36)
    public double drehzahl;

    @Column(name = "Druck_Kalander")
    @S7Variable(type= S7Type.REAL, byteOffset=142, bitOffset=0)
    public double pKalander;

    @Column(name = "Spalt_A")
    private String spaltA;

    @Column(name = "Spalt_B")
    private String spaltB;

    public Kalander(){}
    public Kalander(Kalander k){
        this.drehmoment = k.getDrehmoment();
        this.drehzahl = k.getDrehzahl();
        this.pKalander = k.getpKalander();
        this.spaltA = k.getSpaltA();
        this.spaltB = k.getSpaltB();
    }

    public String getDrehmoment() {
        return drehmoment;
    }

    public void setDrehmoment(String drehmoment) {
        this.drehmoment = drehmoment;
    }

    public double getDrehzahl() {
        return drehzahl;
    }

    public void setDrehzahl(double drehzahl) {
        this.drehzahl = drehzahl;
    }

    public double getpKalander() {
        return pKalander;
    }

    public void setpKalander(double pKalander) {
        this.pKalander = pKalander;
    }

    public String getSpaltA() {
        return spaltA;
    }

    public void setSpaltA(String spaltA) {
        this.spaltA = spaltA;
    }

    public String getSpaltB() {
        return spaltB;
    }

    public void setSpaltB(String spaltB) {
        this.spaltB = spaltB;
    }
}
