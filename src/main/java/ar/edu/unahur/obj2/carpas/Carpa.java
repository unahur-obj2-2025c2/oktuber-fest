package ar.edu.unahur.obj2.carpas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.pais.Pais;
import ar.edu.unahur.obj2.persona.Persona;
import ar.edu.unahur.obj2.recargos.IRecargo;

public class Carpa{
    private final Integer capacidadMaxima;
    private final Boolean tienenBandaTradicional;
    private final Marca marcaExclusiva;
    private List<Persona> personas = new ArrayList<>();
    private IRecargo recargo;

    public Carpa(Integer capacidadMaxima, Boolean tienenBandaTradicional, Marca marcaExclusiva, IRecargo recargo) {
        this.capacidadMaxima = capacidadMaxima;
        this.tienenBandaTradicional = tienenBandaTradicional;
        this.marcaExclusiva = marcaExclusiva;
        this.recargo = recargo;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Boolean getTienenBandaTradicional() {
        return tienenBandaTradicional;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public Marca getMarcaExclusiva() {
        return marcaExclusiva;
    }

    public IRecargo getRecargo() {
        return recargo;
    }

    public void setRecargo(IRecargo recargo) {
        this.recargo = recargo;
    }

    public Boolean hayLugar(){
        return personas.size() < capacidadMaxima;
    }

    public Boolean puedeEntrar(Persona persona){
        return this.hayLugar() && !persona.estaEbria();
    }

    public void entrar(Persona persona){
        personas.add(persona);
    }

    public void servirJarra(Double litros, Persona persona){
        if(!this.estaEnLaCarpa(persona)){
            throw new RuntimeException("No está en la carpa.");
        }
        persona.tomarJarra(new Jarra(marcaExclusiva, litros, this, this.precioPorLitro() * litros));
    }

    public Boolean estaEnLaCarpa(Persona unaPersona){
        return personas.contains(unaPersona);
    }
    
    public Integer ebriosEmpedernidos(){
        return personas.stream().filter(Persona::ebrioEmpedernido).toList().size();
    }

    public Boolean esHomogenea(){
        if (personas.isEmpty()){
            throw new RuntimeException("No hay personas en la carpa"); 
        }
        Pais nacionalidad = personas.get(0).getNacionalidad();
        return personas.stream().allMatch(p -> p.getNacionalidad().equals(nacionalidad));
    }
    
    public List<Persona> personasSinConsumirEnEstaCarpa(){
        return personas.stream().filter(p -> !p.carpasVisitadasSegunJarras().contains(this)).toList();
    }

    public Double precioPorLitro(){
        return marcaExclusiva.getPrecioPorLitro() * (1 + recargo.getMonto(this) / 100);
    }

}