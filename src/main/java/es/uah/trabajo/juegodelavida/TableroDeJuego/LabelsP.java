package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LabelsP extends StackPane {
    private static final Font font;

    static {
        try {
            font = Font.loadFont(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Fuentes/BebasNeue-Regular.ttf"), 50);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Text text;

    public LabelsP(String name) {
        setAlignment(Pos.CENTER);

        text = new Text(name);
        text.setTranslateX(5);
        text.setStyle("-fx-text-alignment: center; -fx-font-size: 16px;-fx-font-weight: bold");


        getChildren().addAll( text);

    }
}