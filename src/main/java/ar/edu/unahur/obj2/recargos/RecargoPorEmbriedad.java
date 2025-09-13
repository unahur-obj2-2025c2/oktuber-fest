package ar.edu.unahur.obj2.recargos;

import ar.edu.unahur.obj2.carpas.Carpa;

public class RecargoPorEmbriedad implements IRecargo{

    private Double porcentajeSiCumple = 50.0;
    private Double porcentajeSiNoCumple = 20.0;

    public RecargoPorEmbriedad(){

    }

    public RecargoPorEmbriedad(Double porcentajeSiCumple, Double porcentajeSiNoCumple){
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
        return unaCarpa.getPersonas().stream().filter(p -> p.estaEbria()).count() >= (unaCarpa.getCapacidadMaxima() * 0.75) ? porcentajeSiCumple : porcentajeSiNoCumple;
    }

}
