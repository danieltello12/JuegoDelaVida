package es.uah.trabajo.juegodelavida.Portada;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Caja_Boton extends Pane {
    private VBox box;

    public Caja_Boton(int width, int height) throws FileNotFoundException {
        ImageView i= new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/imagen_2024-04-27_125603929-removebg-preview.png")));

        i.setFitWidth(500);
        i.setFitHeight(115);



        box = new VBox(5);
        box.setTranslateX(25);
        box.setTranslateY(25);


        getChildren().addAll(i, box);

    }

    public void addItems(Boton... items) {
        for (Boton item : items)
            addItem(item);
    }

    public void addItem(Boton item) {
        box.getChildren().addAll(item);
    }
}
