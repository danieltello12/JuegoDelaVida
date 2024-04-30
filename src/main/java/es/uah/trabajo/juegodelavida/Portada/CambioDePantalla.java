package es.uah.trabajo.juegodelavida.Portada;


import es.uah.trabajo.juegodelavida.CargarPartida.CargarPartidaControlador;
import es.uah.trabajo.juegodelavida.InicioSesionCP.InicioSesionControladorCP;
import es.uah.trabajo.juegodelavida.InicioSesionCP.InicioSesionModelCP;
import es.uah.trabajo.juegodelavida.InicioSesionCP.InicioSesionPropertiesCP;
import es.uah.trabajo.juegodelavida.InicioSesionNP.InicioSesionControladorNP;
import es.uah.trabajo.juegodelavida.InicioSesionNP.InicioSesionControladorNP;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class CambioDePantalla extends Pane  {

    public CambioDePantalla(int width, int height) throws FileNotFoundException {
        ImageView bg = new ImageView(new Image(new FileInputStream("C:\\Users\\UAH\\IdeaProjects\\JuegoDeLaVida\\Imagenes\\8-bit-graphics-pixels-scene-with-village.jpg"))
        );
        bg.setFitWidth(width);
        bg.setFitHeight(height);

        Rectangle masker = new Rectangle(1280, 720); //Creo un sub fondo inicialmente transparente que se vira cuando se haga la transición
        masker.setOpacity(0);
        masker.setMouseTransparent(true);

        Caja_Boton inicio= new Caja_Boton(500,75); //Inicializo el Vbox q contiene la imagen del boton y añadire el boton
        inicio.setTranslateX(400);
        inicio.setTranslateY(360);

        Boton itemNew = new Boton("Nueva Partida", 150);
        itemNew.setTranslateX(95); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
        itemNew.setTranslateY(0);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras
        itemNew.setOnAction(() -> { //Defino la ejecucion que se llevara acabo cuadno se pulse "Iniciar Juego"
            Stage stage = new Stage();
            FXMLLoader fxmlLoader= new FXMLLoader();
            File fichero= new File("C:\\Users\\UAH\\IdeaProjects\\JuegoDeLaVida\\src\\main\\resources\\es\\uah\\trabajo\\juegodelavida\\iniciosesionNP.fxml");
            URL url= null;
            try {
                url= fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);

            try {
                Scene scene = new Scene(fxmlLoader.load(), 450, 150);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                InicioSesionControladorNP p = fxmlLoader.getController(); //dame el controlador
                //p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        inicio.addItem(itemNew);
        Caja_Boton inicio2= new Caja_Boton(500,75); //Inicializo el Vbox q contiene la imagen del boton y añadire el boton
        inicio2.setTranslateX(400);
        inicio2.setTranslateY(480);

        Boton itemCargarPartida= new Boton("Cargar Partida", 150);
        itemCargarPartida.setTranslateX(95); //Posicion X respecto el cuadro donde se encuentra en la vbox letras
        itemCargarPartida.setTranslateY(0);//Posicion Y respecto el cuadro donde se encuentra en la vbox letras
        itemCargarPartida.setOnAction(() -> { //Defino la ejecucion que se llevara acabo cuadno se pulse "Iniciar Juego"
            Stage stage = new Stage();
            FXMLLoader fxmlLoader= new FXMLLoader();
            File fichero= new File("C:\\Users\\UAH\\IdeaProjects\\JuegoDeLaVida\\src\\main\\resources\\es\\uah\\trabajo\\juegodelavida\\iniciosesionCP.fxml");
            URL url= null;
            try {
                url= fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);

            try {
                Scene scene = new Scene(fxmlLoader.load(), 450, 150);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                InicioSesionControladorCP p = fxmlLoader.getController(); //dame el controlador

                p.loadUserData(new InicioSesionPropertiesCP(new InicioSesionModelCP())); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        inicio2.addItem(itemCargarPartida);


        getChildren().addAll(bg,inicio,inicio2);
    }

}