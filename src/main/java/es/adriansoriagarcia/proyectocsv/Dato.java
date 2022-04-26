package es.adriansoriagarcia.proyectocsv;

public class Dato {
    private String pais;
    private String codigo;
    private int year;
    private float fallecidos;

    
    /*public Dato(String pais, String codigo, int year){
        this.pais = pais;
        this.codigo = codigo;
        this.year = year;
        this.fallecidos = fallecidos;
    }*/

    public String getPais(){
        return pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public Float getFallecidos(){
        return fallecidos;
    }

    public void setFallecidos(Float fallecidos){
        this.fallecidos = fallecidos;
    }
    
    @Override
    public String toString(){
        String r = "";
        r += "Pais: " + pais + "\n";
        r += "Codigo: " + codigo + "\n";
        r += "Año: " + year + "\n";
        r += "Fallecidos: " + fallecidos + "\n";
        return r;
    }

    void getPais(String valore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


