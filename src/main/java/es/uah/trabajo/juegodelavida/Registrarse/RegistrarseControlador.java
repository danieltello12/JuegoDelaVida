package es.uah.trabajo.juegodelavida.Registrarse;


import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Usuario;
import javafx.fxml.FXML;
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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarseControlador implements Initializable {
    private Stage scene;
    @FXML
    private TextField textfieldNombre;
    @FXML
    private PasswordField textfieldContraseña;



    private RegistrarseProperties model;
    public void setStage(Stage s){
        this.scene = s;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (model != null) {
            this.updateGUIwithModel();
        }
    }
    protected void updateGUIwithModel() {
        textfieldNombre.textProperty().bindBidirectional(model.nombreProperty());
        textfieldContraseña.textProperty().bindBidirectional(model.contraseñaProperty());
    }
    @FXML
    public void onMibotonGuardarClick() throws IOException {
        model.commit();
    String usuario=    model.original.getUsuario();
    String contraseña= model.original.getContraseña();
     ListaUsuarios l= new ListaUsuarios();
        Usuario nuevo= new Usuario(usuario,contraseña);
        if(l.yacreado(usuario)){
            /** El nombre de usuario que ha introducido ya esta en uso
             *
             */

            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/YaCreado.PNG"));
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
        else {
            String s=usuario+".partidas.json";
            File f= new File(s);
            f.createNewFile();
            l.añadirusuario(nuevo);
            ListaLEPA l2= new ListaLEPA();
            l2.guardar(usuario);
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Captura2.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);
            root.getChildren().addAll(imageView);

            Scene im = new Scene(root);
            Stage s2= new Stage();
            s2.setScene(im);
            s2.setTitle("Juego de La Vida de Conway");
            s2.show();
        }
    }

    public void loadUserData(RegistrarseProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
}
