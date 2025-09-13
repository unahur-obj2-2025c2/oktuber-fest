package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.pais.Pais;

public class Rubia extends Marca {

    private final Double graduacionEstaMarca;

    public Rubia(Double gramosLupulo, Pais pais, Double precioPorLitro, Double graduacionEstaMarca){
        super(gramosLupulo, pais, precioPorLitro);
        this.graduacionEstaMarca = graduacionEstaMarca;
    }

    @Override
    public Double graduacion(){
        return graduacionEstaMarca;
    }
    

}