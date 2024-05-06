package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Botones extends StackPane {
    private static final Font font;

    static {
        try {
            font = Font.loadFont(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Fuentes/BebasNeue-Regular.ttf"), 50);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Botones(int width) {
        setAlignment(Pos.CENTER);
        Rectangle r = new Rectangle(width,width);
        r.setFill(Color.BLACK);
        r.setVisible(false);
        getChildren().addAll(r);
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
