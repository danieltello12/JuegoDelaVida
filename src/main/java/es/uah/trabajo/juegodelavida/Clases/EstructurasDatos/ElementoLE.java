package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Usuario;

public class ElementoLE <TipoDelDato>{
     ElementoLE<TipoDelDato> siguiente;
    Usuario datos;

    public ElementoLE( ElementoLE<TipoDelDato> siguiente, Usuario datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLE(Usuario datos){
        this.datos=datos;
    }



    public ElementoLE getSiguiente() {

        return siguiente;
    }

    public Usuario getDatos() {

        return datos;
    }

    public void setDatos(Usuario datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLE el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
