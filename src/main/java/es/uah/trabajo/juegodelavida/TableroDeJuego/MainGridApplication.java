package es.uah.trabajo.juegodelavida.TableroDeJuego;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    @Override
    public void start(Stage primaryStage) {

        log.info("Inicio del método de arranque de la aplicación para mostrar un grid de forma programática");

        GridPane mainGrid = new GridPane();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Aquí podrías instanciar tu clase de celda, más compleja

                // Ejemplo simplificado con un Label
                Label placeholder = new Label("Celda " + i + "," + j);
                placeholder.setMinSize(60, 60); // Tamaño mínimo para visualización
                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
                mainGrid.add(placeholder, i, j);

                // OJO!: Tal como está programado, pierdo la referencia a los labels...
                //       Si los quisiese usar después, debería guardarlos de alguna manera en algún sitio
                // Pista: los quieres guardar para poder cambiar lo que aparece en pantalla :)
            }
        }


        //Ejemplo para poner 3 labels en la misma celda

        Label antonio = new Label("Antonio");
        Label moratilla = new Label("Moratilla");
        Label ocaña = new Label("Ocaña");

        VBox layout = new VBox(antonio,moratilla,ocaña);
        layout.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
        mainGrid.add(layout,15,15);  // OJO: las coordenadas...: el grid responde automáticamente.

        Scene scene = new Scene(mainGrid, 600, 600);
        primaryStage.setTitle("Grid de 10x10 con Componentes Personalizados");
        primaryStage.setScene(scene);
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
