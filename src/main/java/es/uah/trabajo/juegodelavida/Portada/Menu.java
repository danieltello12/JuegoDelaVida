package es.uah.trabajo.juegodelavida.Portada;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu extends Pane {
    private VBox box;

    public Menu(int width, int height) throws FileNotFoundException {
        ImageView i= new ImageView(new Image(new FileInputStream("C:\\Users\\UAH\\IdeaProjects\\JuegoDeLaVida\\Imagenes\\imagen_2024-04-27_125603929-removebg-preview.png")));

        i.setFitWidth(500);
        i.setFitHeight(115);



        box = new VBox(5);
        box.setTranslateX(25);
        box.setTranslateY(25);


        getChildren().addAll(i, box);

    }

    public void addItems(ItemMenu... items) {
        for (ItemMenu item : items)
            addItem(item);
    }

    public void addItem(ItemMenu item) {
        box.getChildren().addAll(item);
    }
}
