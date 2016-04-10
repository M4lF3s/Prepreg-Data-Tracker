package de.fraas.prepregdatatracker.boot;


import de.fraas.prepregdatatracker.boot.cofiguration.ApplicationContext;
import de.fraas.prepregdatatracker.boot.cofiguration.PersistenceContext;
import de.fraas.prepregdatatracker.threads.ReaderThread;
import de.fraas.prepregdatatracker.ui.utils.SpringFXMLLoader;
import insidefx.undecorator.UndecoratorScene;
import javafx.application.Preloader;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({ApplicationContext.class, PersistenceContext.class})
public class PrepregDataTrackerApplication extends JFXSupport {

    @Autowired
    private ReaderThread readerThread;

	@Override
	public void start(Stage stage) throws Exception {

        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

		//stage.setTitle(windowTitle);
        //System.out.println("ApplicationContext: " + applicationContext);
        SpringFXMLLoader.load(getClass().getResource("/gui/view/Parameter.fxml"));
		SpringFXMLLoader.load(getClass().getResource("/gui/view/Export.fxml"));
		Region root = SpringFXMLLoader.load(getClass().getResource("/gui/view/MainWindow.fxml"));
		final UndecoratorScene undecoratorScene = new UndecoratorScene(stage, null, root, "/gui/view/StageDecoration.fxml");
		stage.setScene(undecoratorScene);
		stage.show();

        /*
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("closing application now");
                readerThread.interrupt();
            }
        });
        */
	}

	public static void main(String[] args) {
		launchApp(PrepregDataTrackerApplication.class, args);
	}
}
