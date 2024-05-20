package es.uah.trabajo.juegodelavida.Clases.Grafos;

public class NodoGrafos <TipoDelDato> {
    protected TipoDelDato datos;
    protected ListaSimple<Arcos> listaSalidaArcos;
    protected ListaSimple<Arcos> listaLlegadaArcos;


    public TipoDelDato getDatos() {

        return datos;
    }

    public NodoGrafos(TipoDelDato datos, ListaSimple listaSalida, ListaSimple listaLlegada) {
        this.datos = datos;
        this.listaSalidaArcos = listaSalida;
        this.listaLlegadaArcos = listaLlegada;
    }


}




