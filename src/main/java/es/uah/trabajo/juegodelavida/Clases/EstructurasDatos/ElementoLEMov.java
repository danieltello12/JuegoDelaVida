package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Movimiento;

public class ElementoLEMov<TipoDelDato>{
     ElementoLEMov<TipoDelDato> siguiente;
    Movimiento datos;

    public ElementoLEMov(ElementoLEMov<TipoDelDato> siguiente, Movimiento datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLEMov(Movimiento datos){
        this.datos=datos;
    }



    public ElementoLEMov getSiguiente() {

        return siguiente;
    }

    public Movimiento getDatos() {

        return datos;
    }

    public void setDatos(Movimiento datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLEMov el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
