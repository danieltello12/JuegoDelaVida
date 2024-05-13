package es.uah.trabajo.juegodelavida;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Básico;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;

public class main{
    public static void main(String[] args) {
      /**  Partida p= new Partida("1");
        Partida p2= new Partida("2");
        Usuario u= new Usuario("p","p");
        ListaLEPA<Partida> l= new ListaLEPA<Partida>();
        l.add(p);
        l.add(p2);
        u.guardar();
        u.setPartidas(l);
        u.getPartidas().guardar(u.getNombre());
        //hAKJGFAEIJFHWEKALF
       */
        ListaELementos l= new ListaELementos();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Básico b = new Básico(5,6,7,8,5,4);

        l.add(b);
        l.guardar(l,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");

    }
}
