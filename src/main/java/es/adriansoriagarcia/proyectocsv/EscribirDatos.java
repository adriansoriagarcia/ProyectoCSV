package es.adriansoriagarcia.proyectocsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


public class EscribirDatos {
    public EscribirDatos(ArrayList datos, String pais, String opciones){
        String nombreFichero = "nuevo.csv";
        ArrayList<String> valores = datos;
        String pais1 = pais;
        BufferedWriter bw = null;
        int total = 0;
        
        //String maximo = (String)valores.get(0); // Declaramos e inicializamos el máximo.
	//String minimo = (String)valores.get(0); // Declaramos e inicializamos el máximo.
        
        for (int i=0;i<valores.size();i++) {
      
            System.out.println(valores.get(i));
          
        }
 
        //System.out.println(valores.get(3));
        //System.out.println("tamaño array " + valores.size());
        
        switch (opciones) {
            case "Máximo":
                
                break;
            case "Mínimo":
                
                break;
            case "Media":
                
                break;
        }
        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Escribir en el fichero el texto con un salto de línea
            bw.write(pais1 + "\n");
        }
        // Comprobar si se ha producido algún error
        catch(Exception ex) {
           System.out.println("Error de escritura del fichero");
           ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
    

}
