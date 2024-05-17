package es.uah.trabajo.juegodelavida.BucleControl;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;
import es.uah.trabajo.juegodelavida.Clases.Partida;

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
                        if (recurso.getCbAgua().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModAgua());
                        }
                        if (recurso.getCbAgua().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModAgua());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;


                            }
                        }
                        if (recurso.getCbAgua().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModAgua() / 100));
                        }
                        if (recurso.getCbAgua().equals("+Probab Repro")) {
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
                        if (recurso.getCbAgua().equals("Muerte Inst")) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("C") ){


                        if (recurso.getCbComida().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModComida());
                        }
                        if (recurso.getCbComida().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModComida());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbComida().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModComida() / 100));
                        }
                        if (recurso.getCbComida().equals("+Probab Repro")) {
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
                        if (recurso.getCbComida().equals("Muerte Inst")) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("M")) {
                        if (recurso.getCbMontana().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModMontana());
                        }
                        if (recurso.getCbMontana().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModMontana());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbMontana().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModMontana() / 100));
                        }
                        if (recurso.getCbMontana().equals("+Probab Repro")) {
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
                        if (recurso.getCbMontana().equals("Muerte Inst")) {

                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("T")) {
                        if (recurso.getCbTesoro().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModTesoro());
                        }
                        if (recurso.getCbTesoro().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModTesoro());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbTesoro().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModTesoro() / 100));
                        }
                        if (recurso.getCbTesoro().equals("+Probab Repro")) {
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
                        if (recurso.getCbTesoro().equals("Muerte Inst")) {
                            eliminado=true;

                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("B")) {

                        if (recurso.getCbBiblio().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModBiblio());
                        }
                        if (recurso.getCbBiblio().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModBiblio());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;

                            }
                        }
                        if (recurso.getCbBiblio().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModBiblio() / 100));
                        }
                        if (recurso.getCbBiblio().equals("+Probab Repro")) {
                            individuoGen.setProbrep(individuoGen.getProbrep() + (recurso.getModBiblio() / 100));
                        }
                        if (recurso.isCkBiblio()) {
                            String nuevoTipo = "Avanzado";
                            if (individuoGen.getTipo().equals("Básico"))
                                nuevoTipo = "Normal";
                            if (individuoGen.getTipo().equals("Normal"))
                                nuevoTipo = "Avanzado";
                            individuoGen.setTipo(nuevoTipo);
                        }
                        if (recurso.getCbBiblio().equals("Muerte Inst")) {
                            eliminado=true;
                            individuos.del(i);
                            i--;
                        }
                    }else if(recurso.getTipo().equals("P")) {
                        if (recurso.getCbPozo().equals("+Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() + recurso.getModPozo());
                        }
                        if (recurso.getCbPozo().equals("-Turnos vida")) {
                            individuoGen.setTurnosvida(individuoGen.getTurnosvida() - recurso.getModPozo());
                            if (individuoGen.getTurnosvida() <= 0) {
                                eliminado = true;
                                individuos.del(i);
                                i--;
                            }
                        }
                        if (recurso.getCbPozo().equals("+Probab Clon")) {
                            individuoGen.setProbclon(individuoGen.getProbclon() + (recurso.getModPozo() / 100));
                        }
                        if (recurso.getCbPozo().equals("+Probab Repro")) {
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
                        if (recurso.getCbPozo().equals("Muerte Inst")&&!eliminado) {
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
                        ejecutarMovimientoIAvanzado();
                        break;
                    default:
                        ejecutarMovimientoIBasico(individuoGen, partida);
                        
                }
                
                        
                
            }
            
        }
    }

    private void ejecutarMovimientoIAvanzado() {
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
