package es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos;

public class Recursos {
    int x;
    int y;
    int Probabilidad_Z;
    int Probabilida_V;
    String tipo;
    public Recursos(int x, int y,int probz,int probv){
        this.x=x;
        this.y=y;
        this.Probabilidad_Z=probz;
        this.Probabilida_V=probv;
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

    public int getProbabilidad_Z() {
        return Probabilidad_Z;
    }

    public void setProbabilidad_Z(int probabilidad_Z) {
        Probabilidad_Z = probabilidad_Z;
    }

    public int getProbabilida_V() {
        return Probabilida_V;
    }

    public void setProbabilida_V(int probabilida_V) {
        Probabilida_V = probabilida_V;
    }

    public String getTipo() {
        return tipo;
    }
}
