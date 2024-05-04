package es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Elementos;

public abstract class Invidiuos extends Elementos {
    int id;
    int generacionind;
    int turnosvida;
    int probrep;
    int probclon;

    public Invidiuos(int x, int y, int id, int generacionind, int turnosvida, int probrep, int probclon) {
        super(x, y);
        this.id = id;
        this.generacionind = generacionind;
        this.turnosvida = turnosvida;
        this.probrep = probrep;
        this.probclon = probclon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracionind() {
        return generacionind;
    }

    public void setGeneracionind(int generacionind) {
        this.generacionind = generacionind;
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
