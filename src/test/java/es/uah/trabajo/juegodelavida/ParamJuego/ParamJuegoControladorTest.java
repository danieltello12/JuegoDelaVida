package es.uah.trabajo.juegodelavida.ParamJuego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParamJuegoControladorTest {
    @Test
    void restablecerind() {
        ParamJuegoControlador p= new ParamJuegoControlador();
        p.setModel(new ParamJuegoProperties(new ParamJuegoModel()));
        p.getmodel().original.setFilaIndv("1");
        p.getmodel().original.setIdentificador("12");

        assertEquals(p.getmodel().original.getFilaIndv(),"1");
        assertEquals(p.getmodel().original.getIdentificador(),"12");
        assertDoesNotThrow(()->p.restablecerind());

        assertEquals(p.getmodel().original.getFilaIndv(),"");
        assertEquals(p.getmodel().original.getIdentificador(),"");

    }

    @Test
    void restablecerrec() {
        ParamJuegoControlador p= new ParamJuegoControlador();
        p.setModel(new ParamJuegoProperties(new ParamJuegoModel()));
        p.getmodel().original.setFilarec("1");

        assertEquals(p.getmodel().original.getFilarec(),"1");
        assertDoesNotThrow(()->p.restablecerrec());

        assertEquals(p.getmodel().original.getFilarec(),"");
    }

}