package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TableroDeJuegoControlador {
    @FXML
    private Label welcomeText;

    @FXML
    private GridPane tableroDeJuego;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Cargando el tablero de juego");

        // Mismo bucle que en el ejemplo de MainGridApplication
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                VBox vbox=new VBox();
                vbox.getChildren().add(new Button("Recurso 1"));
                vbox.getChildren().add(new Button("Recurso 2"));
                vbox.getChildren().add(new Button("Recurso 3"));
                vbox.getChildren().add(new Button("Individuo"));
                Label placeholder = new Label("Celda " + i + "," + j);
                placeholder.setMinSize(30, 30); // Tamaño mínimo para visualización
                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
                tableroDeJuego.add(placeholder, i, j);
            }
        }
    }
}
