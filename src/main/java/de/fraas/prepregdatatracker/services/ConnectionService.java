package de.fraas.prepregdatatracker.services;

import de.fraas.prepregdatatracker.driver.S7Serializer;
import io.rudin.s7connector.exception.S7Exception;
import io.rudin.s7connector.impl.S7Connector;
import io.rudin.s7connector.impl.S7TCPConnection;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Marcel Fraas on 01.03.16.
 */

@Service
public class ConnectionService {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private S7Serializer s7Serializer;

    private String ip;

    private boolean connected = false;

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @PostConstruct
    public void init(){
        this.ip = configurationService.getIp();
        connect();
    }


    public void connect(){
        try{
            S7Connector c = new S7TCPConnection(ip);
            s7Serializer.setConnector(c);
            this.connected = true;
            //throw new S7Exception();
        } catch (S7Exception e){
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ATTENTION");
                alert.setHeaderText("S7Exception");
                alert.setContentText("Could not connect to a S7 CPU");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                String exceptionText = sw.toString();
                Label label = new Label("The exception stacktrace was:");

                TextArea textArea = new TextArea(exceptionText);
                textArea.setEditable(false);
                textArea.setWrapText(true);

                textArea.setMaxWidth(Double.MAX_VALUE);
                textArea.setMaxHeight(Double.MAX_VALUE);
                GridPane.setVgrow(textArea, Priority.ALWAYS);
                GridPane.setHgrow(textArea, Priority.ALWAYS);

                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                expContent.add(label, 0, 0);
                expContent.add(textArea, 0, 1);

                // Set expandable Exception into the dialog pane.
                alert.getDialogPane().setExpandableContent(expContent);

                //alert.showAndWait();
                alert.show();
            });
        }
    }
}
