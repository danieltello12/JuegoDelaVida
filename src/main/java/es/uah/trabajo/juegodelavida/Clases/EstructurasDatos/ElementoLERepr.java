package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Reproduccion;

public class ElementoLERepr<TipoDelDato>{
     ElementoLERepr<TipoDelDato> siguiente;
    Reproduccion datos;

    public ElementoLERepr(ElementoLERepr<TipoDelDato> siguiente, Reproduccion datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLERepr(Reproduccion datos){
        this.datos=datos;
    }



    public ElementoLERepr getSiguiente() {

        return siguiente;
    }

    public Reproduccion getDatos() {

        return datos;
    }

    public void setDatos(Reproduccion datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLERepr el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
