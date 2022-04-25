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
        String resultado = "";
        
        double maximo = Double.parseDouble( valores.get(0)); // Declaramos e inicializamos el máximo.
	double minimo = Double.parseDouble( valores.get(0)); // Declaramos e inicializamos el máximo.
        double media = 0.0;
        /*for (int i=0;i<valores.size();i++) {
      
            //System.out.println(valores.get(i));
            if (Double.parseDouble(valores.get(i)) > maximo  )
                maximo = Double.parseDouble(valores.get(i));
            if (Double.parseDouble(valores.get(i)) < minimo )
                minimo =Double.parseDouble(valores.get(i));
          
        }*/
        
        //System.out.println("La máximo de la lista es " + maximo);
	//System.out.println("La mínimo de la lista es " + minimo);
 
        //System.out.println(valores.get(3));
        //System.out.println("tamaño array " + valores.size());
        
        switch (opciones) {
            case "Máximo":
                for (int i=0;i<valores.size();i++) {
                    if (Double.parseDouble(valores.get(i)) > maximo  )
                        maximo = Double.parseDouble(valores.get(i));
                    double roundDbl = Math.round(maximo*100.0)/100.0;
                    resultado = "El porcentaje maximo de fallecidos es: " +  roundDbl + "%";
                    
                }
                System.out.println(resultado);
                break;
            case "Mínimo":
                for (int i=0;i<valores.size();i++) {
                    if (Double.parseDouble(valores.get(i)) < minimo )
                        minimo =Double.parseDouble(valores.get(i));
                    double roundDbl = Math.round(minimo*100.0)/100.0;
                    resultado = "El porcentaje minimo de fallecidos es: " +  roundDbl + "%";
                    
                }
                System.out.println(resultado);
                break;
            case "Media":
                for (int i=0;i<valores.size();i++) {
                    media = media + Double.parseDouble(valores.get(i));
                }
                System.out.println("suma de media " + media);
                media = media / valores.size();
                double roundDbl = Math.round(media*100.0)/100.0;
                resultado = "El porcentaje medio de fallecidos es: " +  roundDbl + "%";
                System.out.println(resultado);
                break;
        }
        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Escribir en el fichero el texto con un salto de línea
            bw.write(pais1 + "\n" + resultado);
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
