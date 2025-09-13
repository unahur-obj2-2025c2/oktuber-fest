package ar.edu.unahur.obj2;

public class Reglamento {
    private static Reglamento intance;
    private Double graduacionReglamentaria;

    public static Reglamento getIntance() {
        if (intance == null) {
            intance = new Reglamento();
        }
        return intance;
    }

    public Double getGraduacionReglamentaria() {
        return this.graduacionReglamentaria;
    }

    public void setGraduacionReglamentaria(Double graduacionReglamentaria) {
        this.graduacionReglamentaria = graduacionReglamentaria;
    }
}
