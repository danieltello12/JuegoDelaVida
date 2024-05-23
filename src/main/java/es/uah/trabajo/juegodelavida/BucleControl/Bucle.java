package es.uah.trabajo.juegodelavida.BucleControl;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.*;
import es.uah.trabajo.juegodelavida.Clases.Grafos.Cola;
import es.uah.trabajo.juegodelavida.Clases.Grafos.ElementoLDE;
import es.uah.trabajo.juegodelavida.Clases.Grafos.*;
import es.uah.trabajo.juegodelavida.Clases.Historico;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Clases.Reproduccion;

import java.util.Objects;
import java.util.Random;

public class Bucle {
    Partida partida;
    ListaRecursos listaRecursos;
    ListaELementos listaIndividuos;
    int paso=0;
public Bucle (){

}

    public  Bucle (Partida partida){

        this.partida = partida;
        listaRecursos = duplicaRecursos(partida.getRecursos());
        listaIndividuos= duplicaIndividuos(partida.getIndividuos());
    }

    public void ejecutarMovimiento(int paso){
        this.paso=paso;
        /*
        1. Para cada individuo, se actualiza su tiempo de vida, y en su caso se elimina si ha muerto.
        */
        actualizarTvidaI(partida.getIndividuos());

        /*2. Para cada recurso, evaluará si sigue activo o debe eliminarse (por su tiempo de aparición).*/
        actualizarExistenciaR(partida.getRecursos());

        /*3. Se ejecutará el movimiento de cada individuo (siempre obligatorio).*/
        ejecutarMovimientoI(partida);

        /*4. Para cada individuo evaluará las mejoras obtenidas por los distintos recursos que se
        encuentren en su nueva posición.*/
        evaluarMejorasIR(partida.getIndividuos(), partida.getRecursos());

        /*5. Para cada posición, evaluará si existe reproducción o no.*/
        verreproduccion(partida,paso);
        /*6. Para cada individuo, evaluará si existe clonación o no.*/
        verClon(partida);

        /*7. Para cada posición del tablero en la que existan varios individuos, se evaluará si deben
        desaparecer algunos.*/
        actualizarExistenciaI(partida.getIndividuos());

        /*8. Para cada posición del tablero, se evaluará si deben aparecer nuevos recursos
         */
        nuevosrecursos(partida);
        limpiarRec(partida);

    }



    private void actualizarExistenciaI(ListaELementos individuos) {

        boolean continuar=true;
        int numTurnos=Integer.MAX_VALUE;

        for(int f=1; f <= partida.getFilas();f++) {
            for(int c=1; c <= partida.getColumnas();c++){
                int contador =0;
                for (int i = 0; i < partida.getIndividuos().getNumeroElementos(); i++) {
                    if (partida.getIndividuos().getElemento(i).getDatos() != null &&
                            c == partida.getIndividuos().getElemento(i).getDatos().getY() &&
                            f == partida.getIndividuos().getElemento(i).getDatos().getX()) {
                        contador++;


                    }

                }
                while (contador > 3){
                    int pos=-1;
                    for (int i = 0; i < partida.getIndividuos().getNumeroElementos(); i++) {
                        if (partida.getIndividuos().getElemento(i).getDatos() != null &&
                                c == partida.getIndividuos().getElemento(i).getDatos().getY() &&
                                f == partida.getIndividuos().getElemento(i).getDatos().getX()) {
                            if (partida.getIndividuos().getElemento(i).getDatos().getTurnosvida() < numTurnos) {
                                pos=i;
                                numTurnos = partida.getIndividuos().getElemento(i).getDatos().getTurnosvida();
                            }
                        }
                    }
                    if(pos >= 0) {
                        partida.getAcciones().encolar(new ElementoLDE<>("Individuoos: "+ partida.getIndividuos().getElemento(pos).getDatos().getId()+
                                " ha sido eliminado"));
                        partida.getIndividuos().del(pos);
                        contador--;
                        numTurnos=Integer.MAX_VALUE;
                        pos=-1;
                    }


                }
            }
        }

    }

