package es.uah.trabajo.juegodelavida.Clases.Grafos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLERepr;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Clases.Reproduccion;

public class CargaGrafos {
    //Montar grafos en base al tablero
    //Se montan dos grafos, uno descendente y otro ascendente, donde el nombre
    // de cada nodo
    //es la composicion de "f"(de fila) + numfila + "c" (de columna) + numcolumna
    //y el nombre de los arcos son la composicion de "Af"(arco de fila) + numfila_origen + "_" +numfila_destino+
    // "c" (de columna) + numcolumna_origen + "_" + numcolumna_destino

    //Una vez montados los dos grafos, sabiendo en que fila y columna esta el individuo
    //Y las filas y columnas en las que están los recursos
    //Se pueden buscar los caminos más cortos desde el nodo del individuo a los nodos de todos los
    //recursos en ambos grafos, y de todos, se escoge el que menor peso tenga
    //Si el individuo está en la casilla de fila=3 y col=4, por ejemplo, buscariamos el nodo con nombre=>f3c4
    //Si tenemos 3 recursos que estan en las casillas fila=2 y col=2, fila=5 y col=7 y fila=6 y col=5
    //Buscaríamos en ambos grafos los caminos más cortos desde el nodo con nombre=>f3c4 a los nodos con
    //nombres f2c2, f5c7 y f6c5, y de todos los resultados, nos quedaríamos con el de menor peso (el
    //más corto de entre los cortos (que no esté en la misma posición del individuo)


