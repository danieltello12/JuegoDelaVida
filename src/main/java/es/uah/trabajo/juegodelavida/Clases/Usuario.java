package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;

public class Usuario {
    String nombre;
    String contraseña;
    private ListaLE<Partida> partidas;
    public  Usuario(String nombre, String contraseña ){
        this.nombre=nombre;
        this.contraseña=contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ListaLE<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ListaLE<Partida> partidas) {
        this.partidas = partidas;
    }
}