    private void evaluarMejorasIR(ListaELementos individuos, ListaRecursos recursos) {
        /*Posibles mejoras según recurso
                          <String fx:value="+Turnos vida" />
                          <String fx:value="-Turnos vida" />
                          <String fx:value="+Probab Clon " />
                          <String fx:value="+Probab Repro" />
                          <String fx:value="Muerte Inst" />
                          ck->Subida de tipo de individuo

         */

        for (int i=0; i< partida.getIndividuos().getNumeroElementos();i++) {
            if (partida.getIndividuos().getElemento(i) != null) {
                Invidiuos individuoGen = (partida.getIndividuos().getElemento(i).getDatos());
                ListaRecursos listarec = partida.getRecursos();
                ListaRecursos listarecLR = new ListaRecursos();
                for (int j=0; j< listarec.getNumeroElementos();j++) {
                    if (listarec.getElemento(j) != null )

                        if ( listarec.getElemento(j).getDatos().getY() == individuoGen.getY() &&
                                listarec.getElemento(j).getDatos().getX() == individuoGen.getX()) {

                            listarecLR.add(listarec.getElemento(j).getDatos());
                        }
                }
                boolean eliminado=false;
                for (int j=0; j< listarecLR.getNumeroElementos() && !eliminado;j++) {
                    Recursos recurso = listarecLR.getElemento(j).getDatos();
                    if (recurso.getTipo().equals("A")) {
                        if (recurso.getCbAgua()!=null && recurso.getCbAgua().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModAgua());
                        }
                        if (recurso.getCbAgua()!=null && recurso.getCbAgua().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModAgua());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;


                            }
                        }
                        if (recurso.getCbAgua()!=null && recurso.getCbAgua().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModAgua() / 100));
                        }
                        if (recurso.getCbAgua()!=null && recurso.getCbAgua().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModAgua() / 100));
                        }
                        if (recurso.isCkAgua()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbAgua()!=null && recurso.getCbAgua().equals("Muerte Inst")) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("C") ){


                        if (recurso.getCbComida()!=null && recurso.getCbComida().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModComida());
                        }
                        if (recurso.getCbComida()!=null && recurso.getCbComida().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModComida());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbComida()!=null && recurso.getCbComida().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModComida() / 100));
                        }
                        if (recurso.getCbComida()!=null && recurso.getCbComida().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModComida() / 100));
                        }
                        if (recurso.isCkComida()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbComida()!=null && recurso.getCbComida().equals("Muerte Inst")) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("M")) {
                        if (recurso.getCbMontana()!=null && recurso.getCbMontana().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModMontana());
                        }
                        if (recurso.getCbMontana()!=null && recurso.getCbMontana().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModMontana());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbMontana()!=null && recurso.getCbMontana().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModMontana() / 100));
                        }
                        if (recurso.getCbMontana()!=null && recurso.getCbMontana().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModMontana() / 100));
                        }
                        if (recurso.isCkMontana()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbMontana()!=null && recurso.getCbMontana().equals("Muerte Inst")) {

                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("T")) {
                        if (recurso.getCbTesoro()!=null && recurso.getCbTesoro().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModTesoro());
                        }
                        if (recurso.getCbTesoro()!=null && recurso.getCbTesoro().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModTesoro());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbTesoro()!=null && recurso.getCbTesoro().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModTesoro() / 100));
                        }
                        if (recurso.getCbTesoro()!=null && recurso.getCbTesoro().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModTesoro() / 100));
                        }
                        if (recurso.isCkTesoro()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbTesoro()!=null && recurso.getCbTesoro().equals("Muerte Inst")) {
                            eliminado=true;

                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("B")) {

                        if (recurso.getCbBiblio()!=null && recurso.getCbBiblio().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModBiblio());
                        }
                        if (recurso.getCbBiblio()!=null && recurso.getCbBiblio().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModBiblio());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbBiblio()!=null && recurso.getCbBiblio().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModBiblio() / 100));
                        }
                        if (recurso.getCbBiblio()!=null && recurso.getCbBiblio().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModBiblio() / 100));
                        }
                        if (recurso.getCbBiblio()!=null && recurso.isCkBiblio()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbBiblio()!=null && recurso.getCbBiblio().equals("Muerte Inst")) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("P")) {
                        if (recurso.getCbPozo()!=null && recurso.getCbPozo().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModPozo());
                        }
                        if (recurso.getCbPozo()!=null && recurso.getCbPozo().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModPozo());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;
                            }
                        }
                        if (recurso.getCbPozo()!=null && recurso.getCbPozo().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModPozo() / 100));
                        }
                        if (recurso.getCbPozo()!=null && recurso.getCbPozo().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModPozo() / 100));
                        }
                        if (recurso.isCkPozo()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbPozo()!=null && recurso.getCbPozo().equals("Muerte Inst")&&!eliminado) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }


                }
            }
        }
    }
    private void ejecutarMovimientoI(Partida partida) {
        for (int i=0; i< partida.getIndividuos().getNumeroElementos();i++) {
            if (partida.getIndividuos().getElemento(i) != null ) {
                Invidiuos individuoGen = (partida.getIndividuos().getElemento(i).getDatos());

                switch (individuoGen.getTipo()){
                    case "Básico":
                        ejecutarMovimientoIBasico(individuoGen, partida);
                        break;
                    case "Normal":
                        ejecutarMovimientoINormal(individuoGen, partida);
                        break;
                    case "Avanzado":
                        ejecutarMovimientoIAvanzado(individuoGen,partida);
                        break;
                    default:
                        ejecutarMovimientoIBasico(individuoGen, partida);

                }



            }

        }
    }

    private void ejecutarMovimientoIAvanzado(Invidiuos individuoGen, Partida partida) {

        CargaGrafos cargaGrafos = new CargaGrafos();
        ListaSimple<Grafos> listaG = cargaGrafos.dameGrafos(partida.getFilas(),partida.getColumnas());
        //Buscamos el nodo correspondiente a la posicion del individuo
        Grafos grafoDesc= (Grafos)listaG.getElemento(0).getDato();
        Grafos grafoAsc= (Grafos)listaG.getElemento(0).getDato();
        NodoGrafos nodoIndividuo = new NodoGrafos("f"+individuoGen.getX()+"c"+individuoGen.getY(), null, null);
        if (grafoDesc.buscarNodo(nodoIndividuo))
            nodoIndividuo = grafoDesc.dameNodo(nodoIndividuo);

        Cola<Camino<String>> caminosDesc = grafoDesc.dijkstra(nodoIndividuo);


        // Si queremos sacar el peso de un camino en concreto, podemos, ya que lo tenemos calculado de antes:
        //Calculamos el coste de ir a cada recurso y nos vamos al de menor coste
        double coste = Double.MAX_VALUE;
        ListaRecursos listarec = partida.getRecursos();
        int recursoElegido=-1;
        for (int i=0; i< listarec.getNumeroElementos();i++) {
            if (listarec.getElemento(i) != null) {
                NodoGrafos nodoFinal = new NodoGrafos("f" + listarec.getElemento(i).getDatos().getX() + "c" + listarec.getElemento(i).getDatos().getY(), null, null);
                if (grafoDesc.buscarNodo(nodoFinal))
                    nodoFinal = grafoDesc.dameNodo(nodoFinal);
                ElementoLDE<Camino<String>> caminoLDE = grafoDesc.dameCaminoA(nodoFinal, caminosDesc);
                if (caminoLDE != null && caminoLDE.getDatos() != null) {
                    double costeRec = caminoLDE.getDatos().getCoste();
                    if (costeRec < coste && costeRec != 0) {
                        coste = costeRec;
                        recursoElegido = i;
                    }
                }
            }
        }



        if (grafoAsc.buscarNodo(nodoIndividuo))
            nodoIndividuo = grafoDesc.dameNodo(nodoIndividuo);
        Cola<Camino<String>> caminosAsc = grafoAsc.dijkstra(nodoIndividuo);
        for (int i=0; i< listarec.getNumeroElementos();i++) {
            if (listarec.getElemento(i) != null) {
                NodoGrafos nodoFinal = new NodoGrafos("f" + listarec.getElemento(i).getDatos().getX() + "c" + listarec.getElemento(i).getDatos().getY(), null, null);
                if (grafoAsc.buscarNodo(nodoFinal))
                    nodoFinal = grafoAsc.dameNodo(nodoFinal);
                ElementoLDE<Camino<String>> caminoLDE = grafoDesc.dameCaminoA(nodoFinal, caminosAsc);
                if (caminoLDE != null && caminoLDE.getDatos() != null) {

                    double costeRec = caminoLDE.getDatos().getCoste();
                    if (costeRec < coste && costeRec != 0) {
                        coste = costeRec;
                        recursoElegido = i;
                }
            }
        }
            if(recursoElegido==-1){
                recursoElegido=0;
            }
        if ( coste < Double.MAX_VALUE && recursoElegido >= 0)
            individuoGen.setX(partida.getRecursos().getElemento(recursoElegido).getDatos().getX());
            individuoGen.setY(partida.getRecursos().getElemento(recursoElegido).getDatos().getY());
            individuoGen.addMovimiento(new Movimiento(partida.getRecursos().getElemento(recursoElegido).getDatos().getX(), partida.getRecursos().getElemento(recursoElegido).getDatos().getY(),individuoGen.getId()));
            partida.getAcciones().encolar(new ElementoLDE<String>("Individuo(A): "+individuoGen.getId()+", se ha movido a: x="+individuoGen.getX()+"" +
                    ", y= "+individuoGen.getY()));
            individuoGen.añadirmovimientosJSon();

        }



    }
    //

    private void ejecutarMovimientoINormal(Invidiuos individuoGen, Partida partida) {

        ListaRecursos listarec = partida.getRecursos();
        ListaRecursos listarecLR = new ListaRecursos();
        for (int i=0; i< listarec.getNumeroElementos();i++) {
            if (listarec.getElemento(i) != null )

                if ( (listarec.getElemento(i).getDatos().getY() == individuoGen.getY() ||
                        listarec.getElemento(i).getDatos().getX() == individuoGen.getX())&&
                        !(listarec.getElemento(i).getDatos().getY() == individuoGen.getY() &&
                                listarec.getElemento(i).getDatos().getX() == individuoGen.getX())) {

                    listarecLR.add(listarec.getElemento(i).getDatos());
                }
        }

        if(listarecLR != null && listarecLR.getNumeroElementos()>0){
            int minimo=0;
            int maximo = listarecLR.getNumeroElementos();
            Random r = new Random();
            int aleaPos = r.nextInt((maximo - minimo) + 1) + minimo;
            if(aleaPos > 0)
                aleaPos--;
            Recursos recursoLR = listarecLR.getElemento(aleaPos).getDatos();
            individuoGen.setX(recursoLR.getX());
            individuoGen.setY(recursoLR.getY());
            individuoGen.addMovimiento(new Movimiento(recursoLR.getX(),recursoLR.getY(),individuoGen.getId()));
            partida.getAcciones().encolar(new ElementoLDE<String>("Individuo(N): "+individuoGen.getId()+", se ha movido a: x="+individuoGen.getX()+"" +
                    ", y= "+individuoGen.getY()));
            individuoGen.añadirmovimientosJSon();

        }
    }

    private void ejecutarMovimientoIBasico(Invidiuos individuoGen, Partida partida) {
        int minimo = 1;
        int maximoX= partida.getFilas();
        int maximoY= partida.getColumnas();
        Random r = new Random();
        int aleaX = r.nextInt((maximoX - minimo) + 1) + minimo;
        r = new Random();
        int aleaY = r.nextInt((maximoY - minimo) + 1) + minimo;

        individuoGen.setX(aleaX);
        individuoGen.setY(aleaY);
        individuoGen.addMovimiento(new Movimiento(aleaX,aleaY,individuoGen.getId()));
        partida.getAcciones().encolar(new ElementoLDE<String>("Individuo(B): "+individuoGen.getId()+", se ha movido a: x="+individuoGen.getX()+"" +
                ", y= "+individuoGen.getY()));
        individuoGen.añadirmovimientosJSon();
    }
    private void verClon(Partida p){

        ListaELementos individuosPartida=p.getIndividuos();
        ListaELementos individuos= duplicaIndividuos(individuosPartida);

        int numElementosIniciales=individuos.getNumeroElementos();
        for(int i=0; i<numElementosIniciales;i++){
            Invidiuos actual= individuos.getElemento(i).getDatos();
            int n= (int) (Math.random()*100);
            if(n<actual.getProbclon()*100){
                Invidiuos copia= actual.copiar(actual);
                int nuevoID=dameMaxIdIndividuo(p,actual)+1;
                copia.setId(nuevoID);
                if(!existeIndividuo(p, copia))
                    partida.getAcciones().encolar(new ElementoLDE<String>("Individuo("+copia.getTipo()+"): "+copia.getId()+"  Se ha clonado"));
                    p.getIndividuos().add(copia);

            }
        }
    }
    private void verreproduccion(Partida p, int paso){
        ListaELementos individuosPartida=p.getIndividuos();
        ListaELementos individuos= duplicaIndividuos(individuosPartida);
        int numElementosIniciales=individuos.getNumeroElementos();
        for(int i=0; i<numElementosIniciales;i++){
            for (int j=0; j<numElementosIniciales;j++){
                if(individuos.getElemento(i).getDatos().getX()==individuos.getElemento(j).getDatos().getX()
                        && individuos.getElemento(i).getDatos().getY()==individuos.getElemento(j).getDatos().getY()
                        && individuos.getElemento(i).getDatos().getId()!=individuos.getElemento(j).getDatos().getId()) {
                    Invidiuos padre1 ;
                    Invidiuos padre2;
                    if((individuos.getElemento(i).getDatos().getId()) < (individuos.getElemento(j).getDatos().getId()) ) {
                        padre1 = individuos.getElemento(i).getDatos();
                        padre2 = individuos.getElemento(j).getDatos();
                    }else{
                        padre1 = individuos.getElemento(j).getDatos();
                        padre2 = individuos.getElemento(i).getDatos();
                    }

                    if (padre1.getProbrep() + padre2.getProbrep() >= 1) {

                        int turnos = 0;
                        if (padre2.getTurnosvida() <= padre1.getTurnosvida()) {
                            turnos += padre1.getTurnosvida();
                        }
                        if (padre2.getTurnosvida() > padre1.getTurnosvida()) {
                            turnos += padre2.getTurnosvida();
                        }
                        float probclon = 0;
                        if (padre2.getProbclon() < padre1.getProbclon()) {
                            probclon += padre1.getProbclon();
                        }
                        if (padre2.getProbclon() > padre1.getProbclon()) {
                            probclon+= padre2.getProbclon();
                        }
                        if (!existeHijo(padre1, padre2,paso)) {
                            Invidiuos hijo = new Invidiuos(padre1.getX(), padre1.getY(), dameMaxIdIndividuo(partida,padre1) + 1, turnos, probclon, partida.getMejora());
                            if (Objects.equals(padre2.getTipo(), "Avanzado") || Objects.equals(padre1.getTipo(), "Avanzado")) {
                                hijo.setTipo("Avanzado");
                            } else if (Objects.equals(padre2.getTipo(), "Básico") || Objects.equals(padre1.getTipo(), "Básico")) {
                                hijo.setTipo("Básico");
                            } else if (Objects.equals(padre2.getTipo(), "Normal") || Objects.equals(padre1.getTipo(), "Normal")) {
                                hijo.setTipo("Normal");
                            }
                            if(!existeIndividuo(p,hijo)) {
                                p.getIndividuos().add(hijo);
                                Reproduccion reproduccion = new Reproduccion(padre1.getId(), padre2.getId(), hijo.getId(), paso);
                                hijo.addReproduccion(reproduccion);
                                partida.getAcciones().encolar(new ElementoLDE<String>("Individuo("+padre2.getTipo()+"): "+padre2.getId()+" y  Individuo("+padre1.getTipo()+"): "+padre1.getId()+
                                        " se han reproducido= "+hijo.getId()));
                                hijo.añadirReproduccionJSon();
                            }
                        }

                    }
                }
            }
        }
    }
    public  void nuevosrecursos(Partida p){
        for(int i=1;i<=p.getColumnas();i++){
            for(int j=1; j<=p.getFilas();j++){
                int pos= (int) (Math.random()*100);
                if(pos<p.getPz()*100){
                    ListaLEINT pv= getPvs(p);
                    if(Math.random()*100<(int)pv.getElemento(pv.getNumeroElementos()-1).getDatos()){
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(pv.getNumeroElementos()-1).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(pv.getNumeroElementos()-1).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                                ));
                        p.getRecursos().add(r);
                    }
                    else  if(Math.random()*100<(int)pv.getElemento(pv.getNumeroElementos()-2).getDatos()){
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(pv.getNumeroElementos()-2).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(pv.getNumeroElementos()-2).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                        ));
                        p.getRecursos().add(r);
                    }
                    else if(Math.random()*100<(int)pv.getElemento(pv.getNumeroElementos()-3).getDatos()){
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(pv.getNumeroElementos()-3).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(pv.getNumeroElementos()-3).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                        ));
                        p.getRecursos().add(r);
                    }
                    else if(Math.random()*100<(int)pv.getElemento(pv.getNumeroElementos()-4).getDatos()){
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(pv.getNumeroElementos()-4).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(pv.getNumeroElementos()-4).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                        ));
                        p.getRecursos().add(r);
                    }
                    else  if(Math.random()*100<(int)pv.getElemento(pv.getNumeroElementos()-5).getDatos()){
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(pv.getNumeroElementos()-5).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(pv.getNumeroElementos()-5).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                        ));
                        p.getRecursos().add(r);
                    }
                    else if(Math.random()*100<(int)pv.getElemento(0).getDatos()){
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(0).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(0).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                        ));
                        p.getRecursos().add(r);
                    }
                    else{
                        Recursos r= new Recursos(i,j,p.getPz(),p.getPvA(),p.getTiemposvida()
                                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
                        r.setTipo(rec((int)pv.getElemento(pv.getNumeroElementos()-1).getDatos(),p));
                        partida.getAcciones().encolar(new ElementoLDE<String>("Recurso("+rec((int)pv.getElemento(pv.getNumeroElementos()-1).getDatos(),p)+"" +
                                ") Se ha creado  en  x= "+r.getX()+"  y="+r.getY()
                        ));
                        p.getRecursos().add(r);
                    }
                }
            }
        }
    }
    private ListaLEINT getPvs(Partida p){
        ListaLEINT l= new ListaLEINT();

        l.add((int)(p.getPvA()*100));
        l.add((int)(p.getPvC()*100));
        l.add((int)(p.getPvB()*100));
        l.add((int)(p.getPvM()*100));
        l.add((int)(p.getPvP()*100));
        l.add((int)(p.getPvT()*100));
        return ordenar(l);
    }
    private String rec(int pv, Partida p){
        String tipo = null;
        if(Objects.equals(pv,(int)(p.getPvA()*100))){
            tipo= "A";
        }
        else if(Objects.equals(pv, (int)(p.getPvC()*100))){
            tipo= "C";
        }
        else if(Objects.equals(pv, (int)(p.getPvB()*100))){
            tipo= "B";
        }
        else if(Objects.equals(pv,(int)(p.getPvM()*100))){
            tipo= "M";
        }
        else if(Objects.equals(pv,(int)(p.getPvP()*100))){
            tipo= "P";

        }else if(Objects.equals(pv,(int)(p.getPvT()*100))){
            tipo="T";
        }

        return tipo;
    }
    public ListaLEINT ordenar(ListaLEINT l){
        ListaLEINT ordenada= new ListaLEINT();
    for (int i=0; i<l.getNumeroElementos();){
        ElementoLEINT el=l.getElemento(i);
        for (int j=0;j<l.getNumeroElementos()-i;j++){
            ElementoLEINT actual= l.getElemento(j);
            if(el.getDatos()<actual.getDatos()){
                el=actual;
            }
        }
        l.del(l.getPosicion(new ElementoLEINT(el.getDatos())));
        ordenada.add(el.getDatos());
        }
    return ordenada;
    }
    private void limpiarRec(Partida p){
    for(int i=1; i<=p.getFilas();i++){
        for(int j=1;j<=p.getColumnas();j++){
           while (reccelda(i,j,p.getRecursos()).getNumeroElementos()>3){
             borrar(reccelda(i,j,p.getRecursos()),p);
            }
        }
    }
    }
    private void borrar(ListaRecursos r,Partida p){
        Recursos nodoaborrar= r.getElemento(0).getDatos();
        for(int i=0; i<r.getNumeroElementos();i++){
            if(nodoaborrar.getTiemposvida()<r.getElemento(i).getDatos().getTiemposvida()) {
                nodoaborrar = r.getElemento(i).getDatos();
            }
        }
    p.getRecursos().del(p.getRecursos().getPosicion(new ElementoRe(nodoaborrar)));
        partida.getAcciones().encolar(new ElementoLDE<>("Recurso: "+ p.getRecursos().getElemento(p.getRecursos().getPosicion(new ElementoRe(nodoaborrar))).getDatos().getTipo()+
                " ha sido eliminado"));
    }
    private ListaELementos elementosceldas(int x, int y, ListaELementos ind) {
        ListaELementos indcelda = new ListaELementos();
        for(int i=0; i<ind.getNumeroElementos();i++){
            if(ind.getElemento(i).getDatos().getX()-1==x && ind.getElemento(i).getDatos().getY()-1==y){
                indcelda.add(ind.getElemento(i).getDatos());
            }
        }
        return indcelda;
    }
    private ListaRecursos reccelda(int x, int y, ListaRecursos ind) {
        ListaRecursos indcelda = new ListaRecursos();
        for(int i=0; i<ind.getNumeroElementos();i++){
            if(ind.getElemento(i).getDatos().getX()==x && ind.getElemento(i).getDatos().getY()==y){
                indcelda.add(ind.getElemento(i).getDatos());
            }
        }
        return indcelda;
    }

    private void actualizarExistenciaR(ListaRecursos recursos) {

        for (int i=0; i< recursos.getNumeroElementos();i++) {
            if (recursos.getElemento(i) != null )
                if ( recursos.getElemento(i).getDatos().getTiemposvida()>0) {
                    recursos.getElemento(i).getDatos().setTiemposvida(recursos.getElemento(i).getDatos().getTiemposvida() - 1);
                } else{
                    partida.getAcciones().encolar(new ElementoLDE<>("Recurso: "+ recursos.getElemento(i).getDatos().getTipo()+" ha desaparecido"));
                    recursos.del(i);
                    i--;
                }
        }
    }

    private void actualizarTvidaI(ListaELementos individuos) {
        for (int i=0; i< individuos.getNumeroElementos();i++) {
            if (individuos.getElemento(i) != null ) {
                if ( individuos.getElemento(i).getDatos().getTurnosvida()>0)
                    individuos.getElemento(i).getDatos().setTurnosvida(individuos.getElemento(i).getDatos().getTurnosvida() - 1);
                else {
                    partida.getAcciones().encolar(new ElementoLDE<>("Individuo: "+ individuos.getElemento(i).getDatos().getId()+" ha muerto"));
                    individuos.del(i);
                    i--;
                }
            }
        }
    }

    public ListaRecursos duplicaRecursos(ListaRecursos lista){
        ListaRecursos newLista = new ListaRecursos();
        for(int i=0; i < lista.getNumeroElementos();i++){
            newLista.add(lista.getElemento(i).getDatos());
        }
        return newLista;
    }
    public ListaELementos duplicaIndividuos(ListaELementos lista){
        ListaELementos newLista = new ListaELementos();
        for(int i=0; i < lista.getNumeroElementos();i++){
            newLista.add(lista.getElemento(i).getDatos());
        }
        return newLista;
    }
    public int dameMaxIdIndividuo(Partida partida, Invidiuos padre1){
        int maxId=0;
        int maxIdRepr=0;
        if ((maxIdRepr=dameMaxIdHijo(padre1)) == 0) {

            for (int i=0; i< partida.getIndividuos().getNumeroElementos();i++) {
                if (partida.getIndividuos().getElemento(i) != null) {
                    Invidiuos individuoGen = (partida.getIndividuos().getElemento(i).getDatos());
                    if (individuoGen.getId() > maxId) {
                        maxId = individuoGen.getId();
                    }
                }
            }
        }else {
            maxId=maxIdRepr;
        }
        return maxId;

    }
    public int dameMaxIdHijo(Invidiuos padre1){
        ListaLERepr<Reproduccion> listaRep= new ListaLERepr<Reproduccion>();
        listaRep= padre1.getReproducciones().cargar();
        int maxId=0;
        for (int i=0; i< listaRep.getNumeroElementos();i++) {
            if (listaRep.getElemento(i) != null && listaRep.getElemento(i).getDatos() != null) {
                if (listaRep.getElemento(i).getDatos().getIdIndividuoHijo() > maxId) {
                    maxId = listaRep.getElemento(i).getDatos().getIdIndividuoHijo();
                }
            }
        }
        return maxId;
    }
    public boolean existeHijo(Invidiuos padre1, Invidiuos padre2, int paso){
        boolean existe=false;
        for (int i=0; i< partida.getIndividuos().getNumeroElementos();i++) {
            if (partida.getIndividuos().getElemento(i) != null) {
                if (partida.getIndividuos().getElemento(i).getDatos().getReproducciones()!=null ) {
                    ListaLERepr<Reproduccion> reproducciones = partida.getIndividuos().getElemento(i).getDatos().getReproducciones();
                    for (int j = 0; j < reproducciones.getNumeroElementos(); j++){
                        if (reproducciones.getElemento(j) != null && reproducciones.getElemento(j).getDatos()!=null){
                            if (reproducciones.getElemento(j).getDatos().getIdIndividuoPadre1() == padre1.getId()&&
                                    reproducciones.getElemento(j).getDatos().getIdIndividuoPadre2() == padre2.getId() &&
                                    reproducciones.getElemento(j).getDatos().getPaso() == paso){
                                existe=true;
                            }
                        }
                    }
                }

            }

        }
        return existe;

    }
    public boolean existeIndividuo(Partida partida, Invidiuos individuo){
        boolean existe=false;
        for (int i=0; !existe && i< partida.getIndividuos().getNumeroElementos();i++) {
            if (partida.getIndividuos().getElemento(i) != null) {
                if (partida.getIndividuos().getElemento(i).getDatos().getId() == individuo.getId()) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;

    }
    private void guardaHistorico(Partida partida,  int paso){
        Historico historico = new Historico(partida, paso);

    }
}
