package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.carpas.Carpa;

public class Jarra {
    private final Marca marca;
    private final Double litros;
    private final Carpa carpaDondeSeSirvio;
    private final Double precioDeVenta;

    public Jarra(Marca marca, Double litros, Carpa carpaDondeSeSirvio, Double precioDeVenta) {
        this.marca = marca;
        this.litros = litros;
        this.carpaDondeSeSirvio = carpaDondeSeSirvio;
        this.precioDeVenta = precioDeVenta;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double getLitros() {
        return litros;
    }

    public Carpa getCarpaDondeSeSirvio() {
        return carpaDondeSeSirvio;
    }

    public Double cantidadDeAlcohol(){
        return litros * marca.graduacion() / 100;
    }

    public Double getPrecioDeVenta() {
        return precioDeVenta;
    }
 
}
