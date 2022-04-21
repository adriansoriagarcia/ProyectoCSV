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
        
        // Crear un ArrayList con el contenido que se desee para el ComboBox
        /*ArrayList<String> paises = new ArrayList();
        paises.add("Afghanistan");
        paises.add("Africa");
        paises.add("African Region");
        paises.add("African Union");
        paises.add("Albania");
        paises.add("Algeria");
        paises.add("America");
        paises.add("American Samoa");
        paises.add("Andean Latin America");
        paises.add("Andorra");
        paises.add("Angola");
        paises.add("Antigua and Barbuta");
        paises.add("Argentina");
        paises.add("Armenia");
        paises.add("Asia");
        paises.add("Australasia");
        paises.add("Australia");
        paises.add("Austria");
        paises.add("Azerbaijan");
        paises.add("Bahamas");
        paises.add("Bahrain");
        paises.add("Bangladesh");
        paises.add("Barbados");
        paises.add("Belarus");
        paises.add("Belgium");
        paises.add("Belize");
        paises.add("Benin");
        paises.add("Bermuda");
        paises.add("Bhutan");
        paises.add("Bolivia");
        paises.add("Bosnia and Herzegovina");
        paises.add("Botswana");
        paises.add("Brazil");
        paises.add("Brunei");
        paises.add("Bulgaria");
        paises.add("Burkina Faso");
        paises.add("Burundi");
        paises.add("Cambodia");
        paises.add("Cameroon");
        paises.add("Canada");
        paises.add("Cape Verde");
        paises.add("Caribbean");
        paises.add("Central African Republic");
        paises.add("Central Asia");
        paises.add("Central Europe");
        paises.add("Cental Latin America");
        paises.add("Chad");
        paises.add("Chile");
        paises.add("China");
        paises.add("Colombia");
        paises.add("Commonwealth");
        paises.add("Comoros");
        paises.add("Congo");
        paises.add("Cook Islands");
        paises.add("Costa Rica");
        paises.add("Cote d'lvoire");
        paises.add("Croatia");
        paises.add("Cuba");
        paises.add("Cyprus");
        paises.add("Czechia");
        paises.add("Denmark");
        paises.add("Djibouti");
        paises.add("Dominica");
        paises.add("East Asia");
        paises.add("Eastern Europe");
        paises.add("Ecuador");
        paises.add("Egypt");
        paises.add("El Salvador");
        paises.add("England");
        paises.add("Equatorial Guinea");
        paises.add("Eritrea");
        paises.add("Estonia");
        paises.add("Eswatini");
        paises.add("Ethiopia");
        paises.add("Europe");
        paises.add("Fiji");
        paises.add("Finland");
        paises.add("France");
        paises.add("Gabon");
        paises.add("Gambia");
        paises.add("Georgia");
        paises.add("Germany");
        paises.add("Ghana");
        paises.add("Greece");
        paises.add("Greenland");
        paises.add("Grenada");
        paises.add("Guam");
        paises.add("Guatemala");
        paises.add("Guinea");
        paises.add("Guinea-Bissau");
        paises.add("Guyana");
        paises.add("Haiti");
        paises.add("Honduras");
        paises.add("Hungary");
        paises.add("Iceland");
        paises.add("India");
        paises.add("Indonesia");
        paises.add("Iran");
        paises.add("Iraq");
        paises.add("Ireland");
        paises.add("Israel");
        paises.add("Italy");
        paises.add("Jamaica");
        paises.add("Japan");
        paises.add("Jordan");
        paises.add("Kazakhstan");
        paises.add("Kenya");
        paises.add("Kiribati");
        paises.add("Kuwait");
        paises.add("Kyrgyzstan");
        paises.add("Laos");
        paises.add("Latvia");
        paises.add("Lebanon");
        paises.add("Lesotho");
        paises.add("Liberia");
        paises.add("Libya");
        paises.add("Lithuania");
        paises.add("Luxembourg");
        paises.add("Madagascar");
        paises.add("Malawi");
        paises.add("Malaysia");
        paises.add("Maldives");
        paises.add("Mali");
        paises.add("Malta");
        paises.add("Marshall Island");
        paises.add("Mautitania");
        paises.add("Mauritius");
        paises.add("Mexico");
        paises.add("Middle SDI");
        paises.add("Moldova");
        paises.add("Monaco");
        paises.add("Mongolia");
        paises.add("Montenegro");
        paises.add("Morocco");
        paises.add("Mozambique");
        paises.add("Myanmar");
        paises.add("Naminia");
        paises.add("Nauru");
        paises.add("Nepal");
        paises.add("Netherlands");
        paises.add("New Zealand");
        paises.add("Nicaragua");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");
        paises.add("");

        // Crear un ComboBox con el contenido de la lista
        ComboBox<String> comboBoxPais = new ComboBox(FXCollections.observableList(paises));
        comboBoxPais.setLayoutX(100);
        paneRoot.getChildren().add(comboBoxPais);
        
        // Crear un ArrayList con el contenido que se desee para el ComboBox
        ArrayList<String> lista = new ArrayList();
        lista.add("Máximo");
        lista.add("Mínimo");
        lista.add("Media");

        // Crear un ComboBox con el contenido de la lista
        ComboBox<String> comboBox = new ComboBox(FXCollections.observableList(lista));
        paneRoot.getChildren().add(comboBox);

        
        Button boton = new Button("Calcular");
        paneRoot.getChildren().add(boton);
        boton.setLayoutY(100);
        boton.setOnAction((t) -> {
            ProcesarDatos procesar = new ProcesarDatos(comboBox,comboBoxPais);
            
        });*/
        SeleccionOpciones seleccion = new SeleccionOpciones();
        paneRoot.getChildren().add(seleccion);
        
    }

    public static void main(String[] args) {
        launch();
    }

}