package de.fraas.prepregdatatracker.boot;

import de.fraas.prepregdatatracker.ui.utils.SpringFXMLLoader;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Marcel Fraas on 25.02.16.
 */
public class PrepregDataTrackerApplicationPreloader extends Preloader {

    private Stage stage;

    public void start(Stage stage) throws Exception {

        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/gui/view/Splashscreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification pn) {

        if (pn instanceof StateChangeNotification) {
            stage.hide();
        }
    }
}
