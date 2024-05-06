package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Box extends Pane {
    private VBox box;
    private Circle selection;
    private DropShadow shadow;

    public Box(int width, int height,String fondo) throws FileNotFoundException {
        if(fondo!=null) {
            ImageView bg = new ImageView(new Image(new FileInputStream(fondo)));
            bg.setFitWidth(width);
            bg.setFitHeight(height);
            getChildren().addAll(bg);
        }



        box = new VBox(5);
        box.setTranslateX(25);
        box.setTranslateY(25);


        getChildren().addAll(box);
    }






    public void addItem(Botones item) {
        box.getChildren().addAll(item);
    }
}


