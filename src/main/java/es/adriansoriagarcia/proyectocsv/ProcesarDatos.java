package es.adriansoriagarcia.proyectocsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class ProcesarDatos extends Pane{
    static ArrayList arrayMedia = new ArrayList();
    static ArrayList arrayFechas = new ArrayList();
    ArrayList listaPaises = new ArrayList();
    ArrayList paisesOrdenados = new ArrayList();
    static Datos datos1 = new Datos();
    public ProcesarDatos(){
        String nombreFichero = "share-of-deaths-homicides.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
             br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
             br.readLine();
            // Repetir mientras no se llegue al final del fichero

            //String opciones = (String) comboBox.getValue();
            //String seleccionPais = (String) comboBoxPais.getValue();
            
            
            String texto =br.readLine();
            while(texto != null) {
                
               String[] valores = texto.split(",");
               /*if(valores.length < 4 || valores.equals(null)){
                  //texto =br.readLine(); 
                  continue;
               }*/
               //System.out.println(valores.length);
               String pais = valores[0];
               String codigo = valores[1];
               String year = valores[2];
               String anio="";
               
               if(year.isEmpty() ||year.equals(" and Central Asia"+'"') || year.equals(" and Oceania"+'"')){
                   //System.out.println("coincide el año con texto");
                  texto = br.readLine();
                  continue;
               }else{
                   
                   anio = year;
               }
               
               String porcentaje = valores[3];
               if(porcentaje.equals(" and Central Asia"+'"') || porcentaje.isEmpty()){
                   //System.out.println("coincide el porcentaje con texto");
                  texto = br.readLine();
                  continue;
               }

               Dato dato1 = new Dato();
               dato1.setPais(pais);
               dato1.setCodigo(codigo);
               dato1.setYear(Integer.parseInt(anio));
               dato1.setFallecidos(Float.valueOf(porcentaje));
               
               datos1.getListaDatos().add(dato1);
  
               
               listaPaises.add(pais);
               

                // Hacer lo que sea con la línea leída
                // En este ejemplo sólo se muestra por consola
                //System.out.println(texto);
                // Leer la siguiente línea
                texto = br.readLine();
                
            }
            
            
            //Eliminar elementos duplicados
            //HashSet añade se encargar de añadir todos los elementos sin duplicar  a un conjunto.
            Set<String> hashSet = new HashSet<String>(listaPaises);
            //Eliminamos el contenido de la listaPaises.
            listaPaises.clear();
            //Añadimos a la listaPaises el contenido guardado anteriormente en el HasSet pero esta sin ordenar.
            listaPaises.addAll(hashSet);
            
            //En el for recorremos la listaPaises y la añadimos a una nueva lista.
            /*for (Object s : listaPaises) {
                //System.out.println(s);
                paisesOrdenados.add(s);
            }*/
            //Ordenar lista de paises
            //Collections.sort(paisesOrdenados);
            Collections.sort(listaPaises);
            SeleccionOpciones seleccion = new SeleccionOpciones(listaPaises);
            this.getChildren().add(seleccion);

        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
    public static ArrayList CargarDatos(ComboBox comboBoxCalculo, ComboBox comboBoxPais){
        try {
            String opciones = (String) comboBoxCalculo.getValue();
            String seleccionPais = (String) comboBoxPais.getValue();
            System.out.println(opciones);
            System.out.println(seleccionPais);
            for (int i=0;i<datos1.getListaDatos().size();i++) {
                //System.out.println(datos1.getListaDatos().get(i).getPais());
                 if(datos1.getListaDatos().get(i).getPais().equals(seleccionPais)){
                     String datosMedia = Float.toString(datos1.getListaDatos().get(i).getFallecidos());
                     arrayMedia.add(datosMedia);
                     
                     int datosFechas = datos1.getListaDatos().get(i).getYear();
                     arrayFechas.add(datosFechas);
                 }
            }
            //System.out.println(arrayMedia);

            EscribirDatos escribir = new EscribirDatos(arrayMedia, arrayFechas, seleccionPais , opciones);
            //Una vez enviado los datos a la clase EscribirDatos eliminamos el contenido de los array
            //para que no se concatene los datos que contenia con los nuevos
            arrayMedia.clear();
            arrayFechas.clear();
        }
        catch (Exception ex) {
            System.out.println("Error al seleccionar las opciones");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Selecciona ambas opciones");
            alert.showAndWait();
            ex.printStackTrace();
        }
        //System.out.println(arrayFechas);
        return arrayMedia;
        
    }
}
