package es.adriansoriagarcia.proyectocsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.ComboBox;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.Pane;

public class ProcesarDatos extends Pane{
    static ArrayList array = new ArrayList();
    ArrayList prueba = new ArrayList();
    ArrayList paises = new ArrayList();
    static ArrayList <String> informacion  = new ArrayList();
    Datos datosPrueba =new Datos();
    static String[] valores;
    static String texto;
    static BufferedReader br;
    //ComboBox comboBox, ComboBox comboBoxPais
    public ProcesarDatos(){
        String nombreFichero = "share-of-deaths-homicides.csv";
        // Declarar una variable BufferedReader
        br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero

            //String opciones = (String) comboBox.getValue();
            //String seleccionPais = (String) comboBoxPais.getValue();
            Datos datos1 = new Datos();
            while(texto != null) {
               valores = texto.split(",");
               
               String pais = valores[0];
               String porcentaje = valores[3];
               prueba.add(pais);
               
               //informacion.addAll(0, porcentaje);
               //datosPrueba.getListaDatos().addAll(prueba);
               //String edad = valores[3];
               //System.out.println(pais.equals(prueba));
               //System.out.println(pais);
               
               /*if(valores[0].equals(seleccionPais)){
                   String datos = valores[3];

                   array.add(datos);
               }*/

   
                // Hacer lo que sea con la línea leída
                // En este ejemplo sólo se muestra por consola
                //System.out.println(texto);
                // Leer la siguiente línea
                texto = br.readLine();
                
            }

            Set<String> hashSet = new HashSet<String>(prueba);
            prueba.clear();
            prueba.addAll(hashSet);
            
            for (Object s : prueba) {
                //System.out.println(s);
                paises.add(s);
            }
            Collections.sort(paises);
            //System.out.println(paises);
            SeleccionOpciones seleccion = new SeleccionOpciones(paises);
            this.getChildren().add(seleccion);
            //System.out.println(datosPrueba.getListaDatos());
            //System.out.println("tamaño array " + array.size());
            //EscribirDatos escribir = new EscribirDatos(array, seleccionPais , opciones);
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
        String opciones = (String) comboBoxCalculo.getValue();
        String seleccionPais = (String) comboBoxPais.getValue();
        
        //System.out.println(informacion);

        
        //EscribirDatos escribir = new EscribirDatos(array, seleccionPais , opciones);
        //System.out.println(array);
        return array;
        
    }
}
