package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

public class ElementoLEINT {
    protected ElementoLEINT siguiente;
    private int datos;

    public ElementoLEINT( ElementoLEINT siguiente, int datos) {
        this.siguiente = siguiente;
        this.datos = datos;
    }
    public  ElementoLEINT(int dato){
        this.datos=dato;
    }



    protected ElementoLEINT getSiguiente() {

        return siguiente;
    }

    public int getDatos() {

        return datos;
    }

    public void setDatos(int datos) {

        this.datos = datos;
    }
    protected void insertarmeEN(ElementoLEINT el){
        if (el!=null)
            el.siguiente = this.siguiente;
        this.siguiente = el;

    }
}
