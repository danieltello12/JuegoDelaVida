module es.uah.trabajo.juegodelavida {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires com.google.gson;

    opens es.uah.trabajo.juegodelavida.ParamJuego to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.ParamJuego;
    exports es.uah.trabajo.juegodelavida.Portada;
    opens es.uah.trabajo.juegodelavida.Portada to javafx.fxml;
    opens es.uah.trabajo.juegodelavida.CargarPartida to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.CargarPartida;
    opens es.uah.trabajo.juegodelavida.InicioSesionCP to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.InicioSesionCP;
    opens es.uah.trabajo.juegodelavida.InicioSesionNP to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.InicioSesionNP;
    opens  es.uah.trabajo.juegodelavida.Registrarse to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.Registrarse;
    opens es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;
    exports es.uah.trabajo.juegodelavida.Clases.EstructurasDatos;
    opens es.uah.trabajo.juegodelavida.Clases;
    exports es.uah.trabajo.juegodelavida.Clases;
    opens es.uah.trabajo.juegodelavida.TableroDeJuego to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.TableroDeJuego;
    exports es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar;
    opens es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar to com.google.gson;
    exports es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos;
    opens es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos to com.google.gson;
    exports es.uah.trabajo.juegodelavida.Clases.Elementos;
    opens es.uah.trabajo.juegodelavida.Clases.Elementos to  com.google.gson;
    opens es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos to com.google.gson;
    exports es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos;

}