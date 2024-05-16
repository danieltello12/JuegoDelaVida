package es.uah.trabajo.juegodelavida.ParamJuego;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimerosparamCotroller implements Initializable {
    Stage scene;
    String usuario;
    @FXML
    private TextField nombrePartida;
    @FXML
    private TextField columnas;
    @FXML
    private TextField filas;
    @FXML
    private Slider probZ;
    @FXML
    private Slider  probVA;
    @FXML
    private Slider  probC;
    @FXML
    private Slider  probVM;
    @FXML
    private Slider  probVT;
    @FXML
    private Slider  probVB;
    @FXML
    private Slider  probVP;
    @FXML
    private TextField  turnos;
    @FXML
    private TextField  tiempos;

    public String getCbAgua() {
        return (String)cbAgua.getValue();
    }

    public void setCbAgua(String cbAgua) {
        this.cbAgua.setValue(cbAgua);
    }

    @FXML
    private ComboBox cbAgua;

    public boolean getCkAgua() {
        return ckAgua.isSelected();
    }

    public void setCkAgua(boolean ckAgua) {
        this.ckAgua.setSelected(ckAgua);
    }

    @FXML
    private CheckBox ckAgua;

    @FXML
    private TextField modAgua;

    @FXML
    protected  void añadirelementosclick() throws FileNotFoundException {
        ListaLEPA l = new ListaLEPA();
        l.cargar(usuario);
        if (probVA.getValue() == 0 &&
                probZ.getValue() == 0 &&
                probC.getValue() == 0 &&
                probVM.getValue() == 0 &&
                probVT.getValue() == 0 &&
                probVB.getValue() == 0 &&
                probVP.getValue() == 0) {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/pzypv.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im = new Scene(root);
            Stage s = new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        }
        else if (nombrePartida.getText()=="") {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/PartidaYaCreada.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im = new Scene(root);
            Stage s = new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        }
        else if(l.esta(usuario,nombrePartida.getText())){
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/PartidaYaCreada.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im = new Scene(root);
            Stage s = new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        }
        else if(Integer.parseInt(filas.getText())==0||Integer.parseInt(columnas.getText())==0){
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Filas.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        }
        else{
            Partida p= new Partida(nombrePartida.getText());
            p.setFilas(Integer.parseInt(filas.getText()));
            p.setColumnas(Integer.parseInt(columnas.getText()));
            p.setPz((float) probZ.getValue());
            p.setPvC((float) probC.getValue());
            p.setPvA((float) probVA.getValue());
            p.setPvB((float) probVB.getValue());
            p.setPvM((float) probVM.getValue());
            p.setPvT((float) probVT.getValue());
            p.setPvP((float) probVP.getValue());
            p.setTurnosvida(Integer.parseInt(turnos.getText()));
            p.setTiemposvida(Integer.parseInt(tiempos.getText()));
            p.setCbAgua((String)cbAgua.getValue());
            p.setModAgua(Integer.parseInt(modAgua.getText()));
            p.setCkAgua(ckAgua.isSelected());

            ListaELementos l2= new ListaELementos();
            l2=l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
            l2.vaciar();
            l2.guardar(l2,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");

            ListaRecursos l3= new ListaRecursos();
            l3=l3.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
            l3.vaciar();
            l3.guardar(l3,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/ParamJuego.fxml");
            URL url = null;
            try {
                url = fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);
            this.scene.close();

            try {
                Scene scene = new Scene(fxmlLoader.load(), 1234, 636);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                ParamJuegoControlador controlador = fxmlLoader.getController(); //dame el controlador
                controlador.setUsuario(usuario);
                controlador.loadUserData(new ParamJuegoProperties(new ParamJuegoModel()),p); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                controlador.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void loaddata(String usuario){
        this.usuario=usuario;
    }
    public void setStage(Stage stage){
        this.scene=stage;
    }
}
