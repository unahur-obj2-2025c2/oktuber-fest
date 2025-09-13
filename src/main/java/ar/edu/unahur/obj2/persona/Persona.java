package ar.edu.unahur.obj2.persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.carpas.Carpa;
import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.pais.Pais;

public class Persona {
    private final Double peso;
    private List<Jarra> jarrasTomadas = new ArrayList<>();
    private final Boolean leGustaLaMusica;
    private final Integer nivelAguante;
    private List<Marca> marcasFavoritas = new ArrayList<>();
    private final Pais nacionalidad;

    public Persona(Double peso, Boolean leGustaLaMusica, Integer nivelAguante, Pais nacionalidad, List<Marca> marcasFavoritas) {
        this.peso = peso;
        this.leGustaLaMusica = leGustaLaMusica;
        this.nivelAguante = nivelAguante;
        this.nacionalidad = nacionalidad;
        this.marcasFavoritas = marcasFavoritas;
    }

    public Double getPeso() {
        return peso;
    }

    public List<Jarra> getJarrasTomadas() {
        return jarrasTomadas;
    }

    public Boolean getLeGustaLaMusica() {
        return leGustaLaMusica;
    }

    public Integer getNivelAguante() {
        return nivelAguante;
    }

    public List<Marca> getMarcasFavoritas() {
        return marcasFavoritas;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public Boolean estaEbria(){
        return jarrasTomadas.stream().mapToDouble(j -> j.getLitros()).sum() * peso > nivelAguante;
    }
    
    public Boolean leGustaEsteTipoDeCerveza(Marca marca){
        return switch (nacionalidad.nombre()){
            case "Bélgica" -> marca.getGramosLupulo() > 4;
            case "República Checa" -> marca.graduacion() > 8;
            default -> Boolean.TRUE; //aleman le gustan todas al igual que cualquier otro
        };
    }

    public Double alcoholIngerido(){
        return jarrasTomadas.stream().mapToDouble(j -> j.cantidadDeAlcohol()).sum();
    }

    public Boolean quiereEntrarA(Carpa unaCarpa){
        return leGustaLaCervezaDeLaCarpa(unaCarpa) 
        && coincideEnGustosMusicales(unaCarpa)
        && evaluarSegunNacionalidad(unaCarpa);
    }

    public Boolean leGustaLaCervezaDeLaCarpa(Carpa unaCarpa){
        return this.leGustaEsteTipoDeCerveza( unaCarpa.getMarcaExclusiva() );
    }

    public Boolean coincideEnGustosMusicales(Carpa unaCarpa){
        return this.leGustaLaMusica.equals( unaCarpa.getTienenBandaTradicional() );
    }

    public Boolean evaluarSegunNacionalidad(Carpa unaCarpa){
        return switch(nacionalidad.nombre()){
            case "Alemania" -> unaCarpa.getPersonas().size() % 2 == 0;
            default -> Boolean.TRUE;
        };
    }

    public Boolean puedoEntrar(Carpa unaCarpa){
        return this.quiereEntrarA(unaCarpa) && unaCarpa.puedeEntrar(this);
    }

    public void entrarA(Carpa unaCarpa){
        if (!this.puedoEntrar(unaCarpa)){
            throw new RuntimeException("No puede entrar a la carpa.");
        }
        unaCarpa.entrar(this);
    }

    public void tomarJarra(Jarra jarra){
        jarrasTomadas.add(jarra);
    }

    public Boolean ebrioEmpedernido(){
        return this.estaEbria() && jarrasTomadas.stream().allMatch(j -> j.getLitros() > 1);
    }

    public Boolean esPatriota (){
        return jarrasTomadas.stream().allMatch(j -> j.getMarca().getPais().equals(nacionalidad));
    }

    public Boolean sonCompatibles(Persona unaPersona){
        Set<Marca> marcasPersona1 = this.jarrasTomadas.stream().map(j -> j.getMarca()).collect(Collectors.toSet());
        Set<Marca> marcasPersona2 = unaPersona.getJarrasTomadas().stream().map(j -> j.getMarca()).collect(Collectors.toSet());
        Integer coincidencias= 0;
        for (Marca marca : marcasPersona1) {
            if (marcasPersona2.contains(marca)) {
                coincidencias += 1;
            }
        }
        return coincidencias > marcasPersona1.size() / 2;
    }

    public Set<Carpa> carpasVisitadasSegunJarras(){
        return jarrasTomadas.stream().map(j -> j.getCarpaDondeSeSirvio()).collect(Collectors.toSet());
    }
    
    public Boolean estaEntrandoEnElVicio(){
        Double capacidadJarra = 0.0;
        for (Jarra jarra : jarrasTomadas){
            if (jarra.getLitros() < capacidadJarra) {
               return Boolean.FALSE; 
            }
            capacidadJarra = jarra.getLitros();
        }
        return Boolean.TRUE;
    }
}
