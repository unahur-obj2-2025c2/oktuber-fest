package ar.edu.unahur.obj2.recargos;

import ar.edu.unahur.obj2.carpas.Carpa;

public class RecargoPorEmbriedad implements IRecargo{

    @Override
    public Double getMonto(Carpa unaCarpa) {
        return unaCarpa.getPersonas().stream().filter(p -> p.estaEbria()).count() >= (unaCarpa.getCapacidadMaxima() * 0.75) ? 50.0 : 20.0;
    }

}
