package es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar;

import es.uah.trabajo.juegodelavida.Clases.Partida;

public class ElementoLEPA<TipoDelDato>{
     ElementoLEPA<TipoDelDato> siguiente;
    Partida datos;

    public ElementoLEPA(ElementoLEPA<TipoDelDato> siguiente, Partida datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLEPA(Partida datos){
        this.datos=datos;
    }



    public ElementoLEPA getSiguiente() {

        return siguiente;
    }

    public Partida getDatos() {

        return datos;
    }

    public void setDatos(Partida datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLEPA el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
