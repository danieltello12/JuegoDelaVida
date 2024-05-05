package es.uah.trabajo.juegodelavida.ParamJuego;

public class ParamJuegoModel {
    private String dimension ="";
    private String vidas ="";

    public ParamJuegoModel(String vidas, String dimension) {
        this.vidas =vidas;
        this.dimension =dimension;
    }
    public ParamJuegoModel(){

    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getVidas() {
        return vidas;
    }

    public void setVidas(String vidas) {
        this.vidas = vidas;
    }
}
