package es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos;

public class Recursos {


    int tiemposvida;
    int x;
    int y;
    float Probabilidad_Z;
    float Probabilida_V;
    String tipo;
    public Recursos(int x, int y, float probz, float probv, int tiemposvida,
                    String cbAgua, int modAgua, boolean ckAgua,
                    String cbComida, int modComida, boolean ckComida,
                    String cbMontana, int modMontana, boolean ckMontana,
                    String cbTesoro, int modTesoro, boolean ckTesoro,
                    String cbBiblio, int modBiblio, boolean ckBiblio,
                    String cbPozo, int modPozo, boolean ckPozo){
        this.x=x;
        this.y=y;
        this.Probabilidad_Z=probz;
        this.Probabilida_V=probv;
        this.tiemposvida = tiemposvida;
        this.cbAgua=cbAgua;
        this.modAgua = modAgua;
        this.ckAgua=ckAgua;
        this.cbComida=cbComida;
        this.modComida=modComida;
        this.ckComida=ckComida;
        this.cbMontana=cbMontana;
        this.modMontana=modMontana;
        this.ckMontana=ckMontana;
        this.cbTesoro=cbTesoro;
        this.modTesoro=modTesoro;
        this.ckTesoro=ckTesoro;
        this.cbBiblio=cbBiblio;
        this.modBiblio=modBiblio;
        this.ckBiblio=ckBiblio;
        this.cbPozo=cbPozo;
        this.modPozo=modPozo;
        this.ckPozo=ckPozo;

    }
public void setTipo(String tipo){
        this.tipo=tipo;
}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getProbabilidad_Z() {
        return Probabilidad_Z;
    }

    public void setProbabilidad_Z(float probabilidad_Z) {
        Probabilidad_Z = probabilidad_Z;
    }

    public float getProbabilida_V() {
        return Probabilida_V;
    }

    public void setProbabilida_V(float probabilida_V) {
        Probabilida_V = probabilida_V;
    }

    public String getTipo() {
        return tipo;
    }
    public int getTiemposvida() {
        return tiemposvida;
    }

    public void setTiemposvida(int tiemposvida) {
        this.tiemposvida = tiemposvida;
    }
    String cbAgua;

    int modAgua;

    boolean ckAgua;
    String cbComida;

    int modComida;

    boolean ckComida;
    String cbMontana;

    int modMontana;

    boolean ckMontana;
    String cbBiblio;

    int modBiblio;

    boolean ckBiblio;
    String cbTesoro;

    int modTesoro;

    boolean ckTesoro;

    String cbPozo;

    int modPozo;

    boolean ckPozo;

    public String getCbAgua() {
        return cbAgua;
    }

    public void setCbAgua(String cbAgua) {
        this.cbAgua = cbAgua;
    }

    public int getModAgua() {
        return modAgua;
    }

    public void setModAgua(int modAgua) {
        this.modAgua = modAgua;
    }

    public boolean isCkAgua() {
        return ckAgua;
    }

    public void setCkAgua(boolean ckAgua) {
        this.ckAgua = ckAgua;
    }

    public String getCbComida() {
        return cbComida;
    }

    public void setCbComida(String cbComida) {
        this.cbComida = cbComida;
    }

    public int getModComida() {
        return modComida;
    }

    public void setModComida(int modComida) {
        this.modComida = modComida;
    }

    public boolean isCkComida() {
        return ckComida;
    }

    public void setCkComida(boolean ckComida) {
        this.ckComida = ckComida;
    }

    public String getCbMontana() {
        return cbMontana;
    }

    public void setCbMontana(String cbMontana) {
        this.cbMontana = cbMontana;
    }

    public int getModMontana() {
        return modMontana;
    }

    public void setModMontana(int modMontana) {
        this.modMontana = modMontana;
    }

    public boolean isCkMontana() {
        return ckMontana;
    }

    public void setCkMontana(boolean ckMontana) {
        this.ckAgua = ckMontana;
    }

    public String getCbTesoro() {
        return cbTesoro;
    }

    public void setCbTesoro(String cbTesoro) {
        this.cbTesoro = cbTesoro;
    }

    public int getModTesoro() {
        return modTesoro;
    }

    public void setModTesoro(int modTesoro) {
        this.modTesoro = modTesoro;
    }

    public boolean isCkTesoro() {
        return ckTesoro;
    }

    public void setCkTesoro(boolean ckTesoro) {
        this.ckTesoro = ckTesoro;
    }

    public String getCbBiblio() {
        return cbBiblio;
    }

    public void setCbBiblio(String cbBiblio) {
        this.cbBiblio = cbBiblio;
    }

    public int getModBiblio() {
        return modBiblio;
    }

    public void setModBiblio(int modBiblio) {
        this.modBiblio = modBiblio;
    }

    public boolean isCkBiblio() {
        return ckBiblio;
    }

    public void setCkBiblio(boolean ckBiblio) {
        this.ckBiblio = ckBiblio;
    }

    public String getCbPozo() {
        return cbPozo;
    }

    public void setCbPozo(String cbPozo) {
        this.cbPozo = cbPozo;
    }

    public int getModPozo() {
        return modPozo;
    }

    public void setModPozo(int modPozo) {
        this.modPozo = modPozo;
    }

    public boolean isCkPozo() {
        return ckPozo;
    }

    public void setCkPozo(boolean ckPozo) {
        this.ckAgua = ckPozo;
    }

}
