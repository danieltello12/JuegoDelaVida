package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

public class ElementoLDE<TipoDelDato> {
   public ElementoLDE anterior;
    public ElementoLDE siguiente;
     public TipoDelDato datos;


    public ElementoLDE(TipoDelDato datos) {
        this.datos = datos;
    }





    public TipoDelDato getDatos() {

        return datos;
    }

}
