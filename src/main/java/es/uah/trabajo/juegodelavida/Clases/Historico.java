package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLE;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

public class Historico extends gson {
        int paso;


    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public ListaELementos<Invidiuos> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ListaELementos<Invidiuos> individuos) {
        this.individuos = individuos;
    }

    ListaELementos<Invidiuos> individuos;
        public Historico(ListaELementos<Invidiuos> individuos,  int paso) {
            this.paso = paso;
            this.individuos =individuos;

        }
    public boolean existeEnHistorico(Invidiuos individuo){
            boolean existe=false;
            for (int i=0;!existe&& i < this.individuos.getNumeroElementos(); i++){
                if(this.individuos.getElemento(i) != null){
                    if(this.individuos.getElemento(i).getDatos() != null &&
                            ( this.individuos.getElemento(i).getDatos().getId())==(individuo.getId())){
                            existe=true;
                            break;
                    }
                }
            }
            return existe;
    }
    public void añadirHistorico(Invidiuos individuo) {

        Historico historicoF= new Historico(this.individuos,paso);
        historicoF=cargar();
        if(historicoF == null){
            historicoF = new Historico(this.individuos,paso);
            historicoF.guardar(historicoF);
        }

                if (historicoF.existeEnHistorico(individuo )){
                    int posIndi = historicoF.individuos.getPosicionId(new ElementoLE(individuo));
                    if (posIndi >= 0){
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumReproducido(individuo.getNumReproducido());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumClonado(individuo.getNumClonado());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumPasos(individuo.getNumPasos());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumAguas(individuo.getNumAguas());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumBiblioteca(individuo.getNumBiblioteca());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumComida(individuo.getNumComida());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumMontaña(individuo.getNumMontaña());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumTesoro(individuo.getNumTesoro());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumPozo(individuo.getNumPozo());
                        historicoF.individuos.getElemento(posIndi).getDatos().setTurnosvida(individuo.getTurnosvida());
                        historicoF.individuos.getElemento(posIndi).getDatos().setMaxNumTurnosVida(individuo.getMaxNumTurnosVida());

                    }else{
                        historicoF.individuos.add(individuo);
                    }


                }else{
                    historicoF.individuos.add(individuo);
                }

        guardar(historicoF);
    }
    public void limpiar() {

        Historico historicoF = new Historico(this.individuos, paso);
        historicoF = cargar();
        if (historicoF != null) {
            ListaELementos<Invidiuos> individuos = new ListaELementos<Invidiuos> ();
            historicoF = new Historico(individuos, paso);
            historicoF.guardar(historicoF);
        }
    }
    public void añadirHistorico(Partida partida) {

        Historico historicoF= new Historico(this.individuos,paso);
        historicoF=cargar();
        if(historicoF == null){
            historicoF = new Historico(this.individuos,paso);
            historicoF.guardar(historicoF);
        }

        for(int i = 0; partida.individuos != null && i< partida.individuos.getNumeroElementos();i++){
            if(partida.individuos.getElemento(i) != null){

                Invidiuos individuo =partida.individuos.getElemento(i).getDatos();

                if (historicoF.existeEnHistorico(individuo )){
                    int posIndi = historicoF.individuos.getPosicionId(new ElementoLE(individuo));
                    if (posIndi >= 0){
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumReproducido(individuo.getNumReproducido());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumClonado(individuo.getNumClonado());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumPasos(individuo.getNumPasos());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumAguas(individuo.getNumAguas());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumBiblioteca(individuo.getNumBiblioteca());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumComida(individuo.getNumComida());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumMontaña(individuo.getNumMontaña());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumTesoro(individuo.getNumTesoro());
                        historicoF.individuos.getElemento(posIndi).getDatos().setNumPozo(individuo.getNumPozo());
                        historicoF.individuos.getElemento(posIndi).getDatos().setTurnosvida(individuo.getTurnosvida());
                        historicoF.individuos.getElemento(posIndi).getDatos().setMaxNumTurnosVida(individuo.getMaxNumTurnosVida());

                    }else{
                        historicoF.individuos.add(individuo);
                    }


                }else{
                    historicoF.individuos.add(individuo);
                }
            }


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
