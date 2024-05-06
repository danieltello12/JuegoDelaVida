package es.uah.trabajo.juegodelavida.CargarPartida;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.Usuario;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CargarPartida extends Pane {
    static final int max_partidas = 5;
    public CargarPartida(Usuario u,int width,int height) throws FileNotFoundException {
        ListaLEPA l = new ListaLEPA();
        l = l.cargar(u.getNombre());
        u.setPartidas(l);
        if(u.getPartidas().isVacia()){
            ImageView bg = new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Nopartidas.PNG"))
            );
            bg.setFitWidth(width);
            bg.setFitHeight(height);
            getChildren().addAll(bg);

        }
        else {
            ImageView bg = new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/FondoPortada.png"))
            );
            bg.setFitWidth(width);
            bg.setFitHeight(height);
            getChildren().addAll(bg);

            for (int i = 0; i < u.getPartidas().getNumeroElementos(); i++) {
                CajasBotones inicio = new CajasBotones(500, 75);
                inicio.setTranslateX(400);
                inicio.setTranslateY(200 + (120 * i));

                Botones itemNew = new Botones(u.getPartidas().getElemento(i).getDatos().getNombre(), 150);
                itemNew.setTranslateX(95); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
                itemNew.setTranslateY(0);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras

                inicio.addItem(itemNew);
                getChildren().addAll(inicio);


            }
        }


    }
}
