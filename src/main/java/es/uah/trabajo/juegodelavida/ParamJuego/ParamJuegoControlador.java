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
    @FXML
    private TextField numeroIndividuosBasicos;
    @FXML
    private TextField numeroIndividuosAvanzados;
    @FXML
    private TextField numeroIndividuosNormales;
    @FXML
    private TextField probabilidadReproduccion;
    @FXML
    private TextField probabilidadClonacion;

    @FXML
    private TextField numeroRecursosAgua;
    private TextField numeroRecursosComida;
    @FXML
    private TextField numeroRecursosMontana;
    @FXML
    private TextField numeroRecursosTesoro;
    @FXML
    private TextField numeroRecursosPozo;
    @FXML
    private TextField numeroRecursosBiblioteca;





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
        int filas = Integer.parseInt(fDimension.getText());
        int columnas = Integer.parseInt(fDimension.getText());

        try {
            Scene scene = new Scene(setTablero(filas,columnas), 1400, 800);
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
        numeroIndividuosNormales.textProperty().bindBidirectional(model.numeroIndividuosNormalesProperty());
        numeroIndividuosAvanzados.textProperty().bindBidirectional(model.numeroIndividuosAvanzadosProperty());
        numeroIndividuosBasicos.textProperty().bindBidirectional(model.numeroIndividuosBasicosProperty());
        probabilidadClonacion.textProperty().bindBidirectional(model.probabilidadClonacionProperty());
        probabilidadReproduccion.textProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        probabilidadReproduccion.textProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        numeroRecursosAgua.textProperty().bindBidirectional(model.numeroRecursosAguaProperty());
        numeroRecursosMontana.textProperty().bindBidirectional(model.numeroRecursosMontanaProperty());
        numeroRecursosTesoro.textProperty().bindBidirectional(model.numeroRecursosTesoroProperty());
        numeroRecursosPozo.textProperty().bindBidirectional(model.numeroRecursosPozoProperty());
        numeroRecursosComida.textProperty().bindBidirectional(model.numeroRecursosComidaProperty());
        numeroRecursosBiblioteca.textProperty().bindBidirectional(model.numeroRecursosBibliotecaProperty());


    }
    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ParamJuegoProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
}
