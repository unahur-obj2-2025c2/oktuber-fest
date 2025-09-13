package ar.edu.unahur.obj2.marcas.model.cerveza;

import ar.edu.unahur.obj2.Reglamento;
import ar.edu.unahur.obj2.marcas.Marca;

public class Negra extends Marca {

    public Negra(Double contenidoDeLupulo, String pais) {
        super(contenidoDeLupulo, pais);
    }

    @Override
    public Double graduacionDeAlcohol() {
        return Math.min(Reglamento.getIntance().getGraduacionReglamentaria(), getContenidoDeLupulo() * 2);
    }

}
