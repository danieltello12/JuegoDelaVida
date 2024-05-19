package es.uah.trabajo.juegodelavida.Grafos;

import java.util.ArrayList;

public class Grafos<T> {
    protected ListaSimple<NodoGrafos> listavertices;
    protected ListaSimple<Arcos> listaristas;

    public void añadirNodo(NodoGrafos nodo){
        listavertices.add(nodo);
    }

    public Grafos(ListaSimple<NodoGrafos> listavertices,ListaSimple<Arcos> listaristas) {
        this.listavertices = listavertices;
        this.listaristas = listaristas;
    }

    public void añadirArco(Arcos arco){
        if(arco.origen!=null&&arco.destino!=null) {
            NodoGrafos n = arco.origen;
            NodoGrafos n1 = arco.destino;
            n1.listaLlegadaArcos.add(arco);
           // actualizarNodo(n1);
            n.listaSalidaArcos.add(arco);
          //  actualizarNodo(n);
            listaristas.add(arco);
        }
    }
    public void actualizarNodo(NodoGrafos n){
        for (int i=0;listavertices!=null && i<listavertices.getNumeroElementos();i++){
            NodoGrafos nodoBusq= (NodoGrafos) listavertices.getElemento(i).dato;
            if( nodoBusq.datos.equals(n.datos)){
                listavertices.getElemento(i).dato=n;
            }
        }

    }

    public boolean buscarNodo(NodoGrafos nodo){
        boolean ret=false;
        for (int i=0;listavertices!=null && i<listavertices.getNumeroElementos();i++){
            NodoGrafos nodoBusq= (NodoGrafos) listavertices.getElemento(i).dato;
           if( nodoBusq.datos.equals(nodo.datos)){
               ret=true;
           }
        }
        return ret;
    }
    public NodoGrafos dameNodo(NodoGrafos nodo){
        NodoGrafos ret=null;
        for (int i=0;listavertices!=null && i<listavertices.getNumeroElementos();i++){
            NodoGrafos nodoBusq= (NodoGrafos) listavertices.getElemento(i).dato;
            if( nodoBusq.datos.equals(nodo.datos)){
                ret=nodoBusq;
            }
        }
        return ret;
    }
    public boolean buscarArco(Arcos arco){
        boolean ret=false;
        for (int i=0;listaristas!=null && i<listaristas.getNumeroElementos();i++){
            Arcos arcoBusq= (Arcos) listavertices.getElemento(i).dato;
            if( arcoBusq.nombre.equals(arco.nombre)){

                ret=true;
            }
        }
        return ret;
    }

    public void BorrarNodoEstricto(NodoGrafos nodo){
        ElementoLS nododatos=new ElementoLS(nodo);
        if(nodo.listaLlegadaArcos.isVacia()&&nodo.listaSalidaArcos.isVacia()){
            int r=listavertices.getPosicion(nododatos);
            listavertices.del(r);

        }
        

    }

    public void BorrarArco(Arcos arco){
        NodoGrafos n2=arco.destino;
        NodoGrafos n1=arco.origen;
        ElementoLS arcodatos=new ElementoLS(arco);
        if(arco.origen!=null&&arco.destino!=null){
            int r=listaristas.getPosicion(arcodatos);
            int s=n1.listaSalidaArcos.getPosicion(arcodatos);
            int m=n2.listaLlegadaArcos.getPosicion(arcodatos);
            listaristas.del(r);
            n1.listaSalidaArcos.del(s);
            n2.listaLlegadaArcos.del(m);
        }

    }



    /**
     * Cálculo del algoritmo de Dijkstra: dado un vértice por parámetro, calcula los caminos mínimos al resto, si es posible.
     *
     * Un mapa es un conjunto de elementos que son pares K,v (Key,Value). Son similares a las listas con identificador de elemento.
     * Es un tipo de datos estándar de java, de la biblioteca Collection, y no debéis usarlos en la asignatura.
     *
     * @param origen
     * @return
     */
    public Cola<Camino<T>> dijkstra(NodoGrafos<T> origen) {

        //Preparamos las variables.
        Cola<Double> distancias = new Cola<Double>();   // Creamos la cola de distancias.
        Cola<NodoGrafos<T>> colaPendientes = new Cola<NodoGrafos<T>>();  // Creamos la cola de pendientes.
        Cola<NodoGrafos<T>>  colaVerticesAnteriores = new Cola<NodoGrafos<T>>(); //Creamos la cola de verticesAnteriores.

        this.dijkstra_init(origen,distancias,colaPendientes,colaVerticesAnteriores);  //Inicialización
        this.dijkstra_calcula(distancias,colaPendientes,colaVerticesAnteriores);      //Cálculo
        return this.dijkstra_procesaResultados(distancias,colaVerticesAnteriores,origen);    //Procesamiento de resultados
    }

