package es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Elementos;

public class Invidiuos extends Elementos {

    int id;
    int turnosvida;
    float probrep;
    float probclon;
    String tipo;

    public Invidiuos(int x, int y, int id, int turnosvida, float probrep, float probclon) {
       super(x,y);
        this.id = id;
        this.turnosvida = turnosvida;
        this.probrep = probrep;
        this.probclon = probclon;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTurnosvida() {
        return turnosvida;
    }

    public void setTurnosvida(int turnosvida) {
        this.turnosvida = turnosvida;
    }

    public float getProbrep() {
        return probrep;
    }

    public void setProbrep(float probrep) {
        this.probrep = probrep;
    }

    public float getProbclon() {
        return probclon;
    }

    public void setProbclon(float probclon) {
        this.probclon = probclon;
    }
}
