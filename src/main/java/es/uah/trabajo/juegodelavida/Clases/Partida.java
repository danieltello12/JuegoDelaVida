package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;

public class Partida {
    String nombre;
    int filas;
    int columnas;
    float pvA;
    float  pvC;
    float pvM;
    float pvT;
    float pvB;
    float pvP;
    float pz;
    ListaELementos individuos;

    ListaRecursos recursos;

    public  Partida(String  nombre){
        this.nombre=nombre;
    }
    public Partida(String nombre,int filas,int columnas, ListaELementos individuos,ListaRecursos rec){
       this.nombre=nombre;
       this.filas=filas;
       this.columnas=columnas;
       this.individuos=individuos;
       this.recursos=rec;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPvA() {
        return pvA;
    }

    public void setPvA(float pvA) {
        this.pvA = pvA;
    }

    public float getPvC() {
        return pvC;
    }

    public void setPvC(float pvC) {
        this.pvC = pvC;
    }

    public float getPvM() {
        return pvM;
    }

    public void setPvM(float pvM) {
        this.pvM = pvM;
    }

    public float getPvT() {
        return pvT;
    }

    public void setPvT(float pvT) {
        this.pvT = pvT;
    }

    public float getPvB() {
        return pvB;
    }

    public void setPvB(float pvB) {
        this.pvB = pvB;
    }

    public float getPvP() {
        return pvP;
    }

    public void setPvP(float pvP) {
        this.pvP = pvP;
    }

    public float getPz() {
        return pz;
    }

    public void setPz(float pz) {
        this.pz = pz;
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

