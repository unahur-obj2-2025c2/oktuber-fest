package ar.edu.unahur.obj2.marcas;

public class Reglamentacion {
       
    private static Reglamentacion instance;

    private Double graduacionCervezaNegra;

    private Reglamentacion(){}

    public static Reglamentacion getInstance(){
        if (instance == null){
            instance = new Reglamentacion();
        }
        return instance;
    }

    public Double getGraduacionCervezaNegra(){
        return graduacionCervezaNegra;
    }

    public void setGraduacionCervezaNegra(Double graduacionMundial){
        graduacionCervezaNegra = graduacionMundial;
    }

}