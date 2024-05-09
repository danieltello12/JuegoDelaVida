package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;

public class ElementoRe {
    protected ElementoRe siguiente;
    private Recursos datos;

    public ElementoRe( ElementoRe siguiente, Recursos datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoRe(Recursos datos){
        this.datos=datos;
    }



    protected ElementoRe getSiguiente() {

        return siguiente;
    }

    public Recursos getDatos() {

        return datos;
    }

    public void setDatos(Recursos datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoRe el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
