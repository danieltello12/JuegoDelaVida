package es.uah.trabajo.juegodelavida.Clases.Grafos;

/**
 * La clase camino guarda un camino desde un vértice a otro del grafo, junto su coste.
 *
 * @param <T>
 */
public class Camino<T> {
    ListaSimple<NodoGrafos<T>> camino;
    double coste;

    public Camino(ListaSimple<NodoGrafos<T>> camino, double coste) {
        this.camino = camino;
        this.coste = coste;
    }

    public ListaSimple<NodoGrafos<T>> getCamino() {
        return camino;
    }

    public double getCoste() {
        return coste;
    }

    @Override
    public String toString() {
        StringBuffer salida = new StringBuffer();
        salida.append("##CAMINO DESDE [" + getCamino().getPrimero().dato + "] HASTA [" + (NodoGrafos<T>)getCamino().getUltimo().dato + "]:##\n");
        //salida.append("VERTICES: " + this.getCamino().lista + "\n");
        salida.append("DATOS EN VERTICES: [");
        for (int i =0; i <this.getCamino().getNumeroElementos();i++){
            NodoGrafos<T> nodo = (NodoGrafos<T>)this.getCamino().getElemento(i).getDato();
            salida.append(nodo.datos);

        }


        salida.append("] - CON COSTE: " + this.getCoste() + "\n");
        if (this.getCoste() == Double.MAX_VALUE){
            salida.append("@@@@ ESTE CAMINO NO HA SIDO VISITADO EN EL RECORRIDO SOLICITADO DEL ARBOL\n");
        }

        return salida.toString();
    }

    public String formatearArbol() {
        StringBuffer salida = new StringBuffer();
        NodoGrafos<String> nodoPadre =  (NodoGrafos<String>)getCamino().getPrimero().getDato();
        NodoGrafos<String> nodoHijo =  (NodoGrafos<String>)getCamino().getUltimo().getDato();
        salida.append("\nARBOL GENEALÓGICO DE VENCEDOR NODO ID(");
        salida.append(nodoHijo.datos);
        salida.append(")\n");
        salida.append("Tablero\n");
        for(int i =0; this.getCamino() != null && i <this.getCamino().getNumeroElementos();i++){

            if(i == 0)
                continue;
            else if (this.getCamino().getElemento(i) != null){

                int j=0;
                while(j<i) {
                    salida.append("\t");
                    j++;
                }
                salida.append("|");
                salida.append("--");
                salida.append("ES PADRE DE");
                salida.append("-->NODO ID(");
                NodoGrafos<String> nodoActual=(NodoGrafos<String>)this.getCamino().getElemento(i).getDato();
                salida.append(nodoActual.datos);
                salida.append(")\n");
            }


        }

        return salida.toString();
    }
}