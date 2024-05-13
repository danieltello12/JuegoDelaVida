package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

import java.util.Objects;

public class ListaRecursos extends gson {
    protected ElementoRe primero;
    public void añadirindividuo(Recursos nuevo,String ruta) {
        ListaRecursos l= new ListaRecursos();
        l=l.cargar(ruta);
        l.add(nuevo);
        guardar(l,ruta);
    }
    public void guardar(ListaRecursos l,String ruta){
        guardarObjetoEnArchivo(ruta,l);
    }
    public ListaRecursos cargar(String ruta){
        return cargarObjetoDesdeArchivo(ruta, ListaRecursos.class);

    }
    public int elementoscelda(int x,int y,String ruta){
        ListaRecursos rec= new ListaRecursos();
        rec = rec.cargar(ruta);
        int num = 0;
        ElementoRe el = rec.primero;
        while (el != null) {
            if (Objects.equals((el.getDatos().getX()),x)&&Objects.equals((el.getDatos().getY()),y)) {
                num +=1;
            }


            else {
                el =  el.getSiguiente();
            }

        }
        return num;
    }

    public boolean isVacia() {
        boolean vacio = false;
        if (this.primero == null) {
            vacio = true;
        }
        return vacio;
    }

    public void vaciar() {
        this.primero = null;
    }


    private void add(ElementoRe el) {
        if (isVacia()) {
            this.primero = el;

        } else {
            ElementoRe nuevoprimero = new ElementoRe(this.primero, (Recursos) el.getDatos());
            this.primero = nuevoprimero;


        }


    }


    public void add(Recursos obj) {
        ElementoRe nuevoprimero = new ElementoRe(this.primero, obj);
        this.add(nuevoprimero);

    }


    public void insert(Recursos dato, int posicion) {
        ElementoRe el = this.primero;
        if (posicion == 0) {
            this.add(dato);
        } else {
            ElementoRe e= new ElementoRe(this.getElemento(posicion),dato);
            this.getElemento(posicion-1).siguiente=e;
        }
    }

    public int del(int posicion) {
        ElementoRe el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }

            if (el != null && el.getSiguiente() != null) {
                ElementoRe el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoRe el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoRe el2) {
        int contador = 0;
        boolean salir = false;
        ElementoRe el = this.primero;
        while (el != null && salir == false) {
            if (el.getDatos() == el2.getDatos()) {
                salir = true;
            } else {
                el = el.getSiguiente();
                contador++;
            }

        }
        return contador;
    }

    public ElementoRe getPrimero() {
        return this.primero;

    }

    public ElementoRe getUltimo() {
        ElementoRe el = this.primero;
        ElementoRe elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoRe getSiguiente(ElementoRe el2) {
        int contador = 0;
        boolean salir = false;
        ElementoRe el = this.primero;
        while (el != null && salir == false) {
            if (el.getDatos() == el2.getDatos()) {
                salir = true;
            } else {
                el = el.getSiguiente();
                contador++;
            }

        }
        return el.getSiguiente();


    }

    public  ElementoRe getElemento(int posicion) {
        ElementoRe el = this.primero;
        if (posicion != 0) {
            int contador = 0;
            while (el != null && contador != posicion) {
                el = el.getSiguiente();
                contador++;

            }
        }
        return el;
    }
}
