package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Recursos;

public class ElementoLERe {
    ElementoLERe siguiente;
    Recursos datos;

    public ElementoLERe(ElementoLERe siguiente, Recursos datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLERe(Recursos datos){
        this.datos=datos;
    }



    public ElementoLERe getSiguiente() {

        return siguiente;
    }

    public Recursos getDatos() {

        return datos;
    }

    public void setDatos(Recursos datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLERe el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
