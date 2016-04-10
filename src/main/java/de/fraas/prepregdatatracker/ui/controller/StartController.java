package de.fraas.prepregdatatracker.ui.controller;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import de.fraas.prepregdatatracker.services.UIUpdateService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Component;

/**
 * Created by Marcel Fraas on 23.03.16.
 */

@Component
public class StartController {

    @FXML
    private TextField tfFaserhalbzeug;

    @FXML
    private TextField tfHarzsystem;

    @FXML
    private TextField tfTrägermaterial;

    @FXML
    private TextField tfKaschiermaterial;

    @FXML
    private TextField tfSpalthöhe;

    @FXML
    private TextField tfVerfahren;

    @FXML
    private TextField tfBahnverlauf;

    @FXML
    private TextField tfFadenspannung;

    @FXML
    private TextField tfDrehmoment;

    @FXML
    private TextField tfSpaltA;

    @FXML
    private TextField tfSpaltB;

    @FXML
    private TextField tfSpaltZugA;

    @FXML
    private TextField tfSpaltZugB;

    @FXML
    private TextField tfFlächengewicht;

    @FXML
    private TextField tfHarzgehalt;

    @FXML
    private TextField tfPrepregbreite;

    @Autowired
    private Materialien materialien;

    @Autowired
    private Anlagenparameter anlagenparameter;

    @Autowired
    private Zugspannungen zugspannungen;

    @Autowired
    private Kalander kalander;

    @Autowired
    private Zugstation zugstation;

    @Autowired
    private Prepregeigenschaften prepregeigenschaften;

    @Autowired
    private DataBean dataBean;

    public void read() {
        materialien.setFaserhalbzeug(String.valueOf(tfFaserhalbzeug.getText()));
        materialien.setHarzsystem(String.valueOf(tfHarzsystem.getText()));
        materialien.setTrägermaterial(String.valueOf(tfTrägermaterial.getText()));
        materialien.setKaschiermaterial(String.valueOf(tfKaschiermaterial.getText()));

        anlagenparameter.setSpalthöhe(String.valueOf(tfSpalthöhe.getText()));
        anlagenparameter.setVerfahren(String.valueOf(tfVerfahren.getText()));
        anlagenparameter.setBahnverlauf(String.valueOf(tfBahnverlauf.getText()));

        zugspannungen.setFadenspannung(String.valueOf(tfFadenspannung.getText()));

        kalander.setDrehmoment(String.valueOf(tfDrehmoment.getText()));
        kalander.setSpaltA(String.valueOf(tfSpaltA.getText()));
        kalander.setSpaltB(String.valueOf(tfSpaltB.getText()));

        zugstation.setSpaltZugstationA(String.valueOf(tfSpaltZugA.getText()));
        zugstation.setSpaltZugstationB(String.valueOf(tfSpaltZugB.getText()));

        prepregeigenschaften.setFlächengewicht(String.valueOf(tfFlächengewicht.getText()));
        prepregeigenschaften.setHarzgehalt(String.valueOf(tfHarzgehalt.getText()));
        prepregeigenschaften.setPrepregbreite(String.valueOf(tfPrepregbreite.getText()));


        dataBean.merge(materialien);
        ObserverManager.notifyAllObservers(dataBean.getMaterialien());

        dataBean.merge(anlagenparameter);
        ObserverManager.notifyAllObservers(dataBean.getAnlagenparameter());

        dataBean.merge(zugspannungen);
        ObserverManager.notifyAllObservers(dataBean.getZugspannungen());

        dataBean.merge(kalander);
        ObserverManager.notifyAllObservers(dataBean.getKalander());

        dataBean.merge(zugstation);
        ObserverManager.notifyAllObservers(dataBean.getZugstation());

        dataBean.merge(prepregeigenschaften);
        ObserverManager.notifyAllObservers(dataBean.getPrepregeigenschaften());

    }
}
