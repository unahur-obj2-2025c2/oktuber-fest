package ar.edu.unahur.obj2.marcas.model.carpas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.model.excepciones.CarpaExcepcion;
import ar.edu.unahur.obj2.marcas.model.jarras.Jarra;
import ar.edu.unahur.obj2.marcas.model.personas.Persona;

public class Carpa {
    private final Integer limiteAdmitido;
    private final Boolean tieneBanda;
    private final Marca marcaDeCerveza;
    private Jarra jarra;
    private List<Persona> personas;

    public Carpa(Integer limiteAdmitido, Boolean tieneBanda, Marca marcaDeCerveza, Jarra jarra) {
        this.limiteAdmitido = limiteAdmitido;
        this.tieneBanda = tieneBanda;
        this.marcaDeCerveza = marcaDeCerveza;
        this.jarra = jarra;
        this.personas = new ArrayList<>();
    }

    public Boolean dejaIngresar(Persona persona) {
        return !(personas.size() > limiteAdmitido) && !persona.estaEbria();
    }

    public Boolean puedeEntrarAunaCarpa(Persona persona) {
        return persona.quiereEntrar(this) && this.dejaIngresar(persona);
    }

    public void entrarACarpa(Persona persona) {
        if (puedeEntrarAunaCarpa(persona))
            this.personas.add(persona);
        else
            throw new RuntimeException("No puede ingresar a la carpa");
    }

    public void servirJarraDeCerveza(Persona persona, Double capacidad) {
        if (!personas.contains(persona)) {
            throw new RuntimeException("No se encuentra en la carpa");
        }
        persona.comprarJarra(new Jarra(capacidad, marcaDeCerveza));
    }

    public Long cantidadDeEbriosEmpedernidos() {
        return personas.stream().filter(persona -> sonSuperioresAUnLitro(persona.getJarrasCompradas()) &&
                persona.estaEbria()).count();
    }

    // public Boolean esHomogenea(){
    //     return this.personas.stream().allMatch(personas -> )
    // }


    private Boolean sonSuperioresAUnLitro(List<Jarra> jarras) {
        return jarras.stream().allMatch(j -> j.getCapaciadad() >= 1.0);
    }

    public Integer getLimiteAdmitido() {
        return limiteAdmitido;
    }

    public Boolean getTieneBanda() {
        return tieneBanda;
    }

    public Marca getMarcaDeCerveza() {
        return marcaDeCerveza;
    }

    public Jarra getJarra() {
        return jarra;
    }

    public void setJarra(Jarra jarra) {
        this.jarra = jarra;
    }

    public Integer cantidadDePersonas() {
        return this.personas.size();
    }

}
