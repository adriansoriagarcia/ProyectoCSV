package es.adriansoriagarcia.proyectocsv;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox paneRoot;
        paneRoot = new VBox();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        paneRoot.setAlignment(Pos.TOP_CENTER);
        paneRoot.setSpacing(30);
        //SeleccionOpciones seleccion = new SeleccionOpciones();
        //paneRoot.getChildren().add(seleccion);
        
        ProcesarDatos procesar = new ProcesarDatos();
        paneRoot.getChildren().add(procesar);
        
        MuestraDato muestraDato = new MuestraDato();
        muestraDato.setLayoutY(100);
        paneRoot.getChildren().add(muestraDato);
        
    }

    public static void main(String[] args) {
        launch();
    }

}