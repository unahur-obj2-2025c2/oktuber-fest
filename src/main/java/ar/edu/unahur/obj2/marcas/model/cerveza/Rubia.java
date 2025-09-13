package ar.edu.unahur.obj2.marcas.model.cerveza;

import ar.edu.unahur.obj2.marcas.Marca;

public class Rubia extends Marca {
    
    private Double graduacionDeAlcohol;
    
    public Rubia(Double contenidoDeLupulo, String pais,Double graduacionDeAlcohol) {
        super(contenidoDeLupulo, pais);
        this.graduacionDeAlcohol = graduacionDeAlcohol;
    }    

    @Override
    public Double graduacionDeAlcohol() {
       return this.graduacionDeAlcohol;
    }

}
