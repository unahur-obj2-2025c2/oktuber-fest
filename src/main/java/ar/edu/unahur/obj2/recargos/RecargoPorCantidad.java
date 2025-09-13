package ar.edu.unahur.obj2.recargos;

import ar.edu.unahur.obj2.carpas.Carpa;

public class RecargoPorCantidad implements IRecargo{

    @Override
    public Double getMonto(Carpa unaCarpa) {
        return unaCarpa.getPersonas().size() >= (unaCarpa.getCapacidadMaxima() / 2) ? 40.0 : 25.0;
    }

}
