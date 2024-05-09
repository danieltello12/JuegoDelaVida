package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class ListaELementos <TipoDelDato>extends gson {
    protected ElementoLE primero;
    public void añadirindividuo(Invidiuos nuevo) {
        ListaELementos l = new ListaELementos();
        l=l.cargar();
        l.add(nuevo);
        guardar(l);
    }
    public void guardar(ListaELementos l){
        guardarObjetoEnArchivo("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json",l);
    }
    public ListaELementos cargar(){
        return cargarObjetoDesdeArchivo("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json", ListaELementos.class);

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


    private void add(ElementoLE el) {
        if (isVacia()) {
            this.primero = el;

        } else {
            ElementoLE nuevoprimero = new ElementoLE(this.primero, (Invidiuos) el.getDatos());
            this.primero = nuevoprimero;


        }


    }


    public void add(Invidiuos obj) {
        ElementoLE nuevoprimero = new ElementoLE(this.primero, obj);
        this.add(nuevoprimero);

    }


    public void insert(Invidiuos dato, int posicion) {
        ElementoLE el = this.primero;
        if (posicion == 0) {
            this.add(dato);
        } else {
            ElementoLE e= new ElementoLE(this.getElemento(posicion),dato);
            this.getElemento(posicion-1).siguiente=e;
        }
    }

    public int del(int posicion) {
        ElementoLE el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }


            if (el != null && el.getSiguiente() != null) {
                ElementoLE el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoLE el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoLE el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLE el = this.primero;
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

    public ElementoLE getPrimero() {
        return this.primero;

    }

    public ElementoLE getUltimo() {
        ElementoLE el = this.primero;
        ElementoLE elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoLE getSiguiente(ElementoLE el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLE el = this.primero;
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

    public ElementoLE getElemento(int posicion) {
        ElementoLE el = this.primero;
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
