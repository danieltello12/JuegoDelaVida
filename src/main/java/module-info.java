module es.uah.trabajo.juegodelavida {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens es.uah.trabajo.juegodelavida.NuevaPartida to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.NuevaPartida;
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
}