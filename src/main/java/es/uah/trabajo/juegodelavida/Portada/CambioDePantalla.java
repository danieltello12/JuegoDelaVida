package es.uah.trabajo.juegodelavida.Portada;


import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CambioDePantalla extends Pane  {
    private Timeline timeline = new Timeline();

    public CambioDePantalla(int width, int height, Runnable action) throws FileNotFoundException {
        ImageView bg = new ImageView(new Image(new FileInputStream("C:\\Users\\UAH\\IdeaProjects\\JuegoDeLaVida\\Imagenes\\img.png"))
        );
        bg.setFitWidth(width);
        bg.setFitHeight(height);


        timeline.setOnFinished(e -> action.run());

        getChildren().addAll(bg);
    }
}