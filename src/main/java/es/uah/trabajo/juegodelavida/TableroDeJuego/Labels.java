package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Labels extends StackPane {
    private static final Font font;

    static {
        try {
            font = Font.loadFont(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Fuentes/BebasNeue-Regular.ttf"), 50);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Text text;

    public Labels(String name) {
        setAlignment(Pos.CENTER);

        text = new Text(name);
        text.setTranslateX(5);
        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);



        getChildren().addAll( text);

    }
}