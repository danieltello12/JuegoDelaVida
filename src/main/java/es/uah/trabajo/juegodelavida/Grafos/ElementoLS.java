package es.uah.trabajo.juegodelavida.Grafos;

public class ElementoLS <TipoDelDato> {
    TipoDelDato dato;
    public ElementoLS(TipoDelDato dato) {
        this.dato = dato;


    }

    public TipoDelDato getDato() {
        return dato;
    }

    public void setDato(TipoDelDato dato) {
        this.dato = dato;
    }

}
