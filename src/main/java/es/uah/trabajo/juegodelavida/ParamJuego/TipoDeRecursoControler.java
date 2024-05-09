package es.uah.trabajo.juegodelavida.ParamJuego;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class TipoDeRecursoControler implements Initializable {

    private Stage scene;

    private Recursos DatosIndv;

    @FXML
    public void onMiBotonMontañaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int pv=this.DatosIndv.getProbabilida_V();
        int pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,pv);
        b.setTipo("Montaña");
        l.añadirindividuo(b);

        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Añadido.PNG"));
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
    @FXML
    public void onMiBotonAguaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int pv=this.DatosIndv.getProbabilida_V();
        int pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,pv);
        b.setTipo("Agua");
        l.añadirindividuo(b);

        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Añadido.PNG"));
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
    @FXML
    public void onMiBotonComidaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int pv=this.DatosIndv.getProbabilida_V();
        int pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,pv);
        b.setTipo("Comida");
        l.añadirindividuo(b);

        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Añadido.PNG"));
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
    @FXML
    public void onMiBotonTesoroClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int pv=this.DatosIndv.getProbabilida_V();
        int pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,pv);
        b.setTipo("Tesoro");
        l.añadirindividuo(b);

        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Añadido.PNG"));
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

    @FXML
    public void onMiBotonBibliotecaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int pv=this.DatosIndv.getProbabilida_V();
        int pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,pv);
        b.setTipo("Biblioteca");
        l.añadirindividuo(b);

        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Añadido.PNG"));
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
    @FXML
    public void onMiBotonPozoClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int pv=this.DatosIndv.getProbabilida_V();
        int pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,pv);
        b.setTipo("Pozo");
        l.añadirindividuo(b);

        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Añadido.PNG"));
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadDataIndividuo(Recursos datos){
        this.DatosIndv=datos;
    }

    public void setStage(Stage stage) {
        this.scene=stage;
    }
}

