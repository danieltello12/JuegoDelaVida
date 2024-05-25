package es.uah.trabajo.juegodelavida.Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReproduccionTest {
    Reproduccion r= new Reproduccion(1,2,6,4);

    @Test
    void getIdIndividuoPadre1() {

        assertDoesNotThrow(()->r.setIdIndividuoPadre1(3));
        assertEquals(r.getIdIndividuoPadre1(),3);
    }

    @Test
    void setIdIndividuoPadre1() {
        assertDoesNotThrow(()->r.setIdIndividuoPadre1(3));
        assertEquals(r.getIdIndividuoPadre1(),3);
    }

    @Test
    void getIdIndividuoPadre2() {
        assertEquals(r.getIdIndividuoPadre2(),2);
    }

    @Test
    void setIdIndividuoPadre2() {
        assertDoesNotThrow(()->r.setIdIndividuoPadre2(3));
        assertEquals(r.getIdIndividuoPadre2(),3);
    }

    @Test
    void getIdIndividuoHijo() {
        assertEquals(r.getIdIndividuoHijo(),6);
    }

    @Test
    void setIdIndividuoHijo() {
        assertDoesNotThrow(()->r.setIdIndividuoHijo(23));
        assertEquals(r.getIdIndividuoHijo(),23);
    }

    @Test
    void getPaso() {
        assertEquals(r.getPaso(),4);
    }

}