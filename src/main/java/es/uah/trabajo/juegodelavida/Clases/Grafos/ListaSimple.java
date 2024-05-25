package es.uah.trabajo.juegodelavida.Clases.Grafos;

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
        boolean encontrado=false;
        while (pos < maximo) {
            if (this.lista[pos].getDato() == el.getDato()) {
                encontrado=true;
                break;
            }
            pos++;
        }
        if (!encontrado)
            pos=-1;
        return pos;
    }

    public ElementoLS getPrimero() {
        return this.lista[0];

    }

    public ElementoLS getUltimo() {
        return this.lista[this.getNumeroElementos() - 1];

    }

    public ElementoLS getElemento(int pos) {

        return this.lista[pos];
    }
}
