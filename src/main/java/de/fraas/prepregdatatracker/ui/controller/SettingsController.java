package de.fraas.prepregdatatracker.ui.controller;

import de.fraas.prepregdatatracker.services.ConfigurationService;
import de.fraas.prepregdatatracker.services.ConnectionService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Marcel Fraas on 08.10.15.
 */
@Component
public class SettingsController implements Initializable {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private ConnectionService connectionService;

    @FXML
    private TextField lblIP;

    @FXML
    private Button btnConnect;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblIP.setText(configurationService.getIp());
    }

    public void connect() {
        configurationService.setIp(lblIP.getText());
        connectionService.init();
    }

}
