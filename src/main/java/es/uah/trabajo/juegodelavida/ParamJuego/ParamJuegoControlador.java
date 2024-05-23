package es.uah.trabajo.juegodelavida.ParamJuego;


import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.ColaAcciones.Cola;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Recursos.Recursos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Tablero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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

public class ParamJuegoControlador implements Initializable {
    private String usuario;
    private Stage thisstage;
    @FXML
    private TextField filaIndv;
    @FXML
    private TextField columnaIvd;
    @FXML
    private TextField Identificador;
    //@FXML
    //private TextField TurnosDeVida;
    @FXML
    private Slider probabilidadReproduccion;
    @FXML
    private Slider probabilidadClonacion;
    @FXML
    private TextField filaRec;
    @FXML
    private  TextField columnaRec;
    Partida partida;


    private ParamJuegoProperties model;
    public void setStage(Stage s){
        this.thisstage = s;
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
    @FXML
    protected void onMiBotonIniciarJuegoClick() throws FileNotFoundException {
        model.commit();

            ListaELementos l2 = new ListaELementos();
            l2 = l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");

            ListaRecursos l3 = new ListaRecursos();
            l3 = l3.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
            Stage stage = new Stage();
            partida.setRecursos(l3);
            partida.setIndividuos(l2);
        ListaUsuarios usuarios= new ListaUsuarios();
        ListaLEPA partidas= usuarios.getusuario(usuario).getPartidas();
        partidas.add(partida);
        Cola Acciones= new Cola<>().cargar();
        Acciones.vaciar();
        Acciones.guardar(Acciones);
        Cola<String> accionesPartida= new Cola<String>();
        partida.setAcciones(accionesPartida);
        usuarios.getusuario(usuario).setPartidas(limpieza(partidas));

            this.thisstage.close();
            try {
                stage.setTitle("!!!Juego de La Vida de Conway");
                Scene scene = new Scene(new Tablero().Tablero(partida, usuario,stage), 1400, 800);

                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @FXML
    protected void onMibotonAyudaIndvClick() throws FileNotFoundException {
        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/infoindv.PNG"));
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
    @FXML
    protected void onMiBotonAyudarec() throws FileNotFoundException {
        Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/inforec.PNG"));
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
    public ListaLEPA limpieza(ListaLEPA p){
        for(int i=0;i<p.getNumeroElementos();i++){
            if(p.getElemento(i).getDatos().getFilas()==0  && p.getElemento(i).getDatos().getColumnas()==0){
                p.del(i);
            }
        }
        return p;
    }
    @FXML
    protected  void onMibotonCrearIndividuoClick() throws FileNotFoundException {
        model.commit();
        ListaELementos l2 = new ListaELementos();
        l2 = l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
        if(partida.getFilas()<(Integer.parseInt(model.original.getFilaIndv())-1)){
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
        } else  if(partida.getColumnas()<(Integer.parseInt(model.original.getColumnaIvd())-1)){
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Columnas.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        } else if(l2.elementoscelda(Integer.parseInt(model.original.getColumnaIvd()),Integer.parseInt(model.original.getFilaIndv()))==3)  {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/CeldasIndiviudos.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        } else if (l2.esta(Integer.parseInt(model.original.getIdentificador()),"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json")) {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/CeldasIndiviudos.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
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
                Scene scene = new Scene(fxmlLoader.load(), 1006, 518);
                stage.setTitle("Juego de La Vida de Conway");
                stage.setScene(scene);
                TipoDeInviduoControlador p = fxmlLoader.getController();
                p.loadDataIndividuo(i,false,usuario,partida.getNombre());//dame el controlador
                p.setStage(stage); //doy la ventana donde se va a trabajar
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
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
    @FXML
    public void onMiBotonCrearRecursoClick() throws FileNotFoundException {
        model.commit();
        ListaRecursos l2 = new ListaRecursos();
        l2 = l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
        ListaLEPA l = new ListaLEPA();
        l.cargar(usuario);
        if(partida.getFilas()<(Integer.parseInt(model.original.getFilarec())-1)){
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
        } else  if(partida.getColumnas()<(Integer.parseInt(model.original.getColumnarec())-1)){
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Columnas.PNG"));
            ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
            imageView.setFitWidth(1280);
            imageView.setFitHeight(720);

            root.getChildren().addAll(imageView);
            Scene im= new Scene(root);
            Stage s= new Stage();
            s.setScene(im);
            s.setTitle("Juego de La Vida de Conway");
            s.show();
        } else if(l2.elementoscelda(Integer.parseInt(model.original.getColumnarec()),Integer.parseInt(model.original.getFilarec()),"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json")==3)  {
            Pane root = new Pane(); //Creo un pane para ir añadiendo los distintos elementos

            Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/CeldasIndiviudos.PNG"));
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
                int x = Integer.parseInt(model.original.getFilarec());
                int y = Integer.parseInt(model.original.getColumnarec());
                Recursos i = new Recursos(x, y, partida.getPz(),0,partida.getTiemposvida()
                                          ,partida.getCbAgua(),partida.getModAgua(),partida.isCkAgua()
                        ,partida.getCbComida(),partida.getModComida(),partida.isCkComida()
                        ,partida.getCbMontana(),partida.getModMontana(),partida.isCkMontana()
                        ,partida.getCbTesoro(),partida.getModTesoro(),partida.isCkTesoro()
                        ,partida.getCbBiblio(),partida.getModBiblio(),partida.isCkBiblio()
                        ,partida.getCbPozo(),partida.getModPozo(),partida.isCkPozo() );
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
                    p.loadDataIndividuo(i, false, usuario,partida);//dame el controlador
                    p.setStage(stage); //doy la ventana donde se va a trabajar
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
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
    public void loadUserData(ParamJuegoProperties parametrosData,Partida p) {
        this.model = parametrosData;
        this.partida=p;
        this.updateGUIwithModel();

    }
}
