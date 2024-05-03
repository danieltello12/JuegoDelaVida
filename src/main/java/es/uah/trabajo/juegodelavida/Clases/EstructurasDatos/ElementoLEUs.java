package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Usuario;

public class ElementoLEUs<TipoDelDato>{
     ElementoLEUs<TipoDelDato> siguiente;
    Usuario datos;

    public ElementoLEUs(ElementoLEUs<TipoDelDato> siguiente, Usuario datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLEUs(Usuario datos){
        this.datos=datos;
    }



    public ElementoLEUs getSiguiente() {

        return siguiente;
    }

    public Usuario getDatos() {

        return datos;
    }

    public void setDatos(Usuario datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLEUs el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
