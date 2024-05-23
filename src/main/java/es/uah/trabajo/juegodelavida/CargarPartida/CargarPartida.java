package es.uah.trabajo.juegodelavida.CargarPartida;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.ColaAcciones.Cola;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLEMov;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLERepr;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Movimiento;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Clases.Reproduccion;
import es.uah.trabajo.juegodelavida.Clases.Usuario;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Tablero;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CargarPartida extends Pane {
    Stage stagePadre;

    public CargarPartida(Usuario u, int width, int height, Stage s) throws FileNotFoundException {
        stagePadre = s;
        ListaLEPA l = new ListaLEPA();
        l = l.cargar(u.getNombre());
        u.setPartidas(l);
        if (u.getPartidas().isVacia()) {
            ImageView bg = new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Nopartidas.PNG"))
            );
            bg.setFitWidth(width);
            bg.setFitHeight(height);
            getChildren().addAll(bg);

        } else {
            ImageView bg = new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/FondoPortada.png"))
            );

            bg.setFitWidth(width);
            bg.setFitHeight(height);
            getChildren().addAll(bg);

            ListaLEPA l2;
            l2 = u.getPartidas();
            if (l2.getNumeroElementos() > 5) {
                while (l2.getNumeroElementos() > 5) {
                    int i = l2.getNumeroElementos();
                    l2.del(i - 1);
                }
            }

            for (int i = 0; i < l2.getNumeroElementos(); i++) {
                CajasBotones inicio = new CajasBotones(500, 115);
                inicio.setTranslateX(400);
                inicio.setTranslateY(50 + (120 * i));

                Botones itemNew = new Botones(u.getPartidas().getElemento(i).getDatos().getNombre(), 150);
                itemNew.setTranslateX(95); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
                itemNew.setTranslateY(0);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras
                int finalI = i;
                itemNew.setOnAction(() -> {
                    Stage stage = new Stage();
                    Partida p = u.getPartidas().getElemento(finalI).getDatos();

                    ListaELementos L = new ListaELementos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
                    L.vaciar();
                    L = p.getIndividuos();
                    L.guardar(L, "src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");

                    ListaRecursos lrec = new ListaRecursos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
                    lrec.vaciar();
                    lrec = p.getRecursos();
                    lrec.guardar(lrec, "src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

                    ListaLEMov<Movimiento> movimientos = new ListaLEMov<Movimiento>();
                    movimientos.vaciar();
                    movimientos.guardar(movimientos);

                    Cola Acciones= new Cola<>().cargar();
                    Acciones.vaciar();
                    Acciones.guardar(Acciones);

                    ListaLERepr<Reproduccion> reproducciones = new ListaLERepr<Reproduccion>();
                    reproducciones.vaciar();
                    reproducciones.guardar(reproducciones);
                    try {

                        stage.setTitle("!!Juego de La Vida de Conway");
                        Scene scene = new Scene(new Tablero().Tablero(p, u.getNombre(),s), 1400, 800);
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                CajasBotones caja = new CajasBotones(200, 70);
                caja.setTranslateX(1000);
                caja.setTranslateY(80);

                Botones itemBorrar = new Botones("Borrar", 70);
                itemBorrar.setTranslateX(0); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
                itemBorrar.setTranslateY(-17);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras
                itemBorrar.setOnAction(() -> {
                    s.close();
                    Stage stage = new Stage();
                    try {
                        Scene scene = new Scene(new Borrar_Partida(u, width, height), width, height);
                        stage.setTitle("Juego de La Vida de Conway");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                caja.addItem(itemBorrar);


                inicio.addItem(itemNew);
                getChildren().addAll(inicio, caja);


            }
        }


    }
}
