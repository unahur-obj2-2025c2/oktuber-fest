package ar.edu.unahur.obj2.marcas.model.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.model.carpas.Carpa;
import ar.edu.unahur.obj2.marcas.model.jarras.Jarra;
import ar.edu.unahur.obj2.marcas.model.nacionalidad.Nacionalidad;

public class Persona {
    private Double peso;
    private List<Jarra> jarrasCompradas;
    private Boolean leGustaLaMusicaTradicional;
    private Integer nivelDeAguante;
    private Nacionalidad nacionalidad;
    // private Carpa carpa;

    public Persona(Double peso, Boolean leGustaLaMusicaTradicional, Integer nivelDeAguante,
            Nacionalidad nacionalidad) {
        this.peso = peso;
        this.leGustaLaMusicaTradicional = leGustaLaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
        this.nacionalidad = nacionalidad;
        this.jarrasCompradas = new ArrayList<>();
    }

    public Boolean estaEbria() {
        return alcoholIngerido() * peso > nivelDeAguante;
    }

    public Double alcoholIngerido() {
        return jarrasCompradas.stream().mapToDouble(j -> j.cantidadDeAlcohol()).sum();
    }

    public Boolean getLeGustaLaMusicaTradicional() {
        return this.leGustaLaMusicaTradicional;
    }

    public Boolean leGustaLaCeveza(Marca marca) {
        return switch (nacionalidad.name()) {
            case "BELGA" ->
                marca.getContenidoDeLupulo() > 4;
            case "CHECO" ->
                marca.graduacionDeAlcohol() > 0.08;
            case "ALEMAN" ->
                true;
            default ->
                false;
        };
    }

    public Boolean sonCompatibles(Persona persona) {
        Set<Marca> marcasPersona1 = this.jarrasCompradas.stream().map(j -> j.getMarca()).collect(Collectors.toSet());
        Set<Marca> marcasPersona2 = persona.jarrasCompradas.stream().map(j -> j.getMarca()).collect(Collectors.toSet());

        Integer coincidencias = 0;
        for (Marca marca : marcasPersona1) {
            if (marcasPersona2.contains(marca)) {
                coincidencias += 1;
            }
        }
        return coincidencias > marcasPersona1.size() / 2;
    }

    public Boolean esPatriota() {
        return this.jarrasCompradas.stream().allMatch(j -> j.getMarca()
                .getPais().equals(this.nacionalidad.name()));
    }

    public Boolean quiereEntrar(Carpa carpa) {
        return leGustaLaCeveza(carpa.getMarcaDeCerveza()) &&
                (this.leGustaLaMusicaTradicional.equals(carpa.getTieneBanda()))
                && !(nacionalidad.name().equals("ALEMAN") || carpa.cantidadDePersonas() % 2 == 0);
    }

    public void comprarJarra(Jarra jarra) {
        this.jarrasCompradas.add(jarra);
    }

    public List<Jarra> getJarrasCompradas() {
        return this.jarrasCompradas;
    }

    public Nacionalidad getNacionalidad() {
        return this.nacionalidad;
    }
}
