package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.ColaAcciones.Cola;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Grafos.ElementoLDE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {
    Partida p= new Partida("test");

    @Test
    void getAcciones() {
        assertNull(p.getAcciones());
        Cola<String> c= new Cola();
        c.encolar(new ElementoLDE<>("test"));
        assertDoesNotThrow(()->p.setAcciones(c));
        assertEquals(p.getAcciones().getElemento(0).getDatos(),"test");
    }

    @Test
    void setAcciones() {
        assertNull(p.getAcciones());
        Cola<String> c= new Cola();
        c.encolar(new ElementoLDE<>("test"));
        assertDoesNotThrow(()->p.setAcciones(c));
        assertEquals(p.getAcciones().getElemento(0).getDatos(),"test");

    }

    @Test
    void getMejora() {
        assertDoesNotThrow(()->p.setMejora(12));
        assertEquals(p.mejora,12);
    }

    @Test
    void setMejora() {
        assertDoesNotThrow(()->p.setMejora(12));
        assertEquals(p.mejora,12);
    }

    @Test
    void getCbAgua() {
        assertDoesNotThrow(()->p.setCbAgua("12"));
        assertEquals(p.getCbAgua(),"12");
    }

    @Test
    void setCbAgua() {
        assertDoesNotThrow(()->p.setCbAgua("12"));
        assertEquals(p.getCbAgua(),"12");
    }

    @Test
    void getModAgua() {
        assertDoesNotThrow(()->p.setModAgua(12));
        assertEquals(p.getModAgua(),12);
    }

    @Test
    void setModAgua() {
        assertDoesNotThrow(()->p.setModAgua(12));
        assertEquals(p.getModAgua(),12);
    }

    @Test
    void isCkAgua() {
        assertFalse(p.isCkAgua());
        assertDoesNotThrow(()->p.setCkAgua(true));
        assertTrue(p.isCkAgua());
    }

    @Test
    void setCkAgua() {
        assertFalse(p.isCkAgua());
        assertDoesNotThrow(()->p.setCkAgua(true));
        assertTrue(p.isCkAgua());
    }

    @Test
    void getCbComida() {
        assertDoesNotThrow(()->p.setCbComida("12"));
        assertEquals(p.getCbComida(),"12");
    }

    @Test
    void setCbComida() {
        assertDoesNotThrow(()->p.setCbComida("12"));
        assertEquals(p.getCbComida(),"12");
    }

    @Test
    void getModComida() {
        assertDoesNotThrow(()->p.setModComida(12));
        assertEquals(p.getModComida(),12);
    }

    @Test
    void setModComida() {
        assertDoesNotThrow(()->p.setModComida(12));
        assertEquals(p.getModComida(),12);
    }

    @Test
    void isCkComida() {
        assertFalse(p.isCkComida());
        assertDoesNotThrow(()->p.setCkComida(true));
        assertTrue(p.isCkComida());
    }

    @Test
    void setCkComida() {
        assertFalse(p.isCkComida());
        assertDoesNotThrow(()->p.setCkComida(true));
        assertTrue(p.isCkComida());
    }

    @Test
    void getCbMontana() {
        assertDoesNotThrow(()->p.setCbMontana("12"));
        assertEquals(p.getCbMontana(),"12");
    }

    @Test
    void setCbMontana() {
        assertDoesNotThrow(()->p.setCbMontana("12"));
        assertEquals(p.getCbMontana(),"12");
    }

    @Test
    void getModMontana() {
        assertDoesNotThrow(()->p.setModMontana(12));
        assertEquals(p.getModMontana(),12);
    }

    @Test
    void setModMontana() {
        assertDoesNotThrow(()->p.setModMontana(12));
        assertEquals(p.getModMontana(),12);
    }

    @Test
    void isCkMontana() {
        assertFalse(p.isCkMontana());
        assertDoesNotThrow(()->p.setCkMontana(true));
        assertTrue(p.isCkMontana());
    }

    @Test
    void setCkMontana() {
        assertFalse(p.isCkMontana());
        assertDoesNotThrow(()->p.setCkMontana(true));
        assertTrue(p.isCkMontana());
    }

    @Test
    void getCbTesoro() {
        assertDoesNotThrow(()->p.setCbTesoro("12"));
        assertEquals(p.getCbTesoro(),"12");
    }

    @Test
    void setCbTesoro() {
        assertDoesNotThrow(()->p.setCbTesoro("12"));
        assertEquals(p.getCbTesoro(),"12");
    }

    @Test
    void getModTesoro() {
        assertDoesNotThrow(()->p.setModTesoro(12));
        assertEquals(p.getModTesoro(),12);
    }

    @Test
    void setModTesoro() {
        assertDoesNotThrow(()->p.setModTesoro(12));
        assertEquals(p.getModTesoro(),12);
    }

    @Test
    void isCkTesoro() {
        assertFalse(p.isCkTesoro());
        assertDoesNotThrow(()->p.setCkTesoro(true));
        assertTrue(p.isCkTesoro());
    }

    @Test
    void setCkTesoro() {
        assertFalse(p.isCkTesoro());
        assertDoesNotThrow(()->p.setCkTesoro(true));
        assertTrue(p.isCkTesoro());
    }

    @Test
    void getCbBiblio() {
        assertDoesNotThrow(()->p.setCbBiblio("12"));
        assertEquals(p.getCbBiblio(),"12");
    }

    @Test
    void setCbBiblio() {
        assertDoesNotThrow(()->p.setCbBiblio("12"));
        assertEquals(p.getCbBiblio(),"12");
    }

    @Test
    void getModBiblio() {
        assertDoesNotThrow(()->p.setModBiblio(12));
        assertEquals(p.getModBiblio(),12);
    }

    @Test
    void setModBiblio() {
        assertDoesNotThrow(()->p.setModBiblio(12));
        assertEquals(p.getModBiblio(),12);
    }

    @Test
    void isCkBiblio() {
        assertFalse(p.isCkBiblio());
        assertDoesNotThrow(()->p.setCkBiblio(true));
        assertTrue(p.isCkBiblio());
    }

    @Test
    void setCkBiblio() {
        assertFalse(p.isCkBiblio());
        assertDoesNotThrow(()->p.setCkBiblio(true));
        assertTrue(p.isCkBiblio());
    }

    @Test
    void getCbPozo() {
        assertDoesNotThrow(()->p.setCbPozo("12"));
        assertEquals(p.getCbPozo(),"12");
    }

    @Test
    void setCbPozo() {
        assertDoesNotThrow(()->p.setCbPozo("12"));
        assertEquals(p.getCbPozo(),"12");
    }

    @Test
    void getModPozo() {
        assertDoesNotThrow(()->p.setModPozo(12));
        assertEquals(p.getModPozo(),12);
    }

    @Test
    void setModPozo() {
        assertDoesNotThrow(()->p.setModPozo(12));
        assertEquals(p.getModPozo(),12);
    }

    @Test
    void isCkPozo() {
        assertDoesNotThrow(()->p.setCkPozo(true));
        assertTrue(p.isCkPozo());
    }

    @Test
    void setCkPozo() {
        assertDoesNotThrow(()->p.setCkPozo(true));
        assertTrue(p.isCkPozo());
    }

    @Test
    void setNombre() {
        assertDoesNotThrow(()->p.setNombre("test2"));
        assertEquals(p.getNombre(),"test2");
    }

    @Test
    void getPvA() {
        assertDoesNotThrow(()->p.setPvA(12));
        assertEquals(p.getPvA(),12);
    }

    @Test
    void setPvA() {
        assertDoesNotThrow(()->p.setPvA(12));
        assertEquals(p.getPvA(),12);
    }

    @Test
    void getPvC() {
        assertDoesNotThrow(()->p.setPvC(12));
        assertEquals(p.getPvC(),12);
    }

    @Test
    void setPvC() {
        assertDoesNotThrow(()->p.setPvC(12));
        assertEquals(p.getPvC(),12);
    }

    @Test
    void getPvM() {
        assertDoesNotThrow(()->p.setPvM(12));
        assertEquals(p.getPvM(),12);
    }

    @Test
    void setPvM() {
        assertDoesNotThrow(()->p.setPvM(12));
        assertEquals(p.getPvM(),12);
    }

    @Test
    void getPvT() {
        assertDoesNotThrow(()->p.setPvT(12));
        assertEquals(p.getPvT(),12);
    }

    @Test
    void setPvT() {
        assertDoesNotThrow(()->p.setPvT(12));
        assertEquals(p.getPvT(),12);
    }

    @Test
    void getPvB() {
        assertDoesNotThrow(()->p.setPvB(12));
        assertEquals(p.getPvB(),12);
    }

    @Test
    void setPvB() {
        assertDoesNotThrow(()->p.setPvB(12));
        assertEquals(p.getPvB(),12);
    }

    @Test
    void getPvP() {
        assertDoesNotThrow(()->p.setPvP(12));
        assertEquals(p.getPvP(),12);
    }

    @Test
    void setPvP() {
        assertDoesNotThrow(()->p.setPvP(12));
        assertEquals(p.getPvP(),12);
    }

    @Test
    void getPz() {
        assertDoesNotThrow(()->p.setPz(12));
        assertEquals(p.getPz(),12);
    }

    @Test
    void setPz() {
        assertDoesNotThrow(()->p.setPz(12));
        assertEquals(p.getPz(),12);
    }

    @Test
    void getTiemposvida() {
        assertDoesNotThrow(()->p.setTiemposvida(23));
        assertEquals(p.getTiemposvida(),23);
    }

    @Test
    void setTiemposvida() {
        assertDoesNotThrow(()->p.setTiemposvida(23));
        assertEquals(p.getTiemposvida(),23);
    }

    @Test
    void getTurnosvida() {
        assertDoesNotThrow(()->p.setTurnosvida(23));
        assertEquals(p.getTurnosvida(),23);
    }

    @Test
    void setTurnosvida() {
        assertDoesNotThrow(()->p.setTurnosvida(23));
        assertEquals(p.getTurnosvida(),23);
    }

    @Test
    void getNombre() {
        assertDoesNotThrow(()->p.setNombre("hd"));
        assertEquals(p.getNombre(),"hd");
    }

    @Test
    void getFilas() {
        assertDoesNotThrow(()->p.setFilas(3));
        assertEquals(p.getFilas(),3);
    }

    @Test
    void setFilas() {
        assertDoesNotThrow(()->p.setFilas(3));
        assertEquals(p.getFilas(),3);
    }

    @Test
    void getColumnas() {
        assertDoesNotThrow(()->p.setColumnas(23));
        assertEquals(p.getColumnas(),23);
    }

    @Test
    void setColumnas() {
        assertDoesNotThrow(()->p.setColumnas(23));
        assertEquals(p.getColumnas(),23);
    }

    @Test
    void getIndividuos() {
        assertNull(p.getIndividuos());
        ListaELementos l= new ListaELementos();
        l.add(new Invidiuos(3,5,5,6,7,7));
        p.setIndividuos(l);
        assertEquals(p.getIndividuos().getNumeroElementos(),1);
    }

    @Test
    void setIndividuos() {
        assertNull(p.getIndividuos());
        ListaELementos l= new ListaELementos();
        l.add(new Invidiuos(3,5,5,6,7,7));
        p.setIndividuos(l);
        assertEquals(p.getIndividuos().getNumeroElementos(),1);
    }

    @Test
    void getRecursos() {
        assertNull(p.getIndividuos());
        ListaRecursos l= new ListaRecursos();
        l.add(new Recursos(3,5,5,6,7,"e",3,true,"YUF",3,true,"R",4,true,"e",5,true,"E",6,true,"e",6,true));
        p.setRecursos(l);
        assertEquals(p.getRecursos().getNumeroElementos(),1);
    }

    @Test
    void setRecursos() {
        assertNull(p.getIndividuos());
        ListaRecursos l= new ListaRecursos();
        l.add(new Recursos(3,5,5,6,7,"e",3,true,"YUF",3,true,"R",4,true,"e",5,true,"E",6,true,"e",6,true));
        p.setRecursos(l);
        assertEquals(p.getRecursos().getNumeroElementos(),1);
    }
}