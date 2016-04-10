package de.fraas.prepregdatatracker.ui.controller;


import de.fraas.prepregdatatracker.services.UIUpdateService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Marcel Fraas on 18.10.15.
 */

@Component
public class ParameterController implements Initializable {

    @Autowired
    private UIUpdateService uiUpdateService;

    /**
     *  Materialien
     */

    @FXML
    private TextField tfFaserhalbzeug;

    @FXML
    private TextField tfHarzsystem;

    @FXML
    private TextField tfTrägermaterial;

    @FXML
    private TextField tfKaschiermaterial;


    /**
     *  Anlagenparameter
     */

    @FXML
    private TextField tfSpalthöhe;

    @FXML
    private TextField tfAnlagengeschwindigkeit;

    @FXML
    private TextField tfVerfahren;

    @FXML
    private TextField tfBahnverlauf;


    /**
     *  Temperaturen
     */

    @FXML
    private TextField tfAuftrag;

    @FXML
    private TextField tfKalander;

    @FXML
    private TextField tfTisch1;

    @FXML
    private TextField tfTisch2;

    @FXML
    private TextField tfKühlplatte;

    @FXML
    private TextField tfIrStatus;


    /**
     *  Zugspannungen
     */

    @FXML
    private TextField tfBeschichtung;

    @FXML
    private TextField tfZugwalze;

    @FXML
    private TextField tfGewebeOben;

    @FXML
    private TextField tfDeckpapierOben;

    @FXML
    private TextField tfDeckpapierUnten;

    @FXML
    private TextField tfAufwicklerD;

    @FXML
    private TextField tfAufwicklerP;

    @FXML
    private TextField tfFadenspannung;


    /**
     *  Kalander
     */

    @FXML
    private TextField tfDrehmoment;

    @FXML
    private TextField tfDrehzahl;

    @FXML
    private TextField tfDruckKalender;

    @FXML
    private TextField tfSpaltA;

    @FXML
    private TextField tfSpaltB;


    /**
     *  Zugstation
     */

    @FXML
    private TextField tfDruckZugstation;

    @FXML
    private TextField tfSpaltZugA;

    @FXML
    private TextField tfSpaltZugB;


    /**
     *  Aufwickler
     */

    @FXML
    private TextField tfTaperDeckpapier;

    @FXML
    private TextField tfTaperPrepreg;


    /**
     *  Prepregeigenschaften
     */

    @FXML
    private TextField tfFlächengewicht;

    @FXML
    private TextField tfHarzgehalt;

    @FXML
    private TextField tfPrepregbreite;

    @FXML
    private TextField tfLaufmeter;


