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
@Table(name = "Zugspannungen")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Zugspannungen extends Parameter implements Updateable {

    @Column(name = "Beschichtung")
    @S7Variable(type=S7Type.REAL, byteOffset=70, bitOffset=0)
    public double beschichtung;

    @Column(name = "Zugwalze")
    @S7Variable(type=S7Type.REAL, byteOffset = 4)
    public double zugwalze;

    @Column(name = "Gewebe_oben")
    @S7Variable(type=S7Type.REAL, byteOffset = 78)
    public double gewebeOben;

    @Column(name = "Deckpapier_oben")
    @S7Variable(type = S7Type.REAL, byteOffset = 86)
    public double deckpapierOben;

    @Column(name = "Deckpapier_unten")
    @S7Variable(type = S7Type.REAL, byteOffset = 94)
    public double deckpapierUnten;

    @Column(name = "Aufwickler_Deckpapier")
    @S7Variable(type= S7Type.REAL, byteOffset=46, bitOffset=0)
    public double aufwicklerDeckpapier;

    @Column(name = "Aufwickler_PrePreg")
    @S7Variable(type=S7Type.REAL, byteOffset=58, bitOffset=0)
    public double aufwicklerPrepreg;

    @Column(name = "Fadenspannung")
    private String fadenspannung;

    public Zugspannungen(){}
    public Zugspannungen(Zugspannungen z){
        this.beschichtung = z.getBeschichtung();
        this.zugwalze = z.getZugwalze();
        this.gewebeOben = z.getGewebeOben();
        this.deckpapierOben = z.getDeckpapierOben();
        this.deckpapierUnten = z.getDeckpapierUnten();
        this.aufwicklerDeckpapier = z.getAufwicklerDeckpapier();
        this.aufwicklerPrepreg = z.getAufwicklerPrepreg();
        this.fadenspannung = z.getFadenspannung();
    }

    public double getBeschichtung() {
        return beschichtung;
    }

    public void setBeschichtung(double beschichtung) {
        this.beschichtung = beschichtung;
    }

    public double getZugwalze() {
        return zugwalze;
    }

    public void setZugwalze(double zugwalze) {
        this.zugwalze = zugwalze;
    }

    public double getGewebeOben() {
        return gewebeOben;
    }

    public void setGewebeOben(double gewebeOben) {
        this.gewebeOben = gewebeOben;
    }

    public double getDeckpapierOben() {
        return deckpapierOben;
    }

    public void setDeckpapierOben(double deckpapierOben) {
        this.deckpapierOben = deckpapierOben;
    }

    public double getDeckpapierUnten() {
        return deckpapierUnten;
    }

    public void setDeckpapierUnten(double deckpapierUnten) {
        this.deckpapierUnten = deckpapierUnten;
    }

    public double getAufwicklerDeckpapier() {
        return aufwicklerDeckpapier;
    }

    public void setAufwicklerDeckpapier(double aufwicklerDeckpapier) {
        this.aufwicklerDeckpapier = aufwicklerDeckpapier;
    }

    public double getAufwicklerPrepreg() {
        return aufwicklerPrepreg;
    }

    public void setAufwicklerPrepreg(double aufwicklerPrepreg) {
        this.aufwicklerPrepreg = aufwicklerPrepreg;
    }

    public String getFadenspannung() {
        return fadenspannung;
    }

    public void setFadenspannung(String fadenspannung) {
        this.fadenspannung = fadenspannung;
    }
}
