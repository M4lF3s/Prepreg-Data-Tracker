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
@Table(name = "Zugstation")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Zugstation extends Parameter implements Updateable {

    @Column(name = "Druck_Zugstation")
    @S7Variable(type= S7Type.REAL, byteOffset=146, bitOffset=0)
    public double pZugstation;

    @Column(name = "Spalt_Zugstation_A")
    private String spaltZugstationA;

    @Column(name = "Spalt_Zugstation_B")
    private String spaltZugstationB;

    public Zugstation(){}
    public Zugstation(Zugstation z){
        this.pZugstation = z.getpZugstation();
        this.spaltZugstationA = z.getSpaltZugstationA();
        this.spaltZugstationB = z.getSpaltZugstationB();
    }

    public double getpZugstation() {
        return pZugstation;
    }

    public void setpZugstation(double pZugstation) {
        this.pZugstation = pZugstation;
    }

    public String getSpaltZugstationA() {
        return spaltZugstationA;
    }

    public void setSpaltZugstationA(String spaltZugstationA) {
        this.spaltZugstationA = spaltZugstationA;
    }

    public String getSpaltZugstationB() {
        return spaltZugstationB;
    }

    public void setSpaltZugstationB(String spaltZugstationB) {
        this.spaltZugstationB = spaltZugstationB;
    }
}