    public ElementoLDE<Camino<String>> dameCaminoA(NodoGrafos nodoDestino, Cola<Camino<String>> caminos){
        ElementoLDE<Camino<String>> ret=null;
        for(int i =0; caminos != null && i < caminos.getNumeroElem(); i++){
            ElementoLDE<Camino<String>> elemento = caminos.getElemento(i);
            ListaSimple<NodoGrafos<String>> caminoHastaE = elemento.getDatos().getCamino();
            if (caminoHastaE.getElemento(caminoHastaE.getNumeroElementos()-1).getDato()==nodoDestino){
                ret= elemento;
            }
        }
        return ret;
    }
    /**
     * Inicializa las variables de distancias del grafo, la cola de vertices pendientes de procesar, y la lista de vértices anteriores al calculado.
     * @param origen
     * @param distancias
     * @param colaPendientes
     * @param verticesAnteriores
     */
    protected void dijkstra_init(NodoGrafos<T> origen, Cola<Double> distancias, Cola<NodoGrafos<T>> colaPendientes, Cola<NodoGrafos<T>> verticesAnteriores){
        for (int i =0; i <listavertices.getNumeroElementos();i++){
            NodoGrafos<T> nodo = (NodoGrafos<T>)listavertices.getElemento(i).dato;
            distancias.encolar(new ElementoLDE(Double.MAX_VALUE));
            //¿nodo en lugar de origen?
            verticesAnteriores.encolar(new ElementoLDE((NodoGrafos<T>)origen));
        }
        int posicionOrigen = listavertices.getPosicion(new ElementoLS(origen));
        distancias.machacar(new ElementoLDE(0.0),posicionOrigen);
        colaPendientes.encolar(new ElementoLDE(origen));
    }

    /**
     * Realiza el cálculo de dijkstra, calculando tanto las distancias como los
     * anteriores vértices que llegan a uno determinado.
     * @param distancias
     * @param colaPendientes
     * @param verticesAnteriores
     */
    protected void dijkstra_calcula(Cola<Double> distancias, Cola<NodoGrafos<T>> colaPendientes, Cola<NodoGrafos<T>> verticesAnteriores){
        while (!colaPendientes.esVacía()) {
            ElementoLDE<NodoGrafos<T>> elementoActual = colaPendientes.desencolar();  // Sacamos un vértice de la cola
            NodoGrafos<T> verticeActual = elementoActual.datos;
            for(int i = 0; i < verticeActual.listaSalidaArcos.getNumeroElementos();i++){
                Arcos<T> arco = (Arcos<T>)verticeActual.listaSalidaArcos.getElemento(i).dato;
                NodoGrafos<T> verticeVecino = arco.destino;
                int posicionOrigen = listavertices.getPosicion(new ElementoLS(verticeActual));
                ElementoLDE<Double> distancia= distancias.getElemento(posicionOrigen);

                double nuevoCalculoDeDistancia = distancia.datos + arco.peso;
                int posicionVecino = listavertices.getPosicion(new ElementoLS(verticeVecino));
                ElementoLDE<Double> distanciaVecinoLDE= distancias.getElemento(posicionVecino);
                double distanciaVecino = distanciaVecinoLDE.datos;

                if (nuevoCalculoDeDistancia < distanciaVecino) {  // Si resulta que la nueva distancia es mejor que la que se había calculado antes a ese vértice, sustituimos los valores por los nuevos.
                    distancias.machacar( new ElementoLDE(nuevoCalculoDeDistancia),posicionVecino);  // Guardamos la nueva distancia.

                    int posVantVecino = verticesAnteriores.getPOS(new ElementoLDE(verticeVecino) );
                    int posVantActual = verticesAnteriores.getPOS(new ElementoLDE(verticeActual) );
                    verticesAnteriores.machacar(new ElementoLDE(verticeActual), posicionVecino);
                    colaPendientes.encolar(new ElementoLDE(verticeVecino));                       // Añadimos el nuevo vértice a la cola de procesamiento, para en el futuro explorar sus salidas....
                }
            }
        }
    }

