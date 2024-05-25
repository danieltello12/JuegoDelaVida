package es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion;

import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ElementoLEPA;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.ParamJuego.TipoDeInviduoControlador;
import es.uah.trabajo.juegodelavida.ParamJuego.TipoDeRecursoControler;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Box;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Tablero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class ConfiguracionController implements Initializable {
    private String usuario;
    private Stage thisstage;

    private Stage stagePadre;
    @FXML
    private TextField filaIndv;
    @FXML
    private TextField columnaIvd;
    @FXML
    private TextField Identificador;
 //   @FXML
//    private TextField TurnosDeVida;
    @FXML
    private Slider probabilidadReproduccion;
    @FXML
    private Slider probabilidadClonacion;
    @FXML
    private TextField filaRec;
    @FXML
    private  TextField columnaRec;
    Partida partida;
    Pane root;
    FlowPane f;
    GridPane g;
    Box box;
    Pane p;

static  ListaELementos indyacreados= new ListaELementos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
static ListaRecursos recyacreados= new ListaRecursos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");

    private ConfiguracionProperties model;
    @FXML
    protected void onMiBotonIniciarJuegoClick() {
        //this.scene.close();
        ListaELementos l2 = new ListaELementos();
        l2 = l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");

        ListaRecursos l3 = new ListaRecursos();
        l3 = l3.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
        actualizar(l2,l3);

        //this.root.getChildren().remove(box);
        //this.box.getChildren().remove(f);
        //this.f.getChildren().remove(g);

        //ListaELementos individuos= new ListaELementos();
        //individuos = individuos.cargar("src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosindividuos.json");

        //ListaRecursos recursos= new ListaRecursos();
        //recursos= recursos.cargar("src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");


        //this.f.getChildren().add(añadir(recursos,individuos,g));
        //this.box.getChildren().add(f);
        //this.root.getChildren().add(box);


        this.stagePadre.close();
        try {


            thisstage.setTitle("!!!!Juego de La Vida de Conway");
            Tablero t = new Tablero();
            Scene scene = new Scene(t  .Tablero(partida, usuario,thisstage), 1400, 800);
            thisstage.setScene(scene);
            t.setStageA(thisstage);
            thisstage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void actualizar(ListaELementos ind, ListaRecursos rec){
        partida.setIndividuos(ind);
        partida.setRecursos(rec);
        ListaUsuarios usuarios= new ListaUsuarios();
        ListaLEPA l=usuarios.getusuario(usuario).getPartidas();
        int pos=usuarios.getusuario(usuario).getPartidas().getPosicion(new ElementoLEPA<>(partida));
        l.del(pos);
        l.add(partida);
        usuarios.getusuario(usuario).setPartidas(l);
    }


    @FXML
    protected  void onMibotonCrearIndividuoClick() throws FileNotFoundException {
        if (Objects.equals(Identificador.getText(), "") && Objects.equals(filaIndv.getText(), "") && Objects.equals(columnaIvd.getText(), "")) {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Ide.jpeg"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(900);
            imageView.setFitHeight(400);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        }
        else {
            model.commit();

            if (this.partida.getFilas() < (Integer.parseInt(model.original.getFilaIndv()) - 1)) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Filas.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else if (this.partida.getColumnas() < (Integer.parseInt(model.original.getColumnaIvd()) - 1)) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Columnas.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else if (indyacreados.elementoscelda(Integer.parseInt(model.original.getColumnaIvd()), Integer.parseInt(model.original.getFilaIndv())) == 3) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/CeldasIndiviudos.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else if (indyacreados.esta(Integer.parseInt(model.original.getIdentificador()), "src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json")) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/CeldasIndiviudos.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else {
                int x = Integer.parseInt(model.original.getFilaIndv());
                int y = Integer.parseInt(model.original.getColumnaIvd());
                int id = Integer.parseInt(model.original.getIdentificador());
                float clon = model.original.getPclonacion();
                float rep = model.original.getPreproduccion();
                int turnos = partida.getTurnosvida();
                Invidiuos i = new Invidiuos(x, y, id, turnos, rep, clon);
                restablecerind();
                model.rollback();
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
                    Scene scene = new Scene(fxmlLoader.load(), 841, 481);
                    stage.setTitle("Juego de La Vida de Conway");
                    stage.setScene(scene);
                    TipoDeInviduoControlador p = fxmlLoader.getController();
                    p.loadDataIndividuo(i, true, usuario, partida.getNombre());//dame el controlador
                    p.setStage(stage); //doy la ventana donde se va a trabajar
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void restablecerind(){
        model.original.setFilaIndv("");
        model.original.setColumnaIvd("");
        model.original.setIdentificador("");
        model.original.setPreproduccion(0);
        model.original.setPclonacion(0);
        //model.original.setTurnosDeVida("");
    }
    public void restablecerrec(){
        model.original.setFilarec("");
        model.original.setColumnarec("");
    }
    public void actualizarpartida(){
        ListaLEPA l= new ListaLEPA().cargar(usuario);
        this.partida=l.getElemento(l.getPosicion(new ElementoLEPA<>(partida))).getDatos();
    }
    @FXML
    public void cambiarProbabilidadesclick(){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/cambiar probabilidades.fxml");
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlLoader.setLocation(url);

        try {
            Scene scene = new Scene(fxmlLoader.load(), 762, 402);
            stage.setTitle("Juego de La Vida de Conway");
            stage.setScene(scene);
            CambiarProbabilidadesControler controlador = fxmlLoader.getController();
            controlador.loaduserdata(partida,usuario);//dame el controlador
            controlador.setStage(stage); //doy la ventana donde se va a trabajar
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onMiBotonCrearRecursoClick() throws FileNotFoundException {
        if (Objects.equals(columnaRec.getText(), "") && Objects.equals(filaRec.getText(), "")) {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Ide.jpeg"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(900);
            imageView.setFitHeight(400);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        }
        else {
            model.commit();
            if (this.partida.getFilas() < (Integer.parseInt(model.original.getFilarec()) - 1)) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Filas.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else if (this.partida.getColumnas() < (Integer.parseInt(model.original.getColumnarec()) - 1)) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Columnas.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else if (recyacreados.elementoscelda(Integer.parseInt(model.original.getColumnarec()), Integer.parseInt(model.original.getFilarec()), "src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json") == 3) {
                Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

                Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/CeldasIndiviudos.PNG"));
                ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
                imageView.setFitWidth(1280);
                imageView.setFitHeight(720);

                root.getChildren().addAll(imageView);
                Scene im = new Scene(root);
                Stage s = new Stage();
                s.setScene(im);
                s.setTitle("Juego de La Vida de Conway");
                s.show();
            } else {
                int x = Integer.parseInt(model.original.getFilarec());
                int y = Integer.parseInt(model.original.getColumnarec());
                float pz = model.original.getPz();
                Recursos i = new Recursos(x, y, pz, 0, partida.getTiemposvida()
                        , partida.getCbAgua(), partida.getModAgua(), partida.isCkAgua()
                        , partida.getCbComida(), partida.getModComida(), partida.isCkComida()
                        , partida.getCbMontana(), partida.getModMontana(), partida.isCkMontana()
                        , partida.getCbTesoro(), partida.getModTesoro(), partida.isCkTesoro()
                        , partida.getCbBiblio(), partida.getModBiblio(), partida.isCkBiblio()
                        , partida.getCbPozo(), partida.getModPozo(), partida.isCkPozo());
                restablecerrec();
                model.rollback();
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
                    p.loadDataIndividuo(i, true, usuario, partida);//dame el controlador
                    p.setStage(stage); //doy la ventana donde se va a trabajar
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //
    protected void updateGUIwithModel() {
        Identificador.textProperty().bindBidirectional(model.numeroIndividuosNormalesProperty());
        //TurnosDeVida.textProperty().bindBidirectional(model.numeroIndividuosAvanzadosProperty());
        probabilidadClonacion.valueProperty().bindBidirectional(model.probabilidadClonacionProperty());
        probabilidadReproduccion.valueProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        probabilidadReproduccion.valueProperty().bindBidirectional(model.probabilidadReproduccionProperty());
        filaIndv.textProperty().bindBidirectional(model.filaIndvproperty());
        columnaIvd.textProperty().bindBidirectional(model.getColumnaIvdproperty());
        columnaRec.textProperty().bindBidirectional(model.ColumnasrecProperty());
        filaRec.textProperty().bindBidirectional(model.filasrecProperty());

    }
    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ConfiguracionProperties parametrosData,Partida p, Pane root,String usuario) {
        this.usuario=usuario;
        this.p=root;
        this.root=root;
        this.model = parametrosData;
        this.updateGUIwithModel();
        this.model.original.setPz(p.getPz());
        this.partida=p;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (model != null) {
            this.updateGUIwithModel();
        }
    }

    public void setThisstage(Stage thisstage) {
        this.thisstage = thisstage;
    }
    public void setStagePadre(Stage stagePadre) {
        this.stagePadre = stagePadre;
    }
}
