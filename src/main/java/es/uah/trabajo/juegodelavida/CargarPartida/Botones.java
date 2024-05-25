package es.uah.trabajo.juegodelavida.CargarPartida;

import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

    private Text text;
    private Rectangle selection;
    private DropShadow shadow;
    public Botones(String name){
        setAlignment(Pos.CENTER);

        text = new Text(name);
        text.setTranslateX(5);
        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);
        getChildren().addAll(text);
    }


    public Botones(String name, int width) {
        setAlignment(Pos.CENTER);

        text = new Text(name);
        text.setTranslateX(5);
        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);

        shadow = new DropShadow(5, Color.BLACK);
        text.setEffect(shadow);

        selection = new Rectangle(width+70 , 55);
        selection.setFill(Color.WHITE);
        selection.setStroke(Color.BLACK);
        selection.setVisible(false);
        selection.setTranslateX(5);

        GaussianBlur blur = new GaussianBlur(8);
        selection.setEffect(blur);

        getChildren().addAll(selection, text);

        setOnMouseEntered(e -> {
            onSelect();
        });

        setOnMouseExited(e -> {
            onDeselect();
        });

        setOnMousePressed(e -> {
            text.setFill(Color.FORESTGREEN);
        });
    }

    private void onSelect() {
        text.setFill(Color.BLACK);
        selection.setVisible(true);

        shadow.setRadius(1);
    }

    private void onDeselect() {
        text.setFill(Color.WHITE);
        selection.setVisible(false);

        shadow.setRadius(5);
    }

    public void setOnAction(Runnable action) {
        setOnMouseClicked(e -> {
            FillTransition ft = new FillTransition(Duration.seconds(0.45), selection,
                    Color.WHITE, Color.WHITE);
            ft.setOnFinished(e2 -> action.run());
            ft.play();
        });
    }
}
