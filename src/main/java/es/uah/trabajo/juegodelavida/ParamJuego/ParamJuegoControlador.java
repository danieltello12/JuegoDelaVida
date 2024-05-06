package es.uah.trabajo.juegodelavida.ParamJuego;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import static es.uah.trabajo.juegodelavida.TableroDeJuego.Tablero.setTablero;

public class ParamJuegoControlador implements Initializable {
    private Stage scene;
    @FXML
    private TextField fDimension;
    @FXML
    private TextField fVidas;



    private ParamJuegoProperties model;
    public void setStage(Stage s){
        this.scene = s;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (model != null) {
            this.updateGUIwithModel();
        }
    }
    @FXML
    protected void onMiBotonRegistrarseClick() throws FileNotFoundException {
        Stage stage = new Stage();

        try {
            Scene scene = new Scene(setTablero(6,6), 1400, 800);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void updateGUIwithModel() {
        fDimension.textProperty().bindBidirectional(model.dimensionesProperty());
        fVidas.textProperty().bindBidirectional(model.vidasProperty());
    }
    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ParamJuegoProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
}
