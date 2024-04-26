package es.uah.trabajo.juegodelavida.Portada;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Menu extends Pane {
    private VBox box;

    public Menu(int width, int height) {

        Rectangle bg = new Rectangle(width, height);
        bg.setFill(Colores.MENU_BG);
        bg.setOpacity(5);


        box = new VBox(5);
        box.setTranslateX(25);
        box.setTranslateY(25);


        getChildren().addAll(bg, box);

    }

    public void addItems(ItemMenu... items) {
        for (ItemMenu item : items)
            addItem(item);
    }

    public void addItem(ItemMenu item) {
        box.getChildren().addAll(item);
    }
}
