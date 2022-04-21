package es.adriansoriagarcia.proyectocsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;

public class ProcesarDatos {
    int maximo = Integer.MAX_VALUE;
    int minimo = Integer.MIN_VALUE;
    public ProcesarDatos(ComboBox comboBox, ComboBox comboBoxPais){
        String nombreFichero = "share-of-deaths-homicides.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero

            String opciones = (String) comboBox.getValue();
            String seleccionPais = (String) comboBoxPais.getValue();
            while(texto != null) {
               String[] valores = texto.split(",");
               String pais = valores[0];
               //String edad = valores[3];
               //System.out.println(pais.equals(prueba));
               //System.out.println(edad);
               if(valores[0].equals(seleccionPais)){
                   String datos = valores[3];
                   System.out.println(datos);
                   ArrayList array = new ArrayList();
                   array.add(datos);
                   EscribirDatos escribir = new EscribirDatos(array, seleccionPais , opciones);
               }
                
                //EscribirDatos escribir = new EscribirDatos(pais,edad);
   
                // Hacer lo que sea con la línea leída
                // En este ejemplo sólo se muestra por consola
                //System.out.println(texto);
                // Leer la siguiente línea
                texto = br.readLine();
                
            }
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
}
