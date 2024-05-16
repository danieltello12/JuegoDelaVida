package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class Movimiento extends gson {
    public int getIdIndividuo() {
        return idIndividuo;
    }

    public void setIdIndividuo(int idIndividuo) {
        this.idIndividuo = idIndividuo;
    }

    int idIndividuo;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    int idMovimiento;

    int x;
    int y;

    public Movimiento(int x, int y, int idIndividuo) {
        this.x = x;
        this.y = y;
        this.idIndividuo = idIndividuo;

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
}
