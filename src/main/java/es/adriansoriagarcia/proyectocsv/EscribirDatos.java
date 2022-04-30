package es.adriansoriagarcia.proyectocsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


public class EscribirDatos {
    public EscribirDatos(ArrayList datos, ArrayList fechas, String pais, String opciones){
        String nombreFichero = "nuevo.csv"; // Declaramos e inicializamos la variable nombreFichero.
        ArrayList<String> porcentajes = datos; // Declaramos e inicializamos el arrayList de los porcentajes.
        ArrayList listaFechas = fechas; // Declaramos e inicializamos el arrayList de los años.
        BufferedWriter bw = null; // Declaramos e inicializamos la variable bw usada para escribir el texto.
        String resultado = ""; // Declaramos e inicializamos la variable resultado.
        int valorI = 0; // Declaramos e inicializamos la variable valorI(es el valor de la i en el for)
        int fecha ; // Declaramos la variable fecha que va a contener la fecha de cada operación.
        
        System.out.println(porcentajes);
        System.out.println(listaFechas);
        //System.out.println( "tamaño lista fechas " + listaFechas.size());
        //System.out.println( "tamaño lista porcentajes " + porcentajes.size());
        
        double maximo = Double.parseDouble(porcentajes.get(0)); // Declaramos e inicializamos el máximo.
	double minimo = Double.parseDouble(porcentajes.get(0)); // Declaramos e inicializamos el máximo.
        double media = 0.0;// Declaramos e inicializamos la media.
        double roundDbl; // Declaramos una variable para redondear el resultado.
        
        switch (opciones) {
            case "Máximo":
                for (int i=0;i<porcentajes.size();i++) {
                    if (Double.parseDouble(porcentajes.get(i)) > maximo  ){
                        maximo = Double.parseDouble(porcentajes.get(i)); 
                        valorI=i;
                    }
                    roundDbl = Math.round(maximo*100.0)/100.0;
                    resultado = "El porcentaje maximo de fallecidos es: " +  roundDbl + " % ";
                    
                }
                //System.out.println(listaFechas.get(valorI));
                fecha= Integer.parseInt(listaFechas.get(valorI).toString());
                resultado += " año " + fecha;
                System.out.println(resultado);
                break;
            case "Mínimo":
                for (int i=0;i<porcentajes.size();i++) {
                    if (Double.parseDouble(porcentajes.get(i)) < minimo ){
                        minimo =Double.parseDouble(porcentajes.get(i));
                        valorI=i;
                    }
                    roundDbl = Math.round(minimo*100.0)/100.0;
                    resultado = "El porcentaje minimo de fallecidos es: " +  roundDbl + " % ";
                    
                }
                //System.out.println(listaFechas.get(valorI));
                fecha= Integer.parseInt(listaFechas.get(valorI).toString());
                resultado += " año " + fecha;
                System.out.println(resultado);
                break;
            case "Media":
                for (int i=0;i<porcentajes.size();i++) {
                    media = media + Double.parseDouble(porcentajes.get(i));
                }
                //System.out.println("suma de media " + media);
                
                System.out.println(listaFechas.get(listaFechas.size()-1));
                
                media = media / porcentajes.size();
                roundDbl = Math.round(media*100.0)/100.0;
                resultado = "El porcentaje medio de fallecidos es: " +  roundDbl + " % " + " entre los años "
                 + listaFechas.get(0) + " y " + listaFechas.get(listaFechas.size()-1);
                System.out.println(resultado);
                break;
        }
        
        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Escribir en el fichero el texto con un salto de línea
            bw.write(pais + "\n" + resultado);
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
        MuestraDato.text.setText(resultado);
    }
    

}
