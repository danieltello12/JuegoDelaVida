package es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;

public class Cola<TipoDelDato> {
    private ElementoLDE cabecera;
    private ElementoLDE cola;
    private int longitud;
    private ElementoLDE siguiente;
    public Cola(){
        cabecera=cola=null;
        longitud=0;
    }

    public boolean esVacía(){
        return (cabecera==null);
    }

    public ElementoLDE encolar(ElementoLDE ob){
        ElementoLDE n=new ElementoLDE(ob.getDatos());
        if (longitud==0){
            cola=cabecera=n; //Para que en el setSiguiente no de null
            longitud++;
        }else{
            n.siguiente=cabecera;
            cabecera=n;
            longitud++;
        }
        return cabecera;
    }

    public ElementoLDE getCola(){

        return this.cola;
    }

    public ElementoLDE getElemento(int posicion){
        int pos = 0;
        ElementoLDE obj = this.cabecera;
        while (pos<posicion) {
            obj = obj.siguiente;
            pos++;
        }
        return obj;

    }


}
