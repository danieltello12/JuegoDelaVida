package es.uah.trabajo.juegodelavida.Clases;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {
    Usuario u= new Usuario("Dani","hola");

    @Test
    void getNombre() {
        assertEquals(u.getNombre(),"Dani");
    }

    @Test
    void setNombre() {
        assertDoesNotThrow(()->u.setNombre("test"));
        assertEquals(u.getNombre(),"test");
    }

    @Test
    void getContraseña() {
        assertEquals(u.getContraseña(),"hola");
    }

    @Test
    void setContraseña() {
        assertDoesNotThrow(()->u.setContraseña("test"));
        assertEquals(u.getContraseña(),"test");
    }

    @Test
    void getPartidas() {
        assertDoesNotThrow(()->u.setPartidas(new ListaLEPA()));
        assertEquals(u.getPartidas().getNumeroElementos(),0);
    }

    @Test
    void setPartidas() {
        assertDoesNotThrow(()->u.setPartidas(new ListaLEPA()));
        assertEquals(u.getPartidas().getNumeroElementos(),0);
    }

    @Test
    void setPartida() {
        assertDoesNotThrow(()->u.setPartidas(new ListaLEPA()));
        assertEquals(u.getPartidas().getNumeroElementos(),0);
        assertDoesNotThrow(()->u.setPartida(new Partida("test")));
        assertEquals(u.getPartidas().getNumeroElementos(),1);
    }

}