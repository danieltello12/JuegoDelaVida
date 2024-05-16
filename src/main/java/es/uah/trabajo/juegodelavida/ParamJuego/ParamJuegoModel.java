package es.uah.trabajo.juegodelavida.ParamJuego;

public class ParamJuegoModel {
    private String filaIndv="";
    private String columnaIvd="";


    //private String TurnosDeVida ="";
    private String Identificador ="";
    private float pclonacion =0;
    private float preproduccion =0;
    private String filarec="";
    private String columnarec="";

    public String getFilarec() {
        return filarec;
    }

    public void setFilarec(String filarec) {
        this.filarec = filarec;
    }

    public String getColumnarec() {
        return columnarec;
    }

    public void setColumnarec(String columnarec) {
        this.columnarec = columnarec;
    }

    public String getColumnaIvd() {
        return columnaIvd;
    }



    /*public String getTurnosDeVida() {
        return TurnosDeVida;
    }

    public void setTurnosDeVida(String turnosDeVida) {
        TurnosDeVida = turnosDeVida;
    }*/

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String identificador) {
        Identificador = identificador;
    }

    public float getPreproduccion() {
        return preproduccion;
    }

    public void setPreproduccion(float preproduccion) {
        this.preproduccion = preproduccion;
    }

    public void setColumnaIvd(String columnaIvd) {
        this.columnaIvd = columnaIvd;
    }

    public String getFilaIndv() {
        return filaIndv;
    }

    public void setFilaIndv(String filaIndv) {
        this.filaIndv = filaIndv;
    }

    public ParamJuegoModel(){

    }




    public String getNumeroIndividuosAvanzados() {
        return "0";
    }

    public String getNumeroIndividuosNormales() {
        return Identificador;
    }

    public float getPclonacion() {
        return pclonacion;
    }

    public float getProbabilidadreproduccion() {
        return preproduccion;
    }


    public void setNumeroIndividuosAvanzados(String numeroIndividuosAvanzados) {
       // this.TurnosDeVida = numeroIndividuosAvanzados;
    }

    public void setNumeroIndividuosNormales(String numeroIndividuosNormales) {
        this.Identificador = numeroIndividuosNormales;
    }

    public void setPclonacion(float pclonacion) {
        this.pclonacion = pclonacion;
    }

    public void setProbabilidadreproduccion(float probabilidadreproduccion) {
        this.preproduccion = probabilidadreproduccion;
    }


}
