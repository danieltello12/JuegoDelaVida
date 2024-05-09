package es.uah.trabajo.juegodelavida.InicioSesionNP;

import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.ParamJuego.ParamJuegoControlador;
import es.uah.trabajo.juegodelavida.ParamJuego.ParamJuegoModel;
import es.uah.trabajo.juegodelavida.ParamJuego.ParamJuegoProperties;
import es.uah.trabajo.juegodelavida.Registrarse.RegistrarseControlador;
import es.uah.trabajo.juegodelavida.Registrarse.RegistrarseModelo;
import es.uah.trabajo.juegodelavida.Registrarse.RegistrarseProperties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
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

public class InicioSesionControladorNP implements Initializable {
    private Stage scene;
    @FXML
    private TextField textfieldNombre;
    @FXML
    private PasswordField textfieldContraseña;



    private InicioSesionPropertiesNP model;
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
        FXMLLoader fxmlLoader= new FXMLLoader();
        File fichero= new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/registrarse.fxml");
        URL url= null;
        try {
            url= fichero.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlLoader.setLocation(url);

        try {
            Scene scene = new Scene(fxmlLoader.load(), 450, 150);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            RegistrarseControlador p = fxmlLoader.getController(); //dame el controlador

            p.loadUserData(new RegistrarseProperties(new RegistrarseModelo())); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
            p.setStage(stage); //doy la ventana donde se va a trabajar
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void updateGUIwithModel() {
        textfieldNombre.textProperty().bindBidirectional(model.nombreProperty());
        textfieldContraseña.textProperty().bindBidirectional(model.contraseñaProperty());
    }
    @FXML
    public void onMibotonJugarClick() throws FileNotFoundException {
        model.commit();
        ListaUsuarios l= new ListaUsuarios();
        if(l.esta(model.original.getUsuario(),model.original.getContraseña())==2) {

            /** El usuario Ha iniciado sesion de forma correcta y se procede a mostrarle la pantalla de Parametros
             *
             */
            ListaELementos l2= new ListaELementos();
            l2=l2.cargar();
            l2.vaciar();
            l2.guardar(l2);

            ListaRecursos l3= new ListaRecursos();
            l3=l3.cargar();
            l3.vaciar();
            l3.guardar(l3);

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

            try {
                Scene scene = new Scene(fxmlLoader.load(), 1006, 518);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                ParamJuegoControlador p = fxmlLoader.getController(); //dame el controlador
                p.setUsuario(model.original.getUsuario());
                p.loadUserData(new ParamJuegoProperties(new ParamJuegoModel())); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            else if (l.esta(model.original.getUsuario(),model.original.getContraseña())==0){
            /** El usuario Debe registrarse
             *
             */

            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Registro.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im= new Scene(root);
                Stage s= new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else if (l.esta(model.original.getUsuario(),model.original.getContraseña())==1) {

            /**El usuario o la contraseña que ha escrito es erronea, ya que alguna de las dos existe
             *
             */

            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Captura.PNG"));
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
        }


    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(InicioSesionPropertiesNP parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }

}
