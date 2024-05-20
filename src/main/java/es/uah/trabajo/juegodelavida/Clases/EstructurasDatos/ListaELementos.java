package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

import java.util.Objects;

public class ListaELementos <TipoDelDato>extends gson {
    protected ElementoLE primero;
    public void añadirindividuo(Invidiuos nuevo,String ruta) {
        ListaELementos l = new ListaELementos();
        l=l.cargar(ruta);
        l.add(nuevo);
        guardar(l,ruta);
    }
    public void guardar(ListaELementos l,String ruta){
        guardarObjetoEnArchivo(ruta,l);
    }
    public ListaELementos cargar(String ruta){
        return cargarObjetoDesdeArchivo(ruta, ListaELementos.class);

    }
    public int elementoscelda(int x,int y){
        ListaELementos ind= new ListaELementos();
        ind = ind.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
       int num = 0;
        ElementoLE el = ind.primero;
        while (el != null) {
            if (Objects.equals((el.getDatos().getX()),x)&&Objects.equals((el.getDatos().getY()),y)) {
                num +=1;
                el=  el.getSiguiente();
            }
            else {
                el =  el.getSiguiente();
            }

        }
        return num;
    }
    public boolean esta(int id,String ruta){
        ListaELementos ind= new ListaELementos();
        ind = ind.cargar(ruta);
        boolean esta=false;
        ElementoLE el = ind.primero;
        while (el != null &&esta==false) {
            if (Objects.equals(el.getDatos().getId(),id)) {
               esta=true;
            }


            else {
                el =  el.getSiguiente();
            }

        }
        return esta;
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
            ElementoLE nuevoprimero = new ElementoLE(this.primero, el.getDatos());
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
        if (!salir)
            contador=-1;
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
