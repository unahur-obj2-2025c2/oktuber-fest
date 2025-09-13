package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.pais.Pais;

public class Roja extends Marca {

    public Roja(Double gramosLupulo, Pais pais ){
        super(gramosLupulo, pais);
    }

    @Override
    public Double graduacion() {
        return super.graduacionCervezaNegra() * 1.25;
    }

}