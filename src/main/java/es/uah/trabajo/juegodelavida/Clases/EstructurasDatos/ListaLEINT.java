package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

public class ListaLEINT {

    protected ElementoLEINT primero;

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


    private void add(ElementoLEINT el) {
        if (isVacia()) {
            this.primero = el;

        } else {
            ElementoLEINT nuevoprimero = new ElementoLEINT(this.primero, el.getDatos());
            this.primero = nuevoprimero;


        }


    }


    public void add(int obj) {
        ElementoLEINT nuevoprimero = new ElementoLEINT(this.primero, obj);
        this.add(nuevoprimero);

    }





    public void insert(int dato, int posicion) {
        ElementoLEINT el = this.primero;
        if (posicion == 0) {
            this.add(dato);
        } else {
            ElementoLEINT e= new ElementoLEINT(this.getElemento(posicion),dato);
            this.getElemento(posicion-1).siguiente=e;
        }
    }

    public int del(int posicion) {
        ElementoLEINT el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }


            if (el != null && el.getSiguiente() != null) {
                ElementoLEINT el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoLEINT el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoLEINT el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEINT el = this.primero;
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

    public ElementoLEINT getPrimero() {
        return this.primero;

    }

    public ElementoLEINT getUltimo() {
        ElementoLEINT el = this.primero;
        ElementoLEINT elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoLEINT getSiguiente(ElementoLEINT el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEINT el = this.primero;
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

    public ElementoLEINT getElemento(int posicion) {
        ElementoLEINT el = this.primero;
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
