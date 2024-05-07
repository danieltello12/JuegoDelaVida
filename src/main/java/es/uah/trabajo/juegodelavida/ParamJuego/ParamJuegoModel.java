package es.uah.trabajo.juegodelavida.ParamJuego;

public class ParamJuegoModel {
    private String dimension ="";
    private String vidas ="";

    private String nIndividuosBasicos ="";
    private String nIndividuosAvanzados ="";
    private String nIndividuosNormales ="";
    private String pclonacion ="";
    private String preproduccion ="";

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

    public String getNumeroIndividuosBasicos() {
        return nIndividuosBasicos;
    }

    public String getNumeroIndividuosAvanzados() {
        return nIndividuosAvanzados;
    }

    public String getNumeroIndividuosNormales() {
        return nIndividuosNormales;
    }

    public String getPclonacion() {
        return pclonacion;
    }

    public String getProbabilidadreproduccion() {
        return preproduccion;
    }

    public void setNumeroIndividuosBasicos(String numeroIndividuosBasicos) {
        this.nIndividuosBasicos = numeroIndividuosBasicos;
    }

    public void setNumeroIndividuosAvanzados(String numeroIndividuosAvanzados) {
        this.nIndividuosAvanzados = numeroIndividuosAvanzados;
    }

    public void setNumeroIndividuosNormales(String numeroIndividuosNormales) {
        this.nIndividuosNormales = numeroIndividuosNormales;
    }

    public void setPclonacion(String pclonacion) {
        this.pclonacion = pclonacion;
    }

    public void setProbabilidadreproduccion(String probabilidadreproduccion) {
        this.preproduccion = probabilidadreproduccion;
    }
}
