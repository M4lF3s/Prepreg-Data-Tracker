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
@Table(name = "Temperaturen")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Temperaturen extends Parameter implements Updateable {

    @Column(name = "Autrag")
    @S7Variable(type= S7Type.REAL, byteOffset=102, bitOffset=0)
    public double tAuftrag;

    @Column(name = "Kalander")
    @S7Variable(type=S7Type.REAL, byteOffset=110, bitOffset=0)
    public double tKalander;

    @Column(name = "Tisch_1")
    @S7Variable(type=S7Type.REAL, byteOffset=126, bitOffset=0)
    public double tTisch1;

    @Column(name = "Tisch_2")
    @S7Variable(type=S7Type.REAL, byteOffset=134, bitOffset=0)
    public double tTisch2;

    @Column(name = "Kühlplatte")
    @S7Variable(type=S7Type.REAL, byteOffset=154, bitOffset=0)
    public double tKühlplatte;

    @Column(name = "IR_Status")
    @S7Variable(type=S7Type.BOOL, byteOffset=244, bitOffset=0)
    public boolean irStatus;

    public Temperaturen(){}
    public Temperaturen(Temperaturen t){
        this.tAuftrag = t.gettAuftrag();
        this.tKalander = t.gettKalander();
        this.tTisch1 = t.gettTisch1();
        this.tTisch2 = t.gettTisch2();
        this.tKühlplatte = t.gettKühlplatte();
        this.irStatus = t.isIrStatus();
    }

    public double gettAuftrag() {
        return tAuftrag;
    }

    public void settAuftrag(double tAuftrag) {
        this.tAuftrag = tAuftrag;
    }

    public double gettKalander() {
        return tKalander;
    }

    public void settKalander(double tKalander) {
        this.tKalander = tKalander;
    }

    public double gettTisch1() {
        return tTisch1;
    }

    public void settTisch1(double tTisch1) {
        this.tTisch1 = tTisch1;
    }

    public double gettTisch2() {
        return tTisch2;
    }

    public void settTisch2(double tTisch2) {
        this.tTisch2 = tTisch2;
    }

    public double gettKühlplatte() {
        return tKühlplatte;
    }

    public void settKühlplatte(double tKühlplatte) {
        this.tKühlplatte = tKühlplatte;
    }

    public boolean isIrStatus() {
        return irStatus;
    }

    public void setIrStatus(boolean irStatus) {
        this.irStatus = irStatus;
    }
}
