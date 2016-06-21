package de.fraas.prepregdatatracker.ui.controller;


import de.fraas.prepregdatatracker.data.beans.Person;
import de.fraas.prepregdatatracker.data.beans.Versuchsreihe;
import de.fraas.prepregdatatracker.data.repo.PersonRepository;
import de.fraas.prepregdatatracker.driver.utils.ObserverManager;
import de.fraas.prepregdatatracker.services.ConnectionService;
import de.fraas.prepregdatatracker.threads.ReaderThread;
import de.fraas.prepregdatatracker.ui.utils.SpringFXMLLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author Marcel Fraas
 */

@Component
public class MainWindowController implements Initializable {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private ReaderThread readerThread;

    @Autowired
    private Person person;

    @Autowired
    private StartController startController;

    @Autowired
    private Versuchsreihe versuchsreihe;

    @FXML
    private ListView<String> listMenu;

    @FXML
    private Button btnLogout;

    @FXML
    private ImageView logo;

    @FXML
    private AnchorPane paneData;

    @FXML
    private AnchorPane paneParent;

    @FXML
    private Button btnStart;

    @FXML
    private Label lblConnection;

    @FXML
    private Label lblStart;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtPerson;

    @FXML
    private TextField txtAnlage;

    private boolean isRunning = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.isRunning = false;
        Platform.runLater(() -> {
            listMenu.getItems().addAll(" Start", " Parameter", " Export", " Einstellungen");
            listMenu.getSelectionModel().select(0);
            loadAnchorPane(paneData, "Start.fxml");
            txtDate.setText((new Date().toString()));
        });
        if(!connectionService.isConnected()){
            lblConnection.setText("No CPU");
            btnStart.setDisable(true);
        } else {
            lblConnection.setText("Connected to CPU at: " + connectionService.getIp());
            lblConnection.setTextFill(Paint.valueOf("GREEN"));
        }
    }

    @FXML
    private void aksiResize(ActionEvent event) {
    }


    public void start() {
        if(isRunning){
            this.isRunning = false;
            txtPerson.setEditable(true);
            txtPerson.setDisable(false);
            lblStart.setText("Standby");
            lblStart.setTextFill(Paint.valueOf("ORANGE"));
            btnStart.setText("START");

            readerThread.setPaused(true);
        } else {
            this.isRunning = true;
            txtPerson.setEditable(false);
            txtPerson.setDisable(true);
            person.setName(txtPerson.getText());
            versuchsreihe.setPerson(person);
            versuchsreihe.setVersuchsanlage(txtAnlage.getText());
            startController.read();
            lblStart.setText("Reading");
            lblStart.setTextFill(Paint.valueOf("GREEN"));
            btnStart.setText("STOP");

            if(!readerThread.isAlive()){
                readerThread.start();
            } else {
                readerThread.setPaused(false);
            }


        }
    }

    @FXML
    private void listMenu(MouseEvent event) {
        switch(listMenu.getSelectionModel().getSelectedIndex()){
            case 0:{
                loadAnchorPane(paneData, "Start.fxml");
            }break;
            case 1:{
                loadAnchorPane(paneData, "Parameter.fxml");
            }break;
            case 2:{
                loadAnchorPane(paneData, "Export.fxml");
            }break;
            case 3:{
                loadAnchorPane(paneData, "Settings.fxml");
            }break;
        }
    }

    public void loadAnchorPane(AnchorPane ap, String a){
        Platform.runLater(() -> {
            AnchorPane p = SpringFXMLLoader.load(getClass().getResource("/gui/view/" + a));
            ap.getChildren().setAll(p);
        });
    }
}