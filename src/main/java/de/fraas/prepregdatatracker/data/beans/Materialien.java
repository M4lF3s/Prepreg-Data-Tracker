package de.fraas.prepregdatatracker.data.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Marcel Fraas on 13.09.15.
 */

@Entity
@Table(name = "Materialien")
@PrimaryKeyJoinColumn(name = "Parameter_ID")
public class Materialien extends Parameter implements Updateable {

    @Column(name = "Faserhalbzeug")
    private String faserhalbzeug;

    @Column(name = "Harzsystem")
    private String harzsystem;

    @Column(name = "Trägermaterial")
    private String trägermaterial;

    @Column(name = "Kaschiermaterial")
    private String kaschiermaterial;

    public Materialien(){}
    public Materialien(Materialien m){
        this.faserhalbzeug = m.getFaserhalbzeug();
        this.harzsystem = m.getHarzsystem();
        this.trägermaterial = m.getTrägermaterial();
        this.kaschiermaterial = m.getKaschiermaterial();
    }

    public String getFaserhalbzeug() {
        return faserhalbzeug;
    }

    public void setFaserhalbzeug(String faserhalbzeug) {
        this.faserhalbzeug = faserhalbzeug;
    }

    public String getHarzsystem() {
        return harzsystem;
    }

    public void setHarzsystem(String harzsystem) {
        this.harzsystem = harzsystem;
    }

    public String getTrägermaterial() {
        return trägermaterial;
    }

    public void setTrägermaterial(String trägermaterial) {
        this.trägermaterial = trägermaterial;
    }

    public String getKaschiermaterial() {
        return kaschiermaterial;
    }

    public void setKaschiermaterial(String kaschiermaterial) {
        this.kaschiermaterial = kaschiermaterial;
    }
}
