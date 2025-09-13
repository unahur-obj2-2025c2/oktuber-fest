package ar.edu.unahur.obj2.marcas.model.cerveza;

public class Roja extends Negra {

    public Roja(Double contenidoDeLupulo, String pais) {
        super(contenidoDeLupulo, pais);
    }

    @Override
    public Double graduacionDeAlcohol() {
        return super.graduacionDeAlcohol() * 1.25;
    }

}
