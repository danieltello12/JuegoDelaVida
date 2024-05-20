package es.uah.trabajo.juegodelavida.Clases.Grafos;

public class Main {
    public static void main(String[] args) {
        ListaSimple l1= new ListaSimple();
        ListaSimple l2= new ListaSimple();
        ListaSimple l3= new ListaSimple();
        ListaSimple l4= new ListaSimple();
        ListaSimple l5= new ListaSimple();
        ListaSimple l6= new ListaSimple();
        ListaSimple l7= new ListaSimple();
        ListaSimple l8= new ListaSimple();
        ListaSimple l9= new ListaSimple();
        ListaSimple l10= new ListaSimple();
        ListaSimple l11= new ListaSimple();
        ListaSimple l12= new ListaSimple();
        NodoGrafos n1=new NodoGrafos("A",l1,l2);
        NodoGrafos n2=new NodoGrafos("B",l3,l4);
        NodoGrafos n3=new NodoGrafos("C",l5,l6);
        NodoGrafos n4=new NodoGrafos("D",l7,l8);
        NodoGrafos n5=new NodoGrafos("E",l9,l10);
        NodoGrafos n6=new NodoGrafos("F",l11,l12);
        Arcos a1=new Arcos("",n1,n2,11,"d");
        Arcos a2=new Arcos("",n1,n3,4,"d");
        Arcos a3=new Arcos("",n2,n4,7,"d");
        Arcos a4=new Arcos("",n4,n5,-2,"d");
        Arcos a5=new Arcos("",n3,n2,6,"d");
        Arcos a6=new Arcos("",n5,n3,1,"d");
        ListaSimple lv= new ListaSimple();
        ListaSimple la= new ListaSimple();
        Grafos grafo=new Grafos(lv,la);
        grafo.añadirNodo(n1);
        grafo.añadirNodo(n2);
        grafo.añadirNodo(n3);
        grafo.añadirNodo(n4);
        grafo.añadirNodo(n5);
        grafo.añadirNodo(n6);
        grafo.añadirArco(a1);
        grafo.añadirArco(a2);
        grafo.añadirArco(a3);
        grafo.añadirArco(a4);
        grafo.añadirArco(a5);
        grafo.añadirArco(a6);
        //System.out.println(grafo.buscarNodo(n1));
        //System.out.println(grafo.buscarNodo(n2));
        /*Cola c1=new Cola();
        ElementoLDE e1=new ElementoLDE<>(3);
        ElementoLDE e2=new ElementoLDE<>(4);
        ElementoLDE e3=new ElementoLDE<>(5);
        ElementoLDE e4=new ElementoLDE<>(6);
        c1.encolar(e1);
        c1.encolar(e2);
        c1.encolar(e3);
        c1.machacar(e4,2);
      */

        // Ahora hacemos el cálculo de caminos desde un vértice a todos los demás:
        NodoGrafos nodoOrigen = n1;
        Cola<Camino<String>> caminos = grafo.dijkstra(nodoOrigen); //Todos los caminos desde v1 ("A")

        // Vamos a sacar por pantalla todos los caminos, para poder estar seguros.
        mostrar_todos_los_caminos(caminos);


        // Si queremos sacar un camino en concreto, podemos, ya que lo tenemos calculado de antes:
        NodoGrafos nodoFinal = n5;
        int pos= caminos.getPOS(new ElementoLDE(nodoFinal));
        ElementoLDE <Camino<String>> elemento = caminos.getElemento(pos);
        ListaSimple<NodoGrafos<String>> caminoHastaE = elemento.getDatos().getCamino();  // Camino desde v1 a v8 ("A" hasta "H")

        System.out.println("CAMINO MÁS CORTO DESDE NODO  "+nodoOrigen.datos +" HASTA  NODO  " + nodoFinal.datos + " : ");
        for(int i = 0; i < caminoHastaE.getNumeroElementos();i++){

            NodoGrafos<String> vertice = (NodoGrafos<String>)caminoHastaE.getElemento(i).getDato();
            System.out.println(vertice.datos);
        }

        System.out.println("COSTE DE CAMINO MÁS CORTO DESDE NODO  "+nodoOrigen.datos +" HASTA  NODO  " + nodoFinal.datos + " : " + elemento.datos.coste);

    }
    private static void mostrar_todos_los_caminos(Cola<Camino<String>> todosloscaminos){
        //for (Camino c : todosloscaminos.values()){
        for(int i = todosloscaminos.getNumeroElem() -1 ; i >= 0 ;i--){
            ElementoLDE<Camino<String>> mielemento = todosloscaminos.getElemento(i);

            Camino<String> c = mielemento.datos;
            System.out.println(c.toString());
        }

    }


}
