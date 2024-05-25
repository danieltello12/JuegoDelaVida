package es.uah.trabajo.juegodelavida.Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaUsuariosTest {
    ListaUsuarios l= new ListaUsuarios();

    @Test
    void añadirusuario() {
        assertDoesNotThrow(()->l.añadirusuario(new Usuario("Dani","hola")));
        assertEquals(l.getusuario("Dani").getContraseña(),"hola");
    }


    @Test
    void esta() {
        assertDoesNotThrow(()->l.añadirusuario(new Usuario("Dani","hola")));
        assertEquals(l.getusuario("Dani").getContraseña(),"hola");
        assertEquals(l.esta("Dani","hola"),2);
    }

    @Test
    void yacreado() {
        assertDoesNotThrow(()->l.añadirusuario(new Usuario("Dani","hola")));
        assertEquals(l.getusuario("Dani").getContraseña(),"hola");
       assertTrue(l.yacreado("Dani"));
    }

    @Test
    void getusuario() {
        assertDoesNotThrow(()->l.añadirusuario(new Usuario("Dani","hola")));
        assertEquals(l.getusuario("Dani").getContraseña(),"hola");
        assertTrue(l.yacreado("Dani"));
    }


}