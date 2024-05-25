package es.uah.trabajo.juegodelavida.BucleControl;

import es.uah.trabajo.juegodelavida.Clases.ColaAcciones.Cola;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLEINT;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucleTest {
    Bucle b= new Bucle();

    @Test
    void muertes() {
        Partida p= new Partida("Dani");
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,1,4,0,5));
        p.setIndividuos(l);
        assertDoesNotThrow(()->b.muertes(p));
        assertEquals(p.getIndividuos().getNumeroElementos(),0);
    }

    @Test
    void nuevosrecursos() {
        Partida p= new Partida("Dani");
        ListaRecursos l= new ListaRecursos();
        p.setRecursos(l);
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        assertDoesNotThrow(()->b.nuevosrecursos(p));
        assertEquals(p.getRecursos().getNumeroElementos(),1);
    }

    @Test
    void ordenar() {
        ListaLEINT l= new ListaLEINT();
        l.add(2);
        l.add(3);
        l.add(5);
        l.add(7);
        l.add(8);
        assertEquals(l.getElemento(0).getDatos(),8);

    }

    @Test
    void duplicaRecursos() {
        Partida p= new Partida("Dani");
        ListaRecursos l= new ListaRecursos();
        p.setRecursos(l);
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        assertDoesNotThrow(()->b.nuevosrecursos(p));
        assertEquals(b.duplicaRecursos(p.getRecursos()).getElemento(0).getDatos().getTipo(),p.getRecursos().getElemento(0).getDatos().getTipo());

    }

    @Test
    void duplicaIndividuos() {
        Partida p= new Partida("Dani");
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,1,4,0,5));
        p.setIndividuos(l);
        assertEquals(b.duplicaIndividuos(p.getIndividuos()).getElemento(0).getDatos().getId(),p.getIndividuos().getElemento(0).getDatos().getId());

    }

    @Test
    void dameMaxIdIndividuo() {
        Partida p= new Partida("Dani");
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,1,4,0,5));
        p.setIndividuos(l);
        assertEquals(b.dameMaxIdIndividuo(p,new Invidiuos(2,4,566,5,5,5)),1);
    }

    @Test
    void dameMaxIdHijo() {
        Partida p= new Partida("Dani");
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,1,4,0,5));
        p.setIndividuos(l);
        assertEquals(b.dameMaxIdHijo(new Invidiuos(2,4,566,5,5,5)),0);

    }

    @Test
    void existeHijo() {
        Partida p= new Partida("Dani");
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,1,4,0,5));
        p.setIndividuos(l);
        assertEquals(b.existeHijo(p.getIndividuos().getElemento(0).getDatos(),new Invidiuos(2,4,566,5,5,5),4),false);

    }

    @Test
    void existeIndividuo() {
        Partida p= new Partida("Dani");
        p.setPz(1);
        p.setFilas(1);
        p.setColumnas(1);
        p.setPvA(1);
        p.setAcciones(new Cola());
        b.setPartida(p);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,1,4,0,5));
        p.setIndividuos(l);
        assertTrue(b.existeIndividuo(p,new Invidiuos(2,3,1,4,0,5)));
        assertFalse(b.existeIndividuo(p,new Invidiuos(2,3,5,4,0,5)));

    }
}