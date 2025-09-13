package ar.edu.unahur.obj2.recargos;

import ar.edu.unahur.obj2.carpas.Carpa;

public class RecargoFijo implements IRecargo {

    private Double porcentaje = 30.0;

    public RecargoFijo(){
        
    }

    public RecargoFijo(Double porcentaje){
        this.porcentaje = porcentaje;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public Double getMonto(Carpa unaCarpa) {
        return porcentaje;
    }

}
