package es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Elementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLEMov;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;

public class Invidiuos extends Elementos {

    int id;
    int turnosvida;
    float probrep;
    float probclon;
    String tipo;
    ListaLEMov<Movimiento> movimientos;

    public Invidiuos(int x, int y, int id, int turnosvida, float probrep, float probclon) {
       super(x,y);
        this.id = id;
        this.turnosvida = turnosvida;
        this.probrep = probrep;
        this.probclon = probclon;
        movimientos= new ListaLEMov<>();
        movimientos.add(new Movimiento(x,y,id));
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo() {
        return tipo;
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
    public void añadirmovimientosJSon(){

        if(!movimientos.isVacia()){
            movimientos.guardar(movimientos);
        }

    }
    public void addMovimiento(Movimiento mov){
        movimientos.add(new Movimiento(mov.getX(),mov.getY(),id));
    }
}
