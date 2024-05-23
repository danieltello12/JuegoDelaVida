package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class Historico extends gson {
        int paso;

        ListaELementos<Invidiuos> individuos;
        public Historico(Partida partida,  int paso) {
        this.paso = paso;
        this.individuos = partida.getIndividuos();

    }

    public void añadirHistorico(Historico historico) {

        Historico historicoF= cargar();

        for(int i = 0; historico.individuos != null && i< historico.individuos.getNumeroElementos();i++){
            /*
                if (existeEnHistorico(historico.individuos.getElemento(i).getDatos() )){
                    historicoF.individuos.getElemento(i).getDatos().paso= historico.individuos.getElemento(i).getDatos().paso;
                    historicoF.individuos.getElemento(i).getDatos().numClonaciones= historico.individuos.getElemento(i).getDatos().numClonaciones;
                    .
                    .
                    .


                }else{
                    historicoF.individuos.add(historico.individuos.getElemento(i));
                }


             */
        }
        guardar(historicoF);
    }

    public void guardar(Historico historico){
        guardarObjetoEnArchivo("Json/historico.json",historico);
    }
    public Historico cargar(){
        return cargarObjetoDesdeArchivo("Json/historico.json", Historico.class);

    }

}
