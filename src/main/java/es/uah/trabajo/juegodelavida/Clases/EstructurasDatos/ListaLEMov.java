package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

import es.uah.trabajo.juegodelavida.Clases.Json.gson;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;


public class ListaLEMov<TipoDelDato> extends gson {
    protected ElementoLEMov<TipoDelDato> primero;
    public void añadirMovimiento(Movimiento nuevo) {
        ListaLEMov l= new ListaLEMov();
        l=l.cargar();
        int idmovimiento=0;
        //Se obtiene el ultimo idMovimiento para ese individuo
        for (int i=0; l != null&& i < l.getNumeroElementos();i++) {
            if (l.getElemento(i).getDatos().getIdIndividuo() == nuevo.getIdIndividuo()) {
               if(l.getElemento(i).getDatos().getIdMovimiento() >= idmovimiento)
                idmovimiento=(l.getElemento(i).getDatos().getIdMovimiento())+1;
            }
        }
        l.add(nuevo,idmovimiento);
        guardar(l);
    }
    public boolean isVacia() {
        boolean vacio = false;
        if (this.primero == null) {
            vacio = true;
        }
        return vacio;
    }

    public void guardar(ListaLEMov<TipoDelDato> l){
        guardarObjetoEnArchivo("Json/movimientos.json",l);
    }
    public ListaLEMov<Movimiento> cargar(){
        return cargarObjetoDesdeArchivo("Json/movimientos.json", ListaLEMov.class);

    }
    public void vaciar() {
        this.primero = null;
    }

   private void add(ElementoLEMov<TipoDelDato> el) {
       if (isVacia()) {
           this.primero = el;

       } else {
           ElementoLEMov<TipoDelDato> nuevoprimero = new ElementoLEMov(this.primero, el.getDatos());
           this.primero = nuevoprimero;


       }


   }
      public void add(Movimiento obj) {
       obj.setIdMovimiento(this.getNumeroElementos());
          //obj.setIdMovimiento(idmovimiento);

        ElementoLEMov<TipoDelDato> nuevoprimero = new ElementoLEMov(this.primero, obj);
        this.add(nuevoprimero);

    }
    public void add(Movimiento obj,int idmovimiento) {

        obj.setIdMovimiento(idmovimiento);

        ElementoLEMov<TipoDelDato> nuevoprimero = new ElementoLEMov(this.primero, obj);
        this.add(nuevoprimero);

    }

    public void insert(Movimiento dato, int posicion,int kk) {
        ElementoLEMov<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.add(dato,0);
        } else {
            ElementoLEMov<TipoDelDato> e= new ElementoLEMov(this.getElemento(posicion),dato);
            this.getElemento(posicion-1).siguiente=e;
        }
    }

    public int del(int posicion) {
        ElementoLEMov<TipoDelDato> el = this.primero;
        if (posicion == 0) {
            this.primero = el.getSiguiente();
        } else {
            int contador = 0;
            while (el != null && contador < posicion - 1) {
                el = el.getSiguiente();
                contador++;
            }


            if (el != null && el.getSiguiente() != null) {
                ElementoLEMov<TipoDelDato> el2 = el.getSiguiente();
                el.siguiente = el2.getSiguiente();
            }

        }

        return posicion;

    }

    public int getNumeroElementos() {
        int contador = 0;
        ElementoLEMov<TipoDelDato> el = this.primero;
        while (el != null) {
            contador++;
            el=el.getSiguiente();
        }

        return contador;
    }

    public int getPosicion(ElementoLEMov<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEMov<TipoDelDato> el = this.primero;
        while (el != null && salir == false) {
            if (el.getDatos().getIdIndividuo() == el2.getDatos().getIdIndividuo() &&
                    el.getDatos().getIdMovimiento() == el2.getDatos().getIdMovimiento()) {
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

    public ElementoLEMov<TipoDelDato> getPrimero() {
        return this.primero;

    }

    public ElementoLEMov<TipoDelDato> getUltimo() {
        ElementoLEMov<TipoDelDato> el = this.primero;
        ElementoLEMov<TipoDelDato> elanterior = null;
        while (el != null) {
            elanterior = el;
            el = el.getSiguiente();
        }
        return elanterior;

    }

    public ElementoLEMov<TipoDelDato> getSiguiente(ElementoLEMov<TipoDelDato> el2) {
        int contador = 0;
        boolean salir = false;
        ElementoLEMov<TipoDelDato> el = this.primero;
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

    public ElementoLEMov<TipoDelDato> getElemento(int posicion) {
        ElementoLEMov<TipoDelDato> el = this.primero;
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
