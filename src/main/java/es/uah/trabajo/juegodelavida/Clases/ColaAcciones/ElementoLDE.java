package es.uah.trabajo.juegodelavida.Clases.ColaAcciones;

public class ElementoLDE<TipoDelDato> {
    public ElementoLDE<TipoDelDato> anterior;
    public ElementoLDE<TipoDelDato> siguiente;
    public TipoDelDato datos;


    public ElementoLDE(TipoDelDato datos) {
        this.datos = datos;
    }





    public TipoDelDato getDatos() {

        return datos;
    }
}
