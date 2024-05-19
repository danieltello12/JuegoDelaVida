package es.uah.trabajo.juegodelavida.Grafos;

public class Cola<T> {
    private ElementoLDE cabecera;
    private ElementoLDE cola;
    private int longitud;
    private ElementoLDE siguiente;
    public Cola(){
        cabecera=cola=null;
        longitud=0;
    }

    public boolean esVacía(){
        return cabecera==null;
    }

    public ElementoLDE encolar(ElementoLDE<T> ob){
        ElementoLDE n=new ElementoLDE(ob.getDatos());
        if (longitud==0){
            cola=cabecera=n; //Para que en el setSiguiente no de null
            longitud++;
        }else{
            n.siguiente=cola;
            cola.anterior=n;
            cola=n;
            longitud++;
        }

        return cola;
    }
    public ElementoLDE desencolar() {
        ElementoLDE elementoDesencolado=null;
        if (this.cabecera!=null) {
            elementoDesencolado = cabecera;
        }
        if (longitud == 0) {
            cabecera=cola=null;
        }else if (longitud == 1) {
            cabecera = cola = null;
            longitud--;
        } else {
            cabecera = cabecera.anterior;
            cabecera.siguiente = null;
            longitud--;
        }


        return elementoDesencolado;
    }





    public ElementoLDE getCabecera(){

        return this.cabecera;
    }

    public ElementoLDE getCola(){

        return this.cola;
    }

    public ElementoLDE getElemento(int posicion){
        int pos = 0;
        ElementoLDE obj = this.cola;
        while (pos<posicion) {
            obj = obj.siguiente;
            pos++;
        }
        return obj;

    }
    public void machacar(ElementoLDE elemento,int posicion){
        int pos = 0;
        ElementoLDE obj = this.cola;
        while (pos<posicion) {
            obj = obj.siguiente;
            pos++;
        }
        obj.datos=elemento.datos;
    }
    public int getNumeroElem(){
        int elem=0;
        ElementoLDE el = this.cola;
        while (el!=null){
            el=el.siguiente;
            elem++;
        }
        return elem;
    }
    public int getPOS(ElementoLDE el) {
        int contador = -1;
        boolean encontrado =false;
        boolean salir = false;
        if (!this.esVacía()){
            ElementoLDE el2 = this.cola;
            while (el2 != null && el != null && encontrado == false) {

                if (el2.getDatos() == el.getDatos()) {
                    encontrado = true;
                    contador++;
                } else {
                    el2 = el2.siguiente;
                    contador++;
                }

            }
        }
        if (encontrado != true)
            contador = -1;
        return contador;
    }


}
