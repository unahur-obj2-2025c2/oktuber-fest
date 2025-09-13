package ar.edu.unahur.obj2.marcas;

public abstract class Marca {
    private Double contenidoDeLupulo;
    private String pais;

    
    public Marca(Double contenidoDeLupulo, String pais) {
        this.contenidoDeLupulo = contenidoDeLupulo;
        this.pais = pais;
    }

    public abstract Double graduacionDeAlcohol();

    public Double getContenidoDeLupulo(){
        return this.contenidoDeLupulo;
    }

    public String getPais(){
        return this.pais;
    }


}
