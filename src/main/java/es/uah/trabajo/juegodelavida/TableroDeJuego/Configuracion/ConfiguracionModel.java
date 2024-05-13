package es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion;

public class ConfiguracionModel {
    private String filaIndv="";
    private String columnaIvd="";


    private String TurnosDeVida ="";
    private String Identificador ="";
    private int pclonacion =0;
    private int preproduccion =0;
    private String filarec="";
    private String columnarec="";
    private int pv=0;
    private int pz=0;

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

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPz() {
        return pz;
    }

    public void setPz(int pz) {
        this.pz = pz;
    }

    public String getColumnaIvd() {
        return columnaIvd;
    }


    public String getTurnosDeVida() {
        return TurnosDeVida;
    }

    public void setTurnosDeVida(String turnosDeVida) {
        TurnosDeVida = turnosDeVida;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String identificador) {
        Identificador = identificador;
    }

    public int getPreproduccion() {
        return preproduccion;
    }

    public void setPreproduccion(int preproduccion) {
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

    public ConfiguracionModel(){

    }



    public String getNumeroIndividuosAvanzados() {
        return TurnosDeVida;
    }

    public String getNumeroIndividuosNormales() {
        return Identificador;
    }

    public int getPclonacion() {
        return pclonacion;
    }

    public int getProbabilidadreproduccion() {
        return preproduccion;
    }


    public void setNumeroIndividuosAvanzados(String numeroIndividuosAvanzados) {
        this.TurnosDeVida = numeroIndividuosAvanzados;
    }

    public void setNumeroIndividuosNormales(String numeroIndividuosNormales) {
        this.Identificador = numeroIndividuosNormales;
    }

    public void setPclonacion(int pclonacion) {
        this.pclonacion = pclonacion;
    }

    public void setProbabilidadreproduccion(int probabilidadreproduccion) {
        this.preproduccion = probabilidadreproduccion;
    }


}
