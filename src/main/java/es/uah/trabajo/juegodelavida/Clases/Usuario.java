package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLEUs;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class Usuario extends gson {
    String nombre;
    String contraseña;
    ListaLEPA<Partida> partidas;
    public  Usuario(String nombre, String contraseña ){
        this.nombre=nombre;
        this.contraseña=contraseña;
        ListaLEPA  partidas=new ListaLEPA();
        this.partidas=partidas;
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

    public ListaLEPA getPartidas() {
        return partidas;
    }

    public void setPartidas(ListaLEPA partidas) {
        this.partidas = partidas;
        añadirpartidasJSon();
    }

    public void setPartida(Partida partida) {
        this.partidas.add(partida);
        añadirpartidasJSon();
    }

    public void guardar() {
partidas.guardar(this.nombre);
    }
    public ListaLEPA<Usuario> cargar(){
        return partidas.cargar(this.nombre);

    }
    public void añadirpartidasJSon(){
         ListaLE l = new ListaLE();
        l=l.cargar();
        ElementoLEUs e= new ElementoLEUs(this);

        if(l.isVacia()){
            l.add(this);
        }
        else {
            int pos = l.getPosicion(e);
            l.del(pos);
            l.add(this);
        }
        l.guardar(l);
    }
}
