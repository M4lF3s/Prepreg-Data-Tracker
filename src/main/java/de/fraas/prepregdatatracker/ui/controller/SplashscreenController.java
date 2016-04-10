package de.fraas.prepregdatatracker.ui.controller;


import de.fraas.prepregdatatracker.ui.utils.FadeInLeftTransition;
import de.fraas.prepregdatatracker.ui.utils.FadeInRightTransition;
import de.fraas.prepregdatatracker.ui.utils.FadeInTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Marcel Fraas on 14.10.15.
 */
public class SplashscreenController implements Initializable {

    @FXML
    private Text lblWelcome;

    @FXML
    private Text lblCopyright;

    @FXML
    private VBox vboxBottom;

    @FXML
    private Label lblClose;

    @FXML
    private ImageView imgLoading;

    Stage stage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new FadeInLeftTransition(lblWelcome).play();
        new FadeInRightTransition(lblCopyright).play();
        new FadeInTransition(vboxBottom).play();
    }

}
