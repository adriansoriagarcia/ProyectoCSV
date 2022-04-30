package es.adriansoriagarcia.proyectocsv;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class SeleccionOpciones extends HBox{
    public SeleccionOpciones(ArrayList paises){
        //System.out.println(paises);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);

        // Crear un ComboBox con el contenido de la lista
        ComboBox<String> comboBoxPais = new ComboBox(FXCollections.observableList(paises));
        comboBoxPais.getSelectionModel().select("Selecciona el país.");
        comboBoxPais.setLayoutX(200);
        this.getChildren().add(comboBoxPais);
 
        // Crear un ArrayList con el contenido que se desee para el ComboBox
        ArrayList<String> lista = new ArrayList();
        lista.add("Máximo");
        lista.add("Mínimo");
        lista.add("Media");

        // Crear un ComboBox con el contenido de la lista
        ComboBox<String> comboBoxCalculo = new ComboBox(FXCollections.observableList(lista));
        comboBoxCalculo.getSelectionModel().select("Selecciona el calculo.");
        this.getChildren().add(comboBoxCalculo);
        
//Instantiating the Lighting class  
      

        //Boton encargardo de pasar por parametros a la clase ProcesarDatos las opciones seleccionadas.
        Button boton = new Button("Calcular");
        this.getChildren().add(boton);
        boton.setLayoutY(100);
        boton.setOnAction((t) -> {
            ProcesarDatos.CargarDatos(comboBoxCalculo,comboBoxPais);
            //System.out.println(comboBoxCalculo.getValue());
            //System.out.println(comboBoxPais.getValue());
            
        });
    }
}