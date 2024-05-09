package es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Elementos;

public class Invidiuos extends Elementos {
    int id;
    int turnosvida;
    int probrep;
    int probclon;
    String tipo;

    public Invidiuos(int x, int y, int id, int turnosvida, int probrep, int probclon) {
        super(x, y);
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

    public int getProbrep() {
        return probrep;
    }

    public void setProbrep(int probrep) {
        this.probrep = probrep;
    }

    public int getProbclon() {
        return probclon;
    }

    public void setProbclon(int probclon) {
        this.probclon = probclon;
    }
}
