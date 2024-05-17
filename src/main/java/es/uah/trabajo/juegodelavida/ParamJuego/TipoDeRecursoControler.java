package es.uah.trabajo.juegodelavida.ParamJuego;

import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Partida;
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
 boolean conf;
    String nombreus;
  Partida p;


    @FXML
    public void onMiBotonMontañaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        float pz= this.DatosIndv.getProbabilidad_Z();
        Recursos b = new Recursos(x,y,pz,p.getPvM(),this.DatosIndv.getTiemposvida()
                ,this.DatosIndv.getCbAgua(),this.DatosIndv.getModAgua(),this.DatosIndv.isCkAgua()
                ,this.DatosIndv.getCbComida(),this.DatosIndv.getModComida(),this.DatosIndv.isCkComida()
                ,this.DatosIndv.getCbMontana(),this.DatosIndv.getModMontana(),this.DatosIndv.isCkMontana()
                ,this.DatosIndv.getCbTesoro(),this.DatosIndv.getModTesoro(),this.DatosIndv.isCkTesoro()
                ,this.DatosIndv.getCbBiblio(),this.DatosIndv.getModBiblio(),this.DatosIndv.isCkBiblio()
                ,this.DatosIndv.getCbPozo(),this.DatosIndv.getModPozo(),this.DatosIndv.isCkPozo());
        b.setTipo("M");

            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

        if(conf==true) {
            l.añadirindividuo(b, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
        }

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

        this.scene.close();
    }
    @FXML
    public void onMiBotonAguaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        Recursos b = new Recursos(x,y,p.getPz(),p.getPvA(),this.DatosIndv.getTiemposvida()
                ,this.DatosIndv.getCbAgua(),this.DatosIndv.getModAgua(),this.DatosIndv.isCkAgua()
                ,this.DatosIndv.getCbComida(),this.DatosIndv.getModComida(),this.DatosIndv.isCkComida()
                ,this.DatosIndv.getCbMontana(),this.DatosIndv.getModMontana(),this.DatosIndv.isCkMontana()
                ,this.DatosIndv.getCbTesoro(),this.DatosIndv.getModTesoro(),this.DatosIndv.isCkTesoro()
                ,this.DatosIndv.getCbBiblio(),this.DatosIndv.getModBiblio(),this.DatosIndv.isCkBiblio()
                ,this.DatosIndv.getCbPozo(),this.DatosIndv.getModPozo(),this.DatosIndv.isCkPozo());
        b.setTipo("A");
            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
            if(conf==true) {
                l.añadirindividuo(b, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
            }

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
        this.scene.close();
    }
    @FXML
    public void onMiBotonComidaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        Recursos b = new Recursos(x,y,p.getPz(),p.getPvC(),this.DatosIndv.getTiemposvida()
                ,this.DatosIndv.getCbAgua(),this.DatosIndv.getModAgua(),this.DatosIndv.isCkAgua()
                ,this.DatosIndv.getCbComida(),this.DatosIndv.getModComida(),this.DatosIndv.isCkComida()
                ,this.DatosIndv.getCbMontana(),this.DatosIndv.getModMontana(),this.DatosIndv.isCkMontana()
                ,this.DatosIndv.getCbTesoro(),this.DatosIndv.getModTesoro(),this.DatosIndv.isCkTesoro()
                ,this.DatosIndv.getCbBiblio(),this.DatosIndv.getModBiblio(),this.DatosIndv.isCkBiblio()
                ,this.DatosIndv.getCbPozo(),this.DatosIndv.getModPozo(),this.DatosIndv.isCkPozo());
        b.setTipo("C");

            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

        if(conf==true) {
            l.añadirindividuo(b, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
        }

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
        this.scene.close();

    }
    @FXML
    public void onMiBotonTesoroClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        Recursos b = new Recursos(x,y,p.getPz(),p.getPvT(),this.DatosIndv.getTiemposvida()
                ,this.DatosIndv.getCbAgua(),this.DatosIndv.getModAgua(),this.DatosIndv.isCkAgua()
                ,this.DatosIndv.getCbComida(),this.DatosIndv.getModComida(),this.DatosIndv.isCkComida()
                ,this.DatosIndv.getCbMontana(),this.DatosIndv.getModMontana(),this.DatosIndv.isCkMontana()
                ,this.DatosIndv.getCbTesoro(),this.DatosIndv.getModTesoro(),this.DatosIndv.isCkTesoro()
                ,this.DatosIndv.getCbBiblio(),this.DatosIndv.getModBiblio(),this.DatosIndv.isCkBiblio()
                ,this.DatosIndv.getCbPozo(),this.DatosIndv.getModPozo(),this.DatosIndv.isCkPozo());
        b.setTipo("T");

            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
        if(conf==true) {
            l.añadirindividuo(b, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
        }

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
        this.scene.close();
    }

    @FXML
    public void onMiBotonBibliotecaClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();

        Recursos b = new Recursos(x,y,p.getPz(),p.getPvB(),this.DatosIndv.getTiemposvida()
                ,this.DatosIndv.getCbAgua(),this.DatosIndv.getModAgua(),this.DatosIndv.isCkAgua()
                ,this.DatosIndv.getCbComida(),this.DatosIndv.getModComida(),this.DatosIndv.isCkComida()
                ,this.DatosIndv.getCbMontana(),this.DatosIndv.getModMontana(),this.DatosIndv.isCkMontana()
                ,this.DatosIndv.getCbTesoro(),this.DatosIndv.getModTesoro(),this.DatosIndv.isCkTesoro()
                ,this.DatosIndv.getCbBiblio(),this.DatosIndv.getModBiblio(),this.DatosIndv.isCkBiblio()
                ,this.DatosIndv.getCbPozo(),this.DatosIndv.getModPozo(),this.DatosIndv.isCkPozo());
        b.setTipo("B");

            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

        if(conf==true) {
            l.añadirindividuo(b, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
        }




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
        this.scene.close();
    }
    @FXML
    public void onMiBotonPozoClick() throws FileNotFoundException {
        ListaRecursos l= new ListaRecursos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        Recursos b = new Recursos(x,y,p.getPz(),p.getPvP(),p.getTiemposvida()
                ,p.getCbAgua(),p.getModAgua(),p.isCkAgua()
                ,p.getCbComida(),p.getModComida(),p.isCkComida()
                ,p.getCbMontana(),p.getModMontana(),p.isCkMontana()
                ,p.getCbTesoro(),p.getModTesoro(),p.isCkTesoro()
                ,p.getCbBiblio(),p.getModBiblio(),p.isCkBiblio()
                ,p.getCbPozo(),p.getModPozo(),p.isCkPozo());
        b.setTipo("P");

            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

        if(conf==true) {
            l.añadirindividuo(b, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
        }


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
        this.scene.close();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadDataIndividuo(Recursos datos, boolean conf, String nombreusuario, Partida partida){
        this.conf=conf;
        this.DatosIndv=datos;
        this.p= partida;
        this.nombreus=nombreusuario;
    }

    public void setStage(Stage stage) {
        this.scene=stage;
    }
}

