package es.uah.trabajo.juegodelavida.CargarPartida;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.Usuario;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

public class Borrar_Partida extends Pane {

    public  Borrar_Partida(Usuario u, int width, int height) throws FileNotFoundException {
        ListaLEPA l = new ListaLEPA();
        l = l.cargar(u.getNombre());
        u.setPartidas(l);

        ImageView bg = new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/FondoPortada.png"))
        );

        bg.setFitWidth(width);
        bg.setFitHeight(height);
        getChildren().addAll(bg);


        for (AtomicInteger i = new AtomicInteger(); i.get() < u.getPartidas().getNumeroElementos(); i.getAndIncrement()) {
            CajasBotones inicio = new CajasBotones(500, 115);
            if(i.get() <6) {
                inicio.setTranslateX(400);
                inicio.setTranslateY(50 + (120 * i.get()));
            }
            if(i.get() >6){
                int j= i.get() -6;
                inicio.setTranslateX(800);
                inicio.setTranslateY(50 + (120 * j));
            }

            Botones itemNew = new Botones(u.getPartidas().getElemento(i.get()).getDatos().getNombre(), 150);
            itemNew.setTranslateX(95); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
            itemNew.setTranslateY(0);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras
            int finalI1 = i.get();
            itemNew.setOnAction(()->{
                u.getPartidas().del(finalI1);
                u.getPartidas().guardar(u.getNombre());

                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = null;
                try {
                    imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Anadir.PNG"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(400);
                imageView.setFitHeight(75);
                root.getChildren().addAll(imageView);

                Scene im = new Scene(root);
                Stage s2= new Stage();
                s2.setScene(im);
                s2.setTitle("Borrar Partida: Juego de La Vida de Conway");
                s2.show();
                this.getChildren().removeAll(inicio);
                i.set(i.get() - 1);
            });


            inicio.addItem(itemNew);
            getChildren().addAll(inicio);


        }
    }
    }

