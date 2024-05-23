package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.ColaAcciones.Cola;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;

public class Partida {
    String nombre;
    float mejora;
    int filas;
    int columnas;
    float pvA;
    float  pvC;
    float pvM;
    float pvT;
    float pvB;
    float pvP;
    float pz;
    int tiemposvida;

    int turnosvida;
    ListaELementos individuos;

    ListaRecursos recursos;
    String cbAgua;

    int modAgua;

    boolean ckAgua;
    String cbComida;

    int modComida;

    boolean ckComida;
    String cbMontana;

    int modMontana;

    boolean ckMontana;
    String cbBiblio;

    int modBiblio;

    boolean ckBiblio;
    String cbTesoro;

    int modTesoro;

    boolean ckTesoro;

    String cbPozo;

    int modPozo;
    Cola acciones;

    boolean ckPozo;

    public Cola getAcciones() {
        return acciones;
    }

    public void setAcciones(Cola acciones) {
        this.acciones = acciones;
    }

    public float getMejora() {
        return mejora;
    }

    public void setMejora(float mejora) {
        this.mejora = mejora;
    }

    public String getCbAgua() {
        return cbAgua;
    }

    public void setCbAgua(String cbAgua) {
        this.cbAgua = cbAgua;
    }

    public int getModAgua() {
        return modAgua;
    }

    public void setModAgua(int modAgua) {
        this.modAgua = modAgua;
    }

    public boolean isCkAgua() {
        return ckAgua;
    }

    public void setCkAgua(boolean ckAgua) {
        this.ckAgua = ckAgua;
    }

    public String getCbComida() {
        return cbComida;
    }

    public void setCbComida(String cbComida) {
        this.cbComida = cbComida;
    }

    public int getModComida() {
        return modComida;
    }

    public void setModComida(int modComida) {
        this.modComida = modComida;
    }

    public boolean isCkComida() {
        return ckComida;
    }

    public void setCkComida(boolean ckComida) {
        this.ckComida = ckComida;
    }

    public String getCbMontana() {
        return cbMontana;
    }

    public void setCbMontana(String cbMontana) {
        this.cbMontana = cbMontana;
    }

    public int getModMontana() {
        return modMontana;
    }

    public void setModMontana(int modMontana) {
        this.modMontana = modMontana;
    }

    public boolean isCkMontana() {
        return ckMontana;
    }

    public void setCkMontana(boolean ckMontana) {
        this.ckAgua = ckMontana;
    }

    public String getCbTesoro() {
        return cbTesoro;
    }

    public void setCbTesoro(String cbTesoro) {
        this.cbTesoro = cbTesoro;
    }

    public int getModTesoro() {
        return modTesoro;
    }

    public void setModTesoro(int modTesoro) {
        this.modTesoro = modTesoro;
    }

    public boolean isCkTesoro() {
        return ckTesoro;
    }

    public void setCkTesoro(boolean ckTesoro) {
        this.ckTesoro = ckTesoro;
    }

    public String getCbBiblio() {
        return cbBiblio;
    }

    public void setCbBiblio(String cbBiblio) {
        this.cbBiblio = cbBiblio;
    }

    public int getModBiblio() {
        return modBiblio;
    }

    public void setModBiblio(int modBiblio) {
        this.modBiblio = modBiblio;
    }

    public boolean isCkBiblio() {
        return ckBiblio;
    }

    public void setCkBiblio(boolean ckBiblio) {
        this.ckBiblio = ckBiblio;
    }

    public String getCbPozo() {
        return cbPozo;
    }

    public void setCbPozo(String cbPozo) {
        this.cbPozo = cbPozo;
    }

    public int getModPozo() {
        return modPozo;
    }

    public void setModPozo(int modPozo) {
        this.modPozo = modPozo;
    }

    public boolean isCkPozo() {
        return ckPozo;
    }

    public void setCkPozo(boolean ckPozo) {
        this.ckAgua = ckPozo;
    }




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


    public int getTiemposvida() {
        return tiemposvida;
    }

    public void setTiemposvida(int tiemposVida) {
        this.tiemposvida = tiemposVida;
    }

    public int getTurnosvida() {
        return turnosvida;
    }

    public void setTurnosvida(int turnosvida) {
        this.turnosvida = turnosvida;
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

