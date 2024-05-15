package es.uah.trabajo.juegodelavida.CargarPartida;

import javafx.animation.FillTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CajasBotones extends Pane {
    private VBox box;

    public CajasBotones(int width, int height) throws FileNotFoundException {
        ImageView i= new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Boton.png")));

        i.setFitWidth(width);
        i.setFitHeight(height);



        box = new VBox(5);
        box.setTranslateX(25);
        box.setTranslateY(25);


        getChildren().addAll(i, box);

    }

    public void addItems(Botones... items) {
        for (Botones item : items)
            addItem(item);
    }

    public void addItem(Botones item) {
        box.getChildren().addAll(item);
    }
    public void setOnAction(Runnable action) {
        setOnMouseClicked(e -> {
            FillTransition ft = new FillTransition(Duration.seconds(0.45),
                    Color.WHITE, Color.WHITE);
            ft.setOnFinished(e2 -> action.run());
            ft.play();
        });
    }
}


