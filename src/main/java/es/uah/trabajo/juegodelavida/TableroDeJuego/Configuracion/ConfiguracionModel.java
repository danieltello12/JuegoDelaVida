package es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion;

public class ConfiguracionModel {
    private String filaIndv="";
    private String columnaIvd="";


    private String TurnosDeVida ="";
    private String Identificador ="";
    private float pclonacion =0;
    private float preproduccion =0;
    private String filarec="";
    private String columnarec="";
    private float pvA=0;
    private float pVC=0;
    private float pvM=0;
    private float pvT=0;
    private float pvB=0;
    private float pvP=0;
    private float pz=0;

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

    public float getPvA() {
        return pvA;
    }

    public void setPvA(float pvA) {
        this.pvA = pvA;
    }

    public float getpVC() {
        return pVC;
    }

    public void setpVC(float pVC) {
        this.pVC = pVC;
    }

    public float getPvM() {
        return pvM;
    }

    public void setPvM(float pvM) {
        this.pvM = pvM;
    }

    public float getPvT() {
        return pvT;
    }

    public void setPvT(float pvT) {
        this.pvT = pvT;
    }

    public float getPvB() {
        return pvB;
    }

    public void setPvB(float pvB) {
        this.pvB = pvB;
    }

    public float getPvP() {
        return pvP;
    }

    public void setPvP(float pvP) {
        this.pvP = pvP;
    }

    public float getPz() {
        return pz;
    }

    public void setPz(float pz) {
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

    public ConfiguracionModel(){

    }



    public String getNumeroIndividuosAvanzados() {
        return TurnosDeVida;
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
        this.TurnosDeVida = numeroIndividuosAvanzados;
    }

    public void setNumeroIndividuosNormales(String numeroIndividuosNormales) {
        this.Identificador = numeroIndividuosNormales;
    }

    public void setPclonacion(float pclonacion) {
        this.pclonacion = pclonacion;
    }

    public void setProbabilidadreproduccion(int probabilidadreproduccion) {
        this.preproduccion = probabilidadreproduccion;
    }


    public void setProbabilidadreproduccion(float v) {
    }
}
