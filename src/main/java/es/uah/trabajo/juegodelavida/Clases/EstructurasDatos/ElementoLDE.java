package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

public class ElementoLDE<TipoDelDato> {
    ElementoLDE anterior;
    ElementoLDE siguiente;
    TipoDelDato datos;


    public ElementoLDE(TipoDelDato datos) {
        this.datos = datos;
    }





    public TipoDelDato getDatos() {

        return datos;
    }

}
