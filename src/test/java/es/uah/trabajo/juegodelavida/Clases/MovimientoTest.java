package es.uah.trabajo.juegodelavida.Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovimientoTest {
    Movimiento m= new Movimiento(4,5,6);

    @Test
    void getIdIndividuo() {
        assertEquals(m.getIdIndividuo(),6);
    }

    @Test
    void setIdIndividuo() {
        assertDoesNotThrow(()->m.setIdIndividuo(12));
        assertEquals(m.getIdIndividuo(),12);
    }

    @Test
    void getIdMovimiento() {
        assertDoesNotThrow(()->m.setIdMovimiento(12));
        assertEquals(m.getIdMovimiento(),12);
    }

    @Test
    void setIdMovimiento() {
        assertDoesNotThrow(()->m.setIdMovimiento(12));
        assertEquals(m.getIdMovimiento(),12);
    }

    @Test
    void getX() {
        assertEquals(m.getX(),4);

    }

    @Test
    void setX() {
        assertDoesNotThrow(()->m.setX(12));
        assertEquals(m.getX(),12);
    }

    @Test
    void getY() {
        assertEquals(m.getY(),5);
    }

    @Test
    void setY() {
        assertDoesNotThrow(()->m.setY(12));
        assertEquals(m.getY(),12);
    }
}