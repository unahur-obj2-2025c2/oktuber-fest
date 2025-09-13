package ar.edu.unahur.obj2.marcas.model.jarras;

import ar.edu.unahur.obj2.marcas.Marca;

public class Jarra {
    private Double capaciadad;
    private Marca marca;
    
    public Jarra(Double capaciadad, Marca marca) {
        this.capaciadad = capaciadad;
        this.marca = marca;
    }

    public Double getCapaciadad() {
        return capaciadad;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double cantidadDeAlcohol(){
        return capaciadad * marca.graduacionDeAlcohol();
    }

}
