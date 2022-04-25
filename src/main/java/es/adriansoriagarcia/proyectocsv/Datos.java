package es.adriansoriagarcia.proyectocsv;

import java.util.ArrayList;

public class Datos {
    public Datos( ){

    }
    private ArrayList<Dato> listaDatos  = new ArrayList();
   
    public ArrayList<Dato> getListaDatos(){
        return listaDatos;
        
    }

    public void setListaDatos(ArrayList<Dato> listaDatos){
        this.listaDatos = listaDatos;

    }
}
