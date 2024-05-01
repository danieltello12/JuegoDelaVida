package es.uah.trabajo.juegodelavida.InicioSesionNP;

import es.uah.trabajo.juegodelavida.InicioSesionCP.InicioSesionControladorCP;
import es.uah.trabajo.juegodelavida.NuevaPartida.NuevaPartidaControlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioSesionControladorNP implements Initializable {
    private Stage scene;
    public void setStage(Stage s){
        this.scene = s;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    protected void onMiBotonClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader= new FXMLLoader();
        File fichero= new File("C:\\Users\\UAH\\IdeaProjects\\JuegoDeLaVida\\src\\main\\resources\\es\\uah\\trabajo\\juegodelavida\\nuevapartida-view.fxml");
        URL url= null;
        try {
            url= fichero.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlLoader.setLocation(url);

        try {
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            NuevaPartidaControlador p = fxmlLoader.getController(); //dame el controlador
            //p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
            p.setStage(stage); //doy la ventana donde se va a trabajar
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
