package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class tab extends Pane {
    public tab(int largo, int ancho){

        GridPane mainGrid = new GridPane();
        // mainGrid.setStyle("-fx-border-color: red;");
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);
        mainGrid.setGridLinesVisible(true);
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(0, 0, 0, 0));





        for (int i = 0;i < 10; i++) {
            for (int j = 0; j < 10; j++) {

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
                Button boton=new Button();
                boton.setStyle("-fx-background-color: transparent;-fx-border-color: black");
                boton.setPrefSize(64,64);
                mainGrid.add(boton,i,j);



                // OJO!: Tal como está programado, pierdo la referencia a los labels...
                //       Si los quisiese usar después, debería guardarlos de alguna manera en algún sitio
                // Pista: los quieres guardar para poder cambiar lo que aparece en pantalla :)
            }
        }


        //Ejemplo para poner 3 labels en la misma celda



        //mainGrid.add(layout,15,15);  // OJO: las coordenadas...: el grid responde automáticamente.

        // Scene scene = new Scene(mainGrid, 600, 600);
        // primaryStage.setTitle("Grid de 10x10 con Componentes Personalizados");
        // primaryStage.setScene(scene);
        // primaryStage.setMaximized(true);
        // primaryStage.show();
        Stage s= new Stage();
        s.widthProperty().add(10);
        final MenuBar menuBar = buildMenuBarWithMenus(s.widthProperty());


        //border.setStyle("-fx-background-image: url('file:///src/main/resources/es/uah/trabajo/juegodelavida/FondoPortada.png');" +
        //        "-fx-background-size: cover;"); // Ajusta el tamaño de la imagen
        Image image2 = new Image("file://src/main/resources/es/uah/trabajo/juegodelavida/FondoPortada.png");
        ImageView fondo= new ImageView(image2);

        fondo.setFitHeight(largo);
        fondo.setFitHeight(ancho);

        /** BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

         Background background2 = new Background(new BackgroundImage(image2,
         BackgroundRepeat.NO_REPEAT,
         BackgroundRepeat.NO_REPEAT,
         BackgroundPosition.CENTER,
         bSize));
         border.setBackground(background2);
         **/



     getChildren().addAll(fondo,menuBar);


    }
    private MenuBar buildMenuBarWithMenus(final ReadOnlyDoubleProperty menuWidthProperty)
    {
        final MenuBar menuBar = new MenuBar();


        // Prepare 'Examples' drop-down menu
        final Menu paramMenu = new Menu("Parametrizar");
        paramMenu.getItems().add(new MenuItem("Tablero"));
        paramMenu.getItems().add(new MenuItem("Individuos"));
        paramMenu.getItems().add(new MenuItem("Recursos"));
        menuBar.getMenus().add(paramMenu);

        // Prepare 'Help' drop-down menu
        final Menu juegoMenu = new Menu("Juego");
        juegoMenu.setOnAction(null);

        final MenuItem searchMenuItem = new MenuItem("Jugar");
        searchMenuItem.setDisable(true);
        juegoMenu.getItems().add(searchMenuItem);


        final MenuItem onlineManualMenuItem = new MenuItem("Detener juego");
        onlineManualMenuItem.setVisible(true);
        juegoMenu.getItems().add(onlineManualMenuItem);
        juegoMenu.getItems().add(new SeparatorMenuItem());
        final MenuItem aboutMenuItem = new MenuItem("Acerca de...");
        juegoMenu.getItems().add(aboutMenuItem);
        menuBar.getMenus().add(juegoMenu);

        // bind width of menu bar to width of associated stage
        menuBar.prefWidthProperty().bind(menuWidthProperty);

        return menuBar;
    }

}
