package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Json.gson;
import es.uah.trabajo.juegodelavida.Clases.Usuario;

public class ListaLE<TipoDelDato> extends gson {
    protected ElementoLEUs<TipoDelDato> primero;

    public boolean isVacia() {
        boolean vacio = false;
        if (this.primero == null) {
            vacio = true;
        }
        return vacio;
    }

    public void guardar(ListaLE<TipoDelDato> l){
        guardarObjetoEnArchivo("Json/usuarios.json",l);
    }
    public ListaLE<Usuario> cargar(){
        return cargarObjetoDesdeArchivo("Json/usuarios.json", ListaLE.class);

    }
    public void vaciar() {
        this.primero = null;
    }


    private void add(ElementoLEUs<TipoDelDato> el) {
        if (isVacia()) {
            this.primero = el;

        } else {
            ElementoLEUs<TipoDelDato> nuevoprimero = new ElementoLEUs(this.primero, el.getDatos());
            this.primero = nuevoprimero;


        }


    }

    /** public void add(String st) {
     ElementoLE<TipoDelDato> nuevoprimero = new ElementoLE(this.primero, st);
     this.add(nuevoprimero);

     }**/

    public void add(Usuario obj) {
        ElementoLEUs<TipoDelDato> nuevoprimero = new ElementoLEUs(this.primero, obj);
        this.add(nuevoprimero);

    }

    /** public void insert(String s, int posicion) {
     ElementoLE<TipoDelDato> el = this.primero;
     if (posicion == 0) {
     this.add(s);
     } else {
     ElementoLE<TipoDelDato> e = new ElementoLE(this.getElemento(posicion), s);
     this.getElemento(posicion - 1).siguiente = e;
     }


     }**/

    public void insert(Usuario dato, int posicion) {
        ElementoLEUs<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.add(dato);
        } else {
            ElementoLEUs<TipoDelDato> e= new ElementoLEUs(this.getElemento(posicion),dato);
            this.getElemento(posicion-1).siguiente=e;
        }
    }

    public int del(int posicion) {
        ElementoLEUs<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }


            if (el != null && el.getSiguiente() != null) {
                ElementoLEUs<TipoDelDato> el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoLEUs<TipoDelDato> el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoLEUs<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEUs<TipoDelDato> el = this.primero;
        while (el != null && salir == false) {
            if (el.getDatos().getNombre().equals(el2.getDatos().getNombre())) {
                salir = true;
            } else {
                el = el.getSiguiente();
                contador++;
            }

        }
        if(!salir)
            contador=-1;
        return contador;
    }

    public ElementoLEUs<TipoDelDato> getPrimero() {
        return this.primero;

    }

    public ElementoLEUs<TipoDelDato> getUltimo() {
        ElementoLEUs<TipoDelDato> el = this.primero;
        ElementoLEUs<TipoDelDato> elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoLEUs<TipoDelDato> getSiguiente(ElementoLEUs<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEUs<TipoDelDato> el = this.primero;
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

    public ElementoLEUs<TipoDelDato> getElemento(int posicion) {
        ElementoLEUs<TipoDelDato> el = this.primero;
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

