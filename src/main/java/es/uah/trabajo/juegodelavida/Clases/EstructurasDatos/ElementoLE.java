package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;
import com.google.gson.Gson;
public class ElementoLE <TipoDelDato>{
    protected ElementoLE siguiente;
    private TipoDelDato datos;

    public ElementoLE( ElementoLE siguiente, TipoDelDato datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public ElementoLE(TipoDelDato datos){
        this.datos=datos;
    }



    public ElementoLE getSiguiente() {

        return siguiente;
    }

    public TipoDelDato getDatos() {

        return datos;
    }

    public void setDatos(TipoDelDato datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLE el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
