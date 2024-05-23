package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class Reproduccion extends gson {
    public int getIdIndividuoPadre1() {
        return idIndividuoPadre1;
    }

    public void setIdIndividuoPadre1(int idIndividuoPadre1) {
        this.idIndividuoPadre1 = idIndividuoPadre1;
    }
    public int getIdIndividuoPadre2() {
        return idIndividuoPadre2;
    }

    public void setIdIndividuoPadre2(int idIndividuoPadre2) {
        this.idIndividuoPadre2 = idIndividuoPadre2;
    }
    public int getIdIndividuoHijo() {
        return idIndividuoHijo;
    }

    public void setIdIndividuoHijo(int idIndividuo) {
        this.idIndividuoHijo = idIndividuoHijo;
    }

    int idIndividuoPadre1;
    int idIndividuoPadre2;
    int idIndividuoHijo;

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    int paso;
        public Reproduccion(int idIndividuoPadre1, int idIndividuoPadre2, int idIndividuoHijo, int paso) {
        this.idIndividuoPadre1 = idIndividuoPadre1;
        this.idIndividuoPadre2 = idIndividuoPadre2;
        this.idIndividuoHijo = idIndividuoHijo;
        this.paso=paso;

    }

}
