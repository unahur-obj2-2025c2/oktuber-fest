package ar.edu.unahur.obj2.recargos;

import ar.edu.unahur.obj2.carpas.Carpa;

public class RecargoPorCantidad implements IRecargo{

    private Double porcentajeSiCumple = 40.0;
    private Double porcentajeSiNoCumple = 25.0;

    public RecargoPorCantidad(){

    }

    public RecargoPorCantidad(Double porcentajeSiCumple, Double porcentajeSiNoCumple){
        this.porcentajeSiCumple = porcentajeSiCumple;
        this.porcentajeSiNoCumple = porcentajeSiNoCumple;
    }

    public Double getPorcentajeSiCumple() {
        return porcentajeSiCumple;
    }

    public void setPorcentajeSiCumple(Double porcentajeSiCumple) {
        this.porcentajeSiCumple = porcentajeSiCumple;
    }

    public Double getPorcentajeSiNoCumple() {
        return porcentajeSiNoCumple;
    }

    public void setPorcentajeSiNoCumple(Double porcentajeSiNoCumple) {
        this.porcentajeSiNoCumple = porcentajeSiNoCumple;
    }

    @Override
    public Double getMonto(Carpa unaCarpa) {
        return unaCarpa.getPersonas().size() >= (unaCarpa.getCapacidadMaxima() / 2) ? porcentajeSiCumple : porcentajeSiNoCumple;
    }

}
