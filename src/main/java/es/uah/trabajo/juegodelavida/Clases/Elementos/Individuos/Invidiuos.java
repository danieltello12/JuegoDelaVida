package es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Elementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLEMov;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLERepr;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;
import es.uah.trabajo.juegodelavida.Clases.Reproduccion;

public class Invidiuos extends Elementos {

    int id;
    int turnosvida;
    float probrep;
    float probclon;
    String tipo;
    ListaLEMov<Movimiento> movimientos;
    ListaLERepr<Reproduccion> reproducciones;

    int numPasos=0;

    public int getNumPasos() {
        return numPasos;
    }

    public void setNumPasos(int numPasos) {
        this.numPasos = numPasos;
    }

    public int getNumAguas() {
        return numAguas;
    }

    public void setNumAguas(int numAguas) {
        this.numAguas = numAguas;
    }

    public int getNumComida() {
        return numComida;
    }

    public void setNumComida(int numComida) {
        this.numComida = numComida;
    }

    public int getNumTesoro() {
        return numTesoro;
    }

    public void setNumTesoro(int numTesoro) {
        this.numTesoro = numTesoro;
    }

    public int getNumBiblioteca() {
        return numBiblioteca;
    }

    public void setNumBiblioteca(int numBiblioteca) {
        this.numBiblioteca = numBiblioteca;
    }

    public int getNumPozo() {
        return numPozo;
    }

    public void setNumPozo(int numPozo) {
        this.numPozo = numPozo;
    }

    public int getNumMontaña() {
        return numMontaña;
    }

    public void setNumMontaña(int numMontaña) {
        this.numMontaña = numMontaña;
    }

    public int getNumClonado() {
        return numClonado;
    }

    public void setNumClonado(int numClonado) {
        this.numClonado = numClonado;
    }

    public int getNumReproducido() {
        return numReproducido;
    }

    public void setNumReproducido(int numReproducido) {
        this.numReproducido = numReproducido;
    }

    int numAguas=0;
    int numComida=0;
    int numTesoro=0;
    int numBiblioteca=0;
    int numPozo=0;
    int numMontaña=0;

    int numClonado=0;
    int numReproducido=0;

    public ListaLERepr<Reproduccion> getReproducciones(){
        return reproducciones;
    }
    public Invidiuos copiar(Invidiuos i){
        Invidiuos nuevo= new Invidiuos(i.getX(),i.getY(),i.getId(),i.turnosvida,i.probrep,i.getProbclon());
        nuevo.setTipo(i.getTipo());
        return  nuevo;
    }


    public Invidiuos(int x, int y, int id, int turnosvida, float probrep, float probclon) {
       super(x,y);
        this.id = id;
        this.turnosvida = turnosvida;
        this.probrep = probrep;
        this.probclon = probclon;
        movimientos= new ListaLEMov<>();
        movimientos.add(new Movimiento(x,y,id),0);

        reproducciones= new ListaLERepr<>();

    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo() {
        return tipo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTurnosvida() {
        return turnosvida;
    }

    public void setTurnosvida(int turnosvida) {
        this.turnosvida = turnosvida;
    }

    public float getProbrep() {
        return probrep;
    }

    public void setProbrep(float probrep) {
        this.probrep = probrep;
    }

    public float getProbclon() {
        return probclon;
    }

    public void setProbclon(float probclon) {
        this.probclon = probclon;
    }
    public void añadirmovimientosJSon(){

        if(!movimientos.isVacia()){
            ListaLEMov<Movimiento> movimientosFich=new ListaLEMov<Movimiento>();

            for (int i = movimientos.getNumeroElementos();i >= 0;i--){
                    if(movimientos.getElemento(i) != null)
                        movimientosFich.añadirMovimiento(movimientos.getElemento(i).getDatos());
            }

        }

    }
    public void addMovimiento(Movimiento mov){
        movimientos.add(new Movimiento(mov.getX(),mov.getY(),id));
    }

    public void añadirReproduccionJSon(){

        if(!reproducciones.isVacia()){
            ListaLERepr<Reproduccion> reproduccionesFich=new ListaLERepr<Reproduccion>();

            for (int i = reproducciones.getNumeroElementos();i >= 0;i--){
                if(reproducciones.getElemento(i) != null)
                    reproduccionesFich.añadirReproduccion(reproducciones.getElemento(i).getDatos());
            }

        }

    }
    public void addReproduccion(Reproduccion repr){
        reproducciones.add(new Reproduccion(repr.getIdIndividuoPadre1(),repr.getIdIndividuoPadre2(),repr.getIdIndividuoHijo(),repr.getPaso()));
    }
}
