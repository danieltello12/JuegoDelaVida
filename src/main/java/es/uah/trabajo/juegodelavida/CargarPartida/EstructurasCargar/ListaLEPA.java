package es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar;

import es.uah.trabajo.juegodelavida.Clases.Json.gson;
import es.uah.trabajo.juegodelavida.Clases.Partida;

import java.util.Objects;

public class ListaLEPA<TipoDelDato> extends gson {
    protected ElementoLEPA<TipoDelDato> primero;

    public boolean isVacia() {
        boolean vacio = false;
        if (this.primero == null) {
            vacio = true;
        }
        return vacio;
    }
    public void vaciar(){
        this.primero=null;
    }
    public boolean esta(String usuario, String partida) {
        ListaLEPA partidas= new ListaLEPA();
        partidas = partidas.cargar(usuario);
        boolean encontrado = false;
        if (partidas!=null){
            ElementoLEPA el = partidas.getPrimero();
            while (el != null && encontrado == false) {
                if (Objects.equals((el.getDatos().getNombre()),partida)) {
                    encontrado =true;
                }


                else {
                    el =  el.getSiguiente();
                }

            }
        }

        return encontrado;
    }


    private void add(ElementoLEPA<TipoDelDato> el) {
        if (isVacia()) {
            this.primero = el;

        } else {
            ElementoLEPA<TipoDelDato> nuevoprimero = new ElementoLEPA(this.primero, el.getDatos());
            this.primero = nuevoprimero;


        }


    }

    public void add(Partida obj) {
        ElementoLEPA<TipoDelDato> nuevoprimero = new ElementoLEPA(this.primero, obj);
        this.add(nuevoprimero);

    }



    public int del(int posicion) {
        ElementoLEPA<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }


            if (el != null && el.getSiguiente() != null) {
                ElementoLEPA<TipoDelDato> el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoLEPA<TipoDelDato> el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoLEPA<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEPA<TipoDelDato> el = this.primero;
        while (el != null && salir == false) {
            if (Objects.equals(el.getDatos().getNombre(), el2.getDatos().getNombre())) {
                salir = true;
            } else {
                el = el.getSiguiente();
                contador++;
            }

        }
        if (salir != true)
            contador=-1;
        return contador;
    }
    public void guardar(String nombre) {
        String rutaArchivo =nombre+".partidas.json";
        //hola
        guardarObjetoEnArchivo(rutaArchivo, this);
    }
    public ListaLEPA cargar(String nombre){
        String ruta=nombre+".partidas.json";
        return cargarObjetoDesdeArchivo(ruta, ListaLEPA.class);

    }

    public ElementoLEPA<TipoDelDato> getPrimero() {
        return this.primero;

    }

    public ElementoLEPA<TipoDelDato> getUltimo() {
        ElementoLEPA<TipoDelDato> el = this.primero;
        ElementoLEPA<TipoDelDato> elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoLEPA<TipoDelDato> getSiguiente(ElementoLEPA<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEPA<TipoDelDato> el = this.primero;
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

    public ElementoLEPA<TipoDelDato> getElemento(int posicion) {
        ElementoLEPA<TipoDelDato> el = this.primero;
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
