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
       this.recursos=recursos;
    }

    public String getNombre() {
        return nombre;
    }
}

