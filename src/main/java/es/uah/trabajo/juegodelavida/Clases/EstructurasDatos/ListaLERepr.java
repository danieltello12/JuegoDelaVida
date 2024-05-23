package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Json.gson;
import es.uah.trabajo.juegodelavida.Clases.Reproduccion;



public class ListaLERepr<TipoDelDato> extends gson {
    protected ElementoLERepr<TipoDelDato> primero;
    public void añadirReproduccion(Reproduccion nuevo) {
        ListaLERepr l= new ListaLERepr();
        l=l.cargar();
        l.add(nuevo);
        guardar(l);
    }
    public boolean isVacia() {
        boolean vacio = false;
        if (this.primero == null) {
            vacio = true;
        }
        return vacio;
    }

    public void guardar(ListaLERepr<TipoDelDato> l){
        guardarObjetoEnArchivo("Json/reproduccion.json",l);
    }
    public ListaLERepr<Reproduccion> cargar(){
        return cargarObjetoDesdeArchivo("Json/reproduccion.json", ListaLERepr.class);

    }
    public void vaciar() {
        this.primero = null;
    }


   /** public void add(String st) {
        ElementoLE<TipoDelDato> nuevoprimero = new ElementoLE(this.primero, st);
        this.add(nuevoprimero);

    }**/
   private void add(ElementoLERepr<TipoDelDato> el) {
       if (isVacia()) {
           this.primero = el;

       } else {
           ElementoLERepr<TipoDelDato> nuevoprimero = new ElementoLERepr(this.primero, el.getDatos());
           this.primero = nuevoprimero;


       }


   }
      public void add(Reproduccion obj) {

        ElementoLERepr<TipoDelDato> nuevoprimero = new ElementoLERepr(this.primero, obj);
        this.add(nuevoprimero);

    }
    public void add(Reproduccion obj,int idmovimiento) {

        ElementoLERepr<TipoDelDato> nuevoprimero = new ElementoLERepr(this.primero, obj);
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

    public void insert(Reproduccion dato, int posicion) {
        ElementoLERepr<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.add(dato,0);
        } else {
            ElementoLERepr<TipoDelDato> e= new ElementoLERepr(this.getElemento(posicion),dato);
            this.getElemento(posicion-1).siguiente=e;
        }
    }

    public int del(int posicion) {
        ElementoLERepr<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }


            if (el != null && el.getSiguiente() != null) {
                ElementoLERepr<TipoDelDato> el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoLERepr<TipoDelDato> el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoLERepr<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLERepr<TipoDelDato> el = this.primero;
        while (el != null && salir == false) {
            if (el.getDatos().getIdIndividuoPadre1() == el2.getDatos().getIdIndividuoPadre1() &&
                    el.getDatos().getIdIndividuoPadre2() == el2.getDatos().getIdIndividuoPadre2() &&
                    el.getDatos().getIdIndividuoHijo() == el2.getDatos().getIdIndividuoHijo()) {
                salir = true;
            } else {
                el = el.getSiguiente();
                contador++;
            }

        }
        if (!salir)
            contador=-1;
        return contador;
    }

    public ElementoLERepr<TipoDelDato> getPrimero() {
        return this.primero;

    }

    public ElementoLERepr<TipoDelDato> getUltimo() {
        ElementoLERepr<TipoDelDato> el = this.primero;
        ElementoLERepr<TipoDelDato> elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoLERepr<TipoDelDato> getSiguiente(ElementoLERepr<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLERepr<TipoDelDato> el = this.primero;
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

    public ElementoLERepr<TipoDelDato> getElemento(int posicion) {
        ElementoLERepr<TipoDelDato> el = this.primero;
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