    /**
     * Cuando el cálculo ya ha acabado, toda la información queda en las variables por parámetros, pero hay que
     * procesar los resultados para generar algo que sea manejable.
     * El objetivo es generar un mapa o lista en la cuál para cada vértice se guarde el camino desde el origen hasta él
     * y el coste de ese camino completo.
     *
     *
     */
   /* protected Cola<Camino<T>> dijkstra_procesaResultados( Cola<Double> distancias , Cola<NodoGrafos<T>> verticesAnteriores){
        Cola<Camino<T>> caminos = new Cola<Camino<T>>();

        //for (NodoGrafos<T> verticeDestino : verticesAnteriores.keySet()) {
        for(int i = 0; i < verticesAnteriores.getNumeroElem();i++){    //de todos los vértices calculados
            ListaSimple<NodoGrafos<T>> caminoCalculado = new ListaSimple<NodoGrafos<T>>();
            NodoGrafos<T> verticeDestino = (NodoGrafos<T>)verticesAnteriores.getElemento(i).datos;
            // prepara un camino para cada uno
            NodoGrafos<T> v = verticeDestino;                                          // y en un bucle recorre el camino
            while (v != null) {                                                     // hacia atrás.
                caminoCalculado.add(v);
                v =  (NodoGrafos<T>)verticesAnteriores.getElemento(verticesAnteriores.getPOS(new ElementoLDE(v))).siguiente.datos;
               //El bucle es sobre v, o sea, los vértices: actualizo hasta que no tenga un origen (primero)
            }
            //Collections.reverse(caminoCalculado);  //Le damos la vuelta, para que el camino empiece en el origen, no en el último.
            ElementoLDE<Double> nuevaDist = distancias.getElemento(i);
            Camino<T> camino = new Camino<T>(caminoCalculado, nuevaDist.datos);
            ElementoLDE<Camino<T>> elementoCamino= new ElementoLDE<Camino<T>>(camino);
            caminos.machacar( elementoCamino,i);
        }
        return caminos;
    }*/
    protected Cola<Camino<T>> dijkstra_procesaResultados( Cola<Double> distancias , Cola<NodoGrafos<T>> verticesAnteriores,NodoGrafos<T> origen) {
        Cola<Camino<T>> caminos = new Cola<Camino<T>>();
        /*int posOrig = listavertices.getPosicion(new ElementoLS(origen));

        ListaSimple<NodoGrafos<T>> caminoPost = new ListaSimple<NodoGrafos<T>>();
        for (int i = posOrig; i < verticesAnteriores.getNumeroElem(); i++) {

            caminoPost.add(verticesAnteriores.getElemento(i));

        }
        if (posOrig != 0){
            for (int i = 0; i < posOrig; i++) {
                caminoPost.add(verticesAnteriores.getElemento(i));
            }
        }*/
        //for (NodoGrafos<T> verticeDestino : verticesAnteriores.keySet()) {
        for(int i = 0; i < verticesAnteriores.getNumeroElem();i++){    //de todos los vértices calculados
            ListaSimple<NodoGrafos<T>> caminoCalculado = new ListaSimple<NodoGrafos<T>>();
            NodoGrafos<T> verticeDestino = (NodoGrafos<T>)listavertices.getElemento(i).dato;
            caminoCalculado.add(verticeDestino);

            NodoGrafos<T> verticePrevio = (NodoGrafos<T>)verticesAnteriores.getElemento(i).datos;
            // prepara un camino para cada uno

            NodoGrafos<T> v = verticePrevio;                                          // y en un bucle recorre el camino
            while (v != null) {                                                     // hacia atrás.
                caminoCalculado.add(v);
                int posV = listavertices.getPosicion((new ElementoLS(v)));
                if ( v!=origen)
                    v =  (NodoGrafos<T>)verticesAnteriores.getElemento(posV).datos;
                else
                    v=null;
                //El bucle es sobre v, o sea, los vértices: actualizo hasta que no tenga un origen (primero)
            }

            int posElemento = listavertices.getPosicion(new ElementoLS<>(verticeDestino));
            ElementoLDE<Double> nuevaDist = distancias.getElemento(posElemento);


            ArrayList<ElementoLS<T>> invertir= new ArrayList<ElementoLS<T>>();
            for(int k=caminoCalculado.getNumeroElementos()-1; k >= 0; k --) {
                invertir.add((ElementoLS<T>) caminoCalculado.getElemento(k));
            }//
            ListaSimple<NodoGrafos<T>> caminoCalculadoInvertido = new ListaSimple<NodoGrafos<T>>();
            for(int h=0; h < invertir.size(); h++) {
                ElementoLS<T> elementoInvertido = (ElementoLS<T>)invertir.get(h);
                 caminoCalculadoInvertido.add(elementoInvertido.dato);

            }
            Camino<T> camino = new Camino<T>(caminoCalculadoInvertido, nuevaDist.datos);
            caminos.encolar(new ElementoLDE(camino));

        }
        return caminos;
    }
}

