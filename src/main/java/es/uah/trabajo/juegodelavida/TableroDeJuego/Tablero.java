package es.uah.trabajo.juegodelavida.TableroDeJuego;

import es.uah.trabajo.juegodelavida.BucleControl.Bucle;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ElementoLEPA;
import es.uah.trabajo.juegodelavida.CargarPartida.EstructurasCargar.ListaLEPA;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaELementos;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaRecursos;
import es.uah.trabajo.juegodelavida.Clases.Grafos.*;
import es.uah.trabajo.juegodelavida.Clases.ListaUsuarios;
import es.uah.trabajo.juegodelavida.Clases.Partida;
import es.uah.trabajo.juegodelavida.Portada.Boton;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion.ConfiguracionController;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion.ConfiguracionModel;
import es.uah.trabajo.juegodelavida.TableroDeJuego.Configuracion.ConfiguracionProperties;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
    LabelsP l1= new LabelsP("Celda["+finalI+"-"+finalJ+"] Individuos <"+elementosencelda.getNumeroElementos()+">: ");
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
        ultimo = (90);
    }
    else{
        ultimo=(90*(pos)+40);
    }
    LabelsP labrecursos= new LabelsP("Celda["+finalI+"-"+finalJ+"] Recursos:<"+recursosencelda.getNumeroElementos()+"> ");
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
            l3.setTranslateY(ultimo+25+(130*pos));

            LabelsP tipo= new LabelsP("Tipo: "+ recursosencelda.getElemento(pos).getDatos().getTipo());
            tipo.setTranslateX(60);
            tipo.setTranslateY(ultimo+50+(130*pos));

            LabelsP TurnosDeVida= new LabelsP("Vidas: "+ recursosencelda.getElemento(pos).getDatos().getTiemposvida());
            TurnosDeVida.setTranslateY(ultimo+90+(130*pos));
            TurnosDeVida.setTranslateX(60);
            etiquetas.add(l3);
            etiquetas.add(tipo);
            etiquetas.add(TurnosDeVida);
            //caja_info.getChildren().addAll(l3,tipo,TurnosDeVida);
        }
    }
    return etiquetas;
}
    public Parent Tablero ( Partida p,  String usuario, Stage stagePadre) throws
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
                    Pane resultado= new Pane();
                    //ImageView im= new ImageView(new Image(new FileInputStream("src/main/resources/es/uah/trabajo/juegodelavida/Imagenes/FondoPortada.png")));
                    //im.setFitHeight(800);
                    //im.setFitWidth(600);

                    CargaGrafos cargaGrafos = new CargaGrafos();
                    Grafos grafoArbol = cargaGrafos.dameArbolGen(p);

                    NodoGrafos nodoTablero = new NodoGrafos("-1", null, null);
                    if (grafoArbol.buscarNodo(nodoTablero))
                        nodoTablero = grafoArbol.dameNodo(nodoTablero);

                    Cola<Camino<String>> caminosArbol = grafoArbol.dijkstra(nodoTablero);
                    String cadenaArbol="\nARBOL GENEALÓGICO DE VENCEDORES:\n";

                    for(int i = caminosArbol.getNumeroElem() -1 ; i >= 0 ;i--){
                        ElementoLDE<Camino<String>> todoscaminos = caminosArbol.getElemento(i);
                        ListaSimple<NodoGrafos<String>> camino = todoscaminos.getDatos().getCamino();
                        NodoGrafos<String> nodoUltimo = (NodoGrafos<String>)camino.getUltimo().getDato();

                        if(camino!=null && camino.getUltimo() != null && !(nodoUltimo.getDatos().equals("-1"))){
                            cadenaArbol += todoscaminos.getDatos().formatearArbol();
                        }


                    }

                    //resultado.getChildren().add(im);

                    javafx.scene.layout.FlowPane paneRes= new FlowPane();
                    Label lArbol = new Label();
                    lArbol.setStyle("-fx-text-alignment: center; -fx-font-size: 16px;-fx-font-weight: bold");
                    lArbol.setText(cadenaArbol);

                   /* paneRes.setCenter(lArbol);
                    paneRes.setTop(new Label());
                    paneRes.setLeft(new Label());
                    paneRes.setBottom(new Label());
                    paneRes.setRight(new Label());*/
                    //resultado.getChildren().add(paneRes);
                    stagePadre.close();
                    //Scrollbar
                    ScrollBar sB = new ScrollBar();
                    sB.setLayoutX(715);
                    sB.setLayoutY(80);
                    sB.setMin(0);
                    sB.setOrientation(Orientation.VERTICAL);
                    sB.setPrefHeight(500);
                    sB.setMax(360);
                    sB.setUnitIncrement(30);
                    sB.setBlockIncrement(35);
                    paneRes.getChildren().add(lArbol);
                    resultado.getChildren().add(paneRes);
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
        if(p.getIndividuos().getNumeroElementos()<=2){
            return true;
        }
        else{
            return false;
        }
    }

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