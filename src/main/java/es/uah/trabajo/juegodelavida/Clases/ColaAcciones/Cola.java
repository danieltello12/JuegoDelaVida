package es.uah.trabajo.juegodelavida.Clases.ColaAcciones;

import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLDE;

import static es.uah.trabajo.juegodelavida.Clases.Json.gson.cargarObjetoDesdeArchivo;
import static es.uah.trabajo.juegodelavida.Clases.Json.gson.guardarObjetoEnArchivo;

public class Cola <TipoDelDato> {
    private ElementoLDE<String> cabecera;
    private ElementoLDE<String> cola;
    private int longitud;
    private ElementoLDE<String> siguiente;
    public Cola(){
        cabecera=cola=null;
        longitud=0;
    }

    public void vaciar(){
        this.cola=null;
        this.cabecera=null;
    }
    public void guardar(Cola<TipoDelDato> l){
        guardarObjetoEnArchivo("Json/ColaAcciones.json",l);
    }
    public Cola cargar(){
        return cargarObjetoDesdeArchivo("Json/ColaAcciones.json", Cola.class);

    }

    public boolean esVacía(){
        return (cabecera==null);
    }

    public ElementoLDE<String> encolar(es.uah.trabajo.juegodelavida.Clases.Grafos.ElementoLDE<String> ob){
        ElementoLDE<String> n=new ElementoLDE<String>(ob.getDatos());
        if (longitud==0){
            cola=cabecera=n; //Para que en el setSiguiente no de null
            longitud++;
        }else{
            n.siguiente=cabecera;
            cabecera=n;
            longitud++;
        }
        return cabecera;
    }


    public ElementoLDE<String> getCola(){

        return this.cola;
    }

    public ElementoLDE<String> getElemento(int posicion) {
        int pos = 0;
        ElementoLDE<String> obj = this.cabecera;
        while (pos < posicion) {
            obj = obj.siguiente;
            pos++;
        }
        return obj;

    }
    public int getNumeroElemC(){
        int elem=0;
        ElementoLDE<String> el = this.cabecera;
        while (el!=null){
            el=el.siguiente;
            elem++;
        }
        return elem;
    }


}

