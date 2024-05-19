package es.uah.trabajo.juegodelavida.Grafos;

public class ListaSimple<TipoDelDato> {
    ElementoLS<TipoDelDato>[] lista;
    int maximo = 900;

    public ListaSimple() {
        this.lista = new ElementoLS[this.maximo];
    }

    public boolean isVacia() {
        boolean vacio = true;
        int pos = 0;
        while (pos < getNumeroElementos()) {
            if (this.lista[pos] != null) {
                vacio = false;
                break;
            } else {
                vacio = true;
            }
            pos++;
        }
        return vacio;
    }

    public void vaciar() {
        int pos = 0;
        while (pos < maximo) {
            this.lista[pos] = null;
            pos++;
        }
    }

    private int add(ElementoLS o) {
        int pos = 0;
        boolean añadido = false;
        while (pos < maximo) {
            if (this.lista[pos] == null) {
                this.lista[pos] = o;
                añadido = true;
                //System.out.println("Elemento añadido");
                break;
            }
            pos++;
        }
        if (!añadido) {
            System.out.println("Lista Llena");
        }
        return pos;
    }

    public void add(String dato) {
        ElementoLS el = new ElementoLS(dato);
        add(el);

    }

    public void add(Object dato) {
        ElementoLS el = new ElementoLS(dato);
        add(el);

    }

    public void insert(String s, int posicion) {
        ElementoLS el = new ElementoLS(s);
        int i = posicion;
        ListaSimple ancla = new ListaSimple();
        if (posicion < this.maximo) {
            if (this.getNumeroElementos() + 1 <= maximo) {


                for (int j = 0; j < lista.length; j++) {
                    ancla.lista[j] = this.lista[j];
                }
                for (; i < lista.length - 2; ) {
                    this.lista[i + 1] = ancla.lista[i];
                    i++;

                }
                this.lista[posicion] = el;
                this.add(this.lista[i]);
            }
        }
    }

    public void insert(Object dato, int posicion) {
        ElementoLS el = new ElementoLS(dato);
        int i = posicion;
        ListaSimple ancla = new ListaSimple();
        if (posicion < this.maximo) {
            if (lista.length + 1 <= maximo) {

                System.arraycopy(this.lista, 0, ancla.lista, 0, lista.length);
                for (; i < lista.length - 2; ) {
                    this.lista[i + 1] = ancla.lista[i];
                    i++;

                }
                this.lista[posicion] = el;
                this.add(this.lista[i]);
            }
        }
    }

    public int del(int pos) {
        int i = pos;
        ListaSimple ancla = new ListaSimple();
        if (lista.length > 0) {
            for (int j = 0; j < lista.length; j++) {
                ancla.lista[j] = this.lista[j];
            }
            for (; i < lista.length - 2; ) {
                this.lista[i] = ancla.lista[i + 1];
                i++;
            }
            this.lista[i] = null;
        }
        return lista.length;
    }

    public int getNumeroElementos() {
        int numele = 0;
        int pos = 0;
        while (pos < maximo) {
            if (this.lista[pos] != null) {
                numele++;


            }
            pos++;

        }
        return numele;
    }

    public int getPosicion(ElementoLS el) {
        int pos = 0;
        while (pos < maximo) {
            if (this.lista[pos].getDato() == el.getDato()) {
                break;
            }
            pos++;
        }
        return pos;
    }

    public ElementoLS getPrimero() {
        return this.lista[0];

    }

    public ElementoLS getUltimo() {
        return this.lista[this.getNumeroElementos() - 1];

    }

    private ElementoLS getSiguiente(ElementoLS el) {
        int pos = this.getPosicion(el);

        return this.lista[pos + 1];


    }

    public ElementoLS getElemento(int pos) {

        return this.lista[pos];
    }
}
