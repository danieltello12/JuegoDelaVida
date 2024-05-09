package es.uah.trabajo.juegodelavida.ParamJuego;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Avanzado;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Básico;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.normal;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
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

public class TipoDeInviduoControlador implements Initializable {
    private Stage scene;

    private Invidiuos DatosIndv;

    @FXML
    public void onMiBotonBásicoClick() throws FileNotFoundException {
        ListaELementos l= new ListaELementos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int id= this.DatosIndv.getId();
        int clon=this.DatosIndv.getProbclon();
        int rep= this.DatosIndv.getProbrep();
        int turnos= this.DatosIndv.getTurnosvida();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Básico b = new Básico(x,y,id,turnos,rep,clon);
        b.setTipo("Básico");
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
    public void onMiBotonAvanzadoClick() throws FileNotFoundException {
        ListaELementos l= new ListaELementos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int id= this.DatosIndv.getId();
        int clon=this.DatosIndv.getProbclon();
        int rep= this.DatosIndv.getProbrep();
        int turnos= this.DatosIndv.getTurnosvida();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Avanzado b = new Avanzado(x,y,id,turnos,rep,clon);
        b.setTipo("Avanzado");
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
    public void onMiBotonNormalClick() throws FileNotFoundException {
        ListaELementos l= new ListaELementos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int id= this.DatosIndv.getId();
        int clon=this.DatosIndv.getProbclon();
        int rep= this.DatosIndv.getProbrep();
        int turnos= this.DatosIndv.getTurnosvida();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.normal b = new normal(x,y,id,turnos,rep,clon);
        b.setTipo("Normal");

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

    public void loadDataIndividuo(Invidiuos datos){
        this.DatosIndv=datos;
    }

    public void setStage(Stage stage) {
        this.scene=stage;
    }
}
