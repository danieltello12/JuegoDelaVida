package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;

public class ElementoLE<TipoDelDato> {
    protected ElementoLE siguiente;
    private Invidiuos datos;

    public ElementoLE( ElementoLE siguiente, Invidiuos datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLE(Invidiuos datos){
        this.datos=datos;
    }



    protected ElementoLE getSiguiente() {

        return siguiente;
    }

    public Invidiuos getDatos() {

        return datos;
    }

    public void setDatos(Invidiuos datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLE el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
