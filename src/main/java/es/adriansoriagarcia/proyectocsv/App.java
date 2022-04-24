package es.adriansoriagarcia.proyectocsv;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane paneRoot;
        paneRoot = new Pane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        SeleccionOpciones seleccion = new SeleccionOpciones();
        paneRoot.getChildren().add(seleccion);
        
    }

    public static void main(String[] args) {
        launch();
    }

}