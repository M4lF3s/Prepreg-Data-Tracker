package de.fraas.prepregdatatracker.ui.controller;

import de.fraas.prepregdatatracker.data.beans.*;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import de.fraas.prepregdatatracker.driver.utils.PropertyChangeObserver;
import de.fraas.prepregdatatracker.services.ExportService;
import de.fraas.prepregdatatracker.ui.utils.CheckBoxCellFactory;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Marcel Fraas on 15.03.16.
 */

@Component
public class ExportController implements Initializable, PropertyChangeObserver {

    @FXML
    private Button btnExport;

    @FXML
    private TableView<ExportService.Tabledata> datatable;

    @FXML
    private TableColumn<ExportService.Tabledata, Boolean> checkBoxTableColumn;

    @FXML
    private TableColumn<ExportService.Tabledata, String> vnr;

    @FXML
    private TableColumn<ExportService.Tabledata, String> laufmeter;

    @FXML
    private TableColumn<ExportService.Tabledata, String> anlagengeschwindigkeit;

    @FXML
    private TableColumn<ExportService.Tabledata, String> tAuftrag;

    @FXML
    private TableColumn<ExportService.Tabledata, String> tKalander;

    @FXML
    private TableColumn<ExportService.Tabledata, String> tTisch1;

    @FXML
    private TableColumn<ExportService.Tabledata, String> tTisch2;

    @FXML
    private TableColumn<ExportService.Tabledata, String> tKühlplatte;

    @FXML
    private TableColumn<ExportService.Tabledata, String> irStatus;

    @FXML
    private TableColumn<ExportService.Tabledata, String> aufwicklerDeckpapier;

    @FXML
    private TableColumn<ExportService.Tabledata, String> aufwicklerPrepreg;

    @FXML
    private TableColumn<ExportService.Tabledata, String> pKalander;

    @FXML
    private TableColumn<ExportService.Tabledata, String> pZugstation;

    @FXML
    private TableColumn<ExportService.Tabledata, String> fadenspannung;

    @FXML
    private TableColumn<ExportService.Tabledata, String> spalthöhe;


    @Autowired
    private ExportService exportService;

    @PostConstruct
    public void init(){
        ObserverManager.register(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //checkBoxTableColumn.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, Boolean>("checkBoxTableColumn"));
        //checkBoxTableColumn.setCellValueFactory(c -> c.getValue().checkedProperty());
        vnr.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("vnr"));
        spalthöhe.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("spalthöhe"));
        anlagengeschwindigkeit.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("anlagengeschwindigkeit"));
        tAuftrag.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("tAuftrag"));
        tKalander.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("tKalander"));
        tTisch1.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("tTisch1"));
        tTisch2.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("tTisch2"));
        tKühlplatte.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("tKühlplatte"));
        irStatus.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("irStatus"));
        aufwicklerDeckpapier.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("aufwicklerDeckpapier"));
        aufwicklerPrepreg.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("aufwicklerPrepreg"));
        fadenspannung.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("fadenspannung"));
        pKalander.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("pKalander"));
        pZugstation.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("pZugstation"));
        laufmeter.setCellValueFactory(new PropertyValueFactory<ExportService.Tabledata, String>("laufmeter"));

        datatable.setItems(exportService.generateData());
    }


    @Override
    public void update(Anlagenparameter anlagenparameter) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Kalander kalander) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Prepregeigenschaften prepregeigenschaften) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Temperaturen temperaturen) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Zugspannungen zugspannungen) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Zugstation zugstation) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Aufwickler aufwickler) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Materialien materialien) { datatable.setItems(exportService.generateData()); }

    @Override
    public void update(Versuch versuch) {
        datatable.setItems(exportService.generateData());
    }

    @Override
    public void update(Versuchsreihe versuchsreihe) {
        datatable.setItems(exportService.generateData());
    }

    public void export(){
            //exportService.generateFile();
        try {
            exportService.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
