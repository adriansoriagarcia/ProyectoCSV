package es.adriansoriagarcia.proyectocsv;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
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
        paneRoot.setSpacing(50);
        
        //Declaramos y creamos el objeto procesar.
        ProcesarDatos procesar = new ProcesarDatos();
        //Añadimos el objeto creado anteriormente al panel.
        paneRoot.getChildren().add(procesar);
        
        //Declaramos y creamos el objeto muestraDato.
        MuestraDato muestraDato = new MuestraDato();
        //Añadimos el objeto creado anteriormente al panel.
        paneRoot.getChildren().add(muestraDato);
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}