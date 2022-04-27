package es.adriansoriagarcia.proyectocsv;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class MuestraDato extends HBox{
    static TableView tableView;
    static Label label;
    public MuestraDato(){
       this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        //this.setLayoutY(100);
        tableView = new TableView();//Declaración de la tabla.
        TableColumn colPais = new TableColumn<>("Pais");
        colPais.setCellValueFactory(new PropertyValueFactory("pais"));//Atributo.
        TableColumn colCodigo = new TableColumn<>("Codigo");
        colCodigo.setCellValueFactory(new PropertyValueFactory("pais"));//Atributo.
        TableColumn colPorcentaje = new TableColumn<>("Porcentaje");
        colPorcentaje.setCellValueFactory(new PropertyValueFactory("porcentaje"));//Atributo.
        TableColumn colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(new PropertyValueFactory("fecha"));//Atributo.
        
        tableView.getColumns().addAll(colPais, colCodigo, colPorcentaje, colFecha);
        
        //todas las columnas cambiarán su tamaño por igual hasta que se alcance el ancho máximo de TableView
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxHeight(50);
        tableView.setMaxWidth(600);
        //this.getChildren().add(tableView); 
        //String prueba = EscribirDatos.resultado;
        //System.out.println(resultado);
        label = new Label();
        this.getChildren().add(label); 
     
    }
}