    /**
     * initialize Method
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        uiUpdateService.updateAll();
    }

    public void setTfFaserhalbzeugText(String tfFaserhalbzeug) {
        Platform.runLater(()-> this.tfFaserhalbzeug.setText(tfFaserhalbzeug));
    }

    public void setTfHarzsystemText(String tfHarzsystem) {
        Platform.runLater(()-> this.tfHarzsystem.setText(tfHarzsystem));
    }

    public void setTfTrägermaterialText(String tfTrägermaterial) {
        Platform.runLater(()-> this.tfTrägermaterial.setText(tfTrägermaterial));
    }

    public void setTfKaschiermaterialText(String tfKaschiermaterial) {
        Platform.runLater(()-> this.tfKaschiermaterial.setText(tfKaschiermaterial));
    }

    public void setTfSpalthöheText(String tfSpalthöhe) {
        Platform.runLater(()-> this.tfSpalthöhe.setText(tfSpalthöhe));
    }

    public void setTfAnlagengeschwindigkeitText(String tfAnlagengeschwindigkeit) {
        Platform.runLater(()-> this.tfAnlagengeschwindigkeit.setText(tfAnlagengeschwindigkeit));
    }

    public void setTfVerfahrenText(String tfVerfahren) {
        Platform.runLater(()-> this.tfVerfahren.setText(tfVerfahren));
    }

    public void setTfBahnverlaufText(String tfBahnverlauf) {
        Platform.runLater(()-> this.tfBahnverlauf.setText(tfBahnverlauf));
    }

    public void setTfAuftragText(String tfAuftrag) {
        Platform.runLater(()-> this.tfAuftrag.setText(tfAuftrag));
    }

    public void setTfKalanderText(String tfKalander) {
        Platform.runLater(()-> this.tfKalander.setText(tfKalander));
    }

    public void setTfTisch1Text(String tfTisch1) {
        Platform.runLater(()-> this.tfTisch1.setText(tfTisch1));
    }

    public void setTfTisch2Text(String tfTisch2) {
        Platform.runLater(()-> this.tfTisch2.setText(tfTisch2));
    }

    public void setTfKühlplatteText(String tfKühlplatte) {
        Platform.runLater(()-> this.tfKühlplatte.setText(tfKühlplatte));
    }

    public void setTfIrStatusText(String tfIrStatus) {
        Platform.runLater(()-> this.tfIrStatus.setText(tfIrStatus));
    }

    public void setTfBeschichtungText(String tfBeschichtung) {
        Platform.runLater(()-> this.tfBeschichtung.setText(tfBeschichtung));
    }

    public void setTfZugwalzeText(String tfZugwalze) {
        Platform.runLater(()-> this.tfZugwalze.setText(tfZugwalze));
    }

    public void setTfGewebeObenText(String tfGewebeOben) {
        Platform.runLater(()-> this.tfGewebeOben.setText(tfGewebeOben));
    }

    public void setTfDeckpapierObenText(String tfDeckpapierOben) {
        Platform.runLater(()-> this.tfDeckpapierOben.setText(tfDeckpapierOben));
    }

    public void setTfDeckpapierUntenText(String tfDeckpapierUnten) {
        Platform.runLater(()-> this.tfDeckpapierUnten.setText(tfDeckpapierUnten));
    }

    public void setTfAufwicklerDText(String tfAufwicklerD) {
        Platform.runLater(()-> this.tfAufwicklerD.setText(tfAufwicklerD));
    }

    public void setTfAufwicklerPText(String tfAufwicklerP) {
        Platform.runLater(()-> this.tfAufwicklerP.setText(tfAufwicklerP));
    }

    public void setTfFadenspannungText(String tfFadenspannung) {
        Platform.runLater(()-> this.tfFadenspannung.setText(tfFadenspannung));
    }

    public void setTfDrehmomentText(String tfDrehmoment) {
        Platform.runLater(()-> this.tfDrehmoment.setText(tfDrehmoment));
    }

    public void setTfDrehzahlText(String tfDrehzahl) {
        Platform.runLater(()-> this.tfDrehzahl.setText(tfDrehzahl));
    }

    public void setTfDruckKalenderText(String tfDruckKalender) {
        Platform.runLater(()-> this.tfDruckKalender.setText(tfDruckKalender));
    }

    public void setTfSpaltAText(String tfSpaltA) {
        Platform.runLater(()-> this.tfSpaltA.setText(tfSpaltA));
    }

    public void setTfSpaltBText(String tfSpaltB) {
        Platform.runLater(()-> this.tfSpaltB.setText(tfSpaltB));
    }

    public void setTfDruckZugstationText(String tfDruckZugstation) {
        Platform.runLater(()-> this.tfDruckZugstation.setText(tfDruckZugstation));
    }

    public void setTfSpaltZugAText(String tfSpaltZugA) {
        Platform.runLater(()-> this.tfSpaltZugA.setText(tfSpaltZugA));
    }

    public void setTfSpaltZugBText(String tfSpaltZugB) {
        Platform.runLater(()-> this.tfSpaltZugB.setText(tfSpaltZugB));
    }

    public void setTfTaperDeckpapierText(String tfTaperDeckpapier) {
        Platform.runLater(()-> this.tfTaperDeckpapier.setText(tfTaperDeckpapier));
    }

    public void setTfTaperPrepregText(String tfTaperPrepreg) {
        Platform.runLater(()-> this.tfTaperPrepreg.setText(tfTaperPrepreg));
    }

    public void setTfFlächengewichtText(String tfFlächengewicht) {
        Platform.runLater(()-> this.tfFlächengewicht.setText(tfFlächengewicht));
    }

    public void setTfHarzgehaltText(String tfHarzgehalt) {
        Platform.runLater(()-> this.tfHarzgehalt.setText(tfHarzgehalt));
    }

    public void setTfPrepregbreiteText(String tfPrepregbreite) {
        Platform.runLater(()-> this.tfPrepregbreite.setText(tfPrepregbreite));
    }

    public void setTfLaufmeterText(String tfLaufmeter) {
        Platform.runLater(()-> this.tfLaufmeter.setText(tfLaufmeter));
    }
}
