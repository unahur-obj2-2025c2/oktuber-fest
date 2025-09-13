package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.pais.Pais;

public abstract class Marca {

        protected Double gramosLupulo;
        protected Pais pais;
        protected Double precioPorLitro;

        public Marca(Double gramosLupulo, Pais pais, Double precioPorLitro){
            this.gramosLupulo = gramosLupulo;
            this.pais = pais;
            this.precioPorLitro = precioPorLitro;
        }

        protected Double graduacionCervezaNegra(){
            return Double.min(Reglamentacion.getInstance().getGraduacionCervezaNegra(), 2 * gramosLupulo);
        }

        public abstract Double graduacion();

        public Double getGramosLupulo(){
            return gramosLupulo;
        }

        public Pais getPais() {
            return pais;
        }

        public Double getPrecioPorLitro() {
            return precioPorLitro;
        }

}
