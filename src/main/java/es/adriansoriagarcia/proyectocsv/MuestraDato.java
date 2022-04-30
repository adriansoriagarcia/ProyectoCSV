package es.adriansoriagarcia.proyectocsv;

import javafx.geometry.Pos;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MuestraDato extends HBox{
    static Text text;
    public MuestraDato(){
       this.setAlignment(Pos.CENTER);
        this.setSpacing(30);

        text = new Text();
        //Aplicamos estilo al text.
        text.setEffect(new Reflection());
        this.setStyle("-fx-font: normal bold 20px 'serif' ");
        this.getChildren().add(text); 
     
    }
}
