package es.uah.trabajo.juegodelavida.Clases.Grafos;

public class Arcos<T> {
    protected NodoGrafos origen;
    protected  NodoGrafos destino;
    protected int peso;
    protected String relacion;

    protected String nombre;

    public Arcos(String nombre, NodoGrafos origen, NodoGrafos destino , int peso,String relacion) {
        this.nombre=nombre;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.relacion=relacion;

    }
}
