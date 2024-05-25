package es.uah.trabajo.juegodelavida.TableroDeJuego;

import es.uah.trabajo.juegodelavida.BucleControl.Bucle;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ElementoLEPA;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.Elementos.Individuos.Invidiuos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Grafos.*;
import es.uah.trabajo.juegodelavida.Clases.Historico;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Portada.Boton;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion.ConfiguracionController;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion.ConfiguracionModel;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion.ConfiguracionProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class Tablero extends Pane {
    static GridPane tab;
    Pane root = new Pane();
    Stage stagePadre;

    boolean elementosencelda;
    public Tablero() {}
    final Logger log = LogManager.getLogger(Tablero.class);

    int pasos=0;
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
public ListaSimple<Label> contenidoCasilla(Partida partida, String usuario, int finalI, int finalJ){

    actualizarindyrecpart(partida,usuario);
    ListaELementos individuos= new ListaELementos();
    individuos=individuos.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
    ListaELementos elementosencelda= new ListaELementos();
    for(int pos=0; pos<individuos.getNumeroElementos();pos++){
        if(individuos.getElemento(pos).getDatos().getX()-1== finalI && individuos.getElemento(pos).getDatos().getY()-1== finalJ){
            elementosencelda.add(individuos.getElemento(pos).getDatos());
        }
    }
    ListaRecursos recursos= new ListaRecursos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
    ListaRecursos recursosencelda= new ListaRecursos();
    for (int pos=0; pos<recursos.getNumeroElementos();pos++){
        if(recursos.getElemento(pos).getDatos().getX()-1== finalI && recursos.getElemento(pos).getDatos().getY()-1== finalJ){
            recursosencelda.add(recursos.getElemento(pos).getDatos());
        }
    }
    ListaSimple<Label> etiquetas = new ListaSimple<Label>();
    LabelsP l1= new LabelsP("Celda["+(finalI+1)+"-"+(finalJ+1)+"] Individuos <"+elementosencelda.getNumeroElementos()+">: ");
    l1.setTranslateX(0);
    l1.setTranslateY(50);
    etiquetas.add(l1);
    //caja_info.getChildren().addAll(l1);
    int pos=0;
    if(elementosencelda.getNumeroElementos()==0){
        LabelsP l2= new LabelsP("No hay Individuos");
        l2.setTranslateX(60);
        l2.setTranslateY(90);

        //caja_info.getChildren().addAll(l2);
        etiquetas.add(l2);
        this.elementosencelda=false;
    }
    else {
        for (pos=0; pos < elementosencelda.getNumeroElementos(); pos++) {
            LabelsP l3= new LabelsP((pos + 1) + "-");
            l3.setTranslateY(90 + (70 * pos));

            LabelsP tipo = new LabelsP("ID: " +elementosencelda.getElemento(pos).getDatos().getId() + " Tipo: " + elementosencelda.getElemento(pos).getDatos().getTipo());
            tipo.setStyle("-fx-text-alignment: center; -fx-font-size: 16px;-fx-font-weight: bold");
            tipo.setTranslateX(60);
            tipo.setTranslateY(90 + (70 * pos));

            LabelsP TurnosDeVida = new LabelsP("Vidas: " + elementosencelda.getElemento(pos).getDatos().getTurnosvida());
            TurnosDeVida.setTranslateY(130 + (70 * pos));
            TurnosDeVida.setTranslateX(60);
            etiquetas.add(l3);
            etiquetas.add(tipo);
            etiquetas.add(TurnosDeVida);
            //caja_info.getChildren().addAll(l3, tipo, TurnosDeVida);
        }
    }
    int ultimo;
    if(pos==0) {
        ultimo = (140);
    }
    else{
        ultimo=(90*(pos)+70);
    }
    LabelsP labrecursos= new LabelsP("Celda["+(finalI+1)+"-"+(finalJ+1)+"] Recursos:<"+recursosencelda.getNumeroElementos()+"> ");
    labrecursos.setTranslateX(0);
    labrecursos.setTranslateY(ultimo+10);
    etiquetas.add(labrecursos);
    //caja_info.getChildren().addAll(labrecursos);
    if(recursosencelda.getNumeroElementos()==0){
        LabelsP l2rec= new LabelsP("No hay Recursos");
        l2rec.setTranslateX(60);
        l2rec.setTranslateY(ultimo+50);
        etiquetas.add(l2rec);
        //caja_info.getChildren().addAll(l2rec);
    }
    else{
        for( pos=0;pos<recursosencelda.getNumeroElementos();pos++){
            LabelsP l3= new LabelsP((pos+1)+"-");
            l3.setTranslateY(ultimo+50+(70*pos));

            LabelsP tipo= new LabelsP("Tipo: "+ recursosencelda.getElemento(pos).getDatos().getTipo());
            tipo.setTranslateX(60);
            tipo.setTranslateY(ultimo+50+(70*pos));

            LabelsP TurnosDeVida= new LabelsP("Vidas: "+ recursosencelda.getElemento(pos).getDatos().getTiemposvida());
            TurnosDeVida.setTranslateY(ultimo+90+(70*pos));
            TurnosDeVida.setTranslateX(60);
            etiquetas.add(l3);
            etiquetas.add(tipo);
            etiquetas.add(TurnosDeVida);
            //caja_info.getChildren().addAll(l3,tipo,TurnosDeVida);
        }
    }
    return etiquetas;
}
    public Parent Tablero (Partida p, String usuario, Stage stagePadre) throws
            FileNotFoundException {
        this.stagePadre=stagePadre;
        pasos=0;
        return actualizaTablero(p, usuario,stagePadre);
    }
    public void incrementaPasos(){
        pasos++;
    }
    public Parent actualizaTablero( Partida p, String usuario, Stage stagePadre) throws
            FileNotFoundException{
        this.stagePadre=stagePadre;
        //Limpiamos todo el tablero por si venimos de actualizarlo tras un movimiento
        if (root.getChildren() != null)
            root.getChildren().removeAll();

        Image imagen = new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/fondojuego.jpg"));
        ImageView imageView = new ImageView(imagen); //Creo el fondo de la aplicacion.
        imageView.setFitWidth(1450);
        imageView.setFitHeight(800);


        //Añadir Contador de turnos

        GridPane mainGrid = new GridPane();
        // mainGrid.setStyle("-fx-border-color: red;");
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);
        mainGrid.setGridLinesVisible(true);
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(0, 0, 0, 0));


        Box caja_info = new Box(400, 640, null);
        caja_info.setTranslateX(960);
        caja_info.setTranslateY(100);

        Rectangle r = new Rectangle(400, 640);
        r.setOpacity(5);
        r.setFill(Color.WHITE);
        r.setVisible(false);


        for (int i = 0; i < p.getFilas(); i++) {
            for (int j = 0; j < p.getColumnas(); j++) {

                // Aquí podrías instanciar tu clase de celda, más compleja
                GridPane secondaryGrid = new GridPane();
                secondaryGrid.setId("rejilla");
                Label rRecursoVacio = new Label();
                rRecursoVacio.setPrefSize(32, 32);
                rRecursoVacio.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");

                Label rBiblioteca = new Label();
                rBiblioteca.setPrefSize(32, 32);
                rBiblioteca.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rTesoro = new Label();
                rTesoro.setPrefSize(32, 32);
                rTesoro.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rPozo = new Label();
                rPozo.setPrefSize(32, 32);
                rPozo.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rAgua = new Label();
                rAgua.setPrefSize(32, 32);
                rAgua.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rMontana = new Label();
                rMontana.setPrefSize(32, 32);
                rMontana.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label rComida = new Label();
                rComida.setPrefSize(32, 32);
                rComida.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
                Label iIndividuo = new Label("");
                iIndividuo.setPrefSize(32, 32);
                iIndividuo.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: right;");
                iIndividuo.setAlignment(Pos.CENTER);
                secondaryGrid.add(rAgua, 0, 0);
                secondaryGrid.add(rComida, 0, 1);
                secondaryGrid.add(rPozo, 1, 0);
                secondaryGrid.add(iIndividuo, 1, 1);

                //mainGrid.add(addVBox(), i, j);
                mainGrid.add(secondaryGrid, j,i);
                Botones boton = new Botones(64);
                boton.setStyle("-fx-background-color: transparent;-fx-border-color: black");
                int finalI = i;
                int finalJ = j;



                Boton botonsalir = new Boton("Cerrar", 50);
                boton.setOnAction(() -> {

                    ListaSimple<Label> etiquetasContenido=new ListaSimple<Label>();
                    etiquetasContenido=contenidoCasilla(p,usuario,finalI,finalJ);
                    caja_info.getChildren().add(r);
                    for (int et=0; etiquetasContenido != null && et <etiquetasContenido.getNumeroElementos();et++){
                        if(etiquetasContenido.getElemento(et)!= null){
                            LabelsP etiqueta = (LabelsP)etiquetasContenido.getElemento(et).getDato();
                            caja_info.getChildren().addAll(etiqueta);
                        }
                    }
                    /*
                    actualizarindyrecpart(p,usuario);
                    ListaELementos individuos= new ListaELementos();
                    individuos=individuos.cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
                    ListaELementos elementosencelda= new ListaELementos();
                    for(int pos=0; pos<individuos.getNumeroElementos();pos++){
                        if(individuos.getElemento(pos).getDatos().getX()-1== finalI && individuos.getElemento(pos).getDatos().getY()-1== finalJ){
                            elementosencelda.add(individuos.getElemento(pos).getDatos());
                        }
                    }
                    ListaRecursos recursos= new ListaRecursos().cargar("src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
                    ListaRecursos recursosencelda= new ListaRecursos();
                    for (int pos=0; pos<recursos.getNumeroElementos();pos++){
                        if(recursos.getElemento(pos).getDatos().getX()-1== finalI && recursos.getElemento(pos).getDatos().getY()-1== finalJ){
                            recursosencelda.add(recursos.getElemento(pos).getDatos());
                        }
                    }
                    Labels l1= new Labels("Individuos: ");
                    l1.setTranslateX(0);
                    l1.setTranslateY(50);
                    caja_info.getChildren().addAll(l1);
                    int pos=0;
                    if(elementosencelda.getNumeroElementos()==0){
                        Labels l2= new Labels("No hay Individuos");
                        l2.setTranslateX(60);
                        l2.setTranslateY(90);

                        caja_info.getChildren().addAll(l2);
                        this.elementosencelda=false;
                    }
                    else {
                        for (pos=0; pos < elementosencelda.getNumeroElementos(); pos++) {
                            Labels l3= new Labels((pos + 1) + "-");
                            l3.setTranslateY(90 + (130 * pos));

                            Labels tipo = new Labels("Tipo: " + elementosencelda.getElemento(pos).getDatos().getTipo());
                            tipo.setTranslateX(60);
                            tipo.setTranslateY(90 + (130 * pos));

                            Labels TurnosDeVida = new Labels("Vidas: " + elementosencelda.getElemento(pos).getDatos().getTurnosvida());
                            TurnosDeVida.setTranslateY(130 + (130 * pos));
                            TurnosDeVida.setTranslateX(60);
                            caja_info.getChildren().addAll(l3, tipo, TurnosDeVida);
                        }
                    }
                    int ultimo;
                    if(pos==0) {
                        ultimo = (130);
                    }
                    else{
                        ultimo=(130*(pos)+40);
                    }
                    Labels labrecursos= new Labels("Reursos: ");
                    labrecursos.setTranslateX(0);
                    labrecursos.setTranslateY(ultimo+10);
                    caja_info.getChildren().addAll(labrecursos);
                    if(recursosencelda.getNumeroElementos()==0){
                        Labels l2rec= new Labels("No hay Recursos");
                        l2rec.setTranslateX(60);
                        l2rec.setTranslateY(ultimo+50);

                        caja_info.getChildren().addAll(l2rec);
                    }
                    else{
                        for( pos=0;pos<recursosencelda.getNumeroElementos();pos++){
                            Labels l3= new Labels((pos+1)+"-");
                            l3.setTranslateY(ultimo+50+(130*pos));

                            Labels tipo= new Labels("Tipo: "+ recursosencelda.getElemento(pos).getDatos().getTipo());
                            tipo.setTranslateX(60);
                            tipo.setTranslateY(ultimo+50+(130*pos));

                            Labels TurnosDeVida= new Labels("Vidas: "+ recursosencelda.getElemento(pos).getDatos().getTiemposvida());
                            TurnosDeVida.setTranslateY(ultimo+90+(130*pos));
                            TurnosDeVida.setTranslateX(60);
                            caja_info.getChildren().addAll(l3,tipo,TurnosDeVida);
                        }
                    }

                     */
                    botonsalir.setOnAction(()->{
                        caja_info.getChildren().clear();
                        root.getChildren().remove(caja_info);
                    });
                    r.setVisible(true);
                    caja_info.getChildren().add(botonsalir);
                    root.getChildren().add(caja_info);


                });



                mainGrid.add(boton, j,i);

            }
        }
        int pos = 0;
        while (pos < p.getRecursos().getNumeroElementos()) {
            int x = p.getRecursos().getElemento(pos).getDatos().getX() - 1;
            int y = p.getRecursos().getElemento(pos).getDatos().getY() - 1;
            Label recurso = new Label();
            recurso.setAlignment(Pos.CENTER);
            recurso.setPrefSize(32, 32);
            recurso.setStyle("-fx-border-color: lightgrey; -fx-text-alignment: center;");
            recurso.setText(p.getRecursos().getElemento(pos).getDatos().getTipo());
            ObservableList<Node> children = mainGrid.getChildren();
            GridPane nodo = null;
            for (Node child : children) {
                if (GridPane.getRowIndex(child) != null && GridPane.getRowIndex(child) == x
                        && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == y
                        && child != null && child.getId() != null && child.getId().equals("rejilla")) {
                    nodo = (GridPane) child;
                    break;
                }

            }
            if (nodo != null) {
                boolean insertado = false;
                ObservableList<Node> children2 = nodo.getChildren();
                Node hijoABorrar = null;
                int filaABorrar = -1;
                int colABorrar = -1;
                for (Node child : children2) {
                    for (int fila = 0; fila <= 1 && !insertado; fila++) {
                        for (int columna = 0; columna <= 1; columna++) {
                            if (GridPane.getColumnIndex(child) != null && GridPane.getRowIndex(child) == fila
                                    && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == columna) {
                                Label miRecurso = (Label) child;
                                if (miRecurso.getText().equals("")) {
                                    // remover el nodo del GridPane
                                    hijoABorrar = child;
                                    filaABorrar = fila;
                                    colABorrar = columna;
                                    insertado = true;
                                    break;
                                }
                                else{
                                    log.error("No hay más huecos para recursos");
                                }
                                break;
                            }
                        }
                    }


                }
                if (hijoABorrar != null) {
                    nodo.getChildren().remove(hijoABorrar);

                    // volver a agregar el nodo actualizado al GridPane
                    GridPane.setRowIndex(recurso, filaABorrar);
                    GridPane.setColumnIndex(recurso, colABorrar);
                    nodo.getChildren().add(recurso);
                }


            }
            log.info("Recurso añadido");
            pos++;



        }
        pos=0;
        while (pos < p.getIndividuos().getNumeroElementos()) {
            int x = p.getIndividuos().getElemento(pos).getDatos().getX() - 1;
            int y = p.getIndividuos().getElemento(pos).getDatos().getY() - 1;
            Label individuo = new Label();
            individuo.setAlignment(Pos.CENTER);
            individuo.setText("I");
            individuo.setPrefSize(32, 32);
            individuo.setStyle("-fx-border-color: grey; -fx-text-alignment: center;");

            ObservableList<Node> children = mainGrid.getChildren();
            GridPane nodo = null;
            for (Node child : children) {
                if (GridPane.getRowIndex(child) != null && GridPane.getRowIndex(child) == x
                        && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == y
                        && child != null && child.getId() != null && child.getId().equals("rejilla")) {
                    nodo = (GridPane) child;
                    break;
                }

            }
            if (nodo != null) {
                boolean insertado = false;
                ObservableList<Node> children2 = nodo.getChildren();
                Node hijoABorrar = null;
                int filaABorrar = -1;
                int colABorrar = -1;
                for (Node child : children2) {
                    if (GridPane.getColumnIndex(child) != null && GridPane.getRowIndex(child) == 1
                            && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == 1) {
                        Label miCelda = (Label) child;
                        if (miCelda.getText().isEmpty() || (isNumeric(miCelda.getText()) && Integer.parseInt(miCelda.getText())<3) ){
                            // remover el nodo del GridPane
                            hijoABorrar = child;
                            filaABorrar = 1;
                            colABorrar = 1;
                            insertado = true;
                            break;
                        }
                        break;
                    }
                }
                if (hijoABorrar != null) {
                    int totalIndividuosCelda=1;
                    if (!((Label) hijoABorrar).getText().isEmpty())
                        totalIndividuosCelda+=Integer.parseInt(((Label)hijoABorrar).getText());
                    nodo.getChildren().remove(hijoABorrar);
                    individuo.setText(String.valueOf(totalIndividuosCelda));
                    // volver a agregar el nodo actualizado al GridPane
                    GridPane.setRowIndex(individuo, filaABorrar);
                    GridPane.setColumnIndex(individuo, colABorrar);
                    nodo.getChildren().add(individuo);
                }

            }
            log.info("Individuo añadido");
            pos++;


        }

        this.tab = mainGrid;

        FlowPane f = new FlowPane();
        f.getChildren().addAll(mainGrid);
        f.setBackground(Background.fill(Color.WHITE));
        f.setAlignment(Pos.CENTER);
        f.setTranslateX(250);
        f.setTranslateY(50);

        Box caja = new Box(640, 640, null);
        caja.setTranslateX(230);
        caja.setTranslateY(100);


        caja.getChildren().add(f);


        Box b2 = new Box(100, 80, "src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Boton_Config.png");
        b2.setTranslateY(50);
        b2.setTranslateX(525);

        Botones bot1 = new Botones(70);
        bot1.setTranslateY(-20);
        bot1.setTranslateX(-10);
        bot1.setOnAction(() -> {
            root.getChildren().removeAll(caja);

            ListaELementos l2 = new ListaELementos();
            l2 = l2.cargar("src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosindividuos.json");
            l2.vaciar();
            l2.guardar(l2, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosindividuos.json");

            ListaRecursos l3 = new ListaRecursos();
            l3 = l3.cargar("src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");
            l3.vaciar();
            l3.guardar(l3, "src/main/java/es/uah/trabajo/juegodelavida/TableroDeJuego/Configuracion/nuevosrecursos.json");

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            File fichero = new File("src/main/resources/es/uah/trabajo/juegodelavida/ArchivosFXML/Configuración.fxml");
            URL url = null;
            try {
                url = fichero.toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            fxmlLoader.setLocation(url);


            try {


                Scene scene = new Scene(fxmlLoader.load(), 1006, 518);
                stage.setTitle("Reconfigurar Juego de La Vida de Conway");
                stage.setScene(scene);
                ConfiguracionController controlador2 = fxmlLoader.getController(); //dame el controlador
                controlador2.loadUserData(new ConfiguracionProperties(new ConfiguracionModel()),p, root,usuario); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                controlador2.setThisstage(stage); //doy la ventana donde se va a trabajar
                controlador2.setStagePadre(this.stagePadre);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        b2.addItem(bot1);

        Box b3 = new Box(100, 80, "src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Botón_Play.png");
        b3.setTranslateY(50);
        b3.setTranslateX(725);

        Botones bot3 = new Botones(70);
        bot3.setTranslateY(-20);
        bot3.setTranslateX(-10);
        bot3.setOnAction(() -> {
                    incrementaPasos();
                    //Cuando se pulsa el play, se lanza un ciclo del bucle de control
                    Bucle bucleC = new Bucle(p);
                    bucleC.ejecutarMovimiento(pasos);
            try {
                if(finpartida(p,stagePadre)){

                    //ImageView im= new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/FondoPortada.png")));
                    //im.setFitHeight(800);
                    //im.setFitWidth(600);
                   p.getAcciones().guardar(p.getAcciones());

                    CargaGrafos cargaGrafos = new CargaGrafos();
                    Grafos grafoArbol = cargaGrafos.dameArbolGen(p);

                    NodoGrafos nodoTablero = new NodoGrafos("-1", null, null);
                    if (grafoArbol.buscarNodo(nodoTablero))
                        nodoTablero = grafoArbol.dameNodo(nodoTablero);

                    Cola<Camino<String>> caminosArbol = grafoArbol.dijkstra(nodoTablero);
                    String cadenaArbol="\nARBOL GENEALOGICAL DE VENCEDORES:\n";

                    for(int i = caminosArbol.getNumeroElem() -1 ; i >= 0 ;i--){
                        ElementoLDE<Camino<String>> todoscaminos = caminosArbol.getElemento(i);
                        ListaSimple<NodoGrafos<String>> camino = todoscaminos.getDatos().getCamino();
                        NodoGrafos<String> nodoUltimo = (NodoGrafos<String>)camino.getUltimo().getDato();

                        if(camino!=null && camino.getUltimo() != null && !(nodoUltimo.getDatos().equals("-1"))){
                            cadenaArbol += todoscaminos.getDatos().formatearArbol();
                        }


                    }

                    stagePadre.close();

                    BorderPane resultado = new BorderPane();
                    HBox hbox = addHBox();

                    resultado.setTop(hbox);
                    resultado.setLeft(addVBox());
                    addStackPane(hbox);         // Add stack to HBox in top region
                    /*Si  utilizamos el mostrarTrees descomentar esto*/
                    resultado.setCenter(addPane(""));


                    /*Si no utilizamos el mostrarTrees descomentar esto
                    / resultado.setCenter(addPane(cadenaArbol));

                     */
                    resultado.setRight(addFlowPane());
                    HBox hbb1=(HBox)(((VBox)resultado.getChildren().get(2)).getChildren().get(1));
                    ScrollPane scp1=(ScrollPane)hbb1.getChildren().get(1);
                    Pane pp1=(Pane)(scp1.getContent());

                    String finalCadenaArbol = cadenaArbol;
                    mostrarTrees(pp1,caminosArbol,p);


                    ((Boton)((HBox)resultado.getChildren().get(0)).getChildren().get(0)).setOnAction(() -> {
                        limpiarPanel(pp1);
                        Label miTexto= (Label)pp1.getChildren().get(0);
                        miTexto.setText( finalCadenaArbol);
                        mostrarTrees(pp1,caminosArbol,p);
                    });
                    ((Boton)((HBox)resultado.getChildren().get(0)).getChildren().get(1)).setOnAction(() -> {
                        limpiarPanel(pp1);
                        Label miTexto= (Label)pp1.getChildren().get(0);
                        miTexto.setText( dameCadenaFlujo(p));
                    });
                    ((Boton)((HBox)resultado.getChildren().get(0)).getChildren().get(2)).setOnAction(() -> {
                        Label miTexto= (Label)pp1.getChildren().get(0);
                        miTexto.setText("");
                        limpiarPanel(pp1);
                        montaPanelHistorico(pp1,miTexto);
                    });
                    ((Boton)((HBox)resultado.getChildren().get(0)).getChildren().get(3)).setOnAction(() -> {
                        Label miTexto= (Label)pp1.getChildren().get(0);
                        miTexto.setText("");
                        limpiarPanel(pp1);
                        miTexto.setText( dameCadenaMaximos());

                    });





                    Scene sceneRes = new Scene(resultado,900,600);
                    sceneRes.setFill(Color.WHITE);
                    stagePadre.setScene(sceneRes);
                    stagePadre.show();
                }
                else{
                    try {
                        actualizaTablero(p, usuario, stagePadre);
                    } catch (FileNotFoundException e) {
                        try {
                            throw e;
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        b3.addItem(bot3);
        Box b = new Box(100, 80, "src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Boton_Parar.png");
        b.setTranslateY(50);
        b.setTranslateX(625);


        Box cajaGuardar= new Box(400, 100,"src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/Boton.png");
        cajaGuardar.setTranslateX(950);
        cajaGuardar.setTranslateY(5);


        es.uah.trabajo.juegodelavida.CargarPartida.Botones guardar= new es.uah.trabajo.juegodelavida.CargarPartida.Botones("Guardar Partida",150);

        guardar.setTranslateY(25);
        guardar.setTranslateX(55);
        guardar.setOnAction(()->{
            actualizarindyrecpart(p,usuario);

        });
        cajaGuardar.getChildren().add(guardar);

        Botones bot = new Botones(70);
        bot.setTranslateY(-20);
        bot.setTranslateX(-10);
        bot.setOnAction(() -> {
            root.getChildren().remove(b3);
            root.getChildren().add(b2);
        });
        b.addItem(bot);


        root.getChildren().addAll(imageView, b,b3, caja,cajaGuardar);
        //Se inicializa en el gestor del bucle la info de la partida

        return root;

    }
    public FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(1);
        flow.setHgap(1);
        flow.setPrefWrapLength(10); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        return flow;
    }
    public VBox addPane(String cadenaArbol) {
        Pane paneText = new Pane();
        paneText.setPadding(new Insets(5, 0, 5, 0));
        Pane pane = new Pane();
        Line line = new Line(100, 100, 1000, 1000);
        paneText.setMinSize(900,600); // preferred width allows for two columns
        pane.getChildren().add(line);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(paneText);

        ScrollBar vScrollBar = new ScrollBar();
        vScrollBar.setOrientation(Orientation.VERTICAL);
        vScrollBar.minProperty().bind(scrollPane.vminProperty());
        vScrollBar.maxProperty().bind(scrollPane.vmaxProperty());
        vScrollBar.visibleAmountProperty().bind(scrollPane.heightProperty().divide(pane.heightProperty()));
        scrollPane.vvalueProperty().bindBidirectional(vScrollBar.valueProperty());

        ScrollBar hScrollBar = new ScrollBar();
        hScrollBar.setOrientation(Orientation.HORIZONTAL);
        hScrollBar.minProperty().bind(scrollPane.hminProperty());
        hScrollBar.maxProperty().bind(scrollPane.hmaxProperty());
        hScrollBar.visibleAmountProperty().bind(scrollPane.widthProperty().divide(pane.heightProperty()));
        scrollPane.hvalueProperty().bindBidirectional(hScrollBar.valueProperty());

        HBox hBox = new HBox();
        HBox.setHgrow(scrollPane, Priority.ALWAYS);
        hBox.getChildren().addAll(vScrollBar, scrollPane);
        hBox.setStyle("-fx-background-color: DAE6F3;");



        VBox vBox = new VBox();
        VBox.setVgrow(hBox, Priority.ALWAYS);
        vBox.getChildren().addAll(hScrollBar, hBox);
        vBox.setStyle("-fx-background-color: DAE6F3;");

       /* HBox hBoxTot  = new HBox();
        hBoxTot.setHgrow(scrollPane, Priority.ALWAYS);
        hBoxTot.getChildren().addAll(vBox,hBox);*/

        vScrollBar.requestLayout();
        hScrollBar.requestLayout();


        paneText.setStyle("-fx-background-color: DAE6F3;");
        Label lArbol = new Label();
        lArbol.setStyle("-fx-text-alignment: left; -fx-font-size: 10px;-fx-font-weight: bold");
        lArbol.setText(cadenaArbol);
        paneText.getChildren().addAll(lArbol);
        return vBox;
    }
    public HBox addHBoxVacia() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        return hbox;
    }
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Boton botonArbol = new Boton("Árbol", 50);

        Boton botonFlujo = new Boton("Flujo", 50);

        Boton botonIndividuos = new Boton("Individuos", 50);

        Boton botonMaximos = new Boton("Máximos", 50);/*
        /*
        botonArbol.setOnAction(() -> {
        });
        botonFlujo.setOnAction(() -> {
        });
        botonIndividuos.setOnAction(() -> {
        });*/
        hbox.getChildren().addAll(botonArbol, botonFlujo, botonIndividuos,botonMaximos);

            return hbox;
    }
    public VBox addVBox()
    {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: DAE6F3;");

       return vbox;
    }
    public void addStackPane(HBox hb) {
        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        /*helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop[]{
                        new Stop(0,Color.web("#4977A3")),
                        new Stop(0.5, Color.web("#B0C6DA")),
                        new Stop(1,Color.web("#9CB6CF")),}));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);

        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(helpIcon, helpText);*/
        stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack
        /*StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"*/

        hb.getChildren().add(stack);            // Add to HBox from Example 1-2
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
    }
    public void limpiarPanel(Pane panel){
        int tamVbHistorico=panel.getChildren().size();
        int contador=tamVbHistorico-1;
        while(tamVbHistorico>1){
            Node nodoBorrar = panel.getChildren().get(contador);
            panel.getChildren().remove(nodoBorrar);
            tamVbHistorico=panel.getChildren().size();

        }
    }
    public String dameCadenaMaximos(){
        Historico historicoF=new Historico(new ListaELementos<Invidiuos>(),0);
        historicoF=historicoF.cargar();
        StringBuffer datosMaximos=new StringBuffer();
        datosMaximos.append("Máximos valores al finalizar partida:\n");
        int totalReproducciones=0;
        int totalClonaciones=0;
        int maxReproducciones=0;
        int idMaxReproducciones=-1;
        int maxClonaciones=0;
        int idMaxClonaciones=-1;
        int maxNumAguas=0;
        int idMaxNumAguas=-1;
        int maxNumBiblio=0;
        int idMaxNumBiblio=-1;
        int maxNumComida=0;
        int idMaxNumComida=-1;
        int maxNumMontaña=0;
        int idMaxNumMontaña=-1;
        int maxNumTesoro=0;
        int idMaxNumTesoro=-1;
        int maxNumPozo=0;
        int idMaxNumPozo=-1;
        int maxNumVidas=0;
        int idMaxNumVidas=-1;
        int maxNumTurnos=0;
        int idMaxNumTurnos=-1;
        for (int i =0; i <historicoF.getIndividuos().getNumeroElementos();i++){
            if(historicoF.getIndividuos() != null && historicoF.getIndividuos().getElemento(i)!=null
                    && historicoF.getIndividuos().getElemento(i).getDatos() != null) {
                Invidiuos invidiuos = historicoF.getIndividuos().getElemento(i).getDatos();
                totalReproducciones += invidiuos.getNumReproducido();
                totalClonaciones += invidiuos.getNumClonado();
                if (invidiuos.getNumReproducido() > maxReproducciones) {
                    idMaxReproducciones = i;
                    maxReproducciones = invidiuos.getNumReproducido();
                }
                if (invidiuos.getNumClonado() > maxClonaciones) {
                    idMaxClonaciones = i;
                    maxClonaciones = invidiuos.getNumClonado();
                }
                if (invidiuos.getNumAguas() > maxNumAguas) {
                    idMaxNumAguas = i;
                    maxNumAguas = invidiuos.getNumAguas();
                }
                if (invidiuos.getNumComida() > maxNumComida) {
                    idMaxNumComida = i;
                    maxNumComida = invidiuos.getNumComida();
                }
                if (invidiuos.getNumBiblioteca() > maxNumBiblio) {
                    idMaxNumBiblio = i;
                    maxNumBiblio = invidiuos.getNumBiblioteca();
                }
                if (invidiuos.getNumMontaña() > maxNumMontaña) {
                    idMaxNumMontaña = i;
                    maxNumMontaña = invidiuos.getNumMontaña();
                }
                if (invidiuos.getNumPozo() > maxNumPozo) {
                    idMaxNumPozo = i;
                    maxNumPozo = invidiuos.getNumPozo();
                }
                if (invidiuos.getNumComida() > maxNumTesoro) {
                    idMaxNumTesoro = i;
                    maxNumTesoro = invidiuos.getNumTesoro();
                }
                if (invidiuos.getMaxNumTurnosVida() > maxNumVidas) {
                    idMaxNumVidas = i;
                    maxNumVidas = invidiuos.getMaxNumTurnosVida();
                }
                if (invidiuos.getNumPasos() > maxNumTurnos) {
                    idMaxNumTurnos = i;
                    maxNumTurnos = invidiuos.getNumPasos();
                }
            }



        }
        datosMaximos.append("\n\t Total de reproducciones:" +  totalReproducciones);
        datosMaximos.append("\n\t Total de clonaciones:" +  totalClonaciones);
        datosMaximos.append("\n\t Máximo nº de reproducciones:" +  maxReproducciones);
        if(idMaxReproducciones>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxReproducciones).getDatos().getId()+"]" );
        datosMaximos.append("\n\t Máximo nº de clonaciones:" +  maxClonaciones);
        if(idMaxClonaciones>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxClonaciones).getDatos().getId()+"]"  );
        datosMaximos.append("\n\t Máximo tiempo de vida conseguido:" +  maxNumVidas);
        if(idMaxNumVidas>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumVidas).getDatos().getId()+"]"  );
        datosMaximos.append("\n\t Máximo nº de turnos jugados:" +  maxNumTurnos);
        if(idMaxNumTurnos>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumTurnos).getDatos().getId()+"]"  );
        if (idMaxNumVidas == idMaxNumTurnos)
            datosMaximos.append("\n\t ***El individuo más longevo es el que más turnos ha jugado***");
        else
            datosMaximos.append("\n\t ***El individuo más longevo NO es el que más turnos ha jugado***");
        datosMaximos.append("\n\t Máximo nº de recursos AGUAS conseguidas:" +  maxNumAguas);
        if(idMaxNumAguas>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumAguas).getDatos().getId() +"]" );
        datosMaximos.append("\n\t Máximo nº de recursos BIBLIOTECA conseguidas:" +  maxNumBiblio);
        if(idMaxNumBiblio>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumBiblio).getDatos().getId() +"]" );
        datosMaximos.append("\n\t Máximo nº de recursos COMIDA conseguidas:" +  maxNumComida);
        if(idMaxNumComida>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumComida).getDatos().getId() +"]" );
        datosMaximos.append("\n\t Máximo nº de recursos MONTAÑA conseguidas:" +  maxNumMontaña);
        if(idMaxNumMontaña>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumMontaña).getDatos().getId()+"]"  );
        datosMaximos.append("\n\t Máximo nº de recursos TESORO conseguidas:" +  maxNumTesoro);
        if(idMaxNumTesoro>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumTesoro).getDatos().getId() +"]" );
        datosMaximos.append("\n\t Máximo nº de recursos POZO conseguidas:" +  maxNumPozo);
        if(idMaxNumPozo>=0)
            datosMaximos.append(" de ID[" + historicoF.getIndividuos().getElemento(idMaxNumPozo).getDatos().getId() +"]" );


        return datosMaximos.toString();

    }
    public void mostrarTrees(Pane panel,Cola<Camino<String>> caminosArbol,Partida partida){
        //panel.getChildren().removeAll();
        VBox vbTrees= addVBox();
        Label lArbol = new Label();
        lArbol.setStyle("-fx-text-alignment: left; -fx-font-size: 10px;-fx-font-weight: bold");

        lArbol.setText("\nARBOL GENEALÓGICO DE VENCEDORES:\n");

        vbTrees.getChildren().add(lArbol);


        for(int i = caminosArbol.getNumeroElem() -1 ; i >= 0 ;i--){
            ElementoLDE<Camino<String>> todoscaminos = caminosArbol.getElemento(i);
            ListaSimple<NodoGrafos<String>> camino = todoscaminos.getDatos().getCamino();
            NodoGrafos<String> nodoUltimo = (NodoGrafos<String>)camino.getUltimo().getDato();

            if(camino!=null && camino.getUltimo() != null && !(nodoUltimo.getDatos().equals("-1"))){
               TreeItem<String> rootItem = new TreeItem<String>("Tablero");
                rootItem.setExpanded(true);
                for(int t=0; t < camino.getNumeroElementos();t++ )
                    if(camino.getElemento(t) != null && camino.getElemento(t).getDato() != null) {

                        if(t==0){
                            continue;
                        }
                        NodoGrafos<String> nodoActual=(NodoGrafos<String>)camino.getElemento(t).getDato();
                        String id=nodoActual.getDatos();
                        TreeItem<String> item = new TreeItem<String>("PADRE DE NODO [" + id + "]");
                        item.setExpanded(true);

                        if(rootItem.getChildren().size()==0) {

                            rootItem.getChildren().add(item);
                        }else{
                            if (partida.getIndividuos() != null) {
                                int posIndi = partida.getIndividuos().getPosicionId(Integer.parseInt(id));
                                if (posIndi >=0) {
                                    if( partida.getIndividuos().getElemento(posIndi) != null) {
                                        if( partida.getIndividuos().getElemento(posIndi).getDatos()!= null) {
                                            Invidiuos individuo = partida.getIndividuos().getElemento(posIndi).getDatos();
                                            if(individuo.getReproducciones()!=null && individuo.getReproducciones().getNumeroElementos()>0)
                                            {
                                                if(individuo.getReproducciones().getElemento(0).getDatos() != null) {
                                                    int idPadre1 = individuo.getReproducciones().getElemento(0).getDatos().getIdIndividuoPadre1();
                                                    int idPadre2 = individuo.getReproducciones().getElemento(0).getDatos().getIdIndividuoPadre2();
                                                    rootItem.getChildren().getLast().setValue("NODOS [" + idPadre1 + "-" + idPadre2 + "]");
                                                    item.setValue("PADRES DE NODO [" + id + "]");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            rootItem.getChildren().getLast().getChildren().add(item);
                        }

                    }
                TreeView<String> tree = new TreeView<String> (rootItem);
                tree.setPrefSize(300,100);
                tree.setStyle("-fx-background-color: #336699;");

                vbTrees.getChildren().add(tree);
            }



        }

        panel.getChildren().add(vbTrees);
    }
    public void montaPanelHistorico(Pane panel,Label labelPanel){
        Historico historicoF=new Historico(new ListaELementos<Invidiuos>(),0);
        historicoF=historicoF.cargar();

        VBox vbHistorico= addVBox();
        if (historicoF != null && historicoF.getIndividuos() != null && historicoF.getIndividuos().getNumeroElementos()>0) {
            labelPanel.setText("Si hay individuos para seleccionar");
            String idIndividuos[] = new String[historicoF.getIndividuos().getNumeroElementos()];
            for(int i = 0; historicoF.getIndividuos() != null && i<  historicoF.getIndividuos().getNumeroElementos();i++) {
                if (historicoF.getIndividuos().getElemento(i) != null) {
                    Invidiuos individuo =historicoF.getIndividuos().getElemento(i).getDatos();
                    idIndividuos[i]=String.valueOf(individuo.getId());
                }
            }
            HBox hbCombo = addHBoxVacia();
            Label labelCombo = new Label();
            labelCombo.setStyle("-fx-text-alignment: left; -fx-font-size: 10px;-fx-font-weight: bold");
            labelCombo.setText("Individuos ID");


            ComboBox cbbox = new ComboBox(FXCollections.observableArrayList(idIndividuos));
            hbCombo.getChildren().addAll(labelCombo,cbbox);
            vbHistorico.getChildren().addAll(hbCombo);
            panel.getChildren().add(vbHistorico);

            Historico finalHistoricoF = historicoF;
            cbbox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                int tamVbHistorico=vbHistorico.getChildren().size();
                int contador=tamVbHistorico-1;
                while(tamVbHistorico>1){
                    Node nodoBorrar = vbHistorico.getChildren().get(contador);
                    vbHistorico.getChildren().remove(nodoBorrar);
                    tamVbHistorico=vbHistorico.getChildren().size();

                }
                Label lbDatosIndividuo = new Label();
                lbDatosIndividuo.setStyle("-fx-text-alignment: left; -fx-font-size: 10px;-fx-font-weight: bold");
                lbDatosIndividuo.setText(dameDatosFinalesIndividuo(finalHistoricoF,newValue.toString()));

                vbHistorico.getChildren().add(lbDatosIndividuo);
            });


        }else{
            labelPanel.setText("No hay individuos para seleccionar");
        }

    }
    public String dameDatosFinalesIndividuo(Historico historicoF, String id){
        StringBuffer datosFinalesIndividuo=new StringBuffer();
        datosFinalesIndividuo.append("Información de individuo [" + id + " al finalizar partida:\n");
        for (int i =0; i <historicoF.getIndividuos().getNumeroElementos();i++){
            if(historicoF.getIndividuos() != null && historicoF.getIndividuos().getElemento(i)!=null
               && historicoF.getIndividuos().getElemento(i).getDatos() != null){
                Invidiuos invidiuos = historicoF.getIndividuos().getElemento(i).getDatos();
                if(invidiuos.getId() == Integer.parseInt(id)) {
                    datosFinalesIndividuo.append("\t\nNúmero de Turnos en los que ha intervenido:" + invidiuos.getNumPasos());
                    datosFinalesIndividuo.append("\t\nNúmero de veces que se ha reproducido:" + invidiuos.getNumReproducido());
                    datosFinalesIndividuo.append("\t\nNúmero de veces que se ha clonado:" + invidiuos.getNumClonado());
                    datosFinalesIndividuo.append("\t\nNúmero de recursos AGUA que ha tenido:" + invidiuos.getNumAguas());
                    datosFinalesIndividuo.append("\t\nNúmero de recursos BIBLIOTECA que ha tenido:" + invidiuos.getNumBiblioteca());
                    datosFinalesIndividuo.append("\t\nNúmero de recursos COMIDA que ha tenido:" + invidiuos.getNumComida());
                    datosFinalesIndividuo.append("\t\nNúmero de recursos MONTAÑA que ha tenido:" + invidiuos.getNumMontaña());
                    datosFinalesIndividuo.append("\t\nNúmero de recursos TESORO que ha tenido:" + invidiuos.getNumTesoro());
                    datosFinalesIndividuo.append("\t\nNúmero de recursos POZO que ha tenido:" + invidiuos.getNumPozo());
                    datosFinalesIndividuo.append("\t\nNúmero de vidas que le quedaban:" + invidiuos.getTurnosvida());
                }
            }
        }
        return datosFinalesIndividuo.toString();
    }
public String dameCadenaFlujo(Partida partida){
    es.uah.trabajo.juegodelavida.Clases.ColaAcciones.Cola cAcciones = partida.getAcciones().cargar();
    StringBuffer cadenaFlujo=new StringBuffer();
    String paso = "";
    for (int ca=cAcciones.getNumeroElemC()-1; ca >=0; ca --){
        if(cAcciones.getElemento(ca)!=null){
            if (((String)cAcciones.getElemento(ca).getDatos()) != null &&
                    ((String)cAcciones.getElemento(ca).getDatos()).indexOf("Play[") >=0){
                if (((String)cAcciones.getElemento(ca).getDatos()).indexOf("]") > 0) {
                    String pasoNew = ((String) cAcciones.getElemento(ca).getDatos()).substring(((String) cAcciones.getElemento(ca).getDatos()).indexOf("Play["), ((String) cAcciones.getElemento(ca).getDatos()).indexOf("]")+1);
                    if (!pasoNew.equals(paso)) {
                        paso = pasoNew;
                        cadenaFlujo.append(pasoNew+"\n");


                    }
                    String nuevaCadena="\t"+((String) cAcciones.getElemento(ca).getDatos()).substring(((String) cAcciones.getElemento(ca).getDatos()).indexOf("]")+1,((String) cAcciones.getElemento(ca).getDatos()).length());
                    cAcciones.getElemento(ca).datos=nuevaCadena;
                }
            }
            cadenaFlujo.append((String)cAcciones.getElemento(ca).getDatos());
            cadenaFlujo.append("\n");
        }
    }
    return cadenaFlujo.toString();
}
    private  void actualizarindyrecpart(Partida p, String u){
        p.getIndividuos().guardar(p.getIndividuos(),"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/individuos.json");
        p.getRecursos().guardar(p.getRecursos(),"src/main/java/es/uah/trabajo/juegodelavida/ParamJuego/recursos.json");
        ListaUsuarios usuarios= new ListaUsuarios();
        ListaLEPA partidas= usuarios.getusuario(u).getPartidas();
        partidas.del(usuarios.getusuario(u).getPartidas().getPosicion(new ElementoLEPA<>(p)));
        partidas.add(p);
        usuarios.getusuario(u).setPartidas(partidas);
    }
    private boolean finpartida(Partida p,Stage s) throws FileNotFoundException {
        //Descomentar para probar
        if(p.getIndividuos().getNumeroElementos()<=1 || p.getIndividuos().getElemento(0).getDatos().getTurnosvida()==1){
        //Descomentar para final
           // if(p.getIndividuos().getNumeroElementos()<=1){
            return true;
        }
        else{
            return false;
        }
    }
    //

    public Box añadirelementos ( int filas, int columnas, ListaRecursos recursos, ListaELementos individuos) throws
            FileNotFoundException {


        int pos = 0;
        while (pos < recursos.getNumeroElementos()) {
            int x = recursos.getElemento(pos).getDatos().getX() - 1;
            int y = recursos.getElemento(pos).getDatos().getY() - 1;
            Label recurso = new Label();
            recurso.setAlignment(Pos.CENTER);
            recurso.setText(recursos.getElemento(pos).getDatos().getTipo());
            ObservableList<Node> children = tab.getChildren();
            GridPane nodo = null;
            for (Node child : children) {
                if (GridPane.getRowIndex(child) != null && GridPane.getRowIndex(child) == x
                        && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == y
                        && child != null && child.getId() != null && child.getId().equals("recursos")) {
                    nodo = (GridPane) child;
                    break;
                }

            }
            if (nodo != null) {
                boolean insertado = false;
                ObservableList<Node> children2 = nodo.getChildren();
                Node hijoABorrar = null;
                int filaABorrar = -1;
                int colABorrar = -1;
                for (Node child : children2) {
                    for (int fila = 0; fila <= 1 && !insertado; fila++) {
                        for (int columna = 0; columna <= 1; columna++) {
                            if (GridPane.getColumnIndex(child) != null && GridPane.getRowIndex(child) == fila
                                    && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == columna) {
                                Label miRecurso = (Label) child;
                                if (miRecurso.getText().equals("")) {
                                    // remover el nodo del GridPane
                                    hijoABorrar = child;
                                    filaABorrar = fila;
                                    colABorrar = columna;
                                    insertado = true;
                                    break;
                                }
                                break;
                            }
                        }
                    }


                }
                if (hijoABorrar != null) {
                    nodo.getChildren().remove(hijoABorrar);

                    // volver a agregar el nodo actualizado al GridPane
                    GridPane.setRowIndex(recurso, filaABorrar);
                    GridPane.setColumnIndex(recurso, colABorrar);
                    nodo.getChildren().add(recurso);
                }

            }
            pos++;


        }
        while (pos < individuos.getNumeroElementos()) {
            int x = individuos.getElemento(pos).getDatos().getX() - 1;
            int y = individuos.getElemento(pos).getDatos().getY() - 1;
            Label individuo = new Label();
            individuo.setAlignment(Pos.CENTER);

            individuo.setText("1");
            ObservableList<Node> children = tab.getChildren();
            GridPane nodo = null;
            for (Node child : children) {
                if (GridPane.getRowIndex(child) != null && GridPane.getRowIndex(child) == x
                        && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == y
                        && child != null && child.getId() != null && child.getId().equals("individuos")) {
                    nodo = (GridPane) child;
                    break;
                }

            }
            if (nodo != null) {
                boolean insertado = false;
                ObservableList<Node> children2 = nodo.getChildren();
                Node hijoABorrar = null;
                int filaABorrar = -1;
                int colABorrar = -1;
                for (Node child : children2) {
                    for (int fila = 0; fila <= 1 && !insertado; fila++) {
                        for (int columna = 0; columna <= 1; columna++) {
                            if (GridPane.getColumnIndex(child) != null && GridPane.getRowIndex(child) == fila
                                    && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == columna) {
                                Label miRecurso = (Label) child;
                                if (miRecurso.getText().equals("")) {
                                    // remover el nodo del GridPane
                                    hijoABorrar = child;
                                    filaABorrar = fila;
                                    colABorrar = columna;
                                    insertado = true;
                                    break;
                                }
                                break;
                            }
                        }
                    }


                }
                if (hijoABorrar != null) {

                    nodo.getChildren().remove(hijoABorrar);

                    // volver a agregar el nodo actualizado al GridPane
                    GridPane.setRowIndex(individuo, filaABorrar);
                    GridPane.setColumnIndex(individuo, colABorrar);
                    nodo.getChildren().add(individuo);
                }

            }
            pos++;


        }
        pos=0;
        while (pos < individuos.getNumeroElementos()) {
            int x = individuos.getElemento(pos).getDatos().getX() - 1;
            int y = individuos.getElemento(pos).getDatos().getY() - 1;
            Label individuo = new Label();
            individuo.setAlignment(Pos.CENTER);
            individuo.setText("I");
            individuo.setPrefSize(32, 32);
            individuo.setStyle("-fx-border-color: grey; -fx-text-alignment: center;");

            ObservableList<Node> children = tab.getChildren();
            GridPane nodo = null;
            for (Node child : children) {
                if (GridPane.getRowIndex(child) != null && GridPane.getRowIndex(child) == x
                        && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == y
                        && child != null && child.getId() != null && child.getId().equals("rejilla")) {
                    nodo = (GridPane) child;
                    break;
                }

            }
            if (nodo != null) {
                boolean insertado = false;
                ObservableList<Node> children2 = nodo.getChildren();
                Node hijoABorrar = null;
                int filaABorrar = -1;
                int colABorrar = -1;
                for (Node child : children2) {
                    if (GridPane.getColumnIndex(child) != null && GridPane.getRowIndex(child) == 1
                            && GridPane.getColumnIndex(child) != null && GridPane.getColumnIndex(child) == 1) {
                        Label miCelda = (Label) child;
                        if (miCelda.getText().equals("") || Integer.parseInt(miCelda.getText())<3) {
                            // remover el nodo del GridPane
                            hijoABorrar = child;
                            filaABorrar = 1;
                            colABorrar = 1;
                            insertado = true;
                            break;
                        }
                        break;
                    }
                }
                if (hijoABorrar != null) {
                    int totalIndividuosCelda=1;
                    if (!((Label)hijoABorrar).getText().equals("") )
                        totalIndividuosCelda+=Integer.parseInt(((Label)hijoABorrar).getText());
                    nodo.getChildren().remove(hijoABorrar);
                    individuo.setText(String.valueOf(totalIndividuosCelda));


                    // volver a agregar el nodo actualizado al GridPane
                    GridPane.setRowIndex(individuo, filaABorrar);
                    GridPane.setColumnIndex(individuo, colABorrar);
                    nodo.getChildren().add(individuo);
                }

            }
            log.info("Individuo añadido");
            pos++;
        }
        FlowPane f2 = new FlowPane();
        f2.getChildren().addAll(tab);
        f2.setBackground(Background.fill(Color.WHITE));
        f2.setAlignment(Pos.CENTER);
        f2.setTranslateX(250);
        f2.setTranslateY(50);

        Box caja = new Box(640, 640, null);
        caja.setTranslateX(230);
        caja.setTranslateY(100);


        caja.getChildren().add(f2);

        return caja;
    }

}