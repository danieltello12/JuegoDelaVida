package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;

public class Partida {
    String nombre;
    int filas;
    int columnas;
    ListaELementos individuos;

    ListaRecursos recursos;
    public Partida(String nombre,int filas,int columnas, ListaELementos individuos,ListaRecursos rec){
       this.nombre=nombre;
       this.filas=filas;
       this.columnas=columnas;
       this.individuos=individuos;
       this.recursos=rec;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public ListaELementos getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ListaELementos individuos) {
        this.individuos = individuos;
    }

    public ListaRecursos getRecursos() {
        return recursos;
    }

    public void setRecursos(ListaRecursos recursos) {
        this.recursos = recursos;
    }
}

