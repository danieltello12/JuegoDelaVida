package es.uah.trabajo.juegodelavida.BucleControl;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Clases.Grafos.*;

import java.util.Random;

public class Bucle {
    Partida partida;
    ListaRecursos listaRecursos;
    ListaELementos listaIndividuos;


    public  Bucle (Partida partida){

        this.partida = partida;
        listaRecursos = duplicaRecursos(partida.getRecursos());
        listaIndividuos= duplicaIndividuos(partida.getIndividuos());
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

    public void ejecutarMovimiento(){
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
        evaluarReproduccion(partida);

        /*6. Para cada individuo, evaluará si existe clonación o no.*/
        evaluarClonacion(partida.getIndividuos());

        /*7. Para cada posición del tablero en la que existan varios individuos, se evaluará si deben
        desaparecer algunos.*/
        actualizarExistenciaI(partida.getIndividuos());

        /*8. Para cada posición del tablero, se evaluará si deben aparecer nuevos recursos
         */
        evaluarNuevoR(partida);

    }

    private void evaluarNuevoR(Partida partida) {
    }

    private void actualizarExistenciaI(ListaELementos individuos) {

        boolean continuar=true;
        int numTurnos=Integer.MAX_VALUE;

        for(int f=0; f < partida.getFilas();f++) {
            for(int c=0; c < partida.getColumnas();c++){
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
                        partida.getIndividuos().del(pos);
                        contador--;
                        numTurnos=Integer.MAX_VALUE;
                        pos=-1;
                    }


                }
            }
        }

    }

    private void evaluarClonacion(ListaELementos individuos) {
    }

    private void evaluarReproduccion(Partida partida) {
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
                double costeRec = caminoLDE.getDatos().getCoste();
                if (costeRec < coste && costeRec != 0) {
                    coste = costeRec;
                    recursoElegido = i;
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
                double costeRec = caminoLDE.getDatos().getCoste();
                if (costeRec < coste&& costeRec != 0) {
                    coste = costeRec;
                    recursoElegido = i;
                }
            }
        }
        if ( coste < Double.MAX_VALUE && recursoElegido >= 0){
            individuoGen.setX(partida.getRecursos().getElemento(recursoElegido).getDatos().getX());
            individuoGen.setY(partida.getRecursos().getElemento(recursoElegido).getDatos().getY());
            individuoGen.addMovimiento(new Movimiento(partida.getRecursos().getElemento(recursoElegido).getDatos().getX(),
                    partida.getRecursos().getElemento(recursoElegido).getDatos().getY(),individuoGen.getId()));
            individuoGen.añadirmovimientosJSon();

        }



    }

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
        individuoGen.añadirmovimientosJSon();
    }
    private void verClon(){
        ListaELementos individuos= new ListaELementos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
        for(int i=0; i<individuos.getNumeroElementos();i++){
            Invidiuos actual= individuos.getElemento(i).getDatos();
            int n= (int) (Math.random()*100);
            if(n<actual.getProbclon()){
                Invidiuos copia= actual;
                individuos.add(copia);
            }
        }
        individuos.guardar(individuos,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
    }
    private void verreproduccion(){
        ListaELementos individuos= new ListaELementos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
        for(int i=0; i<individuos.getNumeroElementos();i++){
            for (int j=0; j<individuos.getNumeroElementos();j++){
              if(individuos.getElemento(i).getDatos().getX()==individuos.getElemento(j).getDatos().getX()
                            && individuos.getElemento(i).getDatos().getY()==individuos.getElemento(j).getDatos().getY()
                                && individuos.getElemento(i).getDatos().getId()!=individuos.getElemento(j).getDatos().getId()) {
                  Invidiuos padre1 = individuos.getElemento(i).getDatos();
                  Invidiuos padre2 = individuos.getElemento(j).getDatos();
                  if (padre1.getProbrep() + padre2.getProbrep() >= 1) {
                      if (padre2.getTipo() == "Avanzado" || padre1.getTipo() == "Avanzado") {
                          int turnos = 0;
                          if (padre2.getTurnosvida() < padre1.getTurnosvida()) {
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
                          Invidiuos hijo = new Invidiuos(padre1.getX(), padre1.getY(),padre1.getId()+padre2.getId(),turnos,probclon,partida.getMejora());
                          individuos.add(hijo);
                      }
                  }
              }
            }
        }
    }

    private void actualizarExistenciaR(ListaRecursos recursos) {

        for (int i=0; i< recursos.getNumeroElementos();i++) {
            if (recursos.getElemento(i) != null )
                if ( recursos.getElemento(i).getDatos().getTiemposvida()>0) {
                    recursos.getElemento(i).getDatos().setTiemposvida(recursos.getElemento(i).getDatos().getTiemposvida() - 1);
                } else{
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
                    individuos.del(i);
                    i--;
                }
            }
        }
    }
}
