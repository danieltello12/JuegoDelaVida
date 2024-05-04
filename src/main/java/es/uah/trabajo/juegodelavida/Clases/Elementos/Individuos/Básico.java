package es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;

public class Básico extends Invidiuos {

    public Básico(int x, int y, int id, int generacionind, int turnosvida, int probrep, int probclon) {
        super(x, y, id, generacionind, turnosvida, probrep, probclon);
    }

    public void move(int x , int y){
        Básico.super.setX(x);
        Básico.super.setY(y);
    }
}
