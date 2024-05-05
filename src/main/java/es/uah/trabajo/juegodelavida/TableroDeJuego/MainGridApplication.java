package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainGridApplication extends Application {
    /**
     * Generamos un log de sistema para esta clase
     *
     * Necesitamos instalar el paquete apache.logging.log4j.core, en su versión más reciente.
     * Para instalarlo, Open Module Settings -> libraries -> + en la lista -> From maven
     *
     * Además, se necesita configurar un fichero log4j2.xml en la carpeta resources, con la estructura e información
     * del sistema de log que vamos a usar.
     *
     *
     * Ejemplo:

     <?xml version="1.0" encoding="UTF-8"?>
     <Configuration status="DEBUG">
     <Appenders>
     <Console name="LogToConsole" target="SYSTEM_OUT">
     <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
     </Console>
     <RollingFile name="LogToRollingFile" fileName="logs/app.log"
     filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
     <PatternLayout>
     <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} - %-5level - %logger - %msg%n</Pattern>
     </PatternLayout>
     <Policies>
     <TimeBasedTriggeringPolicy />
     <SizeBasedTriggeringPolicy size="10 MB"/>
     </Policies>
     </RollingFile>

     </Appenders>
     <Loggers>
     <!-- Elimina duplicados con additivity=false -->
     <Logger name="es.uah" level="info" additivity="false">
     <AppenderRef ref="LogToRollingFile"/>
     <AppenderRef ref="LogToConsole"/>
     </Logger>
     <Root level="error">
     <AppenderRef ref="LogToConsole"/>
     </Root>
     </Loggers>
     </Configuration>

     * Este fichero de configuración hace que los logs se guarden en un fichero de la carpeta 'logs' del proyecto
     * que si no existe se creará.
     * los ficheros van guardándose, y se pueden añadir descriptores de hora al nombre para
     * que podamos seguir el rastro de cuándo se creó cada fichero de log.
     * Los logs se pueden enviar a consola o a fichero, como está configurado, pero también
     * se pueden enviar por correo electrónico (SMTP) y a bases de datos en otras configuraciones.
     */

    private static final Logger log = LogManager.getLogger(MainGridApplication.class);


    /**
     En este ejemplo, vamos a crear programáticamente la ventan en la que trabajaremos.
     */
    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(4);

        Text title = new Text("Recursos");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        vbox.getChildren().add(title);


        Label label1 = new Label("Recurso 1");
        label1.setFont(Font.font("Arial", 10));
        Label label2 = new Label("Recurso 2");
        label2.setFont(Font.font("Arial", 10));
        Label label3 = new Label("Recurso 3");
        label3.setFont(Font.font("Arial", 10));
        ArrayList<Label> labels  = new ArrayList<Label> ();
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);

        for (int i=0; i<3; i++) {
            VBox.setMargin(labels.get(i), new Insets(0, 0, 0, 4));
            vbox.getChildren().add(labels.get(i));
        }

        return vbox;
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


    public void start(Stage primaryStage) throws FileNotFoundException {

        log.info("Inicio del método de arranque de la aplicación para mostrar un grid de forma programática");


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


        final Group rootGroup = new Group();
        final Scene scene = new Scene(rootGroup, 800, 400, Color.WHITE);
        final MenuBar menuBar = buildMenuBarWithMenus(primaryStage.widthProperty());


        BorderPane border = new BorderPane();


        border.setTop(menuBar);
        border.setLeft(new FlowPane());
        border.setCenter(mainGrid);
        border.setRight(new FlowPane());

        //border.setStyle("-fx-background-image: url('file:///src/main/resources/es/uah/trabajo/juegodelavida/FondoPortada.png');" +
        //        "-fx-background-size: cover;"); // Ajusta el tamaño de la imagen
        Image image2 = new Image("file://src/main/resources/es/uah/trabajo/juegodelavida/FondoPortada.png");

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

        Background background2 = new Background(new BackgroundImage(image2,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize));
        border.setBackground(background2);



        rootGroup.getChildren().add(border);

        primaryStage.setTitle("Grid de 10x10 con Componentes Personalizados");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();


        // Ejemplo de cómo usar los LOGS de sistema que se habían definido antes.
        // Los logs trabajan por niveles:
        // trace, debug, info, warn, error y fatal
        //
        // Según la configuración del fichero de log4j2.xml, se guardarán los mensajes
        // del nivel configurado y superiores, pero no inferiores.

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        // Los logs sólo operan si la clase utilizada coincide con el patrón que se pone en el log4j2.xml.
        // En este caso el patrón es "es.uah" que coincide con nuestro paquete, por eso funciona.


        log.info("Fin del método de arranque de la aplicación para mostrar un grid de forma programática");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
