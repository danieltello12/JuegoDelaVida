package es.uah.trabajo.juegodelavida.ParamJuego;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ElementoLEPA;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Avanzado;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Básico;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.normal;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLEUs;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Clases.Usuario;
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
    boolean conf;
    String nombreus;
    String nombrepar;

    @FXML
    public void onMiBotonBásicoClick() throws FileNotFoundException, InterruptedException {
        ListaELementos l= new ListaELementos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int id= this.DatosIndv.getId();
        float clon=this.DatosIndv.getProbclon();
       float rep= this.DatosIndv.getProbrep();
        int turnos= this.DatosIndv.getTurnosvida();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Básico b = new Básico(x,y,id,turnos,rep,clon);
        b.setTipo("Básico");

            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosindividuos.json");

        ListaLE lista= new ListaLE().cargar();
        Usuario u= new Usuario(nombreus,"");
        ElementoLEUs e= new ElementoLEUs<>(u);
        Partida p= new Partida(nombrepar);
        ElementoLEPA e2= new ElementoLEPA(p);
         int posus=lista.getPosicion(e);
        if(lista.getElemento(posus).getDatos().getPartidas().esta(nombreus,p.getNombre())) {
            int pospar = lista.getElemento(posus).getDatos().getPartidas().getPosicion(e2);
            lista.getElemento(posus).getDatos().getPartidas().getElemento(pospar).getDatos().setIndividuos(l);
            lista.guardar(lista);
            ListaLEPA l2= new ListaLEPA().cargar(nombreus);
            int pos=l2.getPosicion(e2);
            l2.getElemento(pos).getDatos().setIndividuos(l);
            l2.guardar(nombreus);
        }
        else{
            lista.getElemento(posus).getDatos().setPartida(p);
            lista.guardar(lista);

            ListaLEPA l2= new ListaLEPA().cargar(nombreus);
            l2.add(p);
            l2.guardar(nombreus);
        }

            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Anadir.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(400);
            imageView.setFitHeight(75);

            root.getChildren().addAll(imageView);
            Scene im = new Scene(root);
            Stage s = new Stage();
            s.setScene(im);
            s.setTitle("Parametrizar::Juego de La Vida de Conway");
            s.show();
        this.scene.close();
    }
    @FXML
    public void onMiBotonAvanzadoClick() throws FileNotFoundException {
        ListaELementos l= new ListaELementos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int id= this.DatosIndv.getId();
        float clon=this.DatosIndv.getProbclon();
        float rep= this.DatosIndv.getProbrep();
        int turnos= this.DatosIndv.getTurnosvida();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Avanzado b = new Avanzado(x,y,id,turnos,rep,clon);
        b.setTipo("Avanzado");
            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
            l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosindividuos.json");

        ListaLE lista= new ListaLE().cargar();
        Usuario u= new Usuario(nombreus,"");
        ElementoLEUs e= new ElementoLEUs<>(u);
        Partida p= new Partida(nombrepar);
        ElementoLEPA e2= new ElementoLEPA(p);
        int posus=lista.getPosicion(e);
        if(lista.getElemento(posus).getDatos().getPartidas().esta(nombreus,p.getNombre())) {
            int pospar = lista.getElemento(posus).getDatos().getPartidas().getPosicion(e2);
            lista.getElemento(posus).getDatos().getPartidas().getElemento(pospar).getDatos().setIndividuos(l);
            lista.guardar(lista);
            ListaLEPA l2= new ListaLEPA().cargar(nombreus);
            int pos=l2.getPosicion(e2);
            l2.getElemento(pos).getDatos().setIndividuos(l);
            l2.guardar(nombreus);
        }
        else{
            lista.getElemento(posus).getDatos().setPartida(p);
            lista.guardar(lista);

            ListaLEPA l2= new ListaLEPA().cargar(nombreus);
            l2.add(p);
            l2.guardar(nombreus);
        }

            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Anadir.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(400);
            imageView.setFitHeight(75);


            root.getChildren().addAll(imageView);
            Scene im = new Scene(root);
            Stage s = new Stage();
            s.setScene(im);
            s.setTitle("Parametrizar:::Juego de La Vida de Conway");
            s.show();
        this.scene.close();

        }


    @FXML
    public void onMiBotonNormalClick() throws FileNotFoundException {
        ListaELementos l= new ListaELementos();
        int x= this.DatosIndv.getX();
        int y= this.DatosIndv.getY();
        int id= this.DatosIndv.getId();
        float clon=this.DatosIndv.getProbclon();
        float rep= this.DatosIndv.getProbrep();
        int turnos= this.DatosIndv.getTurnosvida();
        es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.normal b = new normal(x,y,id,turnos,rep,clon);
        b.setTipo("Normal");
        l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
        l.añadirindividuo(b,"src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosindividuos.json");

        ListaLE lista= new ListaLE().cargar();
        Usuario u= new Usuario(nombreus,"");
        ElementoLEUs e= new ElementoLEUs<>(u);
        Partida p= new Partida(nombrepar);
        ElementoLEPA e2= new ElementoLEPA(p);
        int posus=lista.getPosicion(e);
        if(lista.getElemento(posus).getDatos().getPartidas().esta(nombreus,p.getNombre())) {
            int pospar = lista.getElemento(posus).getDatos().getPartidas().getPosicion(e2);
            lista.getElemento(posus).getDatos().getPartidas().getElemento(pospar).getDatos().setIndividuos(l);
            lista.guardar(lista);
            ListaLEPA l2= new ListaLEPA().cargar(nombreus);
            int pos=l2.getPosicion(e2);
            l2.getElemento(pos).getDatos().setIndividuos(l);
            l2.guardar(nombreus);
        }
        else{
            lista.getElemento(posus).getDatos().setPartida(p);
            lista.guardar(lista);

            ListaLEPA l2= new ListaLEPA().cargar(nombreus);
            l2.add(p);
            l2.guardar(nombreus);
        }

            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Anadir.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(400);
            imageView.setFitHeight(75);


            root.getChildren().addAll(imageView);
            Scene im = new Scene(root);
            Stage s = new Stage();
            s.setScene(im);
            s.setTitle("Parametrizar::::Juego de La Vida de Conway");
            s.show();


        this.scene.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void loadDataIndividuo(Invidiuos datos,boolean conf,String nombreusuario,String nombrepartida){
        this.conf=conf;
        this.DatosIndv=datos;
        this.nombrepar=nombrepartida;
        this.nombreus=nombreusuario;
    }

    public void setStage(Stage stage) {
        this.scene=stage;
    }
}
