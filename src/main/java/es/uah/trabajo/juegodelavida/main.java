package es.uah.trabajo.juegodelavida;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Clases.Usuario;

public class main{
    public static void main(String[] args) {
        Partida p= new Partida("1");
        Partida p2= new Partida("2");
        Usuario u= new Usuario("p","p");
        ListaLEPA<Partida> l= new ListaLEPA<Partida>();
        l.add(p);
        l.add(p2);
        u.guardar();
        u.setPartidas(l);
        u.getPartidas().guardar(u.getNombre());

    }
}
