package es.uah.trabajo.juegodelavida.ParamJuego;


import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import static es.uah.trabajo.juegodelavida.TableroDeJuego.Tablero.setTablero;

public class ParamJuegoControlador implements Initializable {
    private String usuario;
    private Stage scene;
    @FXML
    private TextField nombrePartida;
    @FXML
    private TextField columnas;
    @FXML
    private TextField filas;
    @FXML
    private TextField filaIndv;
    @FXML
    private TextField columnaIvd;
    @FXML
    private TextField Identificador;
    @FXML
    private TextField TurnosDeVida;
    @FXML
    private Slider probabilidadReproduccion;
    @FXML
    private Slider probabilidadClonacion;
    @FXML
    private TextField filaRec;
    @FXML
    private  TextField columnaRec;
    @FXML
    private Slider probZ;
    @FXML
    private Slider probV;



    private ListaLE elementos; //Provisional mientros vemos como el usuario mete las posiciones


    private ParamJuegoProperties model;
    public void setStage(Stage s){
        this.scene = s;
    }

    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (model != null) {
            this.updateGUIwithModel();
        }
    }
    public void añadirpartida(ListaRecursos rec, ListaELementos ind){
        model.commit();
        ListaUsuarios l = new ListaUsuarios();
        l.getusuario(this.usuario).setPartida(new Partida(model.original.getNombre(),Integer.parseInt(model.original.getFilas()),Integer.parseInt(model.original.getColumnas()),ind,rec));
    }
    @FXML
    protected void onMiBotonIniciarJuegoClick() throws FileNotFoundException {
        model.commit();
        ListaELementos l2= new ListaELementos();
        l2=l2.cargar();

        ListaRecursos l3= new ListaRecursos();
        l3=l3.cargar();
       añadirpartida(l3,l2);
        Stage stage = new Stage();
        int columnas = Integer.parseInt(model.original.getColumnas());
        int filas = Integer.parseInt(model.original.getFilas());
        try {
            Scene scene = new Scene(setTablero(filas,columnas,l2,l3), 1400, 800);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected  void onMibotonCrearIndividuoClick(){
        model.commit();
        int x= Integer.parseInt(model.original.getColumnaIvd());
        int y= Integer.parseInt(model.original.getFilaIndv());
        int id= Integer.parseInt(model.original.getIdentificador());
        int clon=model.original.getPclonacion();
        int rep= model.original.getPreproduccion();
        int turnos= Integer.parseInt(model.original.getTurnosDeVida());
        Invidiuos i= new Invidiuos(x,y,id,turnos,rep,clon);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/elegirIndividuo.fxml");
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlLoader.setLocation(url);

        try {
            Scene scene = new Scene(fxmlLoader.load(), 1006, 518);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            TipoDeInviduoControlador p = fxmlLoader.getController();
            p.loadDataIndividuo(i);//dame el controlador
            p.setStage(stage); //doy la ventana donde se va a trabajar
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onMiBotonCrearRecursoClick(){
        model.commit();
        int x= Integer.parseInt(model.original.getFilarec());
        int y= Integer.parseInt(model.original.getColumnarec());
        int pv=model.original.getPv();
        int pz= model.original.getPz();
        Recursos i= new Recursos(x,y,pv,pz);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/elegirRecurso.fxml");
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlLoader.setLocation(url);

        try {
            Scene scene = new Scene(fxmlLoader.load(), 1006, 518);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            TipoDeRecursoControler p = fxmlLoader.getController();
            p.loadDataIndividuo(i);//dame el controlador
            p.setStage(stage); //doy la ventana donde se va a trabajar
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void updateGUIwithModel() {
        columnas.textProperty().bindBidirectional(model.dimensionesProperty());
        Identificador.textProperty().bindBidirectional(model.numeroIndividuosNormalesProperty());
        TurnosDeVida.textProperty().bindBidirectional(model.numeroIndividuosAvanzadosProperty());
        probabilidadClonacion.valueProperty().bindBidirectional(model.probabilidadClonacionProperty());
        probabilidadReproduccion.valueProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        probabilidadReproduccion.valueProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        filas.textProperty().bindBidirectional(model.filasProperty());
        nombrePartida.textProperty().bindBidirectional(model.nombre());
        filaIndv.textProperty().bindBidirectional(model.filaIndvproperty());
        columnaIvd.textProperty().bindBidirectional(model.getColumnaIvdproperty());
        columnaRec.textProperty().bindBidirectional(model.ColumnasrecProperty());
        filaRec.textProperty().bindBidirectional(model.filasrecProperty());
        probV.valueProperty().bindBidirectional(model.pvProperty());
        probZ.valueProperty().bindBidirectional(model.pzProperty());

    }
    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ParamJuegoProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
}
