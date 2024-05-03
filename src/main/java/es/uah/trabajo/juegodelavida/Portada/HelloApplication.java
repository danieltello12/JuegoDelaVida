package es.uah.trabajo.juegodelavida.Portada;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HelloApplication extends Application {
    private Parent createContent() throws FileNotFoundException {
        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/8-bit-graphics-pixels-scene-with-village.jpg"));
        ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
        imageView.setFitWidth(1280);
        imageView.setFitHeight(720);

        Rectangle masker = new Rectangle(1280, 720); //Creo un sub fondo inicialmente transparente que se vira cuando se haga la transición
        masker.setOpacity(0);
        masker.setMouseTransparent(true);

        Caja_Boton inicio = new Caja_Boton(500, 75); //Inicializo el Vbox q contiene la imagen del boton y añadire el boton
        inicio.setTranslateX(400);
        inicio.setTranslateY(475);

        Boton itemNew = new Boton("INICIAR JUEGO", 150);
        itemNew.setTranslateX(95); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
        itemNew.setTranslateY(0);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras
        itemNew.setOnAction(() -> { //Defino la ejecucion que se llevara acabo cuadno se pulse "Iniciar Juego"
            FadeTransition ft = new FadeTransition(Duration.seconds(1.5), masker);
            ft.setToValue(1);

            ft.setOnFinished(e -> {
                try {
                    root.getChildren().setAll(new CambioDePantalla(1280, 720));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });

            ft.play();
        });
        inicio.addItem(itemNew); //Añado el item al box
        root.getChildren().addAll(imageView, inicio, masker); //Añado el fondo, el fondo de la transición y el box al pane

        /**  Menu menuBox = new Menu(250, 350);
         menuBox.setTranslateX(250);
         menuBox.setTranslateY(230);

         Menu menuBox2 = new Menu(510, 350);
         menuBox2.setTranslateX(250 + 20 + 250);
         menuBox2.setTranslateY(230);

         menuBox.addItem(new ItemMenu("CONTINUE", 250));

         ItemMenu itemNew = new ItemMenu("NEW", 250);
         itemNew.setOnAction(() -> {
         FadeTransition ft = new FadeTransition(Duration.seconds(1.5), masker);
         ft.setToValue(1);

         ft.setOnFinished(e -> {
         try {
         root.getChildren().setAll(new CambioDePantalla(1280, 720, () -> {
         masker.setOpacity(0);
         root.getChildren().setAll(imageView, menuBox, menuBox2, masker);
         }));
         } catch (FileNotFoundException ex) {
         throw new RuntimeException(ex);
         }
         });

         ft.play();
         });
         menuBox.addItem(itemNew);
         menuBox.addItem(new ItemMenu("LOAD", 250));

         ItemMenu itemSettings = new ItemMenu("SETTINGS", 250);
         itemSettings.setOnAction(() -> {
         menuBox2.addItems(
         new ItemMenu("GAMEPLAY", 510),
         new ItemMenu("CONTROLS", 510),
         new ItemMenu("DISPLAY", 510),
         new ItemMenu("AUDIO", 510));
         });

         menuBox.addItem(itemSettings);
         menuBox.addItem(new ItemMenu("CREW", 250));

         ItemMenu itemExit = new ItemMenu("EXIT", 250);
         itemExit.setOnAction(() -> System.exit(0));
         menuBox.addItem(itemExit);

         root.getChildren().addAll(imageView, menuBox, menuBox2, masker);**/
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Juego de La Vida de Conway");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
