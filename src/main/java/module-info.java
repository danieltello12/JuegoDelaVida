module es.uah.trabajo.juegodelavida {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.uah.trabajo.juegodelavida.VentanaPrincipal to javafx.fxml;
    exports es.uah.trabajo.juegodelavida.VentanaPrincipal;
    exports es.uah.trabajo.juegodelavida.Portada;
    opens es.uah.trabajo.juegodelavida.Portada to javafx.fxml;
}