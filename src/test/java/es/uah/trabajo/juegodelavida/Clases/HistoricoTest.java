package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoTest {
    Historico h= new Historico(new ListaELementos<>(),3);
    @Test
    void getPaso() {
        assertEquals(h.getPaso(),3);

    }

    @Test
    void setPaso() {
        assertDoesNotThrow(()->h.setPaso(32));
        assertEquals(h.getPaso(),32);
    }

    @Test
    void getIndividuos() {
        assertEquals(h.getIndividuos().getNumeroElementos(),0);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,4,4,4,4));
        assertDoesNotThrow(()->h.setIndividuos(l));
        assertEquals(h.getIndividuos().getNumeroElementos(),1);
    }

    @Test
    void setIndividuos() {
        assertEquals(h.getIndividuos().getNumeroElementos(),0);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,4,4,4,4));
        assertDoesNotThrow(()->h.setIndividuos(l));
        assertEquals(h.getIndividuos().getNumeroElementos(),1);
    }

    @Test
    void existeEnHistorico() {
        assertEquals(h.getIndividuos().getNumeroElementos(),0);
        ListaELementos l= new ListaELementos<>();
        l.add(new Invidiuos(2,3,4,4,4,4));
        assertDoesNotThrow(()->h.setIndividuos(l));
        assertFalse(h.existeEnHistorico(new Invidiuos(2,1,8,5,5,5)));
        assertEquals(h.getIndividuos().getNumeroElementos(),1);
        assertTrue(h.existeEnHistorico(new Invidiuos(2,3,4,4,4,4)));
    }

    @Test
    void añadirHistorico() {
        assertEquals(h.getIndividuos().getNumeroElementos(),0);
        h.añadirHistorico(new Invidiuos(2,3,4,4,4,4));
        h=h.cargar();
        assertFalse(h.existeEnHistorico(new Invidiuos(2,1,5,5,5,5)));
        assertEquals(h.getIndividuos().getNumeroElementos(),1);
        assertTrue(h.existeEnHistorico(new Invidiuos(2,3,4,4,4,4)));
    }

    @Test
    void limpiar() {
        assertEquals(h.getIndividuos().getNumeroElementos(),0);
        assertDoesNotThrow(()->h.añadirHistorico(new Invidiuos(2,3,4,4,4,4)));
        assertFalse(h.existeEnHistorico(new Invidiuos(2,1,4,5,5,5)));
        assertEquals(h.getIndividuos().getNumeroElementos(),1);
        assertTrue(h.existeEnHistorico(new Invidiuos(2,3,5,4,4,4)));
        assertDoesNotThrow(()->h.limpiar());
        assertTrue(h.existeEnHistorico(new Invidiuos(2,3,4,4,4,4)));
    }

}