    public ListaSimple<Grafos> dameGrafos(int filasTablero, int colsTablero) {

        Grafos grafoDesc = new Grafos(new ListaSimple<NodoGrafos>(), new ListaSimple<Arcos>());
        Grafos grafoAsc = new Grafos(new ListaSimple<NodoGrafos>(), new ListaSimple<Arcos>());

        //Se rellena el Grafos descendente
        for (int i = 1; i <= filasTablero; i++) {
            for (int j = 1; j <= colsTablero; j++) {
                ListaSimple<Arcos> listaIn = new ListaSimple<Arcos>();
                ListaSimple<Arcos> listaOut = new ListaSimple<Arcos>();
                String nombreNodo = "f" + i + "c" + j;
                NodoGrafos nodo = new NodoGrafos(nombreNodo, listaIn, listaOut);
                if (!grafoDesc.buscarNodo(nodo))
                    grafoDesc.añadirNodo(nodo);
                else
                    nodo = grafoDesc.dameNodo(nodo);

                //Arcos
                if (j <= colsTablero - 1) {
                    NodoGrafos nodo1 = new NodoGrafos("f" + i + "c" + (j + 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                    //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                    if (!grafoDesc.buscarNodo(nodo1))
                        grafoDesc.añadirNodo(nodo1);
                    else
                        nodo1=grafoDesc.dameNodo(nodo1);
                    Arcos arco1 = new Arcos("Af" + i + "_" + i + "c" + j + "_" + (j + 1), nodo, nodo1, 1, "desc");
                    grafoDesc.añadirArco(arco1);
                }
                if (j > 1) {
                    NodoGrafos nodo2 = new NodoGrafos("f" + i + "c" + (j - 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                    //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                    if (!grafoDesc.buscarNodo(nodo2))
                        grafoDesc.añadirNodo(nodo2);
                    else
                        nodo2=grafoDesc.dameNodo(nodo2);
                    Arcos arco2 = new Arcos("Af" + i + "_" + i + "c" + j + "_" + (j - 1), nodo, nodo2, 1, "desc");
                    grafoDesc.añadirArco(arco2);
                }
                if (i <= filasTablero - 1) {
                    NodoGrafos nodo3 = new NodoGrafos("f" + (i + 1) + "c" + j, new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                    //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                    if (!grafoDesc.buscarNodo(nodo3))
                        grafoDesc.añadirNodo(nodo3);
                    else
                        nodo3=grafoDesc.dameNodo(nodo3);
                    Arcos arco3 = new Arcos("Af" + i + "_" + (i + 1) + "c" + j + "_" + j, nodo, nodo3, 1, "desc");
                    grafoDesc.añadirArco(arco3);

                    if (j <= colsTablero - 1) {
                        NodoGrafos nodo4 = new NodoGrafos("f" + (i + 1) + "c" + (j + 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                        //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                        if (!grafoDesc.buscarNodo(nodo4))
                            grafoDesc.añadirNodo(nodo4);
                        else
                            nodo4=grafoDesc.dameNodo(nodo4);
                        Arcos arco4 = new Arcos("Af" + i + "_" + (i + 1) + "c" + j + "_" + (j + 1), nodo, nodo4, 1, "desc");
                        grafoDesc.añadirArco(arco4);
                    }
                    if (j > 1) {
                        NodoGrafos nodo5 = new NodoGrafos("f" + (i + 1) + "c" + (j - 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                        //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                        if (!grafoDesc.buscarNodo(nodo5))
                            grafoDesc.añadirNodo(nodo5);
                        else
                            nodo5=grafoDesc.dameNodo(nodo5);
                        Arcos arco5 = new Arcos("Af" + i + "_" + (i + 1) + "c" + j + "_" + (j - 1), nodo, nodo3, 1, "desc");
                        grafoDesc.añadirArco(arco3);
                    }
                }
            }

        }
        //Se rellena el grafo ascendente
        for (int i = 1; i <= filasTablero; i++) {
            for (int j = 1; j <= colsTablero; j++) {
                ListaSimple<Arcos> listaIn = new ListaSimple<Arcos>();
                ListaSimple<Arcos> listaOut = new ListaSimple<Arcos>();
                String nombreNodo = "f" + i + "c" + j;
                NodoGrafos nodo = new NodoGrafos(nombreNodo, listaIn, listaOut);
                if (!grafoAsc.buscarNodo(nodo))
                    grafoAsc.añadirNodo(nodo);
                else
                    nodo = grafoAsc.dameNodo(nodo);

                //Arcos
                if (j <= colsTablero-1) {
                    NodoGrafos nodo1 = new NodoGrafos("f" + i + "c" + (j + 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                    //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                    if (!grafoAsc.buscarNodo(nodo1))
                        grafoAsc.añadirNodo(nodo1);
                    else
                        nodo1=grafoDesc.dameNodo(nodo1);
                    Arcos arco1 = new Arcos("Af" + i + "_" + i + "c" + j + "_" + (j + 1), nodo, nodo1, 1, "desc");
                    grafoAsc.añadirArco(arco1);
                }
                if (j > 1) {
                    NodoGrafos nodo2 = new NodoGrafos("f" + i + "c" + (j - 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                    //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                    if (!grafoAsc.buscarNodo(nodo2))
                        grafoAsc.añadirNodo(nodo2);
                    else
                        nodo2=grafoDesc.dameNodo(nodo2);
                    Arcos arco2 = new Arcos("Af" + i + "_" + i + "c" + j + "_" + (j - 1), nodo, nodo2, 1, "desc");
                    grafoAsc.añadirArco(arco2);
                }
                if (i > 1) {
                    NodoGrafos nodo3 = new NodoGrafos("f" + (i + 1) + "c" + j, new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                    //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                    if (!grafoAsc.buscarNodo(nodo3))
                        grafoAsc.añadirNodo(nodo3);
                    else
                        nodo3=grafoDesc.dameNodo(nodo3);
                    Arcos arco3 = new Arcos("Af" + i + "_" + (i + 1) + "c" + j + "_" + j, nodo, nodo3, 1, "desc");
                    grafoAsc.añadirArco(arco3);

                    if (j <= colsTablero-1) {
                        NodoGrafos nodo4 = new NodoGrafos("f" + (i + 1) + "c" + (j + 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                        //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                        if (!grafoAsc.buscarNodo(nodo4))
                            grafoAsc.añadirNodo(nodo4);
                        else
                            nodo4=grafoDesc.dameNodo(nodo4);
                        Arcos arco4 = new Arcos("Af" + i + "_" + (i + 1) + "c" + j + "_" + (j + 1), nodo, nodo4, 1, "desc");
                        grafoAsc.añadirArco(arco4);
                    }
                    if (j > 1) {
                        NodoGrafos nodo5 = new NodoGrafos("f" + (i + 1) + "c" + (j - 1), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
                        //Hay que comprobar que no se haya cargado ya este nodo nuevo en el grafo
                        if (!grafoAsc.buscarNodo(nodo5))
                            grafoAsc.añadirNodo(nodo5);
                        else
                            nodo5=grafoDesc.dameNodo(nodo5);
                        Arcos arco5 = new Arcos("Af" + i + "_" + (i + 1) + "c" + j + "_" + (j - 1), nodo, nodo3, 1, "desc");
                        grafoAsc.añadirArco(arco3);
                    }
                }
            }

        }

        ListaSimple<Grafos> listaGrafos= new ListaSimple<Grafos>();
        listaGrafos.add(grafoDesc);
        listaGrafos.add(grafoAsc);
        return listaGrafos;
    }
    public Grafos dameArbolGen(Partida partida){
        Grafos grafoArbolGen = new Grafos(new ListaSimple<NodoGrafos>(), new ListaSimple<Arcos>());
        ListaLERepr<Reproduccion> reproducciones= new ListaLERepr<>();

        NodoGrafos nodoTablero = new NodoGrafos("-1",new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
        grafoArbolGen.añadirNodo(nodoTablero);
        //En partida estarán los supervivientes si los ha habido.
        //Se genera el arbol sólo de los supervivientes
        if (partida.getIndividuos() != null && partida.getIndividuos().getNumeroElementos()>0){
            //Si no aparecen como hijos en el fichero de reproducciones
            //es que provienen de la configuración del tablero
            if (partida.getIndividuos().getElemento(0) != null) {
                reproducciones = partida.getIndividuos().getElemento(0).getDatos().getReproducciones();
                reproducciones = reproducciones.cargar();
            }
            for(int j = 0; j < partida.getIndividuos().getNumeroElementos();j++) {
                boolean encontrado=false;
                if (partida.getIndividuos().getElemento(j) != null) {
                    Invidiuos individuo = partida.getIndividuos().getElemento(j).getDatos();

                    if (reproducciones != null && reproducciones.getNumeroElementos() > 0) {
                        for (int i = 0; i < reproducciones.getNumeroElementos(); i++) {

                            if (reproducciones.getElemento(i) != null) {
                                Reproduccion reproduccion = reproducciones.getElemento(i).getDatos();
                                if (reproduccion != null && reproduccion.getIdIndividuoHijo() ==individuo.getId()) {
                                    encontrado=true;
                                    cargaNodosdeId(grafoArbolGen,reproduccion, individuo.getId());
                                }


                            }

                        }

                    }
                    if(!encontrado){
                        NodoGrafos nodoHijoDeTablero = new NodoGrafos(String.valueOf(individuo.getId()), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());


                        if (!grafoArbolGen.buscarNodo(nodoHijoDeTablero))
                            grafoArbolGen.añadirNodo(nodoHijoDeTablero);
                        else
                            nodoHijoDeTablero = grafoArbolGen.dameNodo(nodoHijoDeTablero);
                    }
                }


            }
        }
        grafoArbolGen=revisaNodosTablero(grafoArbolGen,nodoTablero);

        return grafoArbolGen;

    }
    public Grafos revisaNodosTablero(Grafos grafoArbolGen, NodoGrafos nodoTablero){

        for ( int i =0; grafoArbolGen.listavertices != null && i < grafoArbolGen.listavertices.getNumeroElementos();i++){
            NodoGrafos<String> nodo = (NodoGrafos<String>)grafoArbolGen.listavertices.getElemento(i).dato;
            if(nodo.listaLlegadaArcos == null || nodo.listaLlegadaArcos.getNumeroElementos()==0){
                Arcos arco1 = new Arcos("RAR" + nodoTablero.getDatos() + "_" + nodo.getDatos(), nodoTablero, nodo, 1, "Es_padre_De");
                grafoArbolGen.añadirArco(arco1);
            }
        }
        return grafoArbolGen;

    }
        public void cargaNodosdeId(Grafos grafoArbolGen, Reproduccion reproduccion, int id){
        if (reproduccion != null && reproduccion.getIdIndividuoHijo() == id) {
            NodoGrafos nodoIndividuoHijo = new NodoGrafos(String.valueOf(reproduccion.getIdIndividuoHijo()), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());


            if (!grafoArbolGen.buscarNodo(nodoIndividuoHijo))
                grafoArbolGen.añadirNodo(nodoIndividuoHijo);
            else
                nodoIndividuoHijo = grafoArbolGen.dameNodo(nodoIndividuoHijo);
            NodoGrafos nodoIndividuoPadre1 = new NodoGrafos(String.valueOf(reproduccion.getIdIndividuoPadre1()), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
            NodoGrafos nodoIndividuoPadre2 = new NodoGrafos(String.valueOf(reproduccion.getIdIndividuoPadre2()), new ListaSimple<Arcos>(), new ListaSimple<Arcos>());
            Arcos arco1 = new Arcos("AR" + nodoIndividuoPadre1.getDatos() + "_" + nodoIndividuoHijo.getDatos(), nodoIndividuoPadre1, nodoIndividuoHijo, 1, "Es_padre_De");
            Arcos arco2 = new Arcos("AR" + nodoIndividuoPadre2.getDatos() + "_" + nodoIndividuoHijo.getDatos(), nodoIndividuoPadre1, nodoIndividuoHijo, 1, "Es_padre_De");

            grafoArbolGen.añadirArco(arco1);
            grafoArbolGen.añadirArco(arco2);

            cargaNodosdeId(grafoArbolGen, reproduccion, Integer.parseInt(nodoIndividuoPadre1.getDatos().toString()));
            cargaNodosdeId(grafoArbolGen, reproduccion, Integer.parseInt(nodoIndividuoPadre2.getDatos().toString()));
        }
    }
}

