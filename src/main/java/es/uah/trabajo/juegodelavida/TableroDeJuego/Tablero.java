package es.uah.trabajo.juegodelavida.TableroDeJuego;

import es.uah.trabajo.juegodelavida.ParamJuego.ParamJuegoControlador;
import es.uah.trabajo.juegodelavida.Portada.Boton;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class Tablero {
    public static Parent setTablero(int filas,int columnas) throws FileNotFoundException {
        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/FondoPortada.png"));
        ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
        imageView.setFitWidth(1450);
        imageView.setFitHeight(800);


        GridPane mainGrid = new GridPane();
        // mainGrid.setStyle("-fx-border-color: red;");
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);
        mainGrid.setGridLinesVisible(true);
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(0, 0, 0, 0));


        Box caja_info= new Box(300,640,null);
        caja_info.setTranslateX(960);
        caja_info.setTranslateY(100);

        Rectangle r= new Rectangle(300,640);
        r.setOpacity(5);
        r.setFill(Color.FORESTGREEN);
        r.setVisible(false);

        Boton botonsalir= new Boton("Cerrar",50);
        botonsalir.setOnAction(()->{
            r.setVisible(false);
            caja_info.getChildren().removeAll(botonsalir);
        });

        for (int i = 0;i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                // Aquí podrías instanciar tu clase de celda, más compleja
                GridPane secondaryGrid = new GridPane();
                Label rBiblioteca=new Label();
                rBiblioteca.setPrefSize(32,32);
                rBiblioteca.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rTesoro=new Label();
                rTesoro.setPrefSize(32,32);
                rTesoro.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rPozo=new Label();
                rPozo.setPrefSize(32,32);
                rPozo.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rAgua=new Label();
                rAgua.setPrefSize(32,32);
                rAgua.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rMontana=new Label();
                rMontana.setPrefSize(32,32);
                rMontana.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rComida=new Label();
                rComida.setPrefSize(32,32);
                rComida.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label iIndividuo=new Label("I");
                iIndividuo.setPrefSize(32,32);
                iIndividuo.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: right;");
                iIndividuo.setAlignment(Pos.CENTER);
                secondaryGrid.add(rAgua,0,0);
                secondaryGrid.add(rMontana,0,1);
                secondaryGrid.add(rComida,1,0);
                secondaryGrid.add(iIndividuo,1,1);

                //mainGrid.add(addVBox(), i, j);
                mainGrid.add(secondaryGrid, i, j);
                Botones boton=new Botones(64);
                boton.setStyle("-fx-background-color: transparent;-fx-border-color: black");
                boton.setOnAction(()->{
                    r.setVisible(true);
                    caja_info.getChildren().add(botonsalir);
                });

                mainGrid.add(boton,i,j);




            }
        }
        caja_info.getChildren().add(r);

        Box b= new Box(100,80,"src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Boton_Parar.png");
        b.setTranslateY(10);
        b.setTranslateX(250);

        Botones bot= new Botones(70);
        bot.setTranslateY(-20);
        bot.setTranslateX(-10);
        bot.setOnAction(()-> {

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/ParamJuego.fxml");
            URL url = null;
            try {
                url = fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);

            try {
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                ParamJuegoControlador p = fxmlLoader.getController(); //dame el controlador
                //p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        b.addItem(bot);


        Box b2= new Box(100,80,"src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Boton_Config.png");
        b2.setTranslateY(10);
        b2.setTranslateX(150);

        Botones bot1= new Botones(70);
        bot1.setTranslateY(-20);
        bot1.setTranslateX(-10);
        bot1.setOnAction(()-> {

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/ParamJuego.fxml");
            URL url = null;
            try {
                url = fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);

            try {
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                ParamJuegoControlador p = fxmlLoader.getController(); //dame el controlador
                //p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        b2.addItem(bot1);

        Box b3= new Box(100,80,"src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Botón_Play.png");
        b3.setTranslateY(10);
        b3.setTranslateX(350);

        Botones bot3= new Botones(70);
        bot3.setTranslateY(-20);
        bot3.setTranslateX(-10);
        bot3.setOnAction(()-> {

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/ParamJuego.fxml");
            URL url = null;
            try {
                url = fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);

            try {
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                ParamJuegoControlador p = fxmlLoader.getController(); //dame el controlador
                //p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        b3.addItem(bot3);


        Box caja= new Box(640,640,null);
        caja.setTranslateX(230);
        caja.setTranslateY(100);


        FlowPane f= new FlowPane();
        f.getChildren().addAll(mainGrid);
        f.setBackground(Background.fill(Color.WHITE));


        caja.getChildren().add(f);
        root.getChildren().addAll(imageView,b,b2,b3,caja,caja_info);
        return root;

    }



}